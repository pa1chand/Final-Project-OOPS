package finalproject;
import java.util.ArrayList;
import java.util.List;
public class UserAuthentication {
 private List<User> userList;
 public UserAuthentication() {
 this.userList = new ArrayList<>();
 }
 public void registerUser(String userId, String userPassword, String itemName, String emailAddress) {
 // Check if the userId is already in use
 if (isUsernameTaken(userId)) {
 System.out.println("Username is already taken. Please choose a different one.");
 return;
 }
 // Create a new user and add them to the list of userList
 User newUser = new User(userId, userPassword, itemName, emailAddress);
 userList.add(newUser);
 System.out.println("User registered successfully!");
 }
 public User login(String userId, String userPassword) {
 for (User user : userList) {
 if (user.getUsername().equals(userId) && user.getPassword().equals(userPassword)) {
 return user; // User found, return the user object
 }
 }
 return null; // User not found
 }
 private boolean isUsernameTaken(String userId) {
 for (User user : userList) {
 if (user.getUsername().equals(userId)) {
 return true; // Username is already in use
 }
 }
 return false; // Username is available
 }
	public boolean validatePassword(String userPassword) {
	// TODO Auto-generated method stub
	return false;
	}
	public boolean validateUsername(String userId) {
	// TODO Auto-generated method stub
	return false;
	}
}
