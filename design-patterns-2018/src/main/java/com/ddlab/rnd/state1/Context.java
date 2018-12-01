package com.ddlab.rnd.state1;

public class Context {

  private IMobileState state;

  public IMobileState getState() {
    return state;
  }

  public void setState(IMobileState state) {
    this.state = state;
  }

  public void request() {
    state.display(this);
  }
}
