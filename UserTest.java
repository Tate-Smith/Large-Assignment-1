package Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class UserTest {
	private User user = new User("Tate", "12345678");
	
	@Test
	public void testGetUserLibrary() {
		assertTrue(user.getUserLibrary() instanceof LibraryModel);
	}

	@Test
	public void testGetUserName() {
		assertEquals(user.getUsername(), "Tate");
	}
	
	@Test
	public void testGetPassword() throws Exception{
		byte[] password_one = user.getPassword();
		String password = "12345678";
		byte[] copySalt = user.getSalt();
		byte[] hashedPass = user.create_SHA_2Hash(copySalt, password);
		assertEquals(password_one[0], hashedPass[0]);
	}
	
	
}
