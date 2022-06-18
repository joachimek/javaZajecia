package device;

import com.company.Person;

public class Phone extends Device {

  public Phone (Long id, String brand, String model, Integer yearOfProduction) {
    super(id, brand, model, yearOfProduction);
  }

  public void turnOn() {
    System.out.println("The phone has been turned on.");
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(seller.getPhone().id != this.id) {
      System.out.println("The phone does not belong to the 'seller'.");
      return;
    }
    if(buyer.cash < price) {
      System.out.println("The buyer doesn't have enough cash.");
      return;
    }

    buyer.cash += price;
    seller.cash -= price;
    buyer.setPhone(null);
    seller.setPhone(this);

    System.out.println(String.format("%s has been sold by %s to %s", this.toString(), seller.toString(), price.toString()));
  }
}
