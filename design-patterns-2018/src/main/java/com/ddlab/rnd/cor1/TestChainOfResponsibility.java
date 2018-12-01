package com.ddlab.rnd.cor1;

public class TestChainOfResponsibility {

  private static AuthenticationProcessor getChainOfAuthProcessor() {
    AuthenticationProcessor oAuthProcessor = new OAuthAuthenticationProcessor(null);
    AuthenticationProcessor unamePasswordProcessor =
        new UsernamePasswordAuthenticationProcessor(oAuthProcessor);
    return unamePasswordProcessor;
  }

  public static void main(String[] args) {
    AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
    boolean isAuthorized = authProcessorChain.isAuthorized(new OAuthTokenProvider());
    System.out.println("isAuthorized : "+isAuthorized);
  }
}
