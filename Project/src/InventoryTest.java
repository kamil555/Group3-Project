import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing for inventory class.
 * 
 * @author Gabrielle Glynn
 * @since November 14, 2015
 */
public class InventoryTest {
	
	private static final double TOLERANCE = .0001;
	
	private Inventory myInventory;
	private Inventory myNewInventory;
	private Item myItem1;

	@Before
	public void setUp() throws Exception {
		
		// setting up empty inventory list
		myInventory = new Inventory();
		
		myItem1 = new Item("Auction1Name", 5.00, "Item1", "Description of item1");
	}

	/*
	 * Note: "Inventory.txt" must be cleared and empty
	 * before running the test.
	 */
	@Test
	public void testAddItem() throws IOException {
		// Testing that size reads zero and that array
		// list is empty since size is set with the
		// array list.
		assertEquals(0, myInventory.getSize());
		
		// Testing size and array are updated.
		myInventory.addItem(myItem1);
		assertEquals(1, myInventory.getSize());
		
		// Testing size updated again, and contents
		// of the array are as expected.
		myInventory.addItem(myItem1);
		assertEquals(2, myInventory.getSize());
		for(int i = 0; i < myInventory.listofItems.size(); i++) {
			assertEquals("Auction1Name", myInventory.listofItems.get(i).auctionName);	
			assertEquals(5.00, myInventory.listofItems.get(i).startBid, TOLERANCE);
			assertEquals("Item1", myInventory.listofItems.get(i).itemName);
			assertEquals("Description of item1", myInventory.listofItems.get(i).itemInfo);		
		}
		
		// testing if new inventory will read the two auctions
		// that were added from myInventory additions. This will
		// show that they were written to "Inventory.txt" whe added
		// as well as that the constructor read the file.
		myNewInventory = new Inventory();
		assertEquals(2, myNewInventory.getSize());
		for(int i = 0; i < myNewInventory.listofItems.size(); i++) {
			assertEquals("Auction1Name", myNewInventory.listofItems.get(i).auctionName);	
			assertEquals(5.00, myNewInventory.listofItems.get(i).startBid, TOLERANCE);
			assertEquals("Item1", myNewInventory.listofItems.get(i).itemName);
			assertEquals("Description of item1", myNewInventory.listofItems.get(i).itemInfo);		
		}
	}
	
}

/*

import java.io.IOException;

public class InventoryTest
{
	
	public static void main(String[] args) throws IOException
	{
		User u1 = new User("Andrey", "Bidder");
		System.out.println(u1.toString());
		Item i = new Item("Adespya", 5.0, "pencil", "Special pencil");
		System.out.println(i.toString());
		System.out.println();
		Inventory in = new Inventory();
		in.viewAllitems();
		in.addItem(i);
		System.out.println(in.listofItems.get(0));
		Bid b = new Bid(u1.username, i.itemID, 6.0);
		System.out.println(b.toString());
		bidList bl = new bidList();
		bl.addBid(u1, b);
		bl.editBid(u1, i, 7.0);
		System.out.println(bl.isWinBid(i));
		bl.cancelBid(u1, i);
		
	}
	
}
*/