package Lab6;

public class CheckingAccount extends BankAccount {
	/** Withdraw fee */
	private final double FEE = 0.15;
	
	/**
	 * Standard Constructor
	 * @param n : Name of owner of account
	 * @param a : Initial amount for account balance
	 */
	public CheckingAccount(String n, double a) {
		super(n, a);
		this.setAccountNumber(this.getAccountNumber() + "-10");
//		super.setAccountNumber(n + "-10");
//		super.setBalance(a);
	}
	
	/**
	 * Uses super method to check if account has enough money to withdraw amount passed
	 * @param amount : Amount user is trying to withdraw
	 */
	@Override
	public boolean withdraw(double amount) {
		double total = amount + FEE;
		return super.withdraw(total);
	}
}
