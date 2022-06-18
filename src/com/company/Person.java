package com.company;

import creatures.Animal;
import device.Car;

public class Person {
  public String name;
  public String surname;

  public Animal pet;
  private Car car;

  private Double salary;

  public Car getCar() {
    return this.car;
  }

  public void setCar(Car car) {
    if(car.value <= this.salary) {
      System.out.println("The car was bought with cash.");
      this.car = car;
    }
    else if(car.value <= 12*this.salary) {
      System.out.println("The car was bought with mortgage");
      this.car = car;
    }
    else {
      System.out.println("Soz, you're to poor.");
    }
  }

  public Double getSalary() {
    System.out.println(java.time.LocalDateTime.now());
    System.out.println(this.salary);
    return this.salary;
  }

  public void setSalary(Double salary) {
    if(salary > 0) {
      try {
        this.salary = salary;
        System.out.println("The new data has been sent to accountants' office.");
        System.out.println("Please collect the annex to the contract from HR department.");
        System.out.println("ZUS and US have been notified about the salary change.");
      }
      catch(Exception e) {
        System.out.println(e);
      }
    }
    else
      System.out.println("The salary value cannot be negative.");
  }
}
