import java.util.Date;
import java.util.Scanner;

/**
 * @author Stepan Adespya
 *
 */
public class NonProfit {

	/**
	 * 
	 */
	public NonProfit(User u) {
		System.out.println("Welcome :"+ u.username);
		System.out.println("Organization :"+ u.organization);
		System.out.println("Press 1 to schedule an auction");
		System.out.println("Press 2 to enter auction information");
		System.out.println("Press 3 to edit auction information");
		System.out.println("Press 4 to enter inventory item information");
		System.out.println("Press 5 to edit inventory item information");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		switch(input){
		case 1:
			System.out.println("Enter Month(1-12): ");
			int month = reader.nextInt();
			System.out.println("Enter Day(Integer): ");
			int day = reader.nextInt();
			System.out.println("Enter Year(Integer): ");
			int year = reader.nextInt();
			if(checkDate(month,day,year)){
				
			}
		}
	}

	public void scheduleAuction(User u, Date auctionDate){
		/*Calendar c = new Calendar();
		if(c.isAvaiable(auctionDate)){
			System.out.println("Enter Auction Name: ");
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			String name = reader.nextLine();
			name = name.concat(getDate());
			System.out.println("Enter Duration of Auction: ");
			double duration = reader.nextDouble();
			addAuctionInfo(u,name,auctionDate,duration);
		}else{
			System.out.println("Sorry cannot Schedule on this Date Please try again");
			new NonProfit(u);
		}
		 */
	}

	public void addAuctionInfo(User u,String profitName, Date auctionDate, double auctionDuration){
		//Auction a = new Auction(String profitName, Date auctionDate, double auctionDuration);
	}

	public void editAuctionIfo(User u,String profitName){
		/*Calendar c = new Calendar();
		 *Auction a = c.getAuction(profitName);
		 *System.out.println("Enter Auction Name: ");
		 *@SuppressWarnings("resource")
		 *Scanner reader = new Scanner(System.in);
		 *String name = reader.Line();
		 *a.setProfitName(name);
		 *System.out.println("Enter Duration of Auction: ");
		 *double duration = reader.nextDouble();
		 * a.setDuration(duration);
		 */

	}

	public void addItemInfo(User u,String auctionName){
		/*Calendar c = new Calendar();
		 *Auction a = c.getAuction(profitName);
		 *a.addItem()
		 */
	}

	public void editItemInfo(User u,String auctionName){
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
