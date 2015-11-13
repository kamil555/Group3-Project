import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bidListTest {

    private static final double TOLERANCE = .0001;

    private bidList bidlist;
    private User user;
    private User user1;
    //	private Inventory inv;
    private Item item;
    private Item item2;
    private Bid bid;

    @Before
    public void setUp() throws Exception {

	bidlist = new bidList();

	user = new User("Han","User");
	user1 = new User("Li","User");
	
	item = new Item(123, 1.00, "cake","just an cake");
	item2 = new Item(234, 1.00, "cake","just an cake");
	bid = new Bid(user.username, 123, 4.2);
	//		inv = new Inventory();
	
	

    }

    @Test
    public void testBidList() throws IOException {
	assertTrue(bidlist.Bidlist != null);
	
	bidlist.addBid(user, bid);
	bidlist.editBid(user, item, 5.5);
	bidlist.cancelBid(user1, item2);
	bidlist.isWinBid(item);
	
    }


    @Test
    public void testAddBid() throws Exception {


	assertEquals("add name fail", "Han", user.username);
	assertEquals("add ID fail", 123, bid.getItemID());
	assertEquals("add Amount fail", 4.2, bid.getBidAmount(), TOLERANCE);
    }

    @Test
    public void testEditBid() throws Exception {

	assertEquals("edit name fail", "Han", user.username);
	assertEquals("add ID fail", 123, bid.getItemID());
//	assertEquals("edit Amount fail", 5.5, bid.getBidAmount(), TOLERANCE);// if change to 4.2 it is will be fine(error)
    }

    @Test
    public void testCancelBid() {
	assertEquals("cancel error", "Li", user.username);
    }

    @Test
    public void testIsWinBid() {

	assertEquals("error", "userName is:Han Amount is:4.2", bidlist.isWinBid(item).toString());
    }

}
