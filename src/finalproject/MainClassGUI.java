package finalproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;





public class MainClassGUI extends JFrame {

	private static final long serialVersionUID = 1L;

 private User loggedInUser;

 private UserAuthentication authService;

 private ShoppingCart userCart;

 private ProductCatalog itemCatalog;



 public MainClassGUI() {

 super("Online Shopping System");

 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 setSize(400, 300);

 setLocationRelativeTo(null);



 authService = new UserAuthentication();

 userCart = new ShoppingCart();

 itemCatalog = new ProductCatalog();



 // Load products into the itemCatalog

 itemCatalog.insertProducts(ProductLoader.loadProducts());



 createGUIComponents();



 setVisible(true);

 }



 private void createGUIComponents() {

 JPanel panel = new JPanel(new FlowLayout());

 



 JButton registerButton = new JButton("Register");

 registerButton.setBounds(20, 20, 120, 30);

 registerButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showRegistrationDialog();

 }

 });

 panel.add(registerButton);



 JButton loginButton = new JButton("Login");

 loginButton.setBounds(160, 20, 120, 30);

 loginButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showLoginDialog();

 }

 });

 panel.add(loginButton);



 JButton browseProductsButton = new JButton("Browse Products");

 browseProductsButton.setBounds(20, 70, 260, 30);

 browseProductsButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showProductList();

 }

 });

 panel.add(browseProductsButton);



 JButton addToCartButton = new JButton("Add to Cart");

 addToCartButton.setBounds(20, 120, 120, 30);

 addToCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showAddToCartDialog();

 }

 });

 panel.add(addToCartButton);



 JButton viewCartButton = new JButton("View Cart");

 viewCartButton.setBounds(160, 120, 120, 30);

 viewCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 showCart();

 }

 });

 panel.add(viewCartButton);

 

 

 





 JButton placeOrderButton = new JButton("Place Order");

 placeOrderButton.setBounds(20, 170, 260, 30);

 placeOrderButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 confirmOrder();

 }

 });

 panel.add(placeOrderButton);



 add(panel);

 

 

 JButton removeFromCartButton = new JButton("Remove from Cart");

 removeFromCartButton.setBounds(160, 170, 120, 30);

 removeFromCartButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 removeFromCartDialog();

 }

 });

 panel.add(removeFromCartButton);



 add(panel);

 

 



 

}





 private void showRegistrationDialog() {

 JTextField usernameField = new JTextField();

 JPasswordField passwordField = new JPasswordField();

 JTextField nameField = new JTextField();

 JTextField emailField = new JTextField();



 Object[] message = {

 "Username:", usernameField,

 "Password:", passwordField,

 "Name:", nameField,

 "Email:", emailField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String userId = usernameField.getText();

 String userPassword = new String(passwordField.getPassword());

 String itemName = nameField.getText();

 String emailAddress = emailField.getText();



 // Validate input

 if (!validateUsername(userId)) {

 JOptionPane.showMessageDialog(null, "Username must contain only lowercase letters.");

 } else if (!validatePassword(userPassword)) {

 JOptionPane.showMessageDialog(null, "Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");

 } else if (!validateName(itemName)) {

 JOptionPane.showMessageDialog(null, "Name must be in the format 'First Last' with the first letter of each word capitalized.");

 } else if (!validateEmail(emailAddress)) {

 JOptionPane.showMessageDialog(null, "Email must contain the @ symbol.");

 } else {

 authService.registerUser(userId, userPassword, itemName, emailAddress);

 Logger.log("User registered: " + userId);

 JOptionPane.showMessageDialog(null, "User registered successfully!");

 }

 }

 }





 private void showLoginDialog() {

 JTextField usernameField = new JTextField();

 JPasswordField passwordField = new JPasswordField();



 Object[] message = {

 "Username:", usernameField,

 "Password:", passwordField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String loginUsername = usernameField.getText();

 String loginPassword = new String(passwordField.getPassword());



 if (loggedInUser != null) {

 JOptionPane.showMessageDialog(null, "You are already logged in.");

 } else {

 loggedInUser = authService.login(loginUsername, loginPassword);



 if (loggedInUser != null) {

 Logger.log("User logged in: " + loggedInUser.getUsername());

 JOptionPane.showMessageDialog(null, "Login successful. Welcome, " + loggedInUser.getUsername() + "!");

 } else {

 Logger.log("Login failed for user: " + loginUsername);

 JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");

 }

 }

 }

 }



 private void showProductList() {

 List<Product> productList = itemCatalog.listAllProducts();



 if (!productList.isEmpty()) {

 DefaultListModel<String> listModel = new DefaultListModel<>();

 

 for (Product product : productList) {

 String productInfo = product.fetchName() + " - $" + product.fetchPrice()

 + "\n Description: " + product.fetchDescription()

 + "\n Quantity in Stock: " + product.fetchStockQuantity() + "\n";

 listModel.addElement(productInfo);

 }



 JList<String> productListJList = new JList<>(listModel);

 JScrollPane scrollPane = new JScrollPane(productListJList);



 JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.PLAIN_MESSAGE);

 } else {

 JOptionPane.showMessageDialog(null, "No products available in the itemCatalog.", "Product List", JOptionPane.INFORMATION_MESSAGE);

 }

 }





 private void showAddToCartDialog() {

 if (loggedInUser != null) {

 JTextField productNameField = new JTextField();



 Object[] message = {

 "Enter the product itemName to add to the cart:", productNameField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Add to Cart", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String itemName = productNameField.getText();

 Product selectedProduct = searchProductByName(itemCatalog.listAllProducts(), itemName);



 if (selectedProduct != null) {

 userCart.addItem(selectedProduct);

 JOptionPane.showMessageDialog(null, "Product added to the cart.");

 } else {

 JOptionPane.showMessageDialog(null, "Product not found in the itemCatalog.");

 }

 }

 } else {

 JOptionPane.showMessageDialog(null, "You need to log in to add products to the cart.");

 }

 }





 

 

 private void removeFromCartDialog() {

 if (loggedInUser != null) {

 List<Product> cartItems = userCart.getItems();



 if (!cartItems.isEmpty()) {

 JTextField productNameField = new JTextField();



 Object[] message = {

 "Enter the product itemName to remove from the cart:", productNameField

 };



 int option = JOptionPane.showConfirmDialog(null, message, "Remove from Cart", JOptionPane.OK_CANCEL_OPTION);



 if (option == JOptionPane.OK_OPTION) {

 String itemName = productNameField.getText();

 Product productToRemove = searchProductByName(cartItems, itemName);



 if (productToRemove != null) {

 userCart.removeItem(productToRemove);

 JOptionPane.showMessageDialog(null, "Product removed from the cart.");

 } else {

 JOptionPane.showMessageDialog(null, "Product not found in the cart.");

 }

 }

 } else {

 JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Remove from Cart", JOptionPane.INFORMATION_MESSAGE);

 }

 } else {

 JOptionPane.showMessageDialog(null, "You need to log in to remove products from the cart.");

 }

 }

 private Product searchProductByName(List<Product> products, String itemName) {

 for (Product product : products) {

 if (product.fetchName().equalsIgnoreCase(itemName)) {

 return product;

 }

 }

 return null;

 }





	private void showCart() {

 List<Product> cartItems = userCart.getItems();



 if (!cartItems.isEmpty()) {

 DefaultListModel<String> listModel = new DefaultListModel<>();



 for (Product item : cartItems) {

 String itemInfo = item.fetchName() + " - $" + item.fetchPrice();

 listModel.addElement(itemInfo);

 }



 JList<String> cartItemList = new JList<>(listModel);

 JScrollPane scrollPane = new JScrollPane(cartItemList);



 double finalPrice = totalCost(userCart);

 String totalPriceMessage = "Total Price: $" + finalPrice;



 JOptionPane.showMessageDialog(null, new Object[]{scrollPane, totalPriceMessage}, "Shopping Cart", JOptionPane.PLAIN_MESSAGE);

 } else {

 JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);

 }

 }

	

	private void confirmOrder() {

	if (loggedInUser != null) {

	System.out.println("Placing an order...");



	// Placeholder for calculating total itemCost

	double finalPrice = totalCost(userCart);



	// Placeholder for processing payment (replace with your payment processing logic)

	boolean paymentSuccess = new TransactionProcessor().executeTransaction(finalPrice, "Credit Card");



	if (paymentSuccess) {

	Logger.log("Order placed for user: " + loggedInUser.getUsername());

	JOptionPane.showMessageDialog(null, "Order placed successfully. Payment received.");

	// Clear the cart after successful payment

	} else {

	Logger.log("Payment failed for user: " + loggedInUser.getUsername());

	JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");

	}

	} else {

	JOptionPane.showMessageDialog(null, "You need to log in to place an order.");

	}

	}







	private double totalCost(ShoppingCart userCart) {

 double total = 0.0;

 for (Product product : userCart.getItems()) {

 total += product.fetchPrice();

 }

 return total;

 }

	private boolean validateUsername(String userId) {

	// Username must contain only lowercase letters.

	return userId.matches("^[a-z]+$");

	}



	private boolean validatePassword(String userPassword) {

	// Password must contain one uppercase letter, one special character, one number, and at least 8 characters.

	return userPassword.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$");

	}



	private boolean validateName(String itemName) {

	// Name must be in the format 'First Last' with the first letter of each word capitalized.

	return itemName.matches("^[A-Z][a-z]*\\s[A-Z][a-z]*$");

	}



	private boolean validateEmail(String emailAddress) {

	// Email must contain the @ symbol.

	return emailAddress.contains("@");

	}





	



 public static void main(String[] args) {

 SwingUtilities.invokeLater(new Runnable() {

 @Override

 public void run() {

 new MainClassGUI();

 }

 });

 }

}







