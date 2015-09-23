package MainPackage;
/**
 * Base taken from CISC181 Repository Week 3 Package 4
 * This Exception class notifies the user when they have overdrawn their account.
 */
public class InsufficientFundsException extends Exception
{
   private double amount;
   /**
    * Create an instance of the InsufficientFundsException class, to be thrown to the caller
    * @param amount
    */
   public InsufficientFundsException(double amount)
   {
      this.amount = amount;
      System.out.printf("You have overdrawn your account by $%,.2f. \n", amount);
   } 
   public double getAmount()
   {
      return amount;
   }
}