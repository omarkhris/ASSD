package edu.mum.cs.cs525.labs.skeleton;

public class CheckingAcc extends Account{
    public CheckingAcc(String accountNumber) {
        super(accountNumber, new Checking());
    }
}
