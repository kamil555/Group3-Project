import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;


public class BidderTest {

	User u;
	Bidder b;
	/**
	 * Setup
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		u = new User("Stepan","Bidder");
		b = new Bidder(u);
	}

	/**
	 * testBidder
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testBidder() throws IOException, ParseException {
	
		assertNotNull(b);
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * testViewItem
	 */
	@Test
	public void testViewItem() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * test edit bid
	 */
	@Test
	public void testEditBid() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

	/**
	 * test view open auctions.
	 */
	@Test
	public void testViewOpenAuctions() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("Bidder",u.user);
	}

}