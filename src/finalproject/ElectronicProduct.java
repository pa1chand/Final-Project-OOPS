package finalproject;
// This line declares the package "thirdproject" for the current Java file.

// Concrete product class for electronic products
// This class represents a concrete implementation of the Product interface for electronic products.

public class ElectronicProduct implements Product {
// Declaration of the ElectronicProduct class implementing the Product interface.

    private String itemName;
    private double itemCost;
    private String itemDescription;
    private int stockQuantity;
    // Declaration of private instance variables to store information about the electronic product.

    // Constructor and other methods

    public ElectronicProduct(String itemName, double itemCost, String itemDescription, int stockQuantity) {
    // Constructor for creating an instance of the ElectronicProduct class.

        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemDescription = itemDescription;
        this.stockQuantity = stockQuantity;
        // Initializing instance variables with provided values.

    }

    @Override
    // Annotation indicating that the following method overrides a method in the Product interface.

    public String fetchName() {
    // Implementation of the fetchName method from the Product interface.

        return itemName;
        // Returning the itemName of the electronic product.

    }

    @Override
    // Annotation indicating that the following method overrides a method in the Product interface.

    public double fetchPrice() {
    // Implementation of the fetchPrice method from the Product interface.

        return itemCost;
        // Returning the itemCost of the electronic product.

    }

    @Override
    // Annotation indicating that the following method overrides a method in the Product interface.

    public String fetchDescription() {
    // Implementation of the fetchDescription method from the Product interface.

        return itemDescription;
        // Returning the itemDescription of the electronic product.

    }

    @Override
    // Annotation indicating that the following method overrides a method in the Product interface.

    public int fetchStockQuantity() {
    // Implementation of the fetchStockQuantity method from the Product interface.

        return stockQuantity;
        // Returning the quantity in stock of the electronic product.

    }

    // toString method to provide a string representation of the ElectronicProduct instance.
    public String toString() {
        return "ElectronicProduct{" +
                "itemName='" + fetchName() + '\'' +
                ", itemCost=" + fetchPrice() +
                ", itemDescription='" + fetchDescription() + '\'' +
                ", stockQuantity=" + fetchStockQuantity() +
                '}';
    }

}
