package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.CommandInterface;
import edu.mum.cs.cs525.labs.skeleton.command.DepositCommand;

import java.util.Collection;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;


	private CommandInterface performCommand;
	

	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
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


//	@Override
//	public Account getAccountByName(String nameHolder) {
//
//		return null;
//	}
//
//	@Override
//	public void redo( String accountNumber) {
//			Optional<Account> account = Optional.ofNullable(accountDAO.loadAccount(accountNumber));
//			if(account.isPresent()) {
//				performCommand.executeCommand();
//			}
//			else System.out.println("No such account!!");
//	}
//
//	@Override
//	public void undo(String accountNumber) {
//
//		Optional<Account> account = Optional.ofNullable(accountDAO.loadAccount(accountNumber));
//		if(account.isPresent()){
//			performCommand.undoCommand();
//		}
//		else System.out.println("No such account!!");
//
//	}
//
//	@Override
//	public void setCommand(CommandInterface command){
//		this.performCommand = command;
//	}




}
