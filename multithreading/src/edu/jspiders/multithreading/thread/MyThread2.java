package edu.jspiders.multithreading.thread;

public class MyThread2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<=10000;i++) {
			System.out.println(i);
		}
	}
}
