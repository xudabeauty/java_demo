package com.my.create_pattern.abstract_factory.example2;

public class MalFactory implements HumanFactory {

    public Human productBlack() {
        return new MalBlackHuman();
    }

    public Human productWhite() {
        return new MalWhiteHuman();
    }

    public Human productYellow() {
        return new MalYellowHuman();
    }

}
