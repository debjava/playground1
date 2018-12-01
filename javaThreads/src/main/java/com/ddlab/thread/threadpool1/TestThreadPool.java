package com.ddlab.thread.threadpool1;

public class TestThreadPool {

	public static void main(String[] args) throws Exception {
		
		ThreadPool threadPool=new ThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Runnable task=new MyThread();
            threadPool.execute(task);
        }
        threadPool.shutdown();
        System.out.println("All threads executed successfully ...");
	}

}
