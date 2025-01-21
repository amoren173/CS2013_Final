import java.util.Scanner;
public class Player {

    final private String name;
    private int health = 100;
    private int shield = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //adds player health
    public void addHealth(int amount){
        this.health = health + amount;
        System.out.println("New health is: " + this.health);
    }

    //removes player health
    public void removeHealth(int amount){
        this.health = health - amount;
        System.out.println("New health is: " + getHealth());
    }

    //add shield points to player shield
    public void addShieldPoints(int amount){
//        int amount = asset.getEffect();
        if(this.shield + amount < 50)
            this.shield = shield + amount;
        else if(this.shield + amount > 50)
            addShieldPointsTruncate();
    }

    //add shield points to points if adding makes shield higher than 50
    private void addShieldPointsTruncate(){
        Scanner input = new Scanner(System.in);
        System.out.println("Shield limit is 50, the shield will be used \nDO you wish to use? Y -> Yes, N -> No: ");
        char option = input.next().charAt(0);

        switch (option){
            case 'Y':
            case 'y':
                this.shield = 50;
                break;
            case 'N':
            case 'n':
                System.out.println("Okay");
                break;
            default:
                System.out.println("Wrong input, try again");
        }
    }

    public int getHealth() {
        if(health < 0)
            return 0;
        else
            return health;
    }

    //some player information
    public String getStats() {
        return name + " has: " + health + " HP and " + shield + " Shield Points";
    }

    public boolean isAlive(){
        return health > 0;
    }
}
