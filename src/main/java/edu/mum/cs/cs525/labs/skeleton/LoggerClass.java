package edu.mum.cs.cs525.labs.skeleton;

public class LoggerClass implements Observer{
    @Override
    public void update(AccountSubject subject) {
//        Account account = (Account) subject;
//        loggerMethod(account.getAccountNumber());
        loggerMethod("160122322111");
    }

    public void loggerMethod(String accNumber){
        System.out.println("Logger observer is triggered..." + accNumber);
    }
}
