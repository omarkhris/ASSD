package edu.mum.cs.cs525.labs.skeleton.command;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountEntry;

public class WithDrawCommand implements CommandInterface{

    Account account;

    public WithDrawCommand(Account account){
        this.account = account;
    }
    @Override
    public void executeCommand() {
        AccountEntry[] arr = account.getEntryList().toArray(new AccountEntry[0]);
        double amount;
        if(arr != null){
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i].getDescription().equals("withdraw")){
                    amount = Math.abs(arr[i].getAmount());
                    account.withdraw(amount);
                    System.out.println("last withdraw was duplicated!!!!");
                    return;
                }
            }
            System.out.println("No such withDrawl transaction to be removed");
        }
        else{
            System.out.println("No previous transactions recorded");
        }
    }

    @Override
    public void undoCommand() {

        AccountEntry[] arr = account.getEntryList().toArray(new AccountEntry[0]);
        double amount;

        if(arr != null){
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i].getDescription().equals("withdraw")){
                    amount = Math.abs(arr[i].getAmount());
                    account.deposit(amount);
                    System.out.println("Last withdraw was Disputed!!");
                    return;
                }
            }
        }
        else {
            System.out.println("No previous transactions recorded");
        }

    }
}
