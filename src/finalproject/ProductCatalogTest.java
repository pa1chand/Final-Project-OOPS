package finalproject;
// This line declares the package "finalproject" for the current Java file.
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
// Importing the List interface from the java.util package.
public class ProductCatalogTest {
// Declaration of a class named "ProductCatalogTest" for testing the ProductCatalog class.
    @Test
    // Annotation indicating that the following method is a test case.
    public void testAddProduct() {
    // Declaration of a test method named "testAddProduct".
        ProductCatalog itemCatalog = new ProductCatalog();
        // Creating an instance of the ProductCatalog class for testing.
        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        // Creating an instance of the ElectronicProduct class for testing.
        itemCatalog.addProduct(laptop);
        // Adding the laptop product to the itemCatalog.
        assertEquals(1, itemCatalog.listAllProducts().size());
        // Asserting that the itemCatalog has one product after adding.
        assertEquals(laptop, itemCatalog.searchProductByName("Laptop"));
        // Asserting that the product retrieved by itemName is the same as the added laptop.
    }
    @Test
    // Annotation indicating that the following method is a test case.
    public void testAddProducts() {
    // Declaration of a test method named "testAddProducts".
        ProductCatalog itemCatalog = new ProductCatalog();
        // Creating an instance of the ProductCatalog class for testing.
        List<Product> newProducts = new ArrayList<>();
        // Creating a new list to hold products.
        Product tShirt = new ClothingProduct("T-Shirt", 25.0, "Comfortable cotton T-shirt", 50);
        // Creating an instance of the ClothingProduct class for testing.
        newProducts.add(tShirt);
        // Adding the T-shirt product to the list.
        itemCatalog.insertProducts(newProducts);
        // Adding all products from the list to the itemCatalog.
        assertEquals(1, itemCatalog.listAllProducts().size());
        // Asserting that the itemCatalog has one product after adding.
        assertEquals(tShirt, itemCatalog.searchProductByName("T-Shirt"));
        // Asserting that the product retrieved by itemName is the same as the added T-shirt.
    }
    @Test
    // Annotation indicating that the following method is a test case.
    public void testGetProductByName() {
    // Declaration of a test method named "testGetProductByName".
        ProductCatalog itemCatalog = new ProductCatalog();
        // Creating an instance of the ProductCatalog class for testing.
        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        // Creating an instance of the ElectronicProduct class for testing.
        itemCatalog.addProduct(laptop);
        // Adding the laptop product to the itemCatalog.
        assertEquals(laptop, itemCatalog.searchProductByName("Laptop"));
        // Asserting that the product retrieved by itemName is the same as the added laptop.
        assertNull(itemCatalog.searchProductByName("NonexistentProduct"));
        // Asserting that attempting to retrieve a nonexistent product returns null.
    }
    // Add more tests as needed
}
