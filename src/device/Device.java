package device;

import com.company.Sellable;

public abstract class Device implements Sellable {
  public final Long id;
  public final String brand;
  public final String model;
  public final Integer yearOfProduction;

  protected Device(Long id, String brand, String model, Integer yearOfProduction) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.yearOfProduction = yearOfProduction;
  }

  public abstract void turnOn ();

  public String toString () {
    return String.format("%s %s", this.brand, this.model);
  }
}
