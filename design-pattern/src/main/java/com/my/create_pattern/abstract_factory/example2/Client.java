package com.my.create_pattern.abstract_factory.example2;

public class Client {
    public static void main(String[] args) {
        HumanFactory femalFactory=new FemalFactory();
        HumanFactory malFactory=new MalFactory();
        Human femYellowHuman=femalFactory.productYellow();
        Human malBlackHuman=malFactory.productBlack();
        femYellowHuman.getColor();
        femYellowHuman.getTalk();
        femYellowHuman.getSex();
        
        System.out.println("----------------------------------");
        malBlackHuman.getColor();
        malBlackHuman.getTalk();
        malBlackHuman.getSex();
    }

}
