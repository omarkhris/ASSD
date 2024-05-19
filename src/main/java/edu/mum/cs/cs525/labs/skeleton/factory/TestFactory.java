package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountService;

public class TestFactory extends AbstractFactory {
    String serviceType;

    public TestFactory(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public AccountService checkEnvironment(String serviceType) {
        if (serviceType.equalsIgnoreCase("test")) {
            accountService = new TestServiceImpl();
            return accountService;
        }else return null;
    }
}
