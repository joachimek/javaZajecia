package device.car;

import com.company.Person;
import device.Device;

public abstract class Car extends Device {

  public Car (Long id, String brand, String model, Integer yearOfProduction) {
    super(id, brand, model, yearOfProduction);
  }

  public void turnOn() {
    System.out.println("The car has been turned on.");
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(seller.getCar().id != this.id) {
      System.out.println("The car does not belong to the 'seller'.");
      return;
    }
    if(buyer.cash < price) {
      System.out.println("The buyer doesn't have enough cash.");
      return;
    }

    buyer.cash += price;
    seller.cash -= price;
    buyer.setCar(null);
    seller.setCar(this);

    System.out.println(String.format("%s has been sold by %s to %s", this.toString(), seller.toString(), price.toString()));
  }

  abstract void refuel();

  public int compareTo(Car car)
  {
    if (this.yearOfProduction != car.yearOfProduction) {
      return this.yearOfProduction - car.yearOfProduction;
    }
    return this.brand.compareTo(car.brand);
  }
}
