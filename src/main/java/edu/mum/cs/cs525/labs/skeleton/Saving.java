package edu.mum.cs.cs525.labs.skeleton;

public class Saving implements AccountBehaviour {

//    If balance < 1000 then you get 1% interest
//    If balance > 1000 and balance < 5000 then you get 2% interest
//    If balance > 5000 then you get 4% interest


    @Override
    public double interestRate(double balance) {
        double interestRate = 0;
        if(balance < 1000){
            interestRate = balance + (balance * 0.01);
        }else if(balance > 1000 && balance < 5000){
            interestRate = balance + (balance * 0.02);
        }
        else interestRate = balance + (balance * 0.04);
        return interestRate;
    }
}
