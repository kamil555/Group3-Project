import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Date class to keep the date of auction as well as times.
 * 
 * @author Stepan Adespya
 * @since November 14, 2015
 */
public class Date
{
	// holds the date entered
	private String date;
	
	/**
	 * Constructor for the date entered.
	 */
	public Date(String date)
	{
		this.date = date;
	}
	
	/**
	 * If date is not entered, it takes the current date and time.
	 */
	public Date()
	{
		Calendar cal = Calendar.getInstance();
		this.date = cal.get(Calendar.MONTH) + 1 + "/"
				+ cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR)
				+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
				+ cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	}
	
	/**
	 * Gets the month of the date.
	 * 
	 * @return int month
	 * @throws ParseException
	 */
	public int getMonth() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Gets the day of the date.
	 * 
	 * @return int day
	 * @throws ParseException
	 */
	public int getDay() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Get the year of the date.
	 * 
	 * @return int year
	 * @throws ParseException
	 */
	public int getYear() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * Gets the hour of the date.
	 * 
	 * @return int hour
	 * @throws ParseException
	 */
	public int getHour() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Gets the minutes of the date.
	 * 
	 * @return int minutes
	 * @throws ParseException
	 */
	public int getMinutes() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.MINUTE);
	}
	
	/**
	 * Gets the seconds of the date.
	 * 
	 * @return int seconds
	 * @throws ParseException
	 */
	public int getSeconds() throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.SECOND);
	}
	
	/**
	 * Lets you change the month of date.
	 * 
	 * @param month
	 * @throws ParseException
	 */
	public void setMonth(int month) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = month + "/" + this.getDay() + "/" + this.getYear()
				+ " " + this.getHour() + ":" + this.getMinutes() + ":"
				+ this.getSeconds();
		this.date = newDate;
	}
	
	/**
	 * Lets you change the day of date.
	 * 
	 * @param day
	 * @throws ParseException
	 */
	public void setDay(int day) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth() + "/" + day + "/" + this.getYear()
				+ " " + this.getHour() + ":" + this.getMinutes() + ":"
				+ this.getSeconds();
		this.date = newDate;
	}
	
	/**
	 * Lets you change the year of date.
	 * 
	 * @param year
	 * @throws ParseException
	 */
	public void setYear(int year) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth() + "/" + this.getDay() + "/" + year
				+ " " + this.getHour() + ":" + this.getMinutes() + ":"
				+ this.getSeconds();
		this.date = newDate;
	}
	
	/**
	 * Lets you change the hour of the date.
	 * 
	 * @param hour
	 * @throws ParseException
	 */
	public void setHour(int hour) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth() + "/" + this.getDay() + "/"
				+ this.getYear() + " " + hour + ":" + this.getMinutes() + ":"
				+ this.getSeconds();
		this.date = newDate;
	}
	
	/**
	 * Lets you change the minutes of the date.
	 * 
	 * @param minutes
	 * @throws ParseException
	 */
	public void setMinutes(int minutes) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth() + "/" + this.getDay() + "/"
				+ this.getYear() + " " + this.getHour() + ":" + minutes + ":"
				+ this.getSeconds();
		this.date = newDate;
	}
	
	/**
	 * Lets you change the seconds of the date.
	 * 
	 * @param seconds
	 * @throws ParseException
	 */
	public void setSeconds(int seconds) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth() + "/" + this.getDay() + "/"
				+ this.getYear() + " " + this.getHour() + ":"
				+ this.getMinutes() + ":" + seconds;
		this.date = newDate;
	}
	
	/**
	 * Gives the difference of two dates by hours.
	 * 
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public long getDiffHours(Date d) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(this.date));
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(d.date));
		long diff = c1.getTimeInMillis() - c.getTimeInMillis();
		return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Gives the difference of two dates by day.
	 * 
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public long getDiffDay(Date d) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(this.date));
		Calendar c1 = Calendar.getInstance();
		c1.setTime(df.parse(d.date));
		long diff = c1.getTimeInMillis() - c.getTimeInMillis();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Check if current date is before another date.
	 * 
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public boolean before(Date d) throws ParseException
	{
		if (this.getYear() < d.getYear())
		{
			return true;
		} else if (this.getYear() == d.getYear())
		{
			if (this.getMonth() < d.getMonth())
			{
				return true;
			} else if (this.getMonth() == d.getMonth())
			{
				if (this.getDay() < d.getDay())
				{
					return true;
				} else if (this.getDay() == d.getDay())
				{
					if (this.getHour() < d.getHour())
					{
						return true;
					} else if (this.getHour() == d.getHour())
					{
						if (this.getMinutes() < d.getMinutes())
						{
							return true;
						} else if (this.getMinutes() == d.getMinutes())
						{
							if (this.getSeconds() < d.getSeconds())
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
	
	/**
	 * Add days to the current date.
	 * 
	 * @param days
	 * @throws ParseException
	 */
	public void addDays(int days) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.add(java.util.Calendar.DATE, days);
		String newDate = c.get(Calendar.MONTH) + 1 + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR)
				+ " " + c.get(Calendar.HOUR_OF_DAY) + ":"
				+ c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		this.date = newDate;
	}
	
	/**
	 * Adds hours to the date.
	 * 
	 * @param hours
	 * @throws ParseException
	 */
	public void addHours(int hours) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.add(java.util.Calendar.HOUR_OF_DAY, hours);
		String newDate = c.get(Calendar.MONTH) + 1 + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR)
				+ " " + c.get(Calendar.HOUR_OF_DAY) + ":"
				+ c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		this.date = newDate;
	}
	
	
	/**
	 * clones the date to another object.
	 */
	public Date clone()
	{
		return new Date(this.date);
	}
	
	/**
	 * Returns the date.
	 */
	public String toString()
	{
		return date;
	}
	
}
