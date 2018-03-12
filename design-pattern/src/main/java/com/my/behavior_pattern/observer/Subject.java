package com.my.behavior_pattern.observer;

import java.util.Vector;

public abstract class Subject {
    
    private Vector<Observer> observers=new Vector<Observer>();

   public void addObserver(Observer observer) {
       this.observers.add(observer);
   }
   public  void delObserver() {
       this.observers.remove(observers);
   }
   public  void notifyObserver() {
       for(Observer o:observers) {
           o.update();
       }
   }
}
