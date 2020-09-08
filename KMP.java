package com.algo;

public class KMP {
	public static int[] SetupInputArray(String inputstring, int inputlength) {
		int[] lsp = new int[inputlength];
		int i = 1;
		lsp[0] = 0;
		for (i = 1; i < inputlength; i++) {
			int j = lsp[i - 1];// for example if lsp[i] before i++ was 1, j =1
			
			
			/* loop checks whether if character at index i is equivalent to character in
			 * index of j, for example j = 1 and i = 4 in a string of abab, then it would
			 * skip over the while loop
			 */
			while (j > 0 && inputstring.charAt(i) != inputstring.charAt(j)) {
				j = lsp[j - 1];
			}
			if (inputstring.charAt(i) == inputstring.charAt(j)) {
				j++;// eg in abab, where i = 4 and j = 1, j increases to 2
			}
			lsp[i] = j;
		}
		return lsp;

	}

	public static void search(String inputstring, String datastring) {
		int inputlen = inputstring.length();
		int datalen = datastring.length();
		boolean exist = false;

		int j = 0;// j is the number of input characters matching. So when j == inputlen, then an
					// inputstring is considered found.
		int[] lsp = SetupInputArray(inputstring, inputlen);
		for (int i = 0; i < datalen; i++) {
			while(j>0 && datastring.charAt(i)!=inputstring.charAt(j)) {
				//input offset, compare with previous char in input
				j = lsp[j-1];//strictly decreasing
			}
			if (datastring.charAt(i)==inputstring.charAt(j)) {
				j++;//since characters match, number of input char match increase.
				if(j == inputlen)// input string is found in data string
				{
					exist = true;
					System.out.print(" " + (i + 2 - j) + " ");
					j = 0;
				}
			}
		}
		if (!exist)//input string not found
		{
			System.out.print("-1");
		}

	}

}
