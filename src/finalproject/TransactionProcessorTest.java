package finalproject;
import org.junit.Test;
import static org.junit.Assert.*;
public class TransactionProcessorTest {
 @Test
 public void testProcessPaymentSuccess() {
 TransactionProcessor paymentProcessor = new TransactionProcessor();
 double amount = 100.0;
 String paymentMethod = "Credit Card";
 assertTrue(paymentProcessor.executeTransaction(amount, paymentMethod));
 }
 @Test
 public void testProcessPaymentInvalidAmount() {
 TransactionProcessor paymentProcessor = new TransactionProcessor();
 double invalidAmount = -50.0;
 String paymentMethod = "Credit Card";
 assertFalse(paymentProcessor.executeTransaction(invalidAmount, paymentMethod));
 }
 @Test
 public void testProcessPaymentInvalidMethod() {
 TransactionProcessor paymentProcessor = new TransactionProcessor();
 double amount = 50.0;
 String invalidMethod = "Invalid Method";
 assertFalse(paymentProcessor.executeTransaction(amount, invalidMethod));
 }
 // Add more tests as needed
}
