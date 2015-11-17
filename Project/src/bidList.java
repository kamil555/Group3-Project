import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class bidList {
	ArrayList<Bid> Bidlist;

	/**
	 * create a arraylist for bid and read from Bid.txt
	 * @throws IOException
	 */
	public bidList() throws IOException{
		Bidlist = new ArrayList<Bid>();

		readFileToBid("Bids.txt"); 

	}

	/**
	 * add a new bid info to arraylist and save to Bids.txt
	 * @param user: get the user info from bider class
	 * @param bid: create a new Bid list 
	 * @throws IOException
	 */
	public void addBid(User user, Bid b) throws IOException {
		Bid per = new Bid(user.username, b.getItemID(),b.getBidAmount());
		Inventory i = new Inventory();
		Item it = i.getItem(b.getItemID());
		if(b.getBidAmount() >= it.startBid) {
			Bidlist.add(per);
			String blist = ""+user.username+","+b.getItemID()+","+b.getBidAmount();
			writeToFile("Bids.txt", blist);
		}
	}

	/**
	 * edit the previews bid price
	 * @param user: get the user info from bider class
	 * @param bid: create a new Bid list 
	 * @param bidAmount: 
	 * @throws IOException
	 */
	public void editBid(User user, Item item, double bidAmount) throws IOException {
		for(int i =0; i < Bidlist.size(); i++) {
			if(Bidlist.get(i).getuserName().endsWith(user.username) 
					&& bidAmount > item.startBid && item.itemID == Bidlist.get(i).getItemID()) {
				Bidlist.get(i).setBidAmount(bidAmount);
				clearFile("Bids.txt");
				writeAllItemsToFile("Bids.txt");
			}
		}
	}
	/**
	 * Cancel the bid for this Auction
	 * @param user: get the user info from bider class
	 * @param bid: create a new Bid list 
	 * @throws IOException
	 */
	public void cancelBid(User user, Item item) throws IOException {
		for(int i =0; i < Bidlist.size(); i++) {
			if(Bidlist.get(i).getuserName().equalsIgnoreCase(user.username) && item.itemID == Bidlist.get(i).getItemID()) {
				Bidlist.remove(i);
				clearFile("Bids.txt");
				writeAllItemsToFile("Bids.txt");
			}
		}
	}
	/**
	 * check the winning bid price for the item
	 * @param item info
	 * @return the User's name of this item
	 */
	public String isWinBid(Item item) {
		int winner = 0;
		for(int i = 0; i < Bidlist.size(); i++) {
			if(Bidlist.get(winner).getBidAmount() < Bidlist.get(i).getBidAmount()) {
				winner = i;
			}	
		}

		return "userName is:" + Bidlist.get(winner).getuserName() + " Amount is:" + Bidlist.get(winner).getBidAmount();

	}

	/**
	 * write this array list to the Bid.txt
	 * @param string write to the file
	 * @param blist the array list
	 * @throws IOException
	 */
	private void writeToFile(String string, String blist) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(string);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(blist+"\r\n");
		pw.close();
	}
	/**
	 * write all items to Bid.txt
	 * @param string
	 * @throws IOException
	 */
	private void writeAllItemsToFile(String string) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(string);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0;i< Bidlist.size(); i++){
			pw.write(Bidlist.get(i)+"\r\n");
		}
		pw.close();
	}
	
	/**
	 * Clear the file
	 * @param string
	 * @throws IOException
	 */
	private void clearFile(String string) throws IOException {
		FileWriter fw = new FileWriter(string,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("");
		pw.close();
	}
	
	/**
	 * read file to the array list
	 * @param fileName file' name 
	 */
	private void readFileToBid(String fileName){
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String[] split = line.split(",", 3);
				String userName = split[0];
				String itemID = split[1];
				String bidAmount = split[2];
				int id = Integer.parseInt(itemID);
				double money = Double.parseDouble(bidAmount);
				Bidlist.add(new Bid(userName,id,money));

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
}
