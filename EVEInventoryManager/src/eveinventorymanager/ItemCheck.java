package eveinventorymanager;

import java.sql.Timestamp;
import java.util.Calendar;
/*
This class is designed to store information on the required quantities of items that need to be on stock.
The program may check these ItemChecks inorder to determine wether or not an item needs to be restocked.


-------------------------------------------
CHECK TYPES
-------------------------------------------
0) quantity must be more than check quantity
1) quantity must be less than check quantity
2) price must be more than
3) price must be less than

more checks may be added in the future


*/
public class ItemCheck{

    
    //id of object
    private final int ID;
    
    //value to compare to
    private double compareTo;
    
    //type of check that occurs
    private final int checkType;
    
    
    //constructor
    //all these fields are required
    public ItemCheck(int newID, int newCheckType, double newCompareTo){
        ID = newID;
        compareTo = newCompareTo;
        checkType = newCheckType;
    }
    
    //returns the type of check as an int
    public int getType(){
        return checkType;
    }
    
    //sets the quantity of the check to a new value
    public void setCompare(double newValue){
        compareTo = newValue;
    }
    
    //returns quantity of the check
    public double getCompare(){
        return compareTo;
    }
    
    //returns ID of check
    public int getID(){
        return ID;
    }
    
    //returns false if the item fails the check
    public boolean check(ItemList accountList){
        Item newItem = accountList.getItem(ID);
        if(newItem==null) {newItem = new Item(Functions.itemName(ID),0,0,ID);}
        switch(checkType){
            case 0: //quantity must be more than
        return newItem.getQnt() > compareTo;
            
            case 1: //quantity must be less than
        return newItem.getQnt() < compareTo;
            
            case 2: //price must be more than
        return newItem.getTotalValue() > compareTo;
            
            case 3: //price must be less than
        return newItem.getTotalValue() < compareTo;
            
            default://if you get here, the check you requested for does not exist
        return false;
        }
    }
    
    public String getReport(ItemList list) {
        if(check(list)) {
            Item item = list.getItem(ID);
            if(item==null) {item = new Item(Functions.itemName(ID),0,0,ID);}
            switch(checkType) {
                case 0:
                    return "Quantity of "+item.getName()+" is above threshold.\n";
                case 1:
                    return "Quantity of "+item.getName()+" is below threshold.\n";
                case 2:
                    return "Value of "+item.getName()+" is above threshold.\n";
                case 3:
                    return "Value of "+item.getName()+" is below threshold.\n";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }
    
    public Object[] toArray() {
        String value;
        String item;
        String condition;
        String amount;
        if(checkType<2) {value="Quantity of";} else {value="Value of";}
        item = Functions.itemName(ID);
        if(checkType%2==0) {condition="is above";} else {condition="is below";}
        amount = compareTo+"";
        return new Object[]{value,item,condition,amount};
    }
    
}