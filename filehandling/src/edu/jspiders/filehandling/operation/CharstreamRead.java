package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharstreamRead {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\advance-java\\files\\demo.txt");
		String data="";
		if(file.exists()) {
			FileReader filereader=new FileReader(file);
			int ascii=-1;
			while((ascii=filereader.read()) != -1) {
				data+=(char)ascii;
			}
			filereader.close();
			System.out.println(data);
		}
		else {
			System.out.println("File does not exist!!");
		}
	}
}
