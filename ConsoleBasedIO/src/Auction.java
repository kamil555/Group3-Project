import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Mindy Huynh
 *
 */
public class Auction 
{
	//auction name
	private String auctionName;	
	//auction date
	private Date auctionStart;	
	private Date auctionEnd;	
	private int auctionDuration;	
	private String profitName;
	
	public Auction(String profitName, String auctionStartDate, int auctionDuration)
	{
		this.auctionStart = formatDateFromString(auctionStartDate);
		this.auctionEnd = calcAuctionEnd(auctionStartDate, auctionDuration);
		this.auctionName = profitName + "-" + auctionStartDate;
		this.profitName = profitName;
		this.auctionDuration = auctionDuration;
	}
		
	//not done
	public Date calcAuctionEnd(String date, int auctionDuration) {
		Date auctionS = formatDateFromString(date);
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(auctionS);
		c.add(java.util.Calendar.HOUR_OF_DAY, auctionDuration);
		return auctionS;
	}
	
	public Date formatDateFromString(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		String dateInString = date;
		
		try {
			Date formattedDate = formatter.parse(dateInString);
			//System.out.println(formattedDate);
			//System.out.println(formatter.format(formattedDate));
			return formattedDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setProfitName(String profitName)
	{
		this.profitName = profitName;
	}
	
	public void setStartDate(Date date)
	{
		this.auctionStart = date;
	}
	
	public void setEndDate(Date date)
	{
		this.auctionEnd = date;
	}
	
	public void setDuration(int duration)
	{
		this.auctionDuration = duration;
	}
	
	public String getProfitName()
	{
		return profitName;
	}
	
	public Date getStartDate()
	{
		return auctionStart;
	}
	
	public Date getEndDate()
	{
		return auctionEnd;
	}
	
	public int getDuration()
	{
		return auctionDuration;
	}
	
	public String getAuctionName()
	{
		return auctionName;
	}
	
	public String toString()
	{
		
		return this.auctionName + "," + this.auctionDuration;
	}
	
	public void writeAuctionToFile(String fileName) throws IOException {
		 String auctionString = new String();
		 auctionString = this.toString();
		 FileWriter fw = new FileWriter(fileName, true);
		 PrintWriter pw = new PrintWriter(fw);
		 //fw.append(System.lineSeparator());
		 pw.write(auctionString + "\r\n");
		 pw.close();
	 }
	
}
