package Lab6;

public class SavingsAccount extends BankAccount {
	
	/** Interest Rate */
	private final double rate = 0.025;
	/** Savings Number to add on end of accountNumber string */
	private int savingsNumber = 0;
	/** Account number overriden from BankAccount class */
	private String accountNumber;
	
	/**
	 * Standard Constructor
	 * @param n : Name of the owner of the account
	 * @param a : Initial amount for account balance
	 */
	public SavingsAccount(String n, double a) {
		super(n, a);
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	/**
	 * Copy Constructor
	 * @param oldAcc : SavingsAccount to copy from
	 * @param a : Initial amount for account balance
	 */
	public SavingsAccount(SavingsAccount oldAcc, double a) {
		super(oldAcc, a);
		this.savingsNumber = oldAcc.savingsNumber++;
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	/**
	 * Adds month's worth of interest to account
	 */
	public void postInterest() {
		System.out.println("This is the current balance: " + this.getBalance());
		double interest = this.getBalance() * (this.rate / 12);
		this.deposit(interest);
	}
	
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	
}
