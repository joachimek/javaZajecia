package device;

public class Phone extends Device {

  public Phone (String brand, String model, Integer yearOfProduction) {
    super(brand, model, yearOfProduction);
  }

  public void turnOn() {
    System.out.println("The phone has been turned on.");
  }
}
