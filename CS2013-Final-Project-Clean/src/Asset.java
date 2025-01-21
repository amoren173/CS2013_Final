public class Asset {
    final private String name;
    final private String type;
    final private int effect;
    final private String description;

    public Asset(String name, String type, int effect, String description){
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }

    public int getEffect(){
        return effect;
    }

    public String getDescription(){
        return description;
    }


    @Override
    public String toString(){
        return "Item type: " + name + "\nDescription: " + description;
    }
}
