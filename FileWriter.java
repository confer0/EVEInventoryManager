package eve;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
	final String FILENAME = "filename.txt";

	public FileWriter() {

	}

	public void write(ItemList list) {
		try (PrintWriter out = new PrintWriter(FILENAME)) {
			Item item = new Item("name", 0, 0, 0, 0);
			for (int i = 0; i < list.items.size(); i++) {

				item = list.items.get(i);
				out.println(item.getID() + "");
				out.println(item.getName() + "");
				out.println(item.getPrice() + "");
				out.println(item.getQnt() + "");
				out.println(item.getVolume() + "");
			}
		} catch (FileNotFoundException e) {
			System.out.println("nope");

		}

	}

	public ItemList read() {
		ItemList list = new ItemList();
		try {
			BufferedReader br = null;
			FileReader fr = null;

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String s;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((s = br.readLine()) != null) {

				int ID = Integer.parseInt(s);
				String name = br.readLine();
				double price = Double.parseDouble(br.readLine());
				int qnt = Integer.parseInt(br.readLine());
				int volume = Integer.parseInt(br.readLine());
				System.out.println(ID + name + price + qnt + volume);
				Item item = new Item(name, qnt, volume, price, ID);
				list.addNewItem(item);
				// String newName, int newQnt, int newVol, double newPrice, int
				// newID
			}

		} catch (IOException e) {
			System.out.println("error message");
		} finally {
			return list;
		}
	}

	public static void main(String[] args) {
		ItemList i = new ItemList();
		Item item = new Item("thisname", 1, 2, 3, 4);
		i.addNewItem(item);
		i.addNewItem(item);
		FileWriter a = new FileWriter();
		a.write(i);
		a.read();
	}
}