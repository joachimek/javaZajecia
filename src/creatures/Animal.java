package creatures;

import java.io.Console;

public class Animal {
  public String name;
  final private String species;
  private Double weight;
  private boolean isAlive;

  public Animal (String name, String species) {
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

  public Animal (String name, String species, Double weight) {
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
}
