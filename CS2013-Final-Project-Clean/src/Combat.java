import java.util.Random;
import java.util.Scanner;

public class Combat {
    private Player player;
    private Monster monster;

    private final int playerDamage;

    public Combat (Player player, Monster monster, int playerDamage){
        this.player = player;
        this.monster = monster;
        this.playerDamage = playerDamage;
    }

    public void combat(){
        System.out.println("\n" + player.getName() + " Get ready to combat " + monster.getName());

        do{
            String monsterMove = monsterMove();
            String playerMove = playerMove();

            if (monsterMove.equals(playerMove)){
                System.out.println("Tie, get ready for next move");
            }
            else if (playerWins(playerMove, monsterMove)){
                System.out.println("You choose: " + playerMove + " and the monster choose: " + monsterMove);
                monster.takeDamage(playerDamage);
                if(monster.getHealth() > 0)
                    System.out.println("Monster health: " + monster.getHealth() + " HP");

            }
            else{
                System.out.println("You choose: " + playerMove + " and the monster choose: " + monsterMove);
                player.removeHealth(monster.getSword().getEffect());
                if (player.getHealth() > 0){
                    System.out.println(player.getStats());
                }
            }

        }while(player.getHealth() > 0 && monster.getHealth() > 0);

        defeat();

    }

    private String playerMove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose: Rock(1) Paper(2) Scissors(3)");
        int option ;

        String attack = "";

        do{
            option = input.nextInt();
            switch (option){
                case 1: attack =  "rock";
                    break;
                case 2: attack = "paper";
                    break;
                case 3: attack = "scissors";
                    break;
                default:
                    System.out.println("Wrong input");
            }

        }while (attack.isEmpty());

        return attack;

    }

    private String monsterMove(){
        String monsterMove;
        Random random = new Random();
        int number = random.nextInt(3);

        if (number == 0)
            monsterMove = "rock";
        else if (number == 1)
            monsterMove = "paper";
        else
            monsterMove = "scissors";
        return monsterMove;

    }
    private boolean playerWins(String playerMove, String monsterMove) {
        if (playerMove.equals("rock")) {
            return monsterMove.equals("scissors");
        } else if (playerMove.equals("paper")) {
            return monsterMove.equals("rock");
        } else {
            return monsterMove.equals("paper");
        }
    }

    private void defeat(){
        if (player.getHealth() <= 0)
            System.out.println("You died");
        else{
            System.out.println(player.getName() + ", you have defeated " + monster.getName());
        }

    }


}
