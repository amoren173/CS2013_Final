import java.util.ArrayList;
import java.util.Random;

public class RandomPotion {
    private final ArrayList<Asset> potions = new ArrayList<>();

    public RandomPotion(){
        potionsList();
    }

    public Asset randomAsset(){
        return potions.get(chooseRandomIndex());
    }

    private int chooseRandomIndex(){
        Random random = new Random();

        return random.nextInt(potions.size());
    }


    private void potionsList(){
        Asset damagePotion1 = new Asset("-5 health potion", "Damage Potion",-5, "Damage 5 HP");
        Asset damagePotion2 = new Asset("-10 health potion", "Damage Potion",-10, "Damage 10 HP");
        Asset damagePotion3 = new Asset("-15 health potion", "Damage Potion",-15, "Damage 15 HP");
        Asset damagePotion4 = new Asset("-20 health potion", "Damage Potion",-20, "Damage 20 HP");
        Asset damagePotion5 = new Asset("-25 health potion", "Damage Potion",-25, "Damage 25 HP");
        Asset damagePotion6 = new Asset("Ultimate damage potion", "Damage Potion",-50, "Damage 50 HP");

        potions.add(damagePotion1);
        potions.add(damagePotion2);
        potions.add(damagePotion3);
        potions.add(damagePotion4);
        potions.add(damagePotion5);
        potions.add(damagePotion6);

    }

    public static void main(String[] args){
        RandomPotion randomPotion = new RandomPotion();

        Asset asset = randomPotion.randomAsset();

        System.out.println(asset.getName());
    }
}
