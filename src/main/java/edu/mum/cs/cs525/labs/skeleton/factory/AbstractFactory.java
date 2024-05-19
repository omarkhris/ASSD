package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountService;

import java.util.Collection;

public abstract class AbstractFactory {
    AccountService accountService;
    public void perform(String serviceType){
        AccountService accountService = checkEnvironment(serviceType);

    }
    public Account createAccount(String accountNumber, String customerName){
        return accountService.createAccount(accountNumber,customerName);
    }
    public void deposit(String accountNumber, double amount){
        accountService.deposit(accountNumber,amount);
    }
    public Account getAccount(String accountNumber){
        return accountService.getAccount(accountNumber);
    }
    public Collection<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    public void withdraw(String accountNumber, double amount){
        accountService.withdraw(accountNumber,amount);
    }
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description){
        accountService.transferFunds(fromAccountNumber,toAccountNumber,amount,description);
    }

    public abstract AccountService checkEnvironment(String serviceType);

}
