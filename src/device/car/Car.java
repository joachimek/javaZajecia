package device.car;

import com.company.Person;
import com.company.Transaction;
import device.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Car extends Device {

  private List<Transaction> transactionHistory;

  public Car (Long id, String brand, String model, Integer yearOfProduction, Double value, Person originalOwner) {
    super(id, brand, model, yearOfProduction);
    this.value = value;
    this.transactionHistory = new ArrayList<>();
    transactionHistory.add(new Transaction(originalOwner, null, value));
  }

  public void turnOn() {
    System.out.println("The car has been turned on.");
  }

  protected void addTransaction(Transaction transaction) {
    transactionHistory.add(transaction);
  }

  protected Transaction getLastTransaction() {
    return transactionHistory.get(transactionHistory.toArray().length - 1);
  }

  protected Boolean isOwner(Person person) {
    return getLastTransaction().getBuyer().getId().equals(person.getId());
  }

  public Boolean didSell(Person seller, Person buyer) {
    return transactionHistory.stream().anyMatch(t -> t.getSeller().getId().equals(seller.getId()));
  }

  public Integer countTransactions() {
    return transactionHistory.size();
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(!seller.hasCar(this) || !this.isOwner(seller)) {
      System.out.println("The car does not belong to the 'seller'.");
      return;
    }
    if(!buyer.hasGarageSpace()) {
      System.out.println("The buyer has no space for the car in his garage.");
      return;
    }
    if(buyer.cash < price) {
      System.out.println("The buyer doesn't have enough cash.");
      return;
    }

    buyer.cash -= price;
    seller.cash += price;
    buyer.removeCar(this);
    seller.addCar(this);
    addTransaction(new Transaction(buyer, seller, price));

    System.out.println(String.format("%s has been sold by %s to %s for %s", this.toString(), seller.toString(), buyer.toString(), price.toString()));
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
