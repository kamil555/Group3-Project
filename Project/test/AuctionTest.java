import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Gabrielle Glynn
 * @since November 16, 2015
 */
public class AuctionTest {
	
	private Auction myAuction;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAuctionConstructor() throws ParseException {
		
		// Testing that endAuction is correctly calculated
		myAuction = new Auction("NPName1", new Date("11/20/2015 11:00:00"), 2);
		Date expectedAuction = new Date("11/20/2015 13:0:0");

		assertTrue(expectedAuction.toString().equals(myAuction.getAuctionEnd().toString()));
		assertEquals("NPName1-November-20-2015", (myAuction.getAuctionName()));
	}
	
	@Test
	public void testAuctionToString() throws ParseException {
		
		// Testing that endAuction is correctly calculated
		myAuction = new Auction("NPName1", new Date("11/20/2015 11:00:00"), 2);
		
		System.out.println(myAuction.toString());

		assertEquals("NPName1-November-20-2015,11/20/2015 11:00:00,2",myAuction.toString());
	}
}
