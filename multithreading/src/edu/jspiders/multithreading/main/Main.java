package edu.jspiders.multithreading.main;

public class Main {
	
	//alt+shift+s ==create the fields
	//ctrl+space == suggestion
	//ctrl+N == new file
	//ctrl+1 == assign locsl variable
	//ctrl+shift+t ==to check inbuilt class
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Task task1 = new Task();
		task1.run();
		
		Task task2 = new Task();
		task2.run();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start+"ms");
	}

	
}
