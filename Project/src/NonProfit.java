import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Stepan Adespya
 *
 */
public class NonProfit {

	/**
	 * @throws ParseException 
	 * @throws IOException 
	 * 
	 */
	public NonProfit(User u) throws ParseException, IOException {
		System.out.println("Welcome :"+ u.username);
		System.out.println("Organization :"+ u.organization);
		System.out.println("Press 1 to schedule an auction");
		System.out.println("Press 2 to edit auction information");
		System.out.println("Press 3 to enter add item to inventory ");
		System.out.println("Press 4 to edit inventory item information");
		System.out.println("Press 5 to Log out");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch(input){
		case 1:
			System.out.println("Enter Auction Information: ");
			System.out.println("Enter Month(1-12): ");
			int month = reader.nextInt();
			System.out.println("Enter Day(Integer): ");
			int day = reader.nextInt();
			System.out.println("Enter Year(Integer): ");
			int year = reader.nextInt();
			if(checkDate(month,day,year)){
				System.out.println("Enter Hour Auction to Start(0-23): ");
				int hour = reader.nextInt();
				System.out.println("Enter Minute Auction to Start(0-59): ");
				int minute = reader.nextInt();
				System.out.println("Enter Second Auction to Start(0-59): ");
				int second = reader.nextInt();
				System.out.println("Enter the Duration(Hours): ");
				int duration = reader.nextInt();
				String requestday = month+"/"+day+"/"+year+" "+hour+":"+minute+":"+second;
				Date request = new Date(requestday);
				scheduleAuction(u,request,duration);
			}else{
				System.out.println("Invalid Date");
			}
			break;
		case 2:
			CalendarAuctionCentral c = new CalendarAuctionCentral();
			Auction a = c.getAuction(u);
			this.editAuctionIfo(u, a);
			break;
		case 3:
			c = new CalendarAuctionCentral();
			a = c.getAuction(u);
			this.addItemInfo(u, a);
			break;
		case 4:
			c = new CalendarAuctionCentral();
			a = c.getAuction(u);
			Inventory i = new Inventory();
			
			break;
		case 5:

			break;
		default:
			System.out.println("Sorry wrong input");
			break;

		}
	}

	public void scheduleAuction(User u, Date auctionDate,int duration) throws ParseException, IOException{
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		if(c.checkRequestedDate(auctionDate)){
			addAuctionInfo(u,getAuctionName(u,auctionDate),auctionDate,duration);
		}else{
			System.out.println("Sorry cannot Schedule on this Date Please try again");
			new NonProfit(u);
		}
	}

	public void addAuctionInfo(User u,String profitName, Date auctionDate, int auctionDuration) throws ParseException, IOException{
		Auction a = new Auction(profitName,auctionDate,auctionDuration);
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		if(c.checkRequestedAuction(a)){
			c.addFutureAuction(a);
			System.out.println("Auction added");
			int input = 1;
			while(input == 1){
				System.out.println("Press 1 to add items");
				System.out.println("Press 2 to go back to main menu");
				@SuppressWarnings("resource")
				Scanner reader = new Scanner(System.in);
				input = reader.nextInt();
				while(input != 1 && input != 2){
					System.out.println("Sorry wrong input, Please try again");
					input = reader.nextInt();
				}
				if(input == 2){
					new NonProfit(u);
				}else{
					addItemInfo(u,a);
				}
			}
		}else{
			System.out.println("Sorry auction wasn't added");
			new NonProfit(u);
		}
	}

	public void editAuctionIfo(User u,Auction a) throws ParseException, IOException{
		System.out.println("Press 1 to edit Start of Auction");
		System.out.println("Press 2 to edit The duration of Auction");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while(input != 1 && input != 2 ){
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch(input){
		case 1:
			System.out.println("Enter Month(1-12): ");
			int month = reader.nextInt();
			System.out.println("Enter Day(Integer): ");
			int day = reader.nextInt();
			System.out.println("Enter Year(Integer): ");
			int year = reader.nextInt();
			if(checkDate(month,day,year)){
				System.out.println("Enter Hour Auction to Start(0-23): ");
				int hour = reader.nextInt();
				System.out.println("Enter Minute Auction to Start(0-59): ");
				int minute = reader.nextInt();
				System.out.println("Enter Second Auction to Start(0-59): ");
				int second = reader.nextInt();
				String editday = month+"/"+day+"/"+year+" "+hour+":"+minute+":"+second;
				Date newday = new Date(editday);
				a.setAuctionStart(newday);
				System.out.println("Done editing");
				new NonProfit(u);
			}else{
				System.out.println("Sorry invalid date entered");
				new NonProfit(u);
			}
			break;
		case 2:
			System.out.println("Enter the Duration(Hours): ");
			int duration = reader.nextInt();
			a.setAuctionDuration(duration);
			new NonProfit(u);
			break;
		}

	}

	public void addItemInfo(User u,Auction a) throws ParseException, IOException{
		System.out.println("Name of item :");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String itemName = reader.nextLine();
		System.out.println("Starting bid of item :");
		double startBid = reader.nextDouble();
		System.out.println("More Information about item :");
		String moreInfo = reader.nextLine();
		Item i = new Item(a.getAuctionName(),startBid,itemName,moreInfo);
		Inventory in = new Inventory();
		in.addItem(i);
		System.out.println("Item can now be bidded on");
	}

	public void editItemInfo(User u,Auction a){
		/*Calendar c = new Calendar();
		 *Auction a = c.getAuction(profitName);
		 *a.showItems();
		 *System.out.println("Enter Item to edit: ");
		 *@SuppressWarnings("resource")
		 *Scanner reader = new Scanner(System.in);
		 *int item = reader.nextInt();
		 *a.getItem(item).edit();
		 */
	}

	private String getAuctionName(User u,Date d) throws ParseException{
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		String date = monthName[d.getMonth()-1]+"-"+d.getDay()+"-"+d.getYear();
		return u.username+"-"+date;
	}

	private boolean checkDate(int month,int day,int year){
		if(year >= 2015){
			int[] monthDay = {31,28,31,30,31,31,31,30,31,30,31,30};
			if(month < 13 && month > 0){
				if(monthDay[month-1] >= day){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


}
