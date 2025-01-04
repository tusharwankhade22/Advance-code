package edu.jspiders.multithreading.resource;

public class Product {
	
	private int quantity;
	
	public Product(int quantity) {
		super();
		this.setQuantity(quantity);
	}

	synchronized public void consume(){
		
		if(quantity>0)
			this.quantity--;
		else {
			System.out.println("consumer is Waiting");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Consumer consumed a product");
	}
	
	synchronized public void produce() {
	
		this.quantity++;
		System.out.println("Producer produce a product");
		if(quantity==1)
			notify();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
