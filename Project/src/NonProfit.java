import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Stepan Adespya
 * @since November 5, 2015
 */
public class NonProfit
{
	
	/**
	 * Main Menu for the Non Profit User, easier to navigate
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public NonProfit(User user) throws ParseException, IOException
	{
		System.out.println("Welcome, " + user.userName);
		System.out.println("Organization: " + user.organization);
		System.out.println("Press 1 to schedule an auction");
		System.out.println("Press 2 to edit auction information");
		System.out.println("Press 3 to enter add item to inventory ");
		System.out.println("Press 4 to edit inventory item information");
		System.out.println("Press 5 to Log out");
		Scanner reader = new Scanner(System.in);
		while (!reader.hasNextInt())
		{
			System.out.println("Please enter a number between 1 and 5");
			reader = new Scanner(System.in);
		}
		int input = reader.nextInt();
		while (input != 1 && input != 2 && input != 3 && input != 4
				&& input != 5)
		{
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		selectOption(reader, input, user);
	}
	
	private void selectOption(Scanner reader, int input, User user) throws ParseException, IOException
	{
		System.out.println(user);
		CalendarAuctionCentral c;
		Auction a;
		switch (input)
		{
			case 1:
				System.out.println("Enter Auction Information: ");
				System.out.println("Enter Month(1-12): ");
				int month = reader.nextInt();
				System.out.println("Enter Day(Integer): ");
				int day = reader.nextInt();
				System.out.println("Enter Year(Integer): ");
				int year = reader.nextInt();
				while(!isValidDate(month, day, year))
				{
					System.out.println("Invalid date.");
					System.out.println("Enter Auction Information: ");
					System.out.println("Enter Month(1-12): ");
					month = reader.nextInt();
					System.out.println("Enter Day(Integer): ");
					day = reader.nextInt();
					System.out.println("Enter Year(Integer): ");
					year = reader.nextInt();
				}
				System.out.println("Enter Hour Auction to Start(0-23): ");
				int hour = reader.nextInt();
				System.out.println("Enter Minute Auction to Start(0-59): ");
				int minute = reader.nextInt();
				int second = 0;
				System.out.println("Enter the Duration(Hours): ");
				int duration = reader.nextInt();
				String requestday = month + "/" + day + "/" + year + " "
						+ hour + ":" + minute + ":" + second;
				Date request = new Date(requestday);
				System.out.println(request);	
				scheduleAuction(user, request, duration);
							
				break;
			case 2:
				c = new CalendarAuctionCentral();
				a = c.getAuction(user);
				this.editAuctionInfo(user, a);
				break;
			case 3:
				c = new CalendarAuctionCentral();
				a = c.getAuction(user);
				this.addItemInfo(user, a);
				break;
			case 4:
				c = new CalendarAuctionCentral();
				a = c.getAuction(user);
				Inventory i = new Inventory();
				i.allItemsAuction(a);
				System.out.println("Enter the Number of item you want to edit");
				int item = reader.nextInt();
				this.editItemInfo(user, item);
				break;
			case 5:
				new Users();
				break;
			default:
				System.out.println("Sorry wrong input");
				break;
		}
	}
	
	/**
	 * Requests a Auction, checks if the schedule fits
	 * 
	 * @param u
	 * @param auctionDate
	 * @param duration
	 * @throws ParseException
	 * @throws IOException
	 */
	public void scheduleAuction(User u, Date auctionDate, int duration)
			throws ParseException, IOException
	{
		System.out.println("poop");
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		if (c.checkRequestedDate(auctionDate))
		{
			addAuctionInfo(u, getAuctionName(u, auctionDate), auctionDate,
					duration);
		} else
		{
			System.out.println("Sorry cannot Schedule on this Date Please try again");
			new NonProfit(u);
		}
	}
	
	/**
	 * Adds Information to the Auction class.
	 * 
	 * @param u
	 * @param profitName
	 * @param auctionDate
	 * @param auctionDuration
	 * @throws ParseException
	 * @throws IOException
	 */
	public void addAuctionInfo(User u, String profitName, Date auctionDate,
			int auctionDuration) throws ParseException, IOException
	{
		Auction a = new Auction(profitName, auctionDate, auctionDuration);
		CalendarAuctionCentral c = new CalendarAuctionCentral();
		if (c.checkRequestedAuction(a))
		{
			c.addFutureAuction(a);
			System.out.println("Auction added");
			int input = 1;
			while (input == 1)
			{
				System.out.println("Press 1 to add items");
				System.out.println("Press 2 to go back to main menu");
				@SuppressWarnings("resource")
				Scanner reader = new Scanner(System.in);
				input = reader.nextInt();
				while (input != 1 && input != 2)
				{
					System.out.println("Sorry wrong input, Please try again");
					input = reader.nextInt();
				}
				if (input == 2)
				{
					new NonProfit(u);
				} else
				{
					addItemInfo(u, a);
				}
			}
		} else
		{
			System.out.println("Sorry auction wasn't added");
			new NonProfit(u);
		}
	}
	
