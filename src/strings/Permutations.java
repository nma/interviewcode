package strings;

import java.util.HashMap;
import java.util.HashSet;

public class Permutations {
	/*
	 * Finds if string1 is a permutation of string2 having same length
	 */
	
	public boolean checkStringForPermutationIterative(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		HashMap<Character,Integer> str1Map = new HashMap<Character,Integer>();
		HashMap<Character,Integer> str2Map = new HashMap<Character,Integer>();
		
		for (int i = 0; i < str1.length(); i++) {
			
			char str1Key = str1.charAt(i);
			char str2Key = str2.charAt(i);
			
			if (str1Map.containsKey(str1Key)) {
				int old = str1Map.get(str1Key);
				str1Map.put(str1Key, old+1);
			} else {
				str1Map.put(str1Key, 1);
			}
			
			if (str2Map.containsKey(str2Key)) {
				int old = str2Map.get(str2Key);
				str2Map.put(str1Key, old+1);
			} else {
				str2Map.put(str2Key, 1);
			}
		}
		
		return str1Map.equals(str2Map);
	}
	
	public boolean checkStringForPermutationRecusion(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		HashSet<String> wordMap = new HashSet<String>();
		
		permuteAndHashString("", str1, wordMap);
		
		//System.out.println(wordMap.toString());

		return wordMap.contains(str2);
	}
	
	private void permuteAndHashString(String prefix, String str, HashSet<String> wordMap) {
		/*
		 * Try each of the letters in turn as the first letter and then find all the permutations 
		 * of the remaining letters using a recursive call.
		 * 
		 * The base case is when the input is an empty string the only permutation is the empty string.
		 */
		int n = str.length();
		if (n == 0) {
			wordMap.add(prefix);
		} else {
			for ( int i = 0; i < str.length(); i++ ) {
				permuteAndHashString(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1,n), wordMap);
			}
		}
	}
	
	
	public static void main( String[] args ) {
		/*if (args.length != 3) {
			System.out.println("Wrong number of arguements");
			return;
		}*/
		
		String str1="ABC";
		String str2="CBA";
		
		Permutations p = new Permutations();
		System.out.println( p.checkStringForPermutationIterative(str1, str2));
		System.out.println( p.checkStringForPermutationRecusion(str1, str2));
	}
	
	public static void print( Object obj ) {
		System.out.print(obj);
	}
}
