Online Shopping System
Description
This Java application simulates an online shopping system with user authentication, product browsing, shopping cart management, and order placement functionalities.
Features
1. User Authentication
   Register new users with username, password, name, and email.
   Login existing users with username and password.
2. Product Browsing
   Browse a list of available products.
   View details such as price, description, and quantity in stock.
3. Shopping Cart Management
   Add products to the shopping cart.
   Remove products from the shopping cart.
   View the shopping cart with total price.
4. Order Placement
   Place an order for the products in the shopping cart.
   Simulate payment processing (placeholder logic).
5. Validation
   Validate user input for username, password, name, and email.
   Validate format of user data and product details.
6. Logging
   Log user actions like login, registration, and order placement.
   Log system events for tracking.
Components
MainClassGUI.java
Main class containing the GUI for the application.
Implements actions for registration, login, browsing products, managing the shopping cart, and placing orders.
User.java
Represents a user with username, password, name, and email.
Provides methods for user authentication.
UserAuthentication.java
Manages user authentication operations.
Registers new users and authenticates existing users.
ShoppingCart.java
Represents the shopping cart for the logged-in user.
Allows adding/removing products and calculates the total price.
Product.java
Abstract class representing a product.
Defines methods for fetching product details such as name, price, description, and stock quantity.
ElectronicProduct.java
Extends Product.java.
Represents an electronic product with additional attributes specific to electronic items.
ClothingProduct.java
Extends Product.java.
Represents a clothing product with additional attributes specific to clothing items.
ProductCatalog.java
Manages the catalog of available products.
Provides operations to insert products and list all products.
ProductLoader.java
Loads initial sample products into the system.
Returns a list of products for the ProductCatalog.
Logger.java
Logs events and actions performed in the application.
Logs user actions like login, registration, and order placement.
TransactionProcessor.java
Placeholder for simulating payment processing.
Executes the payment transaction with a given amount and payment method.
Catalog.java
Interface representing a catalog of products.
Defines methods for managing products.
ElectronicProduct.java
Implements the Catalog interface.
Represents an electronic product.
ClothingProduct.java
Implements the Catalog interface.
Represents a clothing product.
ShoppingCart.java
Represents a shopping cart of products.
Defines methods for adding/removing products and calculating the total price.
User.java
Represents a user in the system.
Provides methods for registering, logging in, and accessing user information.
ProductCatalog.java
Manages the catalog of products available for sale.
Provides methods for adding products and retrieving product information.
Usage
1. Running the Application
   Compile and run the MainClassGUI.java file.
   The application GUI will appear, providing options for registration, login, product browsing, and cart management.
2. Registering a New User
   Click on the "Register" button and fill in the registration form.
   Validate the username, password, name, and email formats before registering.
3. Logging In
   Click on the "Login" button and enter your registered username and password.
4. Browsing Products
   Click on the "Browse Products" button to view a list of available products.
   Products are displayed with details like name, price, description, and stock quantity.
5. Adding Products to Cart
   Click on the "Add to Cart" button and enter the product name to add to the shopping cart.
   Products added to the cart will display the total price in the shopping cart view.
6. Managing Shopping Cart
   Click on the "View Cart" button to see the products added to the shopping cart.
   Click on the "Remove from Cart" button and enter the product name to remove from the shopping cart.
7. Placing an Order
   Click on the "Place Order" button to place an order for the products in the shopping cart.
   Simulated payment processing will occur (placeholder logic).
   On successful payment, the order is placed, and the shopping cart is cleared.
8. Logging
   All user actions such as login, registration, and order placement are logged.
   Logs can be viewed for tracking purposes.
Implementation Details
MainClassGUI.java
Initializes the GUI components and handles user actions.
Interacts with UserAuthentication, ShoppingCart, ProductCatalog, and Logger.
User.java
Represents a user with basic attributes and methods for validation.
UserAuthentication.java
Manages user registration and login operations.
Validates user credentials against stored user data.
ShoppingCart.java
Stores selected products for the current user.
Supports adding/removing products and calculating the total price.
Product.java
Abstract class representing a product.
Defines methods for fetching product details.
ElectronicProduct.java
Extends Product.java.
Represents electronic products with additional attributes.
ClothingProduct.java
Extends Product.java.
Represents clothing products with additional attributes.
ProductCatalog.java
Manages the list of available products.
Supports operations to add products and retrieve the product list.
ProductLoader.java
Loads initial sample products into the system.
Provides a static method to load and return a list of products.
Logger.java
Logs events and actions performed in the application.
Supports logging user actions, system events, and errors.
TransactionProcessor.java
Placeholder for simulating payment processing logic.
Executes a transaction with a given amount and payment method.
Requirements
Java Development Kit (JDK) 8 or higher.
Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans.
Logger.java
It logs the application events and actions taking place.
It logs user actions, system events, and errors.
TransactionProcessor.java
This is a placeholder to simulate the logic to process a payment.
It has a method to execute a transaction with a certain amount and payment method.
Requirements
JDK 8 or later
An IDE like IntelliJ IDEA, Eclipse, or NetBeans.