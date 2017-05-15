package eve;

public class comparison {
	final static double UPPERALERT=2.00;
	final static double LOWERALERT=0.50;	
	public static void compareToMarket(Item item){
		Item storeData =Functions.itemData(item.getID());
		System.out.println("the current market price of "+item.getName()+" is"+storeData.getPrice());
		System.out.println("the price per unit of your "+item.getName()+"is"+item.getPrice());
		if (item.getPrice()>storeData.getPrice()){
			System.out.println("the current market price of "+item.getName()+" is"+(1-(storeData.getPrice()/item.getPrice()))*100+"percent lower than the price of your "+item.getName());
			if (storeData.getPrice()/item.getPrice()<LOWERALERT){
				//alert
			}
		}
		if (item.getPrice()<storeData.getPrice()){
			System.out.println("the current market price of "+item.getName()+" is"+((storeData.getPrice()/item.getPrice())-1)*100+"percent higher than the price of your "+item.getName());
			if (storeData.getPrice()/item.getPrice()>UPPERALERT){
				//alert
			}
		}
	}
}
