package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	private List<Observer> observers;



	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
		observers = new ArrayList<>();
	}

	public Account createAccount(String accountNumber, String customerName, String accountType) {
		Account account;
		if ("checking".equalsIgnoreCase(accountType)) {
			account = new CheckingAcc(accountNumber);
			account.setAccountBehaviour(new Checking());
		} else if ("saving".equalsIgnoreCase(accountType)) {
			account = new SavingAcc(accountNumber);
			account.setAccountBehaviour(new Saving());
		} else {
			throw new IllegalArgumentException("Invalid account type: " + accountType);
		}

		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	@Override
	public void registerObserver(Observer observer) {
		if(!observers.contains(observer))
			observers.add(observer);
		else
			System.out.println("Observer already registered!");
	}

	@Override
	public void removeObserver(Observer observer) {
		if(observers.contains(observer))
			observers.remove(observer);
		else System.out.println("Observer does not exist!");
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers){
			o.update(this);
		}
	}


}
