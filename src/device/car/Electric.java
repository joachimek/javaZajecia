package device.car;

import com.company.Person;

public class Electric extends Car {

  public Electric (Long id, String brand, String model, Integer yearOfProduction, Double value, Person originalOwner) {
    super(id, brand, model, yearOfProduction, value, originalOwner);
  }

  public void refuel() {
    System.out.println("You poured fuel into your electric car. Great job, mate.");
  }

  public void recharge() {
    System.out.println("The car has been recharged.");
  }
}
