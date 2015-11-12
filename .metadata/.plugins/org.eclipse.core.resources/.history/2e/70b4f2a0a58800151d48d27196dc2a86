import java.util.ArrayList;

public class bidList {
	static ArrayList<Bid> bid = new ArrayList<Bid>(); 
	
	
	private void addBid(String bidName, double bidAmount) {
		
		
		if(bid.size() == 0) { //start bid
			bid.add(new Bid(bidName, bidAmount));
		} 
		else { 
			Bid b = (Bid)bid.get(bid.size());
			if(b.getBidAmount() < bidAmount) { //if the new bid Amount lager than last Amount
				bid.add(new Bid(bidName, bidAmount)); // then add to list
			} else { 
				System.out.println("invalid amount");// else 
			}
		}
	}
	
//	public static void main(String[] args) { // test
//		
//	}

}




//class bidList {
//
//public Bid head;
//
//bidList () {
//head = null;
//}
//
//public boolean isEmpty() {
//return(head == null);
//}
//
//public void firstBid(double bidAmount, String bidName) {
//Bid newBid = new Bid(bidAmount, bidName);
//newBid.next = head;
//head = newBid;
//}
//
//public Bid removeHead() {
//Bid linkReference = head;
//if(!isEmpty()) {
//head = head.next;
//} else {
//System.out.println("No bid");
//}
//
//return linkReference;
//} 
//}