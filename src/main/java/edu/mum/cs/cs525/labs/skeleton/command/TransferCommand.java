package edu.mum.cs.cs525.labs.skeleton.command;

import edu.mum.cs.cs525.labs.skeleton.*;

public class TransferCommand implements CommandInterface{

    Account account;

    AccountService accountService;

    public TransferCommand(Account account){
        this.account = account;
        accountService = new AccountServiceImpl();
    }
    @Override
    public void executeCommand() {
        AccountEntry [] arr = account.getEntryList().toArray(new AccountEntry[0]);
        if(arr[0] != null){
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i].getDescription().equals("Transaction")){
                    Account account1 = accountService.getAccount(arr[i].getFromAccountNumber());
//                    System.out.println(account1);
                    System.out.println(arr[i]);
//                    System.out.println(account1.getBalance());
                    Account account2 = this.account;
                    System.out.println(account2 + "    " + account2+ " get"+ account2.getBalance() + account2.getAccountNumber() );

                    String a = account2.getAccountNumber();
                    if(arr[i].getAmount() > 0){
                        account.deposit(Math.abs(arr[i].getAmount()));
                    }
                    else{
                        account.withdraw(arr[i].getAmount());
                    }
//                    AccountDAO accountDAO = new AccountDAOImpl();
////                    System.out.println(accountDAO.loadAccount("4253892"));
//                    if(arr[i].getAmount() < 0){
//                        System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
//                        account.deposit(Math.abs(arr[i].getAmount()));
////                        accountService.getAccount(arr[i].getFromAccountNumber()).withdraw(Math.abs(arr[i].getAmount()));
//                    }
//                    accountService.transferFunds("4253892","4253892",arr[i].getAmount(),"Transaction");
////                    System.out.println(this.account);

                }
            }
            System.out.println("No such transaction");
        }
    }

    @Override
    public void undoCommand() {
        AccountEntry [] arr = account.getEntryList().toArray(new AccountEntry[0]);
        if(arr[0] != null){
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i].getDescription().equals("Transaction")){
                    if(arr[i].getAmount() > 0){
                        account.withdraw(arr[i].getAmount());
                    }
                    else{
                        account.deposit(Math.abs(arr[i].getAmount()));
                    }
                }
            }
            System.out.println("No such transaction");
        }
    }
}
