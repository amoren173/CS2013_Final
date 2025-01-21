import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * No cave room may be removed, hense no remove function
 *We only need this to transverse, with other classes taking care of the rest of the game logic
 *No adding/inserting since game map will be set in stone
 * Will implement a display visually method later on, perhaps using recursion?
 *
 **/

public class LinkedCave {
    //first element should be the head
    private final ArrayList<Cave> listRoom;
    public int[][] connections;
    protected Cave head;
    protected Cave currentRoom;
    //in the current implementation, the last node in the listRoom should be the exit
    protected Cave exit;

    public LinkedCave(ArrayList<Cave> listRoom, int roomNumbers){
        this.listRoom = listRoom;
        connections = new int[roomNumbers][4];
        setCost();
    }

    public void goUp(){
        if(currentRoom.up != null)
            currentRoom = currentRoom.up;
        else
            System.out.println("You may not go up, no exit");
    }

    public void goDown(){
        if (currentRoom.down != null)
            currentRoom = currentRoom.down;
        else
            System.out.println("You may not go down, no exit");
    }

    public void goEast(){
        if (currentRoom.east != null)
            currentRoom = currentRoom.east;
        else
            System.out.println("You may not go east, no exit");
    }

    public void goWest(){
        if (currentRoom.west != null)
            currentRoom = currentRoom.west;
        else
            System.out.println("You may not go west, no exit");
    }


    //sets up the cost variable, from 5 to 10 HP
    private void setCost(){
        Random random = new Random();

        for(int i = 0; i < listRoom.size(); i++){
            listRoom.get(i).cost = 5 + random.nextInt(6);
        }

    }
    public void createSystem(){
        head = listRoom.get(0);
        exit = listRoom.get(listRoom.size() - 1);
        currentRoom = head;
        for (int i = 0; i < connections.length; i++){
            Cave current = listRoom.get(i);
            for (int j = 0; j < 4; j++){
                connectNodes(current, connections[i][j], j);
            }
        }
    }

    private void connectNodes(Cave currentNode, int nodeId, int direction){
        if(nodeId == -1){
            if(direction == 0)
                currentNode.up = null;
            else if(direction == 1)
                currentNode.down = null;
            else if (direction == 2)
                currentNode.west = null;
            else if (direction == 3)
                currentNode.east = null;
        }
        else{
            switch (direction){
                case 0:
                    currentNode.up = listRoom.get(nodeId);
                    break;
                case 1:
                    currentNode.down = listRoom.get(nodeId);
                    break;
                case 2:
                    currentNode.west = listRoom.get(nodeId);
                    break;
                case 3:
                    currentNode.east = listRoom.get(nodeId);
                    break;
            }

        }

    }

}
