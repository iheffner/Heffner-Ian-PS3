package MainPackage;

/**
 * JUnit test class for methods within the Account class.
 * Testing the withdraw() and deposit() methods.
 * Also testing the InsufficientFundsException class.
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class AccountTest {
	//Establish an instance of Account to work with
	Account acc = new Account(1122, 20000);

	@Before
	public void setUp() throws Exception {
		//Set the annual interest rate
		acc.setAnnualInterestRate(.045);
	}

	@After
	public void tearDown() throws Exception {
		//After each test, print the balance, monthly interest rate, and date created.
		System.out.printf("Balance: $%.2f \nMonthly interest rate: %.3f%% \nDate created: %tB %<te, %<tY %<tT %<Tp%n \n",
				acc.getBalance(), acc.getMonthlyInterestRate() * 100, acc.getDateCreated());
	}

	@Test
	public void testMethods() throws InsufficientFundsException {
		//Withdraw $2500 and test the new balance
		acc.withdraw(2500);
		assertTrue(acc.getBalance() == 17500);
		//Deposit $3000 and test the new balance
		acc.deposit(3000);
		assertTrue(acc.getBalance() == 20500);

	}

	@Test(expected = InsufficientFundsException.class)
	public void testException() throws InsufficientFundsException {
		//Test for an overdraw error
		acc.withdraw(250000);
	}

}
