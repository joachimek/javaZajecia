package creatures;

import com.company.Person;

public class Pet extends Animal {
  public String name;

  public Pet(Long id, String name, String species) {
    super(id, species);
    this.name = name;
  }

  public void sell(Person seller, Person buyer, Double price) {
    //error handling
    if(seller.getPet().getId() != this.getId()) {
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
}
