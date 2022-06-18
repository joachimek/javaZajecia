package device;

public abstract class Device {
  public final String brand;
  public final String model;
  public final Integer yearOfProduction;

  protected Device(String brand, String model, Integer yearOfProduction) {
    this.brand = brand;
    this.model = model;
    this.yearOfProduction = yearOfProduction;
  }

  public abstract void turnOn ();

  public String toString () {
    return String.format("%s %s", this.brand, this.model);
  }
}
