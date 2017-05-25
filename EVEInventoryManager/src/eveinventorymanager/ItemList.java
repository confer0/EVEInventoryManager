package eveinventorymanager;

import java.util.ArrayList;

public class ItemList implements java.io.Serializable {

    ArrayList<Item> items;

    //constructor
    public ItemList(){
        items = new ArrayList();

    }

    //searches for and returns an item with a matching ID or name
    public Item getItem(int ID){
        for(int i = 0; i < items.size(); i++){
            Item itemSelector = items.get(i);
            if(itemSelector.getID() == ID){
                return itemSelector;
            }
        }
        return null;
    }

    public Item getItem(String name){
        for(int i = 0; i < items.size(); i++){
            Item itemSelector = items.get(i);
            if(itemSelector.getName().toLowerCase().equals(name.toLowerCase())){//Sean ya dingus, you used == here!
                return itemSelector;
            }
        }
        return null;
    }

    //adds a new item to the list
    public void addNewItem(Item newItem){
        items.add(newItem);
    }

    //removes a item base on ID. returns true if item was removed.
    //returns false if the item was not found.
    public boolean deleteItem(int ID){
        return items.remove(getItem(ID));
    }

    public boolean deleteItem(String name){
        return items.remove(getItem(name));
    }

    //searches for an item by name and returns its ID number
    public int getID(String name){
        return getItem(name).getID();
    }

    //visions of useful method
    public int getID(int ID){
        return ID;
    }

    //returns the name of an item with a matching ID
    public String getName(int ID){
        return getItem(ID).getName();
    }

    //returns the quantity removed. For example:
    //if you say remove 10 when there is only 7,
    //it removes all available qnt and returns 7
    /*
    public int removeQnt(int ID, int qnt){
    Item itemSelector = getItem(ID);
    int remainder = 
    }
     */
    //public int removeQnt(String name, int qnt){

    //}

    //searches for and returns the total quantity of an item with the matching ID
    public int getQnt(int ID){
        return getItem(ID).getQnt();
    }

    public int getQnt(String name){
        return getItem(name).getQnt();
    }

    //searches for and returns the price per unit of an item with the matching ID
    public double getPrice(int ID){
        return getItem(ID).getPrice();
    }

    public double getPrice(String name){
        return getItem(name).getPrice();
    }

    //searches for and returns the total price of an item account with the matching ID
    public double getTotalPrice(int ID){
        return getItem(ID).getPrice()*getItem(ID).getQnt();
    }

    public double getTotalPrice(String name){
        return getItem(name).getPrice()*getItem(name).getQnt();
    }

     public void AlphaSort() {
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if ((items.get(n).getName()).compareToIgnoreCase(items.get(n+1).getName()) > 0) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
	}
	public void ReverseAlphaSort() {
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if ((items.get(n).getName()).compareToIgnoreCase(items.get(n+1).getName()) < 0) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
        }
	public void AmtSortGtoS() {
            //greatest to smallest
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if (items.get(n).getQnt()<items.get(n+1).getQnt()) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
	}
	public void AmtSortStoG() {
            //greatest to smallest
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if (items.get(n).getQnt()>items.get(n+1).getQnt()) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
	}
	public void ValSortStoG() {
            //greatest to smallest
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if (items.get(n).getTotalValue()>items.get(n+1).getTotalValue()) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
	}
	public void ValSortGtoS() {
            //greatest to smallest
            boolean flag = true;
            while(flag) {
                flag = false;
                for(int n=0;n<items.size()-1;n++) {
                    if (items.get(n).getTotalValue()<items.get(n+1).getTotalValue()) {
                        items.add(n, items.remove(n+1));flag=true;
                    }
                }
            }
	}

    //Converts to table for use in AccountFrame's table
    public Object[][] toTable(String param,int sortOption) {
        switch(sortOption) {
            case 0:AlphaSort();break;
            case 1:ReverseAlphaSort();break;
            case 2:ValSortStoG();break;
            case 3:ValSortGtoS();break;
            case 4:AmtSortStoG();break;
            case 5:AmtSortGtoS();break;
        }
        Object[][] table = new Object[items.size()][4];
        for(int i=0;i<items.size();i++) {
            Item item = items.get(i);
            if(item.getName().toLowerCase().contains(param.toLowerCase())) {
                table[i] = new Object[]{item.getName(),item.getQnt(),item.getPrice(),item.getTotalValue()};
            }
        }
        return table;
    }
    
    //Outputs array of item names for Buy and Sell Frame ComboBoxes.
    public String[] toNameArray() {
        String[] array = new String[items.size()];
        for(int i=0;i<items.size();i++) {
            array[i] = items.get(i).getName();
        }
        return array;
    }
}
