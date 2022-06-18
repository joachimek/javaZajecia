package device.car;

public class Diesel extends Car{

  public Diesel (Long id, String brand, String model, Integer yearOfProduction) {
    super(id, brand, model, yearOfProduction);
  }

  public void refuel() {
    System.out.println("The car has been refueled.");
  }
}
