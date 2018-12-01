package com.ddlab.rnd.builder;

public class Director {
  private IBuilder builder;

  public Director(IBuilder builder) {
    this.builder = builder;
  }

  public void build() {
    builder.buildParts();
  }

  public Product getProduct() {
    return builder.getResult();
  }
}
