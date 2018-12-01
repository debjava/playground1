package com.ddlab.rnd.observer1;

import java.util.ArrayList;
import java.util.List;

public class NewsBroadcast {
    private String news;
    private List<IChannel> channels = new ArrayList<>();

    public void addObserver(IChannel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(IChannel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (IChannel channel : this.channels) {
            channel.update(this.news);
        }
    }
}