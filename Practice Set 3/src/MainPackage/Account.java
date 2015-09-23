package MainPackage;

/**
 * @author Ian Heffner
 * 
 * This program is the Account class.
 * The Account has four private attributes:
 * 	int id = the ID number of the account
 * 	double balance = the balance in the account
 * 	annualInterestRate = the interest rate on the account
 *  dateCreated = the date the account was created, generated by the Account constructor
 * 
 * In addition to getters and setters, the Account class has a withdraw() method 
 * a deposit() method, and a getMonthlyInterestRate() method.
 *  withdraw updates the balance after subtracting the given amount
 *  deposit updates the balance by adding the given amount
 *  getMonthlyInterestRate divides the annual interest rate by 12 and returns it
 * 
 * If the user tries to overdraw the account, it triggers the InsufficientFundsException.
 */

import java.util.Date;

public class Account {
	//Establish private attributes
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;

	public Account() {
		//No-Arg constructor establishes initial value
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}

	
	public Account(int id, double balance) {
		//Constructor with arguments
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}

	//Getters and setters for id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Getters and setters for balance
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//Getters and setters for annualInterestRate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	//Getter for dateCreated
	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterestRate() {
		//Calculate the monthly interest from the annual interest by dividing it by 12
		double monthlyInterestRate = this.getAnnualInterestRate() / 12;
		return monthlyInterestRate;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		//Withdraw money from the account
		if (this.getBalance() - amount > 0){
			//If the balance is more than the amount, withdraw it
			this.setBalance(this.getBalance() - amount);
		}
		else {
			//If the balance is less than the amount, return the error
			//to notify the user they are overdrawing the account.
			throw new InsufficientFundsException(amount - this.getBalance());
		}
	}

	public void deposit(double amount) {
		//Deposit money into the account
		double newBalance = this.getBalance() + amount;
		this.setBalance(newBalance);
	}
}
