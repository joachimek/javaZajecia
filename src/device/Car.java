package device;

public class Car extends Device {
  public Double value;

  public Car (String brand, String model, Integer yearOfProduction) {
    super(brand, model, yearOfProduction);
  }

  public void turnOn() {
    System.out.println("The car has been turned on.");
  }
}
