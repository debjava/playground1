package com.ddlab.thread.prodconsume;

import java.util.ArrayList;
import java.util.List;

public class MyContainer<E> {

    private List<E> list;
    private int maxSize = 1;

    public MyContainer() {
        list = new ArrayList<E>();
    }

    public synchronized void put(E item)  throws InterruptedException  {
        //check space is available or not.
        if (list.size() == maxSize) {
            this.wait();
        }
        //space is available, insert element and notify all waiting threads.
        list.add(item);
        this.notifyAll();
    }

    public synchronized E get()  throws InterruptedException{
        //waits element is available or not.
        if (list.size() == 0) {
            this.wait();
        }
        //element is available, remove element and notify all waiting threads.
        this.notifyAll();
        return list.remove(0);
    }

}
