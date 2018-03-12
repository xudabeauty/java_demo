package com.my.create_pattern.abstract_factory.example2;

public class FemalFactory implements HumanFactory {

    public Human productBlack() {
        return new FemalBlackHuman();
    }

    public Human productWhite() {
        return new FemalWhiteHuman();
    }

    public Human productYellow() {
        return new FemalYellowHuman();
    }
}
