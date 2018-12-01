package com.ddlab.rnd.bridge1;
/** Refined Abstraction */
public class TringleShape extends AbstractShape {

  public TringleShape(IColor color) {
    super(color);
  }

  @Override
  public void draw() {
    System.out.println("Drawing a Triangle ...");
    color.applyColor();
  }
}
