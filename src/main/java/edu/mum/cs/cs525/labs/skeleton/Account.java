package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account {
	private Customer customer;

	private String accountNumber;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	private void setAccountBalance(){

	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());

		entryList.add(fromEntry);

		toAccount.addEntry(toEntry);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

<<<<<<< HEAD

	public void setAccountBehaviour(AccountBehaviour accountBehaviour) {
		this.accountBehaviour = accountBehaviour;
	}

	public void performInterestRate() {
		if (accountBehaviour == null) {
			System.err.println("Error: accountBehaviour is null");
			return;
		}
		double balance = getBalance();
		double interest = accountBehaviour.interestRate(balance);
		System.out.println("Interest calculated: " + interest);
		// Add the interest to the account balance
		double interest_Deduction = balance - interest;
		withdraw(interest_Deduction);
	}


//	@Override
//	public String toString() {
//		return accountNumber;
//
//	}



=======
>>>>>>> de7fa1a (Factory Pattern SOl)
}
