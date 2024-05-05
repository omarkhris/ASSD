package edu.mum.cs.cs525.labs.skeleton;

public class Checking implements AccountBehaviour{

//    If balance < 1000 then you get 1,5% interest
//    If balance > 1000 then you get 2,5% interest

    @Override
    public double interestRate(double balance) {
        double interestRate = 0;
        if(balance < 1000){
            interestRate = (balance * 0.015);
            balance -= interestRate;
        }
        else {
            interestRate = (balance * 0.025);
            balance -= interestRate;
        }
        return balance;
    }
}
