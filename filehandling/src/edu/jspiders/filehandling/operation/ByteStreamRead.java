package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\advance-java\\files\\demo.txt");
		String data="";
		if(file.exists()) {
			FileInputStream fileInputStream=new FileInputStream(file);
			int b=-1;
			while((b=fileInputStream.read())!=-1) {
				data+=(char)b;
			}
			System.out.println(data);
		}else {
			System.out.println("file does not exist!!");
		}
	}
}
