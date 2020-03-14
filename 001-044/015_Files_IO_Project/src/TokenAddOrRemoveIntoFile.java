

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TokenAddOrRemoveIntoFile {
	static String str="";


	public TokenAddOrRemoveIntoFile() {
		// TODO Auto-generated constructor stubW
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
			//Enter the input
	    	System.out.println("CASE-I Add the String into the file");
		    Scanner sc = new Scanner(System.in);
			System.out.println("Please enter input");
			String input = sc.nextLine();
		
			//Read the file
			FileReader freader=new FileReader(new java.io.File("").getAbsolutePath()+"\\src\\main\\resources\\abc.txt");
			BufferedReader bis1=new BufferedReader(freader);
			String str2="";
			while((str2=bis1.readLine()) != null){
				str=str+str2;
			}
			
			//Append the use input with current file data
			 if(input!=null){
				 str=str+","+input;
			 }
			
			//Write the file
			FileWriter writer = new FileWriter(new java.io.File("").getAbsolutePath()+"\\src\\main\\resources\\abc.txt");
			writer.write(str);
			BufferedWriter bwriter = new BufferedWriter(writer);
			bwriter.close();
			writer.close();
					
		
			List<String> strings = Arrays.asList(str.split(","));
			System.out.println(strings+"\n\n\n");
			
			/** CASE-II Remove the String from the file ****/
			System.out.println("CASE-II Remove the String from the file");
			//Enter the input from remove
			System.out.println("Please enter input for remove");
			input = sc.nextLine();
			
			//Read the file
			bis1=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(new java.io.File("").getAbsolutePath()+"\\src\\main\\resources\\abc.txt"))));
			str2="";str="";
			while((str2=bis1.readLine()) != null){
				str=str+str2;
			}
			str=str.replace(input+",", "");
						
			//Write the file
			writer = new FileWriter(new java.io.File("").getAbsolutePath()+"\\src\\main\\resources\\abc.txt");
			writer.write(str);
			bwriter = new BufferedWriter(writer);
			bwriter.close();
			writer.close();
			
			strings = Arrays.asList(str.split(","));
			System.out.println(strings);
			
			
			
	}

}
