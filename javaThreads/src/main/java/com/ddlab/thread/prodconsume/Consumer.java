package com.ddlab.thread.prodconsume;

import java.util.concurrent.TimeUnit;

class Consumer extends Thread {

	private MyContainer<String> container;

	public Consumer(MyContainer<String> container) {
		this.container = container;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				String val = container.get();
				System.out.println("Consumer consumed --->" + val);
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}