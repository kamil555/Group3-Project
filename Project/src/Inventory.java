import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Inventory {
	ArrayList<Item> listofItems ;
	int size;

	public Inventory(){
		listofItems = new ArrayList<Item>();
		size = listofItems.size();
		readFile("Inventory.txt"); 
	}

	public void addItem(Item i) throws IOException{
		listofItems.add(i);
		writeToFile("Inventory.txt",i.toString());
	}

	public void editItemName(int itemID, String newName) throws IOException{
		listofItems.get(itemID).setItemName(newName);
		writeAllItemsToFile("Inventory.txt");
	}
	public void editItemStartBid(int itemID, double startBid) throws IOException{
		listofItems.get(itemID).setStartBid(startBid);
		writeAllItemsToFile("Inventory.txt");
	}
	public void editItemInfo(int itemID, String info) throws IOException{
		listofItems.get(itemID).setItemInfo(info);;
		writeAllItemsToFile("Inventory.txt");
	}

	private void writeAllItemsToFile(String fileName) throws IOException {
		clearFile(fileName);
		for(int i = 0; i< listofItems.size(); i++){
			writeToFile(fileName,listofItems.get(i).toString());
		}

	}
	
	private void clearFile(String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("");
		pw.close();
	}

	public void allItemsAuction(Auction a){
		for(int i = 0; i < listofItems.size();i++){
			if(listofItems.get(i).auctionName.endsWith(a.getAuctionName())){
				System.out.println(i+") "+listofItems.get(i).toString());
			}
		}
	}

	public void allItemsBidder(User u) throws IOException {
		bidList b = new bidList();
		for(int i = 0; i < b.Bidlist.size();i++){
			if(b.Bidlist.get(i).getuserName().endsWith(u.username)){
				System.out.println(i+") "+b.Bidlist.get(i).toString());
			}
		}
	}

	public void viewAllitems() {
		for(int i = 0; i <listofItems.size(); i++){
			System.out.println(i+") "+ listofItems.get(i).toString());
		}

	}

	public Item getItem(int ID) {
		return listofItems.get(ID);
	}

	private void readFile(String fileName){
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String[] split = line.split(",", 5);
				String sitemID = split[0];
				int itemID = Integer.parseInt(sitemID);
				String auctionName = split[1];
				String start = split[2];
				double startbid = Double.parseDouble(start);
				String itemName = split[3];
				String itemInfo = split[4];
				listofItems.add(new Item(itemID,auctionName,startbid,itemName,itemInfo));
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");                  
		}
	}

	private void writeToFile(String fileName,String contents) throws IOException{
		FileWriter fw = new FileWriter(fileName,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(contents+"\r\n");
		pw.close();
	}

}
