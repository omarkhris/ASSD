package edu.mum.cs.cs525.labs.skeleton;

public class SMSSender implements Observer {

    @Override
    public void update(AccountSubject subject) {
        smsSender("Omar");
    }

    public void smsSender(String customerName){
        System.out.println("SMS Sender Observer is triggered/ sending SMS to : " + customerName);
    }
}
