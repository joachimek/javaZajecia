package device;

import com.company.App;
import com.company.Person;

import java.net.URL;
import java.util.List;

public class Phone extends Device {
  private List<App> apps;
  private static final String defaultAppServerAddress = "store.google.com";
  private static final String defaultAppServerProtocol = "https";
  private static final String defaultVersionString = "1.0";

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

  public void installApp(String name) {
    System.out.println(String.format("Installed %s", name));
    this.apps.add(new App(name));
  }

  public void installApp(String name, String version) {
    System.out.println(String.format("Installed %s (version %s)", name, version));
    this.apps.add(new App(name));
  }

  public void installApp(String name, String version, String address) {
    System.out.println(String.format("Installed %s (version %s) from %s", name, version, address));
    this.apps.add(new App(name));
  }

  public void installApp(List<String> names) {
    for (String name:names) {
      System.out.println(String.format("Installed %s", name));
      this.apps.add(new App(name));
    }
  }

  public void installApp(URL link) {
    System.out.println(String.format("Installed %s from %s", link.getFile(), link.getHost()));
    this.apps.add(new App(link.getFile()));
  }
}
