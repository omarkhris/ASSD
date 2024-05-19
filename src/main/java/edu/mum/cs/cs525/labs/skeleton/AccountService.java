package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.CommandInterface;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
<<<<<<< HEAD

    Account getAccountByName(String nameHolder);

    void redo( String accountNumber);

    void undo( String accountNumber);

    void setCommand(CommandInterface command);

//    void redoWithDrawl(String accountNumber);
//
//    void undoWithDrawl(String accountNumber);

}
=======
}
>>>>>>> de7fa1a (Factory Pattern SOl)
