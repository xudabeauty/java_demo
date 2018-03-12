package com.my.behavior_pattern.observer;

public class ConcreteSubject extends Subject {

  public void multiNotify() {
      super.notifyObserver();
  }
}
