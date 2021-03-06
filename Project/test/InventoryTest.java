import static org.junit.Assert.*;

import java.io.IOException;

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
	private Inventory myInventory2;
	private Inventory myInventory3;
	private Inventory myInventory4;
	private Item myItem1;
	private Item myItem2;
	private Item myItem3;

	/*
	 * Note: "Inventory.txt" must be cleared and empty
	 * before running the tests in this file.
	 */
	@Test
	public void testAddItem() throws IOException {
		// Testing that size reads zero and that array
		// list is empty since size is set with the
		// array list.
		myInventory = new Inventory();
		assertEquals(0, myInventory.getSize());
		
		// Testing size and array are updated.
		myItem1 = new Item("Auction1Name", 5.00, "Item1", "Description of item1");
		myInventory.addItem(myItem1);
		assertEquals(1, myInventory.getSize());

		// Testing size updated again, and contents
		// of the array are as expected.		
		myItem2 = new Item("Auction1Name", 5.00, "Item2", "Description of item2");
		myInventory.addItem(myItem2);
		assertEquals(2, myInventory.getSize());
		assertEquals(2, myInventory.listofItems.size());
		for(int i = 0; i < myInventory.listofItems.size(); i++) {
			assertEquals(i+1, myInventory.listofItems.get(i).itemID);
			assertEquals("Auction1Name", myInventory.listofItems.get(i).auctionName);	
			assertEquals(5.00, myInventory.listofItems.get(i).startBid, TOLERANCE);		
		}
		assertEquals("Item1", myInventory.listofItems.get(0).itemName);
		assertEquals("Description of item1", myInventory.listofItems.get(0).itemInfo);
		assertEquals("Item2", myInventory.listofItems.get(1).itemName);
		assertEquals("Description of item2", myInventory.listofItems.get(1).itemInfo);
		
		// testing if new inventory will read the two auctions
		// that were added from myInventory additions. This will
		// show that they were written to "Inventory.txt" when added
		// as well as that the constructor read the file.
		myNewInventory = new Inventory();

		assertEquals(2, myNewInventory.getSize());
		assertEquals(2, myNewInventory.listofItems.size());

		myItem3 = new Item("Auction1Name", 5.00, "Item3", "Description of item3");
		myNewInventory.addItem(myItem3);
		for(int i = 0; i < myNewInventory.listofItems.size(); i++) {
			assertEquals(i+1, myNewInventory.listofItems.get(i).itemID);
			assertEquals("Auction1Name", myNewInventory.listofItems.get(i).auctionName);	
			assertEquals(5.00, myNewInventory.listofItems.get(i).startBid, TOLERANCE);		
		}
		assertEquals("Item1", myNewInventory.listofItems.get(0).itemName);
		assertEquals("Description of item1", myNewInventory.listofItems.get(0).itemInfo);
		assertEquals("Item2", myNewInventory.listofItems.get(1).itemName);
		assertEquals("Description of item2", myNewInventory.listofItems.get(1).itemInfo);
		assertEquals("Item3", myNewInventory.listofItems.get(2).itemName);
		assertEquals("Description of item3", myNewInventory.listofItems.get(2).itemInfo);

	}
	

	@Test
	public void testEditItemName() throws IOException {
		myInventory2 = new Inventory();

		myItem1 = new Item("Auction1Name", 5.00, "Item1", "Description of item1");		
		myInventory2.addItem(myItem1);
		
		myItem2 = new Item("Auction1Name", 5.00, "Item2", "Description of item2");
		myInventory2.addItem(myItem2);
		
		myInventory2.editItemName(myItem1.getItemID(), "editNameItem1");
		assertEquals("editNameItem1", myItem1.getItemName());
	}


	@Test
	public void testEditItemStartBid() throws IOException {
		myInventory3 = new Inventory();

		myItem1 = new Item("Auction1Name", 5.00, "Item1", "Description of item1");			
		myInventory3.addItem(myItem1);
		
		myItem2 = new Item("Auction1Name", 5.00, "Item2", "Description of item2");
		myInventory3.addItem(myItem2);
		
		myInventory3.editItemStartBid(myItem1.getItemID(), 4.00);
		assertEquals(4.00, myItem1.getStartBid(), TOLERANCE);
		myInventory3.editItemStartBid(myItem1.getItemID(), 7.00);
		assertEquals(7.00, myItem1.getStartBid(), TOLERANCE);
	
	}
	

	@Test
	public void testEditItemInfo() throws IOException {
		myInventory4 = new Inventory();

		myItem1 = new Item("Auction1Name", 5.00, "Item1", "Description of item1");			
		myInventory4.addItem(myItem1);
		
		myItem2 = new Item("Auction1Name", 5.00, "Item2", "Description of item2");
		myInventory4.addItem(myItem2);
		
		myInventory4.editItemInfo(myItem2.getItemID(), "New description of item2");
		assertEquals("New description of item2", myItem2.getItemInfo());
		myInventory4.editItemInfo(myItem1.getItemID(), "New description of item1");
		assertEquals("New description of item1", myItem1.getItemInfo());
	
	}
}


/*
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
		Bid b = new Bid(u1.userName, i.itemID, 6.0);
		System.out.println(b.toString());
		bidList bl = new bidList();
		bl.addBid(u1, b);
		bl.editBid(u1, i, 7.0);
		System.out.println(bl.isWinBid(i));
		bl.cancelBid(u1, i);		
	}	
}
*/