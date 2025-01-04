package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.thread.MyThread1;

public class ThreadMain {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		MyThread1 mythread1 = new MyThread1();
		Thread thread1 = new Thread(mythread1);
		thread1.start();
		
		MyThread1 mythread2 = new MyThread1();
		Thread thread2 = new Thread(mythread2);
		thread2.start();
		
		
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println(end-start-2000+"ms");
	
	}
}
