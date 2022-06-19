package com.company;

public class App {
  public String name;
  public String version;
  public Double price;

  public App(String name) {
    this.name = name;
    this.version = "1.0";
    this.price = 0.0;
  }

  public App(String name, String version, Double price) {
    this.name = name;
    this.version = version;
    this.price = price;
  }
}
