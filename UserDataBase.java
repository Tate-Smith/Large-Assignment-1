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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// class full of users, can use crud database to store in files
public class UserDataBase {
	private HashMap<String, User> userDatabase = new HashMap<String, User>();;
	// a file to save all user data in, its static so the database is the same across all instances
	public static final File FILE = new File("User-Database");
	
	public UserDataBase() {
		try {
			// everytime an instance is created the information previously put in the file is read into
			// a hashmap and saved
			Scanner reader = new Scanner(FILE);
			while (reader.hasNext()) {
				if (reader.nextLine() != "") {
					String[] data = reader.nextLine().split(":");
					userDatabase.put(data[0].trim(), data[1]);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		// everytime data is changed in the hashmap it saves it to the file so the changes are permanent
		try {
			FileWriter writer = new FileWriter(FILE);
			for (String key : userDatabase.keySet()) {
				writer.write(key + ":" + userDatabase.get(key) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(User user) {
		// adds user to database
		userDatabase.put(user.getUsername(), user);
		update();
	}
	
	public User getUser(String username) {
		// returns the data
		return userDatabase.get(username);
	}
	
	public void clear() {
		// clears the file
		userDatabase.clear();
		update();
	}
	
	public void removeUser(String username) {
		// removes said user
		userDatabase.remove(username);
		update();
	}
}
