package edu.jspiders.serializationdeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializeUser {
	public static void main(String[] args) throws IOException {
		
		User user=new User("Tushar","Tushar@22",8080475318l,"pune");
		
		File file=new File("D:\\advance-java\\files\\user.txt");
		FileOutputStream fileStream=new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.close();
		fileStream.close();
		System.out.println("User is Serialized");
	}
}
