package edu.mum.cs.cs525.labs.skeleton.Decorator;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountBehaviour;

public class ThirdPromotion extends InterestPromotionDecorator{

    public ThirdPromotion(Account accountNumber){
        super(accountNumber);
    }


    public double calThirdPromotion(){
        double accBalance = account.getBalance();
        double newInterest = accBalance * 0.03;
        accBalance -= newInterest;
        return accBalance;
    }
}