	/**
	 * Edits Auction Information.
	 * 
	 * @param u
	 * @param a
	 * @throws ParseException
	 * @throws IOException
	 */
	public void editAuctionInfo(User u, Auction a) throws ParseException,
			IOException
	{
		System.out.println("Press 1 to edit Start of Auction");
		System.out.println("Press 2 to edit The duration of Auction");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while (input != 1 && input != 2)
		{
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		switch (input)
		{
			case 1:
				System.out.println("Enter Month(1-12): ");
				int month = reader.nextInt();
				System.out.println("Enter Day(Integer): ");
				int day = reader.nextInt();
				System.out.println("Enter Year(Integer): ");
				int year = reader.nextInt();
				if (isValidDate(month, day, year))
				{
					System.out.println("Enter Hour Auction to Start(0-23): ");
					int hour = reader.nextInt();
					System.out.println("Enter Minute Auction to Start(0-59): ");
					int minute = reader.nextInt();
					int second = 0;
					String editday = month + "/" + day + "/" + year + " "
							+ hour + ":" + minute + ":" + second;
					Date newday = new Date(editday);
					a.setAuctionStart(newday);
					System.out.println("Done editing");
					new NonProfit(u);
				} else
				{
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
	
	/**
	 * Adds an Item to the selected auction.
	 * 
	 * @param u
	 * @param a
	 * @throws ParseException
	 * @throws IOException
	 */
	public void addItemInfo(User u, Auction a) throws ParseException,
			IOException
	{
		System.out.println("Name of item :");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String itemName = reader.nextLine();
		System.out.println("Starting bid of item :");
		double startBid = reader.nextDouble();
		System.out.println("More Information about item :");
		String moreInfo = reader.nextLine();
		Item i = new Item(a.getAuctionName(), startBid, itemName, moreInfo);
		Inventory in = new Inventory();
		in.addItem(i);
		System.out.println("Item can now be bidded on");
	}
	
	/**
	 * Edits an items from selected auction.
	 * 
	 * @param u
	 * @param itemID
	 * @throws IOException
	 */
	public void editItemInfo(User u, int itemID) throws IOException
	{
		System.out.println("Press 1 to edit Item Name");
		System.out.println("Press 2 to edit Start Bid");
		System.out.println("Press 3 to edit Item Info");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		while (input != 1 && input != 2 && input != 3)
		{
			System.out.println("Sorry wrong input, Please try again");
			input = reader.nextInt();
		}
		Inventory i;
		switch (input)
		{
			case 1:
				System.out.println("Enter New name :");
				String newName = reader.nextLine();
				i = new Inventory();
				i.editItemName(itemID, newName);
				break;
			case 2:
				System.out.println("Enter New start Bid :");
				double startBid = reader.nextDouble();
				i = new Inventory();
				i.editItemStartBid(itemID, startBid);
				break;
			case 3:
				System.out.println("Enter New Info :");
				String newInfo = reader.nextLine();
				i = new Inventory();
				i.editItemInfo(itemID, newInfo);
				break;
		}
	}
	
	/**
	 * Gets the Name for the auction.
	 * 
	 * @param u
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	private String getAuctionName(User u, Date d) throws ParseException
	{
		String[] monthName =
		{ "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		String date = monthName[d.getMonth() - 1] + "-" + d.getDay() + "-"
				+ d.getYear();
		return u.userName + "-" + date;
	}
	
	/**
	 * Checks if the date entered is correct;
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	private boolean isValidDate(int month, int day, int year)
	{
		if (year >= 2015)
		{
			int[] monthDay =
			{ 31, 28, 31, 30, 31, 31, 31, 30, 31, 30, 31, 30 };
			if (month < 13 && month > 0)
			{
				if (monthDay[month - 1] >= day)
				{
					return true;
				} else
				{
					return false;
				}
			} else
			{
				return false;
			}
		} else
		{
			return false;
		}
	}
	
}
