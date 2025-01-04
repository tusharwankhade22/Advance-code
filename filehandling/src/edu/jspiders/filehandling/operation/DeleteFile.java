package edu.jspiders.filehandling.operation;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		File file = new File("D:\\advance-java\\files\\demo.txt");
		boolean fileIsDeleted = file.delete();
		 
		if(fileIsDeleted)
			System.out.println("File is Deleted");
		else
			System.out.println("something went wrong");
	}
	
}
