import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Stepan Adespya
 *
 */
public class NonProfitTest {

	User u;
	NonProfit np;
	Date d;
	Auction a;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		u = new User("Stepan","NonProfit");
		d = new Date("11/16/2015 5:35:30");
		a = new Auction("Stepan",d,1);
	}

	/**
	 * Test method for {@link NonProfit#NonProfit(User)}.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@Test
	public void testNonProfit() throws ParseException, IOException {
		np = new NonProfit(u);
		assertNotNull(np);
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * Test method for {@link NonProfit#scheduleAuction(User, Date, int)}.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@Test
	public void testScheduleAuction() throws ParseException, IOException {
		np.scheduleAuction(u, d, 1);
		assertEquals(d.getMonth(),11);
		assertEquals(d.getDay(),16);
		assertEquals(d.getYear(),2015);
		assertEquals(d.getHour(),5);
		assertEquals(d.getMinutes(),35);
		assertEquals(d.getMonth(),30);
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * Test method for {@link NonProfit#addAuctionInfo(User, java.lang.String, Date, int)}.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@Test
	public void testAddAuctionInfo() throws ParseException, IOException {
		np.addAuctionInfo(u,a.getProfitName(),d,1);
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * Test method for {@link NonProfit#editAuctionInfo(User, Auction)}.
	 */
	@Test
	public void testEditAuctionInfo() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * Test method for {@link NonProfit#addItemInfo(User, Auction)}.
	 */
	@Test
	public void testAddItemInfo() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * Test method for {@link NonProfit#editItemInfo(User, int)}.
	 */
	@Test
	public void testEditItemInfo() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

}
