package creatures;

import com.company.Person;
import com.company.Sellable;

public abstract class Animal implements Sellable, Feedable {
  private final Long id;
  final private String species;
  private Double weight;
  private boolean isAlive;

  public Animal (Long id, String species) {
    this.id = id;
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

  public Long getId () {
    return this.id;
  }

  public Animal(Long id, String species, Double weight) {
    this.id = id;
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

  public void feed (Double weight) {
    if(this.isAlive)
      this.weight += weight;
    else
      System.out.println("look how they massacred my boy");
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

  public String toString () {
    return this.species;
  }
}
