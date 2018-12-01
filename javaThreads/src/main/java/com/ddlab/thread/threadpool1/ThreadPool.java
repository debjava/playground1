package com.ddlab.thread.threadpool1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> bq;

	private boolean shutDownStatus = false;

	public ThreadPool(int noOfThreads) {

		bq = new LinkedBlockingQueue<>(noOfThreads);

		for (int i = 0; i < noOfThreads; i++) {
			TaskExecutor executor = new TaskExecutor(this, bq);
			executor.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			executor.start(); // start thread
		}
	}

	public synchronized void execute(Runnable task) throws Exception {
		System.out.println("task has been added.");
		bq.put(task);
	}

	public synchronized void shutdown() {
		shutDownStatus = true;
		System.out.println("ThreadPool SHUTDOWN initiated.");
	}

	public boolean isShutDownStatus() {
		return shutDownStatus;
	}

}
