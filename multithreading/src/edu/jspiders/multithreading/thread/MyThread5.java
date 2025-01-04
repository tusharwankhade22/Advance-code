package edu.jspiders.multithreading.thread;

import edu.jspiders.multithreading.resource.Resource;

public class MyThread5 extends Thread{
	
	private Resource resource;
	public MyThread5(Resource resource) {
		super();
		this.resource = resource;
	}
	@Override
	public void run() {
		synchronized (resource.object1) {
			System.out.println("Thread 1 has applied lock on resource1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (resource.object2) {
				System.out.println("Thread 1 has applied lock on resource2");
			}  
		}
	}
}
