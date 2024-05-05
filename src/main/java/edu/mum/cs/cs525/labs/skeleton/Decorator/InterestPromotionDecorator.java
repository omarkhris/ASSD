package edu.mum.cs.cs525.labs.skeleton.Decorator;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountBehaviour;

public abstract class InterestPromotionDecorator extends Account {
    Account account;
    public InterestPromotionDecorator(Account accountNumber) {
        super(accountNumber.getAccountNumber());
        this.account = accountNumber;
    }
}
