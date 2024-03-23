package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank{
	private LinkedHashMap<Long, Account> accounts;
	static long i=1000000;
	//CommercialAccount commercialAccount;
	//Transaction transaction;


	public Bank() {
		accounts=new LinkedHashMap<>();
	}

	private Long getAccount(Long accountNumber) {
	
		return accountNumber;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long accountNumber=generateUniqueAccountNumber();
		CommercialAccount commercialAccount = new CommercialAccount(company,accountNumber,pin,startingDeposit);
		accounts.put(accountNumber,commercialAccount);
		return  accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accountNumber=generateUniqueAccountNumber();
		ConsumerAccount consumerAccount=new ConsumerAccount(person,accountNumber,pin,startingDeposit);
		accounts.put(accountNumber,consumerAccount);
        return accountNumber;
	}

	private Long generateUniqueAccountNumber() {
		return i++;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		
		Account account = accounts.get(accountNumber);
        return account.validatePin(pin) && account!=null && account.getAccountNumber().equals(accountNumber);
	}

	public double getBalance(Long accountNumber) {
	
		Account account = accounts.get(accountNumber);
		return account.getBalance();

	}

	public void credit(Long accountNumber, double amount) {
		
		Account account = accounts.get(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		
		Account account = accounts.get(accountNumber);
		if(account.getBalance()>0 && account.getBalance()>=amount) {
			return account.debitAccount(amount);
		}
        return false;
	}
}
