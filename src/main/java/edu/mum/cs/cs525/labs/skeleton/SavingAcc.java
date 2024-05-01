package edu.mum.cs.cs525.labs.skeleton;

public class SavingAcc extends Account{

    public SavingAcc(String accountNumber) {
        super(accountNumber, new Saving());
    }
}
