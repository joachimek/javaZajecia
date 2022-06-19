package com.company;

import java.util.Date;

public class Transaction {
  private final Person buyer;
  private final Person seller;
  private final Double price;
  private final Date date;

  public Transaction(Person buyer, Person seller, Double price) {
    this.buyer = buyer;
    this.seller = seller;
    this.price = price;
    this.date = new Date();
  }

  public Person getBuyer() {
    return this.buyer;
  }
}
