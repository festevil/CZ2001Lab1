package com.algo;

public class BoyerMoore {
	static int charnum = 256;

	private static int[] BadCharSetup(char[] str, int strlen) {
		int[] BadChar = new int[charnum]; /*
											 * char table setup, checks whether character in txt is in string, and where
											 * to move if character is in string
											 */
		for (int i = 0; i < charnum; i++) {
			BadChar[i] = -1;// -1 basically means character is not in string
		}
		for (int k = 0; k < strlen; k++) {
			BadChar[(int) str[k]] = k; // tells us the index to move to in character in string
		}
		return BadChar;
	}

	public static void search(char inputstring[], char datastring[]) {
		int inputlen = inputstring.length;
		int datalen = datastring.length;
		int badchar[] = BadCharSetup(inputstring, inputlen);

		int s = 0; // loop initialization, also records shift of pattern

		while (s <= (datalen - inputlen)) {
			int inputindex = inputlen - 1;// index of character being compared in string
			while (inputindex >= 0 && inputstring[inputindex] == datastring[inputindex + s]) {
				inputindex--;
			}
			if (inputindex < 0) {// all characters match
				System.out.print(" " + (s + 1) + " ");
				if (s + inputlen < datalen) {
					s += inputlen - badchar[datastring[s + inputlen]];/* Here the input shifts such that the next 
					character in text aligns with the last occurrence of it in pattern.*/
				} else {
					s++;// if pattern occurs at end of string
				}
			} else {
				if (inputindex - badchar[datastring[s + inputindex]] > 1) {
					s += inputindex - badchar[datastring[s + inputindex]];//shift pattern so that bad character aligns with last occurrence in pattern
				} else {
					s++;
				}
			}
		}

	}
}
