package com.algo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class testbf {
	public static void main(String[] args)
	{
		String data = "";
		Scanner Scan = new Scanner(System.in);
		try
		{	// extract a txt file as a variable, file has to be in the same directory
			System.out.println("Input directory of file...");
			String path = Scan.nextLine();
			data = new String(Files.readAllBytes(Paths.get(path))); 		}
		catch (IOException e) {
		      e.printStackTrace();
		    }
		try {
		System.out.println("Enter pattern to search for...");
		String string = Scan.next();
		System.out.println("Brute Force");
		BruteForce.Brute(string,data);
		System.out.println();
		System.out.println("KMP");
		KMP.search(string, data);
		System.out.println();
		System.out.println("Boyer Moore");
		BoyerMoore.search(string.toCharArray(), data.toCharArray());
		}
		catch(Exception e){
			System.out.println("Something went wrong.");
		}
		finally {
			Scan.close();
		}
		return;
	}
}
