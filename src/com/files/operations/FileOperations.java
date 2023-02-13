package com.files.operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileOperations {
	public static void read(String filename) throws IOException
	{
		int ch;
		FileReader fr=null;
		//check if file exists or not
		try
		{
			fr=new FileReader(filename);
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not found");
		}
		//Read from File Reader till the end of the file
		while((ch=fr.read())!=-1)
		{
			System.out.print((char)ch);
		}
		//close the file
		fr.close();
	}
	public static void write(String filename) throws IOException
	{
		String str;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		FileWriter fileWriter = new FileWriter(filename);
	    System.out.println("Enter the data:");
	    //exits from writing when the string is equal to exit
	    while(!(str=br.readLine()).equals("exit"))
	    {
	    fileWriter.write(str+"\n");
	    }
	    fileWriter.close();	
	}
	public static void append(String filename) throws IOException
	{
		String str;
		File file = new File(filename);
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		FileWriter filewriter = new FileWriter(file, true);
		System.out.println("enter the data that needs to appended");
		while(!(str=br1.readLine()).equals("exit"))
	    {
	    filewriter.write(str+"\n");
	    }
		filewriter.close();
	}

	public static void main(String[] args) throws IOException {
		

			System.out.println("please select the operation to perform");
			System.out.println("1.Write\n2.Read\n3.Append");
			Scanner sc= new Scanner(System.in);
			int option=sc.nextInt();
			if(option<4)
			{
				
				System.out.println("enter the file name");
				String s=sc.next();
				//String currentDirectory = System.getProperty("user.dir");
				String filename=System.getProperty("user.dir")+"\\"+s;
				//File f=new File(filename);
			switch(option)
			{
			
			case 1:
				write(filename);			
				break;
				//Reading data from a file
			case 2:
				read(filename);
				break;
			case 3:
				append(filename);
				break;
			
			}
			}
			else
				System.out.println("option is not available");
			
			sc.close();

	}

}
