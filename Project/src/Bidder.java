import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Stepas
 *
 */
public class Bidder {
	private int AUCTIONS = 1;
	private int BIDS = 2;
	private int BID = 1;
	private int MENU = 2;
	//private ArrayList<Item> biddedItems;

	/**
	 * 
	 */
	public Bidder(User u) {
		//biddedItems = new ArrayList<Item>();
		System.out.println("Welcome :" + u.username);
		System.out.println("Press 1 to see availiable auctions");
		System.out.println("Press 2 to see bidded items");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != AUCTIONS && input != BIDS){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		if(input == AUCTIONS){
			viewOpenAuctions();
		}else if(input == BIDS){
			viewItemsBidded(u);
		}
		
	}
	
	public void viewItem(User u,int ID){
		//Item i = new Item();
		//i.getInfo(ID);
		System.out.println("Press 1 to Bid");
		System.out.println("Press 2 to go back to menu");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != AUCTIONS && input != BIDS){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		if(input == BID){
			System.out.println("How much do you want to bid? $");
			int money = reader.nextInt();
			//Bid a = new Bid(u,ID,money);
		}else if(input == MENU){
			new Bidder(u);
		}
	}
	
	public void editBid(User u,int ID, int money){
		//Item i = new Item();
		//i.getItem(ID).editBid(u.username,money);
	}
	
	public void viewOpenAuctions(){
		//Auction a = new Auction();
		//a.listFutureAuctions();
	}
	
	private void viewItemsBidded(User u){
		//Item i = new Item();
		//i.searchUser(u);
	}

}
