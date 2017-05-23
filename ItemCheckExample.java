public class ItemCheckExample{
    public static void main(String []args){
        ItemCheckQuery que = new ItemCheckQuery();
        ItemList list = new ItemList();
        String[] shit = que.getChecks(list);
        for(int i = 0; i < shit.length; i++){
            System.out.println(shit[i]);
        }
    }
}
