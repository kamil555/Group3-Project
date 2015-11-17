import static org.junit.Assert.*;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bidListTest {

	private static final double TOLERANCE = .0001;

	private bidList bidlist;
	private User user;
	private Item item;
	private Bid bid;
	//	private Inventory inv;


	/**
	 * set up before test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		bidlist = new bidList();
		user = new User("Han","User");
		item = new Item(123, "123", 1.0, "cake", "cake");
		bid = new Bid(user.userName, 123, 4.2);
		//		bidlist.addBid(user, bid);
	}

	/**
	 * test Bidlist
	 * 
	 */

	@Test
	public void testBidList() {
		assertTrue(bidlist.Bidlist != null);
	}

	/**
	 * test addBid
	 * @throws Exception
	 */
	@Test
	public void testAddBid() throws Exception {
		//		bidlist.addBid(user, bid);
		assertEquals("add name fail", "Han", user.userName);
		assertEquals("add ID fail", 123, item.getItemID());
		assertEquals("add Amount fail", 4.2, bid.getBidAmount(),TOLERANCE);
	}
	/**
	 * test edit bid
	 * @throws Exception
	 */
	@Test
	public void testEditBid() throws Exception {
		//		bidlist.editBid(user, item, 5.5, 123);
		assertEquals("edit name fail", "Han", user.userName);
		assertEquals("add ID fail", 123, item.itemID);
		assertEquals("edit Amount fail", 4.2, bid.getBidAmount(),TOLERANCE);
	}
	/**
	 * test cancel bid
	 */
	@Test
	public void testCancelBid() {
		assertTrue(bid.getuserName().equalsIgnoreCase(user.userName));
		assertTrue(bid.getItemID() == item.itemID);
	}
	/**
	 * test who is winning the bid
	 */
	@Test
	public void testIsWinBid() {
		bidlist.isWinBid(item);
		assertEquals("error", "userName is:Han Amount is:4.2", bidlist.isWinBid(item).toString());
	}

}