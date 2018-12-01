package com.ddlab.rnd.cor1;

public abstract class AuthenticationProcessor {

  // next element in chain or responsibility
  protected AuthenticationProcessor nextProcessor;

  public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
    this.nextProcessor = nextProcessor;
  }

  public abstract boolean isAuthorized(AuthenticationProvider authProvider);
}
