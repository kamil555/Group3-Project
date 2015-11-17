import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class bidList {
	ArrayList<Bid> Bidlist;

	public bidList() throws IOException{
		Bidlist = new ArrayList<Bid>();

<<<<<<< HEAD
		readFileToBid("Bids.txt"); 

	}

	public void addBid(User user, Bid b) throws IOException {
		Bid per = new Bid(user.username, b.getItemID(),b.getBidAmount());
		Inventory i = new Inventory();
		Item it = i.getItem(b.getItemID());
		if(b.getBidAmount() >= it.startBid) {
			Bidlist.add(per);
			String blist = ""+user.username+","+b.getItemID()+","+b.getBidAmount();
			writeToFile("Bids.txt", blist);
		}
		//		if(item.winBid == null) {
		//			item.winBid = bidAmount;
		//			item.winUser = user.username;
		//		}
		//		
		//		if(bidAmount > item.winBid) {
		//			item.winBid = bidAmount;
		//			item.winUser = user.username;
		//		}
	}

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

	public void cancelBid(User user, Item item) throws IOException {
		for(int i =0; i < Bidlist.size(); i++) {
			if(Bidlist.get(i).getuserName().equalsIgnoreCase(user.username) && item.itemID == Bidlist.get(i).getItemID()) {
				Bidlist.remove(i);
				clearFile("Bids.txt");
				writeAllItemsToFile("Bids.txt");
			}
		}
=======
		readFileToBid("bidlist.txt"); 

	}

	private void addBid(User user, double bidAmount, Item item) throws IOException {
		Bid per = new Bid(user.username, item.itemID, bidAmount);

		if(bidAmount >= item.startBid) {
			String blist = ""+user.username+","+item.itemID+","+bidAmount;
			writeToFile("bidlist.txt", blist);
		}
	}

	private void editBid(User user, double bidAmount, int id, Item item) throws IOException {
		for(int i =0; i < Bidlist.size(); i++) {
			if(Bidlist.get(i).getuserName().endsWith(user.username) && bidAmount > item.startBid && id == item.itemID) {
				Bidlist.get(i).setBidAmount(bidAmount);
				clearFile("bidlist.txt");

				for(int j=0; j< Bidlist.size();i++ ) {
					writeToFile("bidlist.txt", Bidlist.get(j).toString());
				}
			}
		}
	}
	
	private void cancelBid(User user, Item item, int id) throws IOException {
		for(int i =0; i < Bidlist.size(); i++) {
			if(Bidlist.get(i).getuserName().endsWith(user.username) &&  id == item.itemID) {
				Bidlist.remove(i);
				clearFile("bidlist.txt");
				
				for(int j=0; j< Bidlist.size();i++ ) {
					writeToFile("bidlist.txt", Bidlist.get(j).toString());
				}
			}
		}
	}
	
	private String isWinBid(Item item) {
		int winner = 0;
		for(int i = 0; i < Bidlist.size(); i++) {
			if(Bidlist.get(winner).getBidAmount() < Bidlist.get(i).getBidAmount()) {
				winner = i;
			}	
		}
		
		return "userName is:" + Bidlist.get(winner).getuserName() + "Amount is:" + Bidlist.get(winner).getBidAmount();
		
	}


	private void writeToFile(String string, String blist) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(string);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(blist+"\r\n");
		pw.close();

>>>>>>> bid-inventory
	}

	public String isWinBid(Item item) {
		int winner = 0;
		for(int i = 0; i < Bidlist.size(); i++) {
			if(Bidlist.get(winner).getBidAmount() < Bidlist.get(i).getBidAmount()) {
				winner = i;
			}	
		}

		return "userName is:" + Bidlist.get(winner).getuserName() + " Amount is:" + Bidlist.get(winner).getBidAmount();

	}


	private void writeToFile(String string, String blist) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(string);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(blist+"\r\n");
		pw.close();
	}
	
<<<<<<< HEAD
	private void writeAllItemsToFile(String string) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(string);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0;i< Bidlist.size(); i++){
			pw.write(Bidlist.get(i)+"\r\n");
		}
		pw.close();
	}

	private void clearFile(String string) throws IOException {
		FileWriter fw = new FileWriter(string,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("");
		pw.close();
	}

	private void readFileToBid(String fileName){
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);
=======
	private void clearFile(String string) throws IOException {
		FileWriter fw = new FileWriter(string,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.print("");
		pw.close();
	}

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
>>>>>>> bid-inventory

			while((line = bufferedReader.readLine()) != null) {
				String[] split = line.split(",", 3);
				String userName = split[0];
				String itemID = split[1];
				String bidAmount = split[2];
				int id = Integer.parseInt(itemID);
				double money = Double.parseDouble(bidAmount);
				Bidlist.add(new Bid(userName,id,money));

<<<<<<< HEAD
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
=======
>>>>>>> bid-inventory
