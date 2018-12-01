package com.ddlab.rnd.observer1;

public class TestObserver1 {
  public static void main(String[] args) {
    NewsBroadcast observable = new NewsBroadcast(); // <--- Observable
    AajTakChannel observer = new AajTakChannel(); // <--- Observer
    observable.addObserver(observer);
    observable.setNews("news");
    System.out.println("News : " + observer.getNews());
  }
}
