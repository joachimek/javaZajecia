package com.company;

import device.Phone;
import device.car.Car;
import device.car.Diesel;

public class Main {

    public static void main(String[] args) {
        Person tadeusz = new Person(1L, "tadeusz", "kowalski");
        Person janusz = new Person(2L, "janusz", "nowak", 4);

        janusz.addCar(new Diesel(1L, "volkswagen", "golf", 2005, 1500.0, janusz));
        janusz.addCar(new Diesel(1L, "volkswagen", "polo", 2003, 1500.0, janusz));
        janusz.addCar(new Diesel(1L, "fiat", "panda", 2010, 1500.0, janusz));
        janusz.addCar(new Diesel(1L, "volkswagen", "golf", 2009, 1500.0, janusz));
        janusz.addCar(new Diesel(1L, "honda", "civic", 2007, 1500.0, janusz));

        janusz.sortCars();

        for(Car car : janusz.getCars()) {
            System.out.println(car.toString());
        }

        janusz.getCar(1).sell(janusz, tadeusz, 3000.0);

        tadeusz.cash = 5000.0;
        janusz.getCar(1).sell(janusz, tadeusz, 3000.0);
        System.out.println(tadeusz.cash);

        tadeusz.setPhone(new Phone(1L, "xiaomi", "redmi 3", 2017));
        tadeusz.getPhone().installApp("angry birds");
        tadeusz.getPhone().installApp(tadeusz, new App("minecraft", "1.0", 5.00));

        if(tadeusz.getPhone().isAppInstalled("minecraft")) {
            System.out.println("hey tadek, wanna play minecraft?");
        }
        System.out.println(tadeusz.cash);
    }
}
