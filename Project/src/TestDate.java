import java.text.ParseException;


public class TestDate {

	public static void main(String[] args) throws ParseException {
		Date d = new Date("11/14/2015 17:19:38");
//		System.out.println(d.getMonth());
//		System.out.println(d.getDay());
//		System.out.println(d.getYear());
//		System.out.println(d.getHour());
//		System.out.println(d.getMinutes());
//		System.out.println(d.getSeconds());
		d.addDays(-1);
		System.out.println(d.toString());
		Date d1 = new Date();
		System.out.println(d1.toString());
		if(d1.before(d)){
			System.out.println("Future");
		}else{
			System.out.println("Past");
		}

	}

}
