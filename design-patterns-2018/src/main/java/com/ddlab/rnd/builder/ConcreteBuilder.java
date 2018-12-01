package com.ddlab.rnd.builder;

public class ConcreteBuilder implements IBuilder {
  private Product product = new Product();

  @Override
  public void buildParts() {
    System.out.println("Building product ...");
    product.setName("Car");
    product.setType("Light");
  }

  @Override
  public Product getResult() {
    return product;
  }
}
