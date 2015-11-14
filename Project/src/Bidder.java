import java.io.IOException;
import java.util.Scanner;

/**
 * @author Stepan Adespya
 *
 */
public class Bidder {

	/**
	 * @throws IOException 
	 * 
	 */
	public Bidder(User u) throws IOException {
		System.out.println("Welcome :" + u.username);
		System.out.println("Press 1 to see availiable auctions");
		System.out.println("Press 2 to see bidded items");
		System.out.println("Press 3 log out");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != 1 && input != 2 && input != 3){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch(input){
		case 1:
			viewOpenAuctions();
			
			break;
		case 2:
			viewItemsBidded(u);
			System.out.println("Enter item ID to edit bid or -1 to go back: ");
			int select = reader.nextInt();
			Inventory i = new Inventory();
			Item it =  i.getItem(select);
			if(select == -1){
				new Bidder(u);
			}else{
				System.out.println("Enter the amount you want to change? $");
				double money = reader.nextDouble();
				editBid(u,it,money);
				System.out.println("Bid changed");
				new Bidder(u);
			}
			
			break;
		case 3:
			new Users();
			break;
		}
		
	}
	
	public void viewItem(User u,Item i) throws IOException{
		System.out.println(i.toString());
		System.out.println("Press 1 to Bid");
		System.out.println("Press 2 to go back to menu");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != 1 && input != 2 && input != 3){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch(input){
		case 1:
			System.out.println("How much do you want to bid? $");
			double money = reader.nextDouble();
			//bidList a = new bidList();
			//a.addBid(.......);
			System.out.println("Bid entered");
			new Bidder(u);
			break;
		case 2:
			new Bidder(u);
			break;
		}
	}
	
	public void editBid(User u,Item i,double money) throws IOException{
		bidList b = new bidList();
		b.editBid(u, i , money);
	}
	
	public void viewOpenAuctions(){
		//Calendar c = new Calendar();
		//c.viewFuturAuctions();
	}
	
	private void viewItemsBidded(User u) throws IOException{
		Inventory i = new Inventory();
		i.allItemsBidder(u);
	}

}