package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.resource.Product;
import edu.jspiders.multithreading.thread.Consumer;
import edu.jspiders.multithreading.thread.Producer;

public class ProductMain {
	public static void main(String[] args) {
		Product product=new Product(0);
		
		Consumer consumer1=new Consumer(product);
		consumer1.start();
		
		Producer producer1=new Producer(product);
		producer1.start();
		
	}
}
