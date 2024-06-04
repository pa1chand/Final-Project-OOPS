package finalproject;

class TransactionProcessor {

 public boolean executeTransaction(double amount, String paymentType) {
  // Simulate payment processing using a mock payment gateway

  // Check if the payment method is valid (e.g., Credit Card, PayPal, etc.)
  if (isAcceptedPaymentType(paymentType)) {
   // Check if the amount is valid
   if (amount > 0) {
    // Simulate a successful payment
    System.out.println("Processing payment of $" + amount + " via " + paymentType);
    System.out.println("Payment successful.");
    return true;
   } else {
    System.out.println("Invalid payment amount.");
   }
  } else {
   System.out.println("Invalid payment method.");
  }

  // If payment processing fails, return false
  System.out.println("Payment processing failed.");
  return false;
 }

 private boolean isAcceptedPaymentType(String paymentType) {
  // Simulate validation of payment method (e.g., check against a list of supported methods)
  // For simplicity, we'll assume all payment methods are valid.
  return !"Invalid Method".equals(paymentType);
 }
}
