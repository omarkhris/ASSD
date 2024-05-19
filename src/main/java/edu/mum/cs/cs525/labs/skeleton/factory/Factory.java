package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountService;

public interface Factory {
         AccountService createEnvironment(String serviceType);
}
