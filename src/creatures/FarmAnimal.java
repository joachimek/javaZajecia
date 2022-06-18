package creatures;

import com.company.Person;

public class FarmAnimal extends Animal {

  public FarmAnimal(Long id, String species) {
    super(id, species);
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(!seller.getFarmAnimalList().contains(this)) {
      System.out.println("The car does not belong to the 'seller'.");
      return;
    }
    if(buyer.cash < price) {
      System.out.println("The buyer doesn't have enough cash.");
      return;
    }

    buyer.cash += price;
    seller.cash -= price;
    buyer.removeFarmAnimal(this);
    seller.addFarmAnimal(this);

    System.out.println(String.format("%s has been sold by %s to %s", this.toString(), seller.toString(), price.toString()));
  }
}
