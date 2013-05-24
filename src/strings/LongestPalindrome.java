package strings;

import java.util.*;

class LongestPalindrome {
	
	HashSet<String> palindromeSet = new HashSet<String>();
	
	public void getLongestPalindrome(String input) {
		for (int i = 0; i < input.length();i++) {
			String rest = input.substring(i+1,input.length());
			for (int j = 1; j <= rest.length(); j++) {
				String subsequence = input.charAt(i) + rest.substring(0,j);
				if (isPalindrome(subsequence)) {
					palindromeSet.add(subsequence);
				}
			}
		}
		
		int longestSize = 0;
		for (String s : palindromeSet) {
			if (s.length() > longestSize) {
				println(s);
				longestSize = s.length();
				println(longestSize);
			}
		}
	}
	
	public boolean isPalindrome(String input) {

		String reverse = new StringBuffer(input).reverse().toString();
		
		return reverse.equals(input);
	}

	public static void println( Object obj ) {
		System.out.println(obj);
	}
	
	public static void main(String args[]) {
		LongestPalindrome p = new LongestPalindrome();
		String input = "aabbcccccddddaaaaaddaa";
		p.getLongestPalindrome(input);
	}
}