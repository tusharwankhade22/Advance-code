package edu.jspiders.multithreading.thread;

public class MyThread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=10000;i++) {
			System.out.println(i);
		}
	}
}
