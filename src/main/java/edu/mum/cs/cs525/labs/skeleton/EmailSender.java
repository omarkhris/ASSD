package edu.mum.cs.cs525.labs.skeleton;

public class EmailSender implements Observer{
    @Override
    public void update(AccountSubject subject) {
        emailSender("Omar");
    }

    public void emailSender(String customer){
        System.out.println("Email Has been sent. to this customer : " + customer);
    }
}
