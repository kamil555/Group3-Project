import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class itemIDGenerator {

	private static int id = 0;
	
	public static int getCurrentID() {
		return id;
	}

	public static int nextID() {
		id = id + 1;
		return id;
	}

}
