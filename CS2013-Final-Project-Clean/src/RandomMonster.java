import java.util.ArrayList;
import java.util.Random;

public class RandomMonster {
    private final ArrayList<Monster> monsters = new ArrayList<>();

    public RandomMonster(){
        monstersList();
    }

    public Monster randomMonster(){
        return monsters.get(chooseRandomIndex());
    }

    private int chooseRandomIndex(){
        Random random = new Random();

        return random.nextInt(monsters.size());
    }

    private void monstersList(){
        Asset asset1 = new Asset("Monster sword", "Sword", 30, "Sword for monster");

        Monster monster1 = new Monster("Orc", "Humanoid", 75, asset1);
        Monster monster2 = new Monster("Cave Spider", "Spider", 50, asset1);
        Monster monster3 = new Monster("Dark Link", "Humanoid", 100, asset1);
        Monster monster4 = new Monster("Zombie", "Zombie", 100, asset1);

        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);
        monsters.add(monster4);

    }

    public static void main(String[] args){
        RandomMonster randomMonster = new RandomMonster();

        Monster monster = randomMonster.randomMonster();

        System.out.println(monster.getName());
    }
}
