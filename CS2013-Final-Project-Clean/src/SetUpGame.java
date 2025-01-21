import java.util.ArrayList;
import java.util.Scanner;

public class SetUpGame {

    GamePlay gamePlay;
    private static LinkedCave cave;
    private static ArrayList<Cave> list;

    public SetUpGame(){
        setUpRooms();
        setUpGamePlay();
        setUpPotions();
        setUpMonsters();
    }

    private void setUpRooms(){
        ArrayList<Cave> list = getCaves();

        int[][] structure = {
                {-1, 1, -1, -1},
                {0, -1, -1, 2},
                {-1, 6, 1, 5},
                {-1, 5, -1, 4},
                {-1, -1, 3, -1},
                {3, -1, 2, -1},
                {2, 7, -1, -1},
                {6, -1, -1, -1}
        };
        
        cave = new LinkedCave(list, 7);
        cave.connections = structure;
        cave.createSystem();


    }

    private static ArrayList<Cave> getCaves() {

        Cave cave1 = new Cave(1);
        Cave cave2 = new Cave(2);
        Cave cave3 = new Cave(3);
        Cave cave4 = new Cave(4);
        Cave cave5 = new Cave(5);
        Cave cave6 = new Cave(6);
        Cave cave7 = new Cave(7);
        Cave cave8 = new Cave(8);

        list = new ArrayList<>();
        list.add(cave1);
        list.add(cave2);
        list.add(cave3);
        list.add(cave4);
        list.add(cave5);
        list.add(cave6);
        list.add(cave7);
        list.add(cave8);
        return list;
    }

//    public static void main(String[] args){
//        setUpRooms();
//    }

    private void setUpGamePlay(){
        int[][] structure = {
                {-1, 1, -1, -1},
                {0, -1, -1, 2},
                {-1, 6, 1, 5},
                {-1, 5, -1, 4},
                {-1, -1, 3, -1},
                {3, -1, 2, -1},
                {2, 7, -1, -1},
                {6, -1, -1, -1}
        };
        Asset item1 = new Asset("Level 1 Sword", "Sword",10, "Does 15 HP damage");

        gamePlay = new GamePlay(cave);
        gamePlay.inventory.addItem(item1);
        gamePlay.player = setPlayer();

    }

    private void setUpPotions(){
        RandomPotion potions = new RandomPotion();
        for (int i = 0; i < list.size(); i++){
            list.get(i).potion = potions.randomAsset();
        }
    }

    private void setUpMonsters(){
        RandomMonster monster = new RandomMonster();
        for(int i = 0; i < list.size(); i++){
            list.get(i).monster1 = monster.randomMonster();
            list.get(i).monster2 = monster.randomMonster();


        }
    }

    private Player setPlayer(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?: ");
        String user = input.nextLine();

        return new Player(user);
    }

    public static void main(String[] args){
        SetUpGame game = new SetUpGame();


        game.gamePlay.Start();

    }
}
