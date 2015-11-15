import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Stepas
 *
 */
public class AuctionCentralEmployee {
	private int CALENDAR = 1;
	private int AUCTIONS = 2;
	

	/**
	 * @throws ParseException 
	 * 
	 */
	public AuctionCentralEmployee(User u) throws ParseException {
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
			System.out.println("Enter the Month you want to view(1-12)");
			int month = reader.nextInt();
			System.out.println("Enter the Year you want to view(EX. 2015)");
			int year = reader.nextInt();
			viewCalendar(u,month,year);
			break;
		case 2:
			viewAuctionDetails(u);
			break;
		}
		
	}
	
	public void viewAuctionDetails(User u) throws ParseException{
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		System.out.println("Select Auction(Number) :");
		c.viewFutureAuctions();
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int select = reader.nextInt();
		Auction a = c.futureAuctionList.get(select);
		System.out.println(a.printDetials());
		System.out.println("Press 1 to return to main menu");
		int input = reader.nextInt();
		while(input != AUCTIONS){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		if(input == 1){
			new AuctionCentralEmployee(u);
		}
	}
	
	public void viewCalendar(User u,int month, int year) throws ParseException{
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		c.printCalendarMonthly(month, year);
		System.out.println("Press 1 to return to main menu");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != AUCTIONS){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		if(input == 1){
			new AuctionCentralEmployee(u);
		}
	}

}
