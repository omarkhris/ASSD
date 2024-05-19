package edu.mum.cs.cs525.labs.skeleton.Decorator;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountBehaviour;

public class SecondPromotion extends InterestPromotionDecorator{
    public SecondPromotion(Account accountNumber) {
        super(accountNumber);
    }


    public double calSecondPromotion(){
        double accBalance = account.getBalance();
        double newInterest = accBalance * 0.02;
        accBalance -= newInterest;
        return accBalance;
    }
}
