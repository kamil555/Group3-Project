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
public class AuctionCentralEmployeeTest {

	User u; 
	AuctionCentralEmployee ace;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		u = new User("Stepan","AuctionCentral Employee");
		ace = new AuctionCentralEmployee(u);
		
	}

	/**
	 * Test method for {@link AuctionCentralEmployee#AuctionCentralEmployee(User)}.
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Test
	public void testAuctionCentralEmployee() throws ParseException, IOException {
		
		assertNotNull(ace);
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("AuctionCentral Employee",u.user);
	}

	/**
	 * Test method for {@link AuctionCentralEmployee#viewAuctionDetails(User)}.
	 */
	@Test
	public void testViewAuctionDetails() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("AuctionCentral Employee",u.user);
	}

	/**
	 * Test method for {@link AuctionCentralEmployee#viewCalendar(User, int, int)}.
	 */
	@Test
	public void testViewCalendar() {
		assertNotNull(u);
		assertEquals("Stepan",u.username);
		assertEquals("AuctionCentral Employee",u.user);
	}

}
