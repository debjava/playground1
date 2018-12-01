package com.ddlab.rnd.state1;

public class SilentState implements IMobileState {
  @Override
  public void display(Context context) {
    System.out.println("Silent...");
  }
}
