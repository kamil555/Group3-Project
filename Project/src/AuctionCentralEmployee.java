import java.util.Scanner;

/**
 * @author Stepas
 *
 */
public class AuctionCentralEmployee {
	private int CALENDAR = 1;
	private int AUCTIONS = 2;
	

	/**
	 * 
	 */
	public AuctionCentralEmployee(User u) {
		System.out.println("Employee :"+ u.username);
		System.out.println("Press 1 to view calendar");
		System.out.println("Press 2 to view Auction Details");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != AUCTIONS && input != CALENDAR){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch(input){
		case 1:
			viewCalendar();
			break;
		case 2:
			viewAuctionDetails();
			break;
		}
		
	}
	
	public void viewAuctionDetails(){
		//Calender c = new Calendar();
		//c.viewFutureAuctions();
		System.out.println("Enter the aution you want details:");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int auctionID = reader.nextInt();
		//c.viewAuctionDetails(auctionID);
	}
	
	public void viewCalendar(){
		//Calendar c = new Calendar();
		//c.viewCalendarMonthly();
	}

}
