package finalproject;
import javax.management.monitor.Monitor;
import java.util.ArrayList;
import java.util.List;
public class ProductLoader {
 public static List<Product> loadProducts() {
 List<Product> products = new ArrayList<>();
 // Add some sample products (you can modify or extend this list)
 ElectronicProduct Monitor = new ElectronicProduct("Monitor", 1200.0, "High-performance Monitor", 33);
 ElectronicProduct watch = new ElectronicProduct("watch", 199.99, "Fitness and health tracker", 88);
 ElectronicProduct earphones = new ElectronicProduct("Earphones", 99.99, "Wired over-ear earphones", 37);
 ElectronicProduct smartphone = new ElectronicProduct("Smartphone", 799.99, " phone with advanced features", 13);
 ElectronicProduct tab = new ElectronicProduct("Tab", 499.99, "10-inch tab with HD display", 7);
 ClothingProduct CollarShirt = new ClothingProduct("CollarShirt", 25.0, "Comfortable cotton Collar-shirt", 58);
 ClothingProduct jeans = new ClothingProduct("Jeans", 39.99, " blue jeans", 31);
 ClothingProduct shoes = new ClothingProduct("Shoes", 59.99, "Casual shoes for everyday wear", 22);
 ClothingProduct Dress = new ClothingProduct("Dress", 79.99, "Elegant dress", 13);
 ClothingProduct Track = new ClothingProduct("Track", 29.99, "Comfortable fleece track", 44);
 products.add(Monitor);
 products.add(watch);
 products.add(earphones);
 products.add(smartphone);
 products.add(tab);
 products.add(CollarShirt);
 products.add(jeans);
 products.add(shoes);
 products.add(Dress);
 products.add(Track);
 return products;
 }
}
