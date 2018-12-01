package com.ddlab.rnd.state1;

public class Test {
  public static void main(String[] args) {
    Context context = new Context();
    context.setState(new SilentState());
    context.request();
    context.setState(new VibrationState());
    context.request();
  }
}
