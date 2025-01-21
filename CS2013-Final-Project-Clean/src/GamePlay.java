import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {
    public Player player;
    Inventory inventory;
    public LinkedCave cave;

//    private final Dialogue dialogue = new Dialogue();

    public GamePlay (LinkedCave cave){
        this.cave = cave;
        inventory = new Inventory();
    }

    public void Start(){
        boolean gameover = true;
        System.out.println("\nYou are currently in room " + cave.currentRoom.id + "\nYou must find a way out, be careful of the monsters");

        do{
            combatEncounter();
            switchRoom();

        }while (gameover && player.isAlive() && !isExit());

    }

    //method used to change rooms
    public void switchRoom(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose where to go next \nOptions include: \n(1)Up \n(2)Down \n(3)East \n(4)West");
        int option = input.nextInt();
        int currentRoomId = cave.currentRoom.id;

        switch (option){
            case 1: cave.goUp();
                break;
            case 2: cave.goDown();
                break;
            case 3: cave.goEast();
                break;
            case 4: cave.goWest();
                break;
//            case 5: useItem();
            default:
                System.out.println("Invalid Option");
        }

        if (currentRoomId != cave.currentRoom.id && cave.currentRoom.id != cave.exit.id) {
            System.out.println("\nYou are currently in room " + cave.currentRoom.id);
            player.removeHealth(cave.currentRoom.cost);
            System.out.println("Cost of proceeding was: " + cave.currentRoom.cost + "\nNew health is: " + player.getHealth() + "HP");
        }
        if (cave.currentRoom.id == cave.exit.id)
            System.out.println("You made it out, congrats");


    }

    private void usePotion() {
        System.out.println("Which potion would you like to use?");


    }

    //method for setting up combat with enemy
    public void combatEncounter(){
        Combat combat1 = new Combat(player, cave.currentRoom.monster1, inventory.getItem(0).getEffect());
        Combat combat2 = new Combat(player, cave.currentRoom.monster2, inventory.getItem(0).getEffect());

        if(cave.currentRoom.monster1 != null || cave.currentRoom.monster2 != null){

            if(cave.currentRoom.monster1 != null && player.isAlive()){
                combat1.combat();
                //may have to change this logic, it is fine since either way when a player dies the whole program ends
                cave.currentRoom.monster1 = null;
            }
            if(cave.currentRoom.monster2 != null && player.isAlive()){
                combat2.combat();
                cave.currentRoom.monster2 = null;
            }

        }
        else
            System.out.println("Cave clear of monsters");

    }

    public boolean isExit(){
        return cave.currentRoom == cave.exit;
    }

}

