package com.ddlab.rnd.builder;

public class TestBuilder {
  public static void main(String[] args) {
    Director director = new Director(new ConcreteBuilder());
    director.build();
    Product product = director.getProduct();
    System.out.println("Product :\n" + product);
  }
}
