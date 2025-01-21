public  class Monster {
    private String name;
    private final String type;
    private int health;
    private final Asset sword;

    public Monster(String name, String type, int health, Asset sword){
        this.name = name;
        this.type = type;
        this.health = health;
        this.sword = sword;
    }
    public void gainHealth(int amount){
        this.health = health + amount;
    }
    public void takeDamage (int amount){
        this.health = health - amount;
    }
    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Asset getSword(){
        return sword;
    }

    public boolean isAlive(){
        return health > 0;
    }

}
