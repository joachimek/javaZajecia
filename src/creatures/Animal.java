package creatures;

import com.company.Person;
import com.company.Sellable;

public class Animal implements Sellable {
  private final Long id;
  public String name;
  final private String species;
  private Double weight;
  private boolean isAlive;

  public Animal (Long id, String name, String species) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.isAlive = true;

    switch(species) {
      case "Dog":
        this.weight = 5.00;
        break;
      case "Cat":
        this.weight = 3.00;
        break;
      default:
        this.weight = 4.00;
        break;
    }
  }

  public Animal(Long id, String name, String species, Double weight) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.weight = weight;
    this.isAlive = true;
  }

  public void feed () {
    if(this.isAlive)
      this.weight += 1.00;
    else
      System.out.println("rip in spaghetti, never forgetti");
  }

  public void takeForWalk () {
    if(this.isAlive) {
      this.weight -= 1.00;

      if (this.weight <= 0) {
        this.isAlive = false;
      }
    }
    else
      System.out.println("your pet is dead");
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(seller.getPet().id != this.id) {
      System.out.println("The car does not belong to the 'seller'.");
      return;
    }
    if(buyer.cash < price) {
      System.out.println("The buyer doesn't have enough cash.");
      return;
    }

    buyer.cash += price;
    seller.cash -= price;
    buyer.setPet(null);
    seller.setPet(this);

    System.out.println(String.format("%s has been sold by %s to %s", this.toString(), seller.toString(), price.toString()));
  }

  public String toString () {
    return this.name;
  }
}
