import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Stepan Adespya
 *
 */
public class UsersTest {

	private Users u;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		u = new Users();
	}

	/**
	 * Test method for createUser.
	 * @throws IOException 
	 */
	@Test
	public void testCreateUser() throws IOException {
		assertTrue(u.createUser("bob", "jim", "Bidder"));
	}

	/**
	 * Test method for Login.
	 * @throws IOException 
	 */
	@Test
	public void testLogin() throws IOException {
		assertTrue(u.Login("Stepan","Adespya"));
	}

}
