package Model;
// class to store username and password
// as well as the users specific userLibrary object
public class User {
	private String username;
	private String password;
	private LibraryModel userLibrary;
	
	public User(String username, String password) {
		this.username = username;
		// encrypt this with a java library when storing it
		this.password = password;
		this.userLibrary = new LibraryModel();
	}
	
	public LibraryModel getUserLibrary() {
		return userLibrary;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		// decyrpt password before returning it
		return password;
	}
}
