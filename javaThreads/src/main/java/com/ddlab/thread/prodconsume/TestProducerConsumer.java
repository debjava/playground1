package com.ddlab.thread.prodconsume;

public class TestProducerConsumer {

	public static void main(String[] args) {
		
		MyContainer<String> container = new MyContainer<String>();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);
        producer.start();
        consumer.start();
    }

}
