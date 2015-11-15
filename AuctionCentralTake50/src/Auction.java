/**
 * 
 * @author Mindy Huynh
 *
 */
public class Auction 
{
	//auction name
	private String auctionName;
	private int auctionDuration;
	private String profitName;
	private int startMonth;
	private int startDate;
	private int startHourOfDay;
	private int startMinuteOfHour;
	private int endHourOfDay;
	private int endMinuteOfHour;
	
	public Auction(String profitName, int startMonth, int startDate, 
						int startHourOfDay, int startMinuteOfHour,
							int endHourOfDay, int endMinuteOfHour)
	{		
		this.auctionName = profitName;
		this.profitName = profitName;
		
		//checking valid date
		if(isValidDate(startMonth, startDate))
		{
			this.startMonth = startMonth;
			this.startDate = startDate;
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid month or date");
		}
		
		//check valid hour of day
		if(isValidHour(endMinuteOfHour) && isValidHour(startMinuteOfHour))
		{			
			this.startHourOfDay = startHourOfDay;
			this.endHourOfDay = endHourOfDay;
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid hour of the day.");
		}
		
		//check valid minute of hour
		if(isValidMinute(endMinuteOfHour) && isValidMinute(startMinuteOfHour))
		{			
			this.endMinuteOfHour = endMinuteOfHour;
			this.startMinuteOfHour = startMinuteOfHour;
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid minute");
		}
		
		getDuration(startHourOfDay, startMinuteOfHour,
				endHourOfDay, endMinuteOfHour);
	}
	
	private void getDuration(int startHourOfDay, int startMinuteOfHour,
			int endHourOfDay, int endMinuteOfHour)
	{
		
		int auctionHourDuration = endHourOfDay - startHourOfDay;
		int auctionMinuteDuration = endMinuteOfHour - startMinuteOfHour;
		
		this.auctionDuration = auctionHourDuration*60 + auctionMinuteDuration;
	}

	//setters and getters for profit name.
	public void setProfitName(String profitName)
	{
		this.profitName = profitName;
	}
	public String getProfitName()
	{
		return profitName;
	}
	
	//Setters and getters for auction date.
	public void setDate(int date)
	{
		this.startDate = date;
	}
	public int getDate()
	{
		return startDate;
	}
	
	//setters and getter for auction month
	public void setMonth(int month)
	{
		this.startMonth = month;
	}
	public int getMonth()
	{
		return startMonth;
	}
	
	//getters and setters for start hour of date
	public void setStartHourOfDay(int startHour)
	{
		this.startHourOfDay = startHour;
	}
	public int getStartHourOfDay()
	{
		return startHourOfDay;
	}
	
	//getters and setters for start minute of hour
	public void setStartMinuteOfHour(int startMinute)
	{
		this.startMinuteOfHour = startMinute;
	}
	public int getStartMinuteOfHour()
	{
		return startMinuteOfHour;
	}
	
	//getters and setters for end hour of date
	public void setEndHourOfDay(int endHour)
	{
		this.endHourOfDay = endHour;
	}
	public int getEndHourOfDay()
	{
		return endHourOfDay;
	}
	
	//getters and setters for end minute of hour
	public void setEndMinuteOfHour(int endMinute)
	{
		this.endMinuteOfHour = endMinute;
	}
	public int getEndMinuteOfHour()
	{
		return endMinuteOfHour;
	}
	
	public String toString()
	{
		return this.auctionName + ", " + this.profitName + ", " + this.startDate  + ", " + this.auctionDuration;
	}
	
	public String getAuctionName()
	{
		return auctionName;
	}
	
	private boolean isValidHour(int hour)
	{
		return hour < 24 && hour >= 0;
	}
	
	private boolean isValidMinute(int minute)
	{
		return minute < 60 && minute >= 0;
	}
	
	private boolean isValidDate(int month, int date)
	{
		//Checking valid date for each individual months
		if (month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12)
		{
			System.out.println("Invalid Date.");
			return (date > 0) && date <= 31;
		}
		else if (month == 2 || month == 4 || month == 6 || month == 9
				|| month == 11)
		{
			System.out.println("Invalid Date.");
			return (date > 0) && date <= 30;
		}
		else
		{
			System.out.println("Invalid Month.");
			return false;
		}
	}
	
}
