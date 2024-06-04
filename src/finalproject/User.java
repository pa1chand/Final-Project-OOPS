package finalproject;
public class User {
 private String userId;
 private String userPassword;
 private String itemName;
 private String emailAddress;
 public User(String userId, String userPassword, String itemName, String emailAddress) {
 this.userId = userId;
 this.userPassword = userPassword;
 this.itemName = itemName;
 this.emailAddress = emailAddress;
 }
	public String getUsername() {
	return userId;
	}
	public void setUsername(String userId) {
	this.userId = userId;
	}
	public String getPassword() {
	return userPassword;
	}
	public void setPassword(String userPassword) {
	this.userPassword = userPassword;
	}
	public String fetchName() {
	return itemName;
	}
	public void setName(String itemName) {
	this.itemName = itemName;
	}
	public String getEmail() {
	return emailAddress;
	}
	public void setEmail(String emailAddress) {
	this.emailAddress = emailAddress;
	}
 // Getters for user properties
}
