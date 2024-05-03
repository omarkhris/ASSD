package edu.mum.cs.cs525.labs.skeleton;

public interface AccountSubject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
