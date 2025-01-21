import java.util.ArrayList;
import java.util.Arrays;


public class Inventory {
    final int listSize = 10;
    private ArrayList<Asset> items = new ArrayList<>();

    public Inventory (){

    }
    //gets item from inventory
    public Asset getItem(int location){
        Asset asset = null; //remember to take "null" in account in other code that uses this method
        if(location >= 0 && location < listSize){
            asset = items.get(location);
        }
        else if (location > listSize || location < 0) {
            System.out.println("Inventory index out of bounds");
        }
        else
            System.out.println("Cant get item at zero");

        return asset;
    }

    //adds item to inventory
    public void addItem(Asset item){
        if(this.items.size() < listSize)
            this.items.add(item);
        else
            System.out.println("Inventory full - Max size is 10 - item: " + item.getName() + " was not added");
    }


    //deletes item from inventory
    public void removeItem(int location){
        if (location > 0 && location < listSize){
            items.remove(location);
        }
        else if (location > listSize || location < 0) {
            System.out.println("Inventory index out of bounds");
        }
        else
            System.out.println("Can't delete item at position 0 or");
        //check if i should instead return the int value of item rather than the object item

    }

    //Returns an item and then deletes it
    //The reason for this method, is because I may delete items but not want the object, or I may want to access the object, but not delete it.
    public Asset getAndRemoveItem(int location){
        Asset holder = null;
        if (location > 0 && location < listSize){
            holder = items.get(location);
            items.remove(location);
        }
        else if (location > listSize || location < 0) {
            System.out.println("Inventory index out of bounds");
        }
        else
            System.out.println("Can't delete item at position 0 or");
        //check if i should instead return the int value of item rather than the object item
        return holder;

    }


    @Override
    public String toString(){
        String[] itemsArray = new String[listSize];
        for (int i = 0; i < this.items.size(); i++){
            itemsArray[i] = items.get(i).getName();
        }

        return(Arrays.toString(itemsArray));
        //check if you can redue this method with out needing the array
    }

}
