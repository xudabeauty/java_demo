package com.my.spring.chapter05;

public class CarFactory {
    public Car createCar() {
        Car car = new Car();
        car.setBrand("宝马");
        return car;
    }
}
