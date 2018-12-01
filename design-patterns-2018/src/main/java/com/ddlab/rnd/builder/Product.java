package com.ddlab.rnd.builder;

public class Product {
  private String name;
  private String type;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Product{" + "name='" + name + '\'' + ", type='" + type + '\'' + '}';
  }
}
