package com.company;

import creatures.FarmAnimal;
import creatures.Pet;
import device.car.Car;
import device.Phone;

import java.util.Arrays;
import java.util.List;

public class Person {
  private final Long id;
  public String name;
  public String surname;

  private Pet pet;
  private Car[] garage;
  private Phone phone;

  private List<FarmAnimal> farmAnimalList;

  private Double salary;
  public Double cash;

  public Person (Long id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.salary = 0.0;
    this.cash = 0.0;
    this.garage = new Car[1];
  }

  public Person(Long id, String name, String surname, Integer garageSize) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.salary = 0.0;
    this.cash = 0.0;
    this.garage = new Car[garageSize];
  }

  public Long getId() {
    return this.id;
  }

  public Pet getPet() {
    return this.pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Car getCar(Integer space) {
    return this.garage[space];
  }

  public Car[] getCars() {
    return this.garage;
  }

  protected void setCar(Car car, Integer space) {
    this.garage[space] = car;
  }

  public void addCar(Car car) {
    for(var i = 0; i < garage.length; i++) {
      if(garage[i] == null) {
        setCar(car, i);
        System.out.println(String.format("%s has been added to garage space %d.", car.toString(), i));
        return;
      }
    }
    System.out.println("The garage is full.");
  }

  public void removeCar(Car car) {
    for(var i = 0; i < garage.length; i++) {
      if(garage[i] != null && garage[i].id == car.id) {
        setCar(null, i);
        System.out.println(String.format("%s has been removed from garage space %d.", car.toString(), i));
        return;
      }
    }
    System.out.println("The car was not found.");
  }

  public Boolean hasGarageSpace() {
    for(Car car:garage) {
      if(car == null)
        return true;
    }
    return false;
  }

  public Boolean hasCar(Car car) {
    return Arrays.stream(garage).anyMatch(c -> c.id.equals(car.id));
  }

  public Integer getCarsNumber() {
    var count = 0;
    for (Car car:this.garage)
      if(car != null)
        count ++;
    return count;
  }

  public Double getCarsValue() {
    Double value = 0.0;
    for (Car car:this.garage)
      if(car != null)
        value += car.value;
    return value;
  }

  public void sortCars() {
    Arrays.sort(this.garage);
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
    this.farmAnimalList.removeIf(animal -> animal.getId().equals(farmAnimal.getId()));
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
