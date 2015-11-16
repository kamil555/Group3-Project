import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Gabrielle Glynn and Stepan Adespya
 * @since November 15, 2015
 */

public class DateTest {
	private Date date1;
	private Date date2;
	private Date date3;
	private Date date4;
	private Date date5;
	private Date date6;
	private Date date7;
	private Date date8;

	@Before
	public void setUp() throws Exception {
		date1 = new Date("11/17/2015 18:00:00");
		date2 = new Date("11/17/2015 20:00:00");
		date3 = new Date("11/18/2015 20:00:00");
		date4 = new Date("11/17/2015 21:30:00");
		date5 = new Date("11/30/2015 20:00:00");
		date6 = new Date("11/1/2015 20:00:00");
		date7 = new Date("11/1/2015 20:00:01");
		date8 = new Date("11/1/1999 20:00:01");
	}

	@Test
	public void testGetDiffHours() throws ParseException {
		
		// testing if diff calc'd correctly
		assertEquals(2, date1.getDiffHours(date2));		
		assertEquals(-2, date2.getDiffHours(date1));		
		assertEquals(24, date2.getDiffHours(date3));
		
		// rounding down when the diff is not an int
		assertEquals(1, date2.getDiffHours(date4));
	}
	
	@Test
	public void testGetDiffDay() throws ParseException {
		
		// testing if diff calc'd correctly
		assertEquals(0, date1.getDiffDay(date2));		
		assertEquals(13, date2.getDiffDay(date5));		
		assertEquals(-16, date2.getDiffDay(date6));
	}
	
	@Test
	public void testBefore() throws ParseException {
		assertTrue(date6.before(date7));
		assertFalse(date7.before(date6));
		assertTrue(date8.before(date7));
		assertFalse(date7.before(date8));
	}
	
	@Test
	public void testAddDays() throws ParseException {

		Date expDate1 = new Date("11/22/2015 18:0:0");
		date1.addDays(5);
		assertEquals(expDate1.toString(),date1.toString());
		
		Date expDate2 = new Date("11/22/2014 18:0:0");
		date1.addDays(-365);
		assertEquals(expDate2.toString(),date1.toString());
		
	}
	
	@Test
	public void testAddHours() {
		/*
		Date expTime1 = new Date("11/17/2015 19:0:0");
		date1.addHours(1);
		assertEquals(expTime1.toString(),date1.toString());
		
		Date expDate2 = new Date("11/22/2014 18:0:0");
		date1.addDays(-365);
		assertEquals(expDate2.toString(),date1.toString());
		*/
	}
	
	@Test
	public void testClone() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}

/*
 import java.text.ParseException;

public class DateTest
{
	
	public static void main(String[] args) throws ParseException
	{
		Date d = new Date();
		// System.out.println(d.getMonth());
		// System.out.println(d.getDay());
		// System.out.println(d.getYear());
		// System.out.println(d.getHour());
		// System.out.println(d.getMinutes());
		// System.out.println(d.getSeconds());
		d.addDays(90);
		System.out.println(d.toString());
		Date d1 = new Date();
		d1.addDays(91);
		System.out.println(d1.toString());
		if (d1.before(d))
		{
			System.out.println("Future");
		} else
		{
			System.out.println("Past");
		}
		System.out.println(d1.getDiffDay(d) + "Days");
		
	}
	
}
*/