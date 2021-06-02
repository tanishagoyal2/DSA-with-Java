package files;

import java.io.*;

public class Files {

	
	public static void main(String []args) {
		try {
			FileWriter file=new FileWriter("C:\\Users\\HP\\Documents\\Downloads\\filename.txt");
			file.write("hello first character");
			file.close();
			System.out.println("successfully wrorte to the file");
		}catch(IOException e) {
			System.out.println("oops some error occured");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
