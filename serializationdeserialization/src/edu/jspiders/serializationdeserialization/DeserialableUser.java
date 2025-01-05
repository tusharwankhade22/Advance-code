package edu.jspiders.serializationdeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialableUser {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file=new File("D:\\advance-java\\files\\user.txt");
		FileInputStream fileInputStream =new FileInputStream(file); 
		ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream); 
		User user=(User)objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
//		user.setMobile(8080475319l);
		System.out.println(user);
	}
}
