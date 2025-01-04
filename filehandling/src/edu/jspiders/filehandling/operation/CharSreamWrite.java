package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharSreamWrite {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\advance-java\\files\\demo.txt");
		if(file.exists()) {
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("Hello World!!");
			fileWriter.close();
			System.out.println("Data is written to a file");
		}
		else {
			file.createNewFile();
			System.out.println("file is created");
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("Hello World!!");
			fileWriter.close();
			System.out.println("Data is written to a file");
		}
			
	}
}
