package device.car;

import com.company.Person;

public class Diesel extends Car{

  public Diesel (Long id, String brand, String model, Integer yearOfProduction, Double value, Person originalOwner) {
    super(id, brand, model, yearOfProduction, value, originalOwner);
  }

  public void refuel() {
    System.out.println("The car has been refueled.");
  }
}
