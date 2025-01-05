package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteTreamWrite {
	public static void main(String[] args) throws IOException {
		
		byte[] password= {'A','k','a','s','h','@','2','4'};
		File file=new File("D:\\advance-java\\files\\demo.txt");
		if(file.exists()) {
			FileOutputStream fileoutstream=new FileOutputStream(file);
			fileoutstream.write(password);
			fileoutstream.close();
			System.out.println("Data is written to a file.");
		}
		else {
			file.createNewFile();
			System.out.println("File is created");
			FileOutputStream fileoutstream=new FileOutputStream(file);
			fileoutstream.write(password);
			fileoutstream.close();
			System.out.println("Data is written to a file.");
		}
	}
}
