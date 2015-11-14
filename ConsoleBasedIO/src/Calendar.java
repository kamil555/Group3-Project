import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Gabrielle Glynn
 * @since November 8, 2015
 * @updated November 14, 2015
 */

public class Calendar {

	private int futureAuctions;
	private ArrayList<Auction> auctionList;
	private ArrayList<Auction> futureAuctionList;

	// constructor
	public Calendar() {
		this.auctionList = new ArrayList<Auction>();
		this.auctionList = readAuctionsFromFile();
		sortListByDate(this.auctionList);
		System.out.println(this.auctionList);

		futureAuctionList = new ArrayList<Auction>();

		for (Auction a : this.auctionList) {
			Date now = new Date();
			java.util.Calendar c = java.util.Calendar.getInstance();
			c.setTime(now);
			
			if (now.before(a.getStartDate())) {
				futureAuctionList.add(a);
			}
		}

		futureAuctions = futureAuctionList.size();
	}

	// Make calendar a singleton.
	// http://www.tutorialspoint.com/java/java_using_singleton.htm
	private static Calendar sCalendar;

	public static Calendar getCalendar() {
		if (sCalendar == null)
			sCalendar = new Calendar();
		return sCalendar;
	}

	private static int MAX_FUTURE_AUCTIONS = 25;
	private static int MAX_DAYS_OUT = 90;
	private static int MAX_AUCTIONS_ROLLING_7DAY = 5;
	private static int MAX_AUCTIONS_SAME_DAY = 2;
	private static int MAX_HOURS_BTW_AUCTIONS = 2;
	private static int MAX_NP_AUCTIONS_PER_365_DAYS = 1;
	private static String FILENAME = "auctionList.txt";

	// read file into array list of auctions, will use to construct auctionList,
	// futureAuctionList and pastAuctionList
	private ArrayList<Auction> readAuctionsFromFile() {
		String line = null;
		try {

			ArrayList<Auction> auctionList = new ArrayList<Auction>();
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(FILENAME);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String[] split = line.split(",", 2);
				String auctionName = split[0];
				String auctionDuration = split[1];
				int duration = Integer.parseInt(auctionDuration);

				String[] splitName = auctionName.split("-", 2);
				String nonProfitName = splitName[0];
				String auctionDate = splitName[1];

				auctionList.add(new Auction(nonProfitName, auctionDate,
						duration));
			}

			bufferedReader.close();

			return auctionList;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + FILENAME + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + FILENAME + "'");
		}
		return null;
	}

	/**
	 * Returns an auction if a nonprofit has one scheduled for the future.
	 * 
	 * @param nonProfitName
	 */
	public Auction getAuction(String nonProfitName) {
		for (Auction a : this.futureAuctionList) {
			if (a.getProfitName() == nonProfitName)
				return a;
		}
		System.out.println("No scheduled auction found for " + nonProfitName
				+ ".");
		return null;
	}

	private void removeOneAuctionFromFile(Auction auctionToRemove) {
		for (Auction a : this.auctionList) {
			if (auctionToRemove.getAuctionName() == a.getAuctionName()) {
				this.auctionList.remove(a);
				writeAuctionsToFile();
			}
		}
		for (Auction a : this.futureAuctionList) {
			if (auctionToRemove.getAuctionName() == a.getAuctionName()) {
				this.futureAuctionList.remove(a);
				futureAuctions -= 1;
			}
		}
	}

	public void clearFile() throws IOException {
		try {
			FileWriter fw = new FileWriter(FILENAME, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print("");
			pw.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + FILENAME + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + FILENAME + "'");
		}
	}

	private void writeAuctionsToFile() {
		try {
			clearFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Auction a : this.auctionList) {
			try {
				writeOneAuctionToFile(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void writeOneAuctionToFile(Auction auctionToWrite) throws IOException {
		String auctionString = new String();
		auctionString = auctionToWrite.toString();
		FileWriter fw = new FileWriter(FILENAME, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(auctionString + "\r\n");
		pw.close();
	}
	
	// sort list of auctions by date
	private void sortListByDate(ArrayList<Auction> auctionList) {
		Collections.sort(auctionList, new Comparator<Auction>() {
			  public int compare(Auction auctionOne, Auction auctionTwo) {
			      if (auctionOne.getStartDate() == null || auctionTwo.getStartDate() == null) {
			        return 0;
			      }
			      return auctionOne.getStartDate().compareTo(auctionTwo.getStartDate());
			  }
		});
	}

	// return array list of all auctions: past and future
	public ArrayList<Auction> getAuctionList() {
		return this.auctionList;
	}

	// return array list of future auctions
	public ArrayList<Auction> getfutureAuctionList() {
		return this.futureAuctionList;
	}

	public void addFutureAuction(Auction reqAuction) throws IOException {
		if (checkRequestedAuction(reqAuction)) {
			addAuction(this.auctionList, reqAuction);
			futureAuctionList.add(reqAuction);
			futureAuctions += 1;
		}
	}

	// check if auction meets requirements
	public boolean checkRequestedAuction(Auction reqAuction) {
		Date now = new Date();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(now);
		if (!atMaxFutureAuctions()) {
			if (inDateRange(now, reqAuction.getStartDate())) {

			}

			return true;
		}
		return false;
	}

	// add auction passed to it without any error checking; used in function
	// that add past auctions to an arraylist
	public void addAuction(ArrayList<Auction> auctionList, Auction newAuction)
			throws IOException {
		auctionList.add(newAuction);
		writeOneAuctionToFile(newAuction);
	}

	// check if future list is current; if not remove out of date auctions and
	// append them to past auction list

	// no more than 5 auctions in a rolling 7 day period

	// no more than 25 auctions may be scheduled into the future
	private boolean atMaxFutureAuctions() {
		return (this.futureAuctions == MAX_FUTURE_AUCTIONS);
	}

	// an auction may not be more than 90 days from the current date
	private boolean inDateRange(Date currentDate, Date requestedDate) {
		Date dateAtEndOfRange = new Date();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(dateAtEndOfRange);
		c.add(java.util.Calendar.DATE, MAX_DAYS_OUT);
		dateAtEndOfRange = c.getTime();

		return !(requestedDate.before(currentDate) || requestedDate
				.after(dateAtEndOfRange));
	}

	// no more than 2 auctions in the same day
	private boolean atMaxAuctionsPerDay(Date requestedDate) {
		return true;
	}

	// start time of 2nd auction/day must be two hours after end time of he
	// first

	// no more than one auction per year per nonprofit organization can be
	// scheduled

}