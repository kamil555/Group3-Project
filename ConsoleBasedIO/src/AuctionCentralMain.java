import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;


public class AuctionCentralMain {
	
	public static void main(String[] args)
	{
      
		Calendar testCalendar = Calendar.getCalendar();
		
		java.util.Calendar today = java.util.Calendar.getInstance();
		
		Date currentDate = new Date();
		
		
		Auction test1 = new Auction("npname1", "2018-10-22-18-0", 3);
		Auction test2 = new Auction("npname2", "2017-10-22-18-0", 3);
		Auction test3 = new Auction("npname3", "2016-10-22-18-0", 3);
		Auction test4 = new Auction("npname4", "2014-10-22-18-0", 3);
		Auction test5 = new Auction("npname5", "2013-10-22-18-0", 3);
		Auction test6 = new Auction("npname6", "2012-10-22-18-0", 3);
		
		try {
			test5.writeAuctionToFile("auctionList.txt");
			test2.writeAuctionToFile("auctionList.txt");
			test3.writeAuctionToFile("auctionList.txt");
			test6.writeAuctionToFile("auctionList.txt");
			test1.writeAuctionToFile("auctionList.txt");
			test4.writeAuctionToFile("auctionList.txt");
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + "auctionList.txt" + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + "auctionList.txt" + "'");
		}
	}
}
