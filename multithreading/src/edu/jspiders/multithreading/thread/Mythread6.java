package edu.jspiders.multithreading.thread;

import edu.jspiders.multithreading.resource.Resource;

public class Mythread6 extends Thread{
	private Resource resource2;
	
	public Mythread6(Resource resource2) {
		super();
		this.resource2 = resource2;
	}

	@Override
	public void run() {
		synchronized (resource2.object2) {
			System.out.println("Thread 2 has applied lock on resource2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (resource2.object1) {
				System.out.println("Thread 2 has applied lock on resource1");
			}
		}
		
	}
}
