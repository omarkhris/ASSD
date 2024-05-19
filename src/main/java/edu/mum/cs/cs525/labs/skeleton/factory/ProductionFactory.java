package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountService;
import edu.mum.cs.cs525.labs.skeleton.AccountServiceImpl;

public class ProductionFactory extends AbstractFactory {
    String serviceType;

    public ProductionFactory(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public AccountService checkEnvironment(String serviceType) {
        if (serviceType.equalsIgnoreCase("test")) {
            accountService = new TestServiceImpl();
        } else if (serviceType.equalsIgnoreCase("account")) {
            accountService = new AccountServiceImpl();
        } else if (serviceType.equalsIgnoreCase("customer")) {
            accountService = new CustomerServiceImpl();
        } else {
            accountService = null;
        }
        return accountService;
    }
}

