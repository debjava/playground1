package com.ddlab.rnd.bridge1;
/** Abstraction */
public abstract class AbstractShape {
  protected IColor color;

  public AbstractShape(IColor color) {
    this.color = color;
  }

  public abstract void draw();
}
