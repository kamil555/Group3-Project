import java.io.IOException;
import java.util.Date;


public class AuctionCentralMain {
	
	public static void main(String[] args)
	{
      
		Calendar testCalendar = Calendar.getCalendar();
		
		java.util.Calendar today = java.util.Calendar.getInstance();
		
		Date currentDate = new Date();
		
		Auction testAuction = new Auction("name11", "2015-11-22-16-30", 1);
		Auction testAuction2 = new Auction("name22", "2015-1-2-9-0", 2);
		
		
		try {
			testAuction.writeAuctionToFile("auctionList1.txt");
			testAuction2.writeAuctionToFile("auctionList1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
