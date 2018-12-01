package com.ddlab.rnd.bridge1;

public class TestBridge1 {
  public static void main(String[] args) {
    AbstractShape triangleShape = new TringleShape(new ConcreteGreenColor());
    triangleShape.draw();
  }
}
