public class Cave {
    final public int id;

    public Cave(int id){
        this.id = id;
    }
    //cave rooms
    Cave up;
    Cave down;
    Cave east;
    Cave west;

    //how much health the player loses for going to the cave
    public int cost;

    //monsters
    public Monster monster1;
    public Monster monster2;

    public Asset potion;

}
