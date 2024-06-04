package finalproject;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Pattern; 
public class MainClass {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        User loggedInUser = null;
        UserAuthentication authService = new UserAuthentication();
        ShoppingCart userCart = new ShoppingCart();
        ProductCatalog itemCatalog = new ProductCatalog();
        // Load products into the itemCatalog
        List<Product> products = ProductLoader.loadProducts();
        itemCatalog.insertProducts(products);
        
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");
            if (loggedInUser != null) {
                System.out.println("Logged in as: " + loggedInUser.getUsername());
            }
            System.out.print("Select an option: ");
            int option = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character.
            switch (option) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String userId = userInput.nextLine();
                    System.out.print("Enter userPassword: ");
                    String userPassword = userInput.nextLine();
                    System.out.print("Enter name: ");
                    String itemName = userInput.nextLine();
                    System.out.print("Enter emailAddress: ");
                    String emailAddress = userInput.nextLine();
                 // Validate input
                    if (!validateUsername(userId)) {
                        System.out.println("Username must contain only lowercase letters.");
                    } else if (!validatePassword(userPassword)) {
                        System.out.println("Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
                    } else if (!validateName(itemName)) {
                        System.out.println("Name must be in the format 'First Last' with the first letter of each word capitalized.");
                    } else if (!validateEmail(emailAddress)) {
                        System.out.println("Email must contain the @ symbol.");
                    } else {
                        authService.registerUser(userId, userPassword, itemName, emailAddress);
                        Logger.log("User registered: " + userId);
                        System.out.println("User registered successfully!");
                    }
                    break;
                    
                    
                    
                case 2: // Login
                    if (loggedInUser != null) {
                        System.out.println("You are already logged in.");
                    } else {
                        System.out.print("Enter userId: ");
                        String loginUsername = userInput.nextLine();
                        System.out.print("Enter userPassword: ");
                        String loginPassword = userInput.nextLine();
                        loggedInUser = authService.login(loginUsername, loginPassword);
                        if (loggedInUser != null) {
                            Logger.log("User logged in: " + loggedInUser.getUsername());
                            System.out.println("Login successful. Welcome, " + loggedInUser.getUsername() + "!");
                        } else {
                            Logger.log("Login failed for user: " + loginUsername);
                            System.out.println("Login failed. Please check your credentials.");
                        }
                    }
                    break;
                case 3: // Browse Products (Not implemented in this example)
                    
                    listProducts(itemCatalog.listAllProducts());
                    break;
                    
                case 4: // Add Product to Cart (Not implemented in this example)
                	if (loggedInUser != null) {
                        // Placeholder for adding a product to the cart
                        System.out.print("Enter the product itemName to add to the cart: ");
                        String ProductName = userInput.nextLine();
                        Product selectedProduct = searchProductByName(itemCatalog.listAllProducts(), ProductName);
                        if (selectedProduct != null) {
                            userCart.addItem(selectedProduct);
                            System.out.println("Product added to the cart.");
                        } else {
                            System.out.println("Product not found in the itemCatalog.");
                        }
                    } else {
                        System.out.println("You need to log in to add products to the cart.");
                    }
                    break;
                 // Inside your main switch statement
                case 5: // View Cart
                    if (loggedInUser != null) {
                        List<Product> items = userCart.getItems();
                        System.out.println("Cart for " + loggedInUser.getUsername() + ":");
                        for (Product item : items) {
                            System.out.println(item.fetchName());
                        }
                        double finalPrice = totalCost(userCart);
                        System.out.println("Total Price: $" + finalPrice);
                    } else {
                        System.out.println("You need to log in to view your cart.");
                    }
                    break;
                case 6: // Place Order (Not implemented in this example)
                    if (loggedInUser != null) {
                        System.out.println("Placing an order...");
                        double finalPrice = totalCost(userCart);
                        boolean paymentSuccess = new TransactionProcessor().executeTransaction(finalPrice, "Credit Card");
                        if (paymentSuccess) {
                            Logger.log("Order placed for user: " + loggedInUser.getUsername());
                            System.out.println("Order placed successfully.");
                        } else {
                            Logger.log("Payment failed for user: " + loggedInUser.getUsername());
                            System.out.println("Payment failed. Please try again.");
                        }
                    } else {
                        System.out.println("You need to log in to place an order.");
                    }
                    break;
                case 7: // Exit
                    System.out.println("Exiting the program.");
                    userInput.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    
    
	// Validation methods
    private static boolean validateUsername(String userId) {
        // Username contains all lowercase letters
        return Pattern.matches("^[a-z]+$", userId);
    }
    private static boolean validatePassword(String userPassword) {
        // Password contains one uppercase, one special character, one number, and all lowercase
        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$", userPassword);
    }
    private static boolean validateName(String itemName) {
        // Name contains the first itemName and last itemName
        return Pattern.matches("^[A-Z][a-z]* [A-Z][a-z]*$", itemName);
    }
    private static boolean validateEmail(String emailAddress) {
        // Email contains the @ symbol
        return emailAddress.contains("@");
    }
    private static void listProducts(List<Product> productList) {
        System.out.println("Product List:");
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.fetchName() + " - $" + product.fetchPrice());
            System.out.println("   Description: " + product.fetchDescription());
            System.out.println("   Quantity in Stock: " + product.fetchStockQuantity());
        }
    }
// Placeholder method to find a product by itemName
private static Product searchProductByName(List<Product> catalogProducts, String itemName) {
    for (Product product : catalogProducts) {
        if (product.fetchName().equalsIgnoreCase(itemName)) {
            return product;
        }
    }
    return null;
}
// Placeholder method to calculate the total itemCost of items in the cart
private static double totalCost(ShoppingCart userCart) {
    double total = 0.0;
    for (Product product : userCart.getItems()) {
        total += product.fetchPrice();
    }
    return total;
}
}