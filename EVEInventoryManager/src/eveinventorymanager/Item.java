package eveinventorymanager;


//Abstract class all items.
//Items need to be defined by what kind of item they are.
public class Item implements java.io.Serializable {   
    //name of item
    private String name;
    //number of items
    private int quantity;
    //current average price per unit
    private double avgPrice;
    //Item type ID
    //dependant on subclass
    private final int ID;
    //constructor for creating a new item
    public Item(String newName, int newQnt, double newPrice, int newID){
        name = newName;
        quantity = newQnt;
        avgPrice = newPrice;
        ID = newID;
    }
    
    @Override
    public String toString(){
        return "Item Name: " + name
        + "\nItem Type: " + ID
        + "\nQuantity : " + quantity
        + "\nPrice    : " + avgPrice;
        
    }
    
    
    //these methods are used for adding and subtracting items.
    //average price must be included.
    public void add(int newQnt, double price){
        avgPrice = ((quantity*avgPrice)+(newQnt*price))/(newQnt+quantity);
        quantity += newQnt;
    }
    
    public void subtract(int soldQnt){
        quantity -= soldQnt;
    }
    
    //returns current quantity
    public int getQnt(){
        return quantity;
    }
    
    //returns current average price
    public double getPrice(){
        return avgPrice;
    }
    
    //returns subclass ID
    public int getID(){
        return ID;
    }
    
    //returns name
    public String getName(){
        return name;
    }
    
    //>:(
    //dealwithit
    public double getTotalValue() {
        return avgPrice*quantity;
    }
}
