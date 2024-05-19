package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.factory.AbstractFactory;
import edu.mum.cs.cs525.labs.skeleton.factory.Factory;
import edu.mum.cs.cs525.labs.skeleton.factory.ProductionFactory;
import edu.mum.cs.cs525.labs.skeleton.factory.TestFactory;

public class Application {
	public static void main(String[] args) {
//		AccountService accountService = new AccountServiceImpl();
//
//		// create 2 accounts;
//		accountService.createAccount("1263862", "Frank Brown",	"checking");
//
//		accountService.createAccount("4253892", "John Doe", "saving");
//
//		// use account 1;
//		accountService.deposit("1263862", 240);
//		accountService.deposit("1263862", 529);
//		accountService.withdraw("1263862", 230);
//		// use account 2;
//		accountService.deposit("4253892", 12450);
//		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
//		// show balances
//
////		for (Account account : accountService.getAllAccounts()) {
////			double amount = accountService.getAccount(account.getAccountNumber()).accountBehaviour.interestRate(accountService.getAccount(account.getAccountNumber()).getBalance());
//////			accountService.withdraw(account.getAccountNumber(), amount);
////		}
//
//		for (Account account : accountService.getAllAccounts()) {
//			Customer customer = account.getCustomer();
//			System.out.println("Statement for Account: " + account.getAccountNumber());
//			System.out.println("Account Holder: " + customer.getName());
//
//			System.out.println("-Date-------------------------"
//					+ "-Description------------------"
//					+ "-Amount-------------");
//
//			for (AccountEntry entry : account.getEntryList()) {
//				System.out.printf("%30s%30s%20.2f\n",
//						entry.getDate().toString(),
//						entry.getDescription(),
//						entry.getAmount());
//			}
//
//			System.out.println("----------------------------------------" + "----------------------------------------");
//			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
//		}
//
//		//perform and apply the interest rate
////		accountService.getAccount("4253892");
//		System.out.println(accountService.getAccount("4253892").accountBehaviour.interestRate(accountService.getAccount("4253892").getBalance()));
//		accountService.withdraw("4253892", accountService.getAccount("4253892").getBalance() - accountService.getAccount("4253892").accountBehaviour.interestRate(accountService.getAccount("4253892").getBalance()));
//		System.out.println(accountService.getAccount("4253892").getBalance());
//		accountService.withdraw("1263862", accountService.getAccount("1263862").getBalance() - accountService.getAccount("1263862").accountBehaviour.interestRate(accountService.getAccount("1263862").getBalance()));
//		System.out.println(accountService.getAccount("1263862").getBalance());
//
//		FirstPromotion firstPromotion = new FirstPromotion(accountService.getAccount("1263862"));
//		accountService.withdraw("1263862", accountService.getAccount("1263862").getBalance() - firstPromotion.calFirstPromotion());
//		System.out.println(accountService.getAccount("1263862").getBalance());
//
//		SecondPromotion secondPromotion = new SecondPromotion(accountService.getAccount("1263862"));
//		accountService.withdraw("1263862", accountService.getAccount("1263862").getBalance() - secondPromotion.calSecondPromotion());
//		System.out.println(accountService.getAccount("1263862").getBalance());
//
//		ThirdPromotion thirdPromotion = new ThirdPromotion(accountService.getAccount("1263862"));
//		accountService.withdraw("1263862", accountService.getAccount("1263862").getBalance() - thirdPromotion.calThirdPromotion());
//		System.out.println(accountService.getAccount("1263862").getBalance());
//


	AccountService accountService = new AccountServiceImpl();
	AbstractFactory factory = new ProductionFactory("customer");

		AccountService accountService1 = factory.checkEnvironment("account");
		if (accountService != null) {
			// Now create the account
			factory.createAccount("12345", "John Doe");
		} else {
			System.out.println("Failed to initialize account service.");
		}
		factory.createAccount("1263862", "Frank Brown");

	// create 2 accounts;
        accountService.createAccount("1263862", "Frank Brown");
        accountService.createAccount("4253892", "John Doe");
	// use account 1;
        accountService.deposit("1263862", 240);
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
	// use account 2;
        accountService.deposit("4253892", 12450);
        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
	// show balances

        for (Account account : accountService.getAllAccounts()) {
		Customer customer = account.getCustomer();
		System.out.println("Statement for Account: " + account.getAccountNumber());
		System.out.println("Account Holder: " + customer.getName());

		System.out.println("-Date-------------------------"
				+ "-Description------------------"
				+ "-Amount-------------");

		for (AccountEntry entry : account.getEntryList()) {
			System.out.printf("%30s%30s%20.2f\n",
					entry.getDate().toString(),
					entry.getDescription(),
					entry.getAmount());
		}

		System.out.println("----------------------------------------" + "----------------------------------------");
		System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
	}



}}
