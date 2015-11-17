import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing for inventory class.
 * 
 * @author Gabrielle Glynn
 * @since November 14, 2015
 */
public class InventoryAllItemsAuctionTest {
	
	private Inventory myInventory;
	private Item myItem1;
	private Item myItem2;
	private Item myItem3;
	private Item myItem4;
	private Item myItem5;

	@Before
	public void setUp() throws Exception {
		
		// setting up empty inventory list
		myInventory = new Inventory();

		myItem1 = new Item("NPName1-November-22-2015", 5.00, "Item1", "Description of item1");		
		myItem2 = new Item("NPName1-November-22-2015", 5.00, "Item2", "Description of item2");
		myItem3 = new Item("NPName2-November-22-2015", 5.00, "Item3", "Description of item3");		
		myItem4 = new Item("NPName3-November-22-2015", 5.00, "Item4", "Description of item4");		
		myItem5 = new Item("NPName1-November-22-2015", 5.00, "Item5", "Description of item5");
		
		myInventory.addItem(myItem1);
		myInventory.addItem(myItem2);
		myInventory.addItem(myItem3);
		myInventory.addItem(myItem4);
		myInventory.addItem(myItem5);
	}

	/*
	 * Note: "Inventory.txt" must be cleared and empty
	 * before running the test.
	 */
	@Test
	public void testAllAuctionItems() throws ParseException {

		Date testDate1 = new Date("11/22/2015 10:00:00");
		Auction testAuction1 = new Auction("NPName1", testDate1, 2);
		assertEquals(3, myInventory.allItemsAuction(testAuction1));
		
		Auction testAuction2 = new Auction("NPName2", testDate1, 2);
		assertEquals(1, myInventory.allItemsAuction(testAuction2));
		
		Auction testAuction3 = new Auction("NPName3", testDate1, 2);
		assertEquals(1, myInventory.allItemsAuction(testAuction3));
		
		// testing name not on list
		Auction testAuction4 = new Auction("NPName4", testDate1, 2);
		assertEquals(0, myInventory.allItemsAuction(testAuction4));
	}

}
