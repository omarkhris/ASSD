package edu.mum.cs.cs525.labs.skeleton.command;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DepositCommand implements CommandInterface{

    Account account;




    public DepositCommand(Account account){
        this.account = account;
    }


    @Override
    public void executeCommand() {
        AccountEntry[] arr = account.getEntryList().toArray(new AccountEntry[0]);
        for(int i = arr.length - 1; i >= 0; i--){
            AccountEntry accountEntry = arr[i];
            if(accountEntry.getDescription().equals("deposit")){
                double amount = accountEntry.getAmount();
                account.deposit(amount);
                System.out.println("last deposit was duplicated !");
                return;
            }
        }

        System.out.println("there is no previous deposits to duplicate...");

    }

    @Override
    public void undoCommand() {
        AccountEntry[] arr = account.getEntryList().toArray(new AccountEntry[0]);

        for(int i = arr.length - 1; i >= 0; i--){
            AccountEntry accountEntry = arr[i];
            if(accountEntry.getDescription().equals("deposit")){
                double amount = accountEntry.getAmount();
                account.withdraw(amount);
                System.out.println("Last deposit was removed!");
                return;
            }
        }

        System.out.println("there is no previous deposits to remove...");

    }
}
