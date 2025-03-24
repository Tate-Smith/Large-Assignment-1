/* 
 * basically the idea of this class is that it saves user data to a file that
 * is static so everytime a new instance of this class is created you can still
 * retrieve the data from the database, it does this through a HashMap. 
 * It's a crud database which stands for:
 * 
 * Create: adds data to the file (addUser())
 * Read: get data from the file (getUser())
 * Update: update info in the file, we don't need this beacuse User data is immutable
 * Delete: remove data from the file (removeUser())
 * 
 * it uses these methods through a HashMap to manipulate the file. The file is a permamnent
 * database because once the user creates an account it is saved to the file and never goes away
 * unless explicitly removed, even if the program is terminated, on the next run when it creates
 * the UserDataBase object again it acesses the same exact file and takes all of the files data
 * and puts it in the HashMap, so the User account will still be there. Everytime an account is 
 * added, removed or the whole database is cleared, the file is updated throigh the update()
 * method, that way the info is permanently saved. 
 */

package Model;

import org.json.*;
import java.io.*;

// class full of users, can use crud database to store in files
public class UserDataBase {
	
	private JSONObject database;
	private static final File FILE = new File("database.json");
	
	public UserDataBase() {
		this.database = new JSONObject();
	}
	
	public void update() {
		try (FileWriter writer = new FileWriter(FILE)) {
			for (String key : database.keySet()) {
				writer.write(database.toString());
			}
			writer.flush();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* This method add user to the JSONObject "database" */
	public void addUser(User user) {
		String userName = user.getUsername();
		if (database.keySet().contains(userName)) {
			System.out.println("User Already in Database");
		} 
		else {
			database.put(userName, user);
		}	
		update();
	}
	
	public User getUser(String userName) {
		return (User)database.get(userName);
	}
	
	public void removeUser(String userName) {
		database.remove(userName);
		update();
	}
}