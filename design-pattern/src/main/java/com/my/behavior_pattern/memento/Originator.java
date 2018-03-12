package com.my.behavior_pattern.memento;

public class Originator {
    
    private String state ="";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public IMemento createMemento() {
        return new Memento(this.state);
    }
    public void restore(IMemento _mIMemento) {
       this.setState(((Memento) _mIMemento).getState());    
    }
    
    private class Memento implements IMemento{
        private String state="";
        public Memento(String _state) {
            this.state=_state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
        
              
    }
    

}
