import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 */

/**
 * @author Stepas
 *
 */
public class Date {
	
	private String date;

	/**
	 * 
	 */
	public Date(String date) {
		this.date = date;
	}
	
	public Date() {
		Calendar cal = Calendar.getInstance();
		this.date = cal.get(Calendar.MONTH)+1+"/"
				+cal.get(Calendar.DAY_OF_MONTH)+"/"
				+cal.get(Calendar.YEAR)+" "
				+cal.get(Calendar.HOUR_OF_DAY)+":"
				+cal.get(Calendar.MINUTE)+":"
				+cal.get(Calendar.SECOND);
	}
	
	public int getMonth() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.MONTH)+1;
	}
	public int getDay() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.DAY_OF_MONTH);
	}
	public int getYear() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.YEAR);
	}
	
	public int getHour() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinutes() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.MINUTE);
	}
	public int getSeconds() throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		return c.get(Calendar.SECOND);
	}
	
	public void setMonth(int month) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = month+"/"+this.getDay()+"/"+this.getYear()+" "+this.getHour()+":"+this.getMinutes()+":"+this.getSeconds();
		this.date = newDate;
	}
	public void setDay(int day) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth()+"/"+day+"/"+this.getYear()+" "+this.getHour()+":"+this.getMinutes()+":"+this.getSeconds();
		this.date = newDate;
	}
	public void setYear(int year) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth()+"/"+this.getDay()+"/"+year+" "+this.getHour()+":"+this.getMinutes()+":"+this.getSeconds();
		this.date = newDate;
	}
	
	public void setHour(int hour) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth()+"/"+this.getDay()+"/"+this.getYear()+" "+hour+":"+this.getMinutes()+":"+this.getSeconds();
		this.date = newDate;
	}
	public void setMinutes(int minutes) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth()+"/"+this.getDay()+"/"+this.getYear()+" "+this.getHour()+":"+minutes+":"+this.getSeconds();
		this.date = newDate;
	}
	public void setSeconds(int seconds) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		String newDate = this.getMonth()+"/"+this.getDay()+"/"+this.getYear()+" "+this.getHour()+":"+this.getMinutes()+":"+seconds;
		this.date = newDate;
	}
	public boolean before(Date d) throws ParseException{
		if(this.getYear() < d.getYear()){
			return true;
		}else if(this.getYear() == d.getYear()){
			if(this.getMonth() < d.getMonth()){
				return true;
			}else if(this.getMonth() == d.getMonth()){
				if(this.getDay() < d.getDay()){
					return true;
				}else if(this.getDay() == d.getDay()){
					if(this.getHour() < d.getHour()){
						return true;
					}else if(this.getHour() == d.getHour()){
						if(this.getMinutes() < d.getMinutes()){
							return true;
						}else if(this.getMinutes() == d.getMinutes()){
							if(this.getSeconds() < d.getSeconds()){
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
	public void addDays(int days) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.add(java.util.Calendar.DATE, days);
		String newDate =c.get(Calendar.MONTH)+1+"/"
				+c.get(Calendar.DAY_OF_MONTH)+"/"
				+c.get(Calendar.YEAR)+" "
				+c.get(Calendar.HOUR_OF_DAY)+":"
				+c.get(Calendar.MINUTE)+":"
				+c.get(Calendar.SECOND);
		this.date = newDate;
	}
	
	public void addHours(int hours) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.add(java.util.Calendar.HOUR_OF_DAY, hours);
		String newDate =c.get(Calendar.MONTH)+1+"/"
				+c.get(Calendar.DAY_OF_MONTH)+"/"
				+c.get(Calendar.YEAR)+" "
				+c.get(Calendar.HOUR_OF_DAY)+":"
				+c.get(Calendar.MINUTE)+":"
				+c.get(Calendar.SECOND);
		this.date = newDate;
	}
	
	public Date clone(){
		return new Date(this.date);
	}
	
	public String toString(){
		return date;
	}

}
