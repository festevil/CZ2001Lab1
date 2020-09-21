package com.algo;

public class BruteForce{
	public static void Brute(String inputstring, String datastring) {
		int inputlength = inputstring.length();
		int datalength = datastring.length();
		boolean exist = false;
		for (int i = 0; i < (datalength-inputlength+1); i++) {
			boolean a = true;
			for (int k = 0; k < inputlength; k++) {
				if (inputstring.charAt(k) != datastring.charAt(i + k)) {
					exist = true;
					a = false;
					break;
				}
			}
			if (a == true) {
				System.out.print(" " + (i + 1) + " ");
			}
			
		}
		if(exist) {
			System.out.print("-1");
		}
	}

}
