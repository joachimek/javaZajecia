package com.company;

import creatures.FarmAnimal;
import creatures.Pet;
import device.car.Car;
import device.Phone;

import java.util.List;

public class Person {
  public String name;
  public String surname;

  private Pet pet;
  private Car car;
  private Phone phone;

  private List<FarmAnimal> farmAnimalList;

  private Double salary;
  public Double cash;

  public Person (String name, String surname) {
    this.name = name;
    this.surname = surname;
    this.salary = 0.0;
    this.cash = 0.0;
  }

  public Pet getPet() {
    return this.pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Car getCar() {
    return this.car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Phone getPhone() {
    return this.phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  public List<FarmAnimal> getFarmAnimalList() {
    return this.farmAnimalList;
  }

  public void setFarmAnimalList(List<FarmAnimal> farmAnimalList) {
    this.farmAnimalList = farmAnimalList;
  }

  public void addFarmAnimal(FarmAnimal farmAnimal) {
    this.farmAnimalList.add(farmAnimal);
  }

  public void removeFarmAnimal(FarmAnimal farmAnimal) {
    this.farmAnimalList.removeIf(animal -> animal.getId() == farmAnimal.getId());
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

  public String toString () {
    return String.format("%s %s", this.name, this.surname);
  }
}
