package edu.mum.cs.cs525.labs.skeleton.Decorator;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountBehaviour;

public class FirstPromotion extends InterestPromotionDecorator {


    public FirstPromotion(Account account) {
        super(account);
        this.account = account;
    }

    public double calFirstPromotion(){
        double accBalance = account.getBalance();
        double newInterest = accBalance * 0.01;
        accBalance -= newInterest;
        return accBalance;
    }


}
