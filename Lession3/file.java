package Lession3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class file {
	static String name;
	static Scanner sc=new Scanner(System.in);
	static String path="E:\\DwnlData\\Documents";
	static File file;
	
	private static void create() {
		String s;
		try {
			if(file.createNewFile()) {
				System.out.println("File created");
				FileWriter f=new FileWriter(file);
				System.out.println("Enter String to be write:");
				s=sc.nextLine();
				f.write(s);
				f.close();
				main(null);
				
			}
			else {
				System.out.println("File Found");
				FileWriter f=new FileWriter(file);
				System.out.println("Enter String to be write:");
				s=sc.nextLine();
				f.write(s);
				f.close();
				main(null);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void read() {
	
		try {
			
			FileReader read=new FileReader(path+"//"+name);
			BufferedReader buff=new BufferedReader(read);
			String line;
			//while(line=buff.readLine() != null) {
			//	System.out.println(line);
			while((line = buff.readLine()) != null) {
                System.out.println(line +"hai");
                main(null);
            }   
		}catch (FileNotFoundException e) {
			System.out.println("File not Exist!!!");
			main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void append() {
		System.out.println("Enter String to be appended:");
		String data=sc.nextLine();
		List<String> str=Arrays.asList(data);
		String paths=path+"//"+name;
		Path p=Paths.get(paths);
		try {
			Files.write(p,str,StandardOpenOption.APPEND);
			main(null);
		}catch (NoSuchFileException e) {
			System.out.println("File not Found");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("(1)\tWrite \n(2)\tRead \n(3)\tAppend \nAny other key to exit ");
		System.out.println("\nEnter your choice:");
		int a=Integer.parseInt(sc.nextLine());
		System.out.println("Enter File name");
		name=sc.nextLine();
		file=new File(path,name);
		switch (a) {
		case 1:
			create();
			break;
		case 2:
			read();
			break;
		case 3:
			append();
			break;
		default:
			System.out.println("Exiting");
			System.exit(0);
			break;
		}
	}
	
}
