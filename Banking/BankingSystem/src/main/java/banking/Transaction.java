package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction extends Bank implements TransactionInterface{
	//private final int attemptedPin;
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		this.bank=bank;
		this.accountNumber=accountNumber;
		if(!bank.authenticateUser(accountNumber,attemptedPin)){
			throw new Exception("Account validation failed.");
		}
	}

	public double getBalance() {
		 return bank.getBalance(accountNumber);
       // return -1;
	}

	public void credit(double amount) {
		
		bank.credit(accountNumber,amount);
		
	}

	public boolean debit(double amount) {
		
		return bank.debit(accountNumber,amount);
	}
}
