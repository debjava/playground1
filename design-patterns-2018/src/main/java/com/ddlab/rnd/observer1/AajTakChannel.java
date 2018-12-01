package com.ddlab.rnd.observer1;

public class AajTakChannel implements IChannel {

  private String news;

  @Override
  public void update(Object news) {
    this.setNews((String) news);
  }

  public String getNews() {
    return news;
  }

  public void setNews(String news) {
    this.news = news;
  }
}
