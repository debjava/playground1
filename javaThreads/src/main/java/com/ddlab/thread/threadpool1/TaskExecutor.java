package com.ddlab.thread.threadpool1;

import java.util.concurrent.BlockingQueue;

public class TaskExecutor extends Thread {

	private BlockingQueue<Runnable> bq;

	private ThreadPool threadPool;

	public TaskExecutor(ThreadPool threadPool, BlockingQueue<Runnable> bq) {
		this.threadPool = threadPool;
		this.bq = bq;
	}

	@Override
	public void run() {

		try {
			while (true) {
				System.out.println(Thread.currentThread().getName() + " is READY to execute task.");
				Runnable runnable = bq.take();
				runnable.run();
				System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");

				if (bq.size() == 0 && threadPool.isShutDownStatus()) {
					this.interrupt();
					Thread.sleep(1);
				}
			}
		} catch (InterruptedException ie) {
			System.out.println(Thread.currentThread().getName() + " has been STOPPED.");
		}

	}

}
