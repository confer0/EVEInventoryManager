import java.util.ArrayList;
/*
 * stores the item checks
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ItemCheckQuery{

    ArrayList<ItemCheck> list;
    //constructors, first one allows the creation with a pre-existing ArrayList of ItemChecks
    public ItemCheckQuery(ArrayList<ItemCheck> newList){
        list = newList;
    }

    public ItemCheckQuery(){
        list = new ArrayList<ItemCheck>();
    }

    // adds a new ItemCheck
    public void addItemCheck(ItemCheck newItemCheck){
        list.add(newItemCheck);
    }
    
    //removes the first instance ItemCheck with a corrisponding ID
    //returns true if removal successful
    //returns false if item not found
    public boolean removeItemCheck(int ID){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == ID){
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //next segment includes so get methods with different search options
    
    //gets the first ItemCheck with the corrisponding ID
    //returns null if none are found
    public ItemCheck getItemCheck(int ID){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == ID){
                return list.get(i);
            }
        }
        return null;
    }
    
    //gets the first ItemCheck with the corrisponding ID AND checktype
    //returns null if none are found
    public ItemCheck getItemCheck(int ID, int checkType){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == ID && list.get(i).getType() == checkType){
                return list.get(i);
            }
        }
        return null;
    }
    
    
    
    //accepts an ItemList and then returns an array of strings containing the results of every check done
    //against the ItemList
    String[] getChecks(ItemList items){
        String[] errors = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            try{
                //runs the check and returns a string containing the error if there is one
                //returns a message of success if VICTORY ACHIEVED
                int ID = list.get(i).getID();
                if(list.get(i).check(items.getItem(ID)) == false){
                    errors[i] = list.get(i).toString();
                }else{
                    errors[i] = "success at " + i;
                }
                
                
                
            }catch(IndexOutOfBoundsException e){//This part here occurs when then
                switch(list.get(i).getType()){
                    //int this case, the account quantity must be of a value greater than the check
                    //therefore not existing is of zero value and ist less than.
                    case 0:
                    errors[i] = list.get(i).toString();
                    break;
                     
                    //in this case, the Account quantity  must be of lower value than the check
                    //therefore not existing satisfies this condition
                    case 1:
                    errors[i] = "success at " + i;
                    break;
                    
                    //in the next two cases, the Account value will be treated as zero because it 
                    //does not exist
                    case 2:
                    errors[i] = list.get(i).toString();
                    break;
                    
                    case 3:
                    errors[i] = "success at " + i;
                    break;
                    
                    default:
                    errors[i] = "ERROR IN ItemCheckQuery String[] getChecks(ItemList items)";
                    break;
                }
                
            }
        }
        return errors;
    }

}