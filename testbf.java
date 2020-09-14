package com.algo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class testbf {
	public static void main(String[] args)
	{
		String data = "";
		try
		{	// extract a txt file as a variable, file has to be in the same directory
			data = new String(Files.readAllBytes(Paths.get("C:/Users/Benjamin Tan/eclipse-workspace/AlgorithmLab1/src/com/algo/GCF_000006945.2_ASM694v2_genomic.fna"))); 		}
		catch (IOException e) {
		      e.printStackTrace();
		    }
		String string = "CCTCCCT";
		System.out.println("Brute Force");
		BruteForce.Brute(string,data);
		System.out.println();
		System.out.println("KMP");
		KMP.search(string, data);
		System.out.println();
		System.out.println("Boyer Moore");
		BoyerMoore.search(string.toCharArray(), data.toCharArray());
		return;
	}
}
