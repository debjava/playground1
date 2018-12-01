package com.ddlab.thread.prodconsume;

import java.util.concurrent.TimeUnit;

class Producer extends Thread {
	
    private MyContainer<String> container;
    
    public Producer(MyContainer<String> container) {
        this.container = container;
    }

    @Override
    public void run() {
        for( int i = 0 ; i < 10 ; i++ )
            try {
            	container.put("S-"+i);
            	System.out.println("Producer produced --->"+"S-"+i);
            	TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}