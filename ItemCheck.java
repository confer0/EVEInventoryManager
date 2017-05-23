import java.sql.Timestamp;
import java.util.Calendar;
/*
This class is designed to store information on the required quantities of items that need to be on stock.
The program may check these ItemChecks inorder to determine wether or not an item needs to be restocked.


-------------------------------------------
CHECK TYPES
-------------------------------------------
0) must be more than check quantity
1) must be less than check quantity


more checks may be added in the future


*/
public class ItemCheck{

    
    //id of object
    private final int ID;
    //quantity number that get checks
    private int quantity;
    //type of check that occurs
    private final int checkType;
    
    //constructor
    //all these fields are required
    public ItemCheck(int newID, int newQuantity, int newCheckType){
        ID = newID;
        quantity = newQuantity;
        checkType = newCheckType;
    }
    
    //returns the type of check as an int
    public int getType(){
        return checkType;
    }
    
    //sets the quantity of the check to a new value
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    
    //returns quantity of the check
    public int getQuantity(){
        return quantity;
    }
    
    //returns ID of check
    public int getID(){
        return ID;
    }
    
    //returns false if the item fails the check
    public boolean check(Item newItem){
        switch(checkType){
            case 0://must be more than
            if(newItem.getQnt() > quantity){
                return true;
            }else{
                return false;
            }
            case 1://must be less than
            if(newItem.getQnt() < quantity){
                return true;
            }else{
                return false;
            }
            default://if you get here, the check you requested for does not exist
                return false;
        }
    }
    
    //returns the ItemCheck's info
    public String toString(){
        return "Item: " + ID + " " + checkType + " " + quantity;
    }
    
}