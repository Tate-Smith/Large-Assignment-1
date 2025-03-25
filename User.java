package Model;

import org.json.*;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

// class to store username and password
// as well as the users specific userLibrary object
public class User {
	
	
	private String username;
	private byte[] salt;
	private byte[] password;
	private LibraryModel userLibrary;
	
	public User(String username, String password) throws Exception {
		this.username = username;
		this.salt = createRandSalt();
		this.password = create_SHA_2Hash(salt, password);
		this.userLibrary = new LibraryModel();
	}
	
	/* 
	 * This method creates a random 16 byte salt.
	*/
	private static byte[] createRandSalt() {
		// create new byte array of 8 bytes
		byte[] newSalt = new byte[8];
		// initializes a form of random that is better for security purposes
		SecureRandom secure_random = new SecureRandom();
		// fills the byte array with random values
		secure_random.nextBytes(newSalt);
		return newSalt;
	}
	
	/*
	 * This method encrypts the password using the salt that is created for the user
	 * and the string password that is inputed. 
	 * */
	public static byte[] create_SHA_2Hash(byte[] salt, String password) throws Exception{
		// creates a byteStream that makes it easy to concatenate the salt and password
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		// add salt to byteStream
		byteStream.write(salt);
		// add the bytes of the password
		byteStream.write(password.getBytes());
		// forms a single array from the salt and the password
		byte [] valueToHash = byteStream.toByteArray();
		// MessageDigest creates a hashing function that utilizes SHA2_ALGORITHM
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		// returns the value after the hash
		return messageDigest.digest(valueToHash);
	}
	
	
	public LibraryModel getUserLibrary() {
		return userLibrary;
	}
	
	public String getUsername() {
		return username;
	}
	
	public byte[] getSalt() {
		// returns a copy of the salt
		return Arrays.copyOf(salt, salt.length);
	}
	
	public byte[] getPassword() {
		// returns a copy of the password
		return Arrays.copyOf(password, password.length);
	}
	
	public JSONObject userToJSON() {
		JSONObject userJSON = new JSONObject();
		
		userJSON.put("username", this.username);
		userJSON.put("salt", getSalt());
		userJSON.put("password", getPassword());
		userJSON.put("User Library", userLibrary);
		
		return userJSON;
	}
	
	
}
