package strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Two ways of checking for permutations of the same length String
 * Iteratively using two HashMaps
 * Recursively using one HashSet
 **/

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
			
			// Update character counters for the first String
			if (str1Map.containsKey(str1Key)) {
				int old = str1Map.get(str1Key);
				str1Map.put(str1Key, old+1);
			} else {
				str1Map.put(str1Key, 1);
			}
			
			// Update character counters for the second String
			if (str2Map.containsKey(str2Key)) {
				int old = str2Map.get(str2Key);
				str2Map.put(str1Key, old+1);
			} else {
				str2Map.put(str2Key, 1);
			}
		}
		

		// Note to self: In hindsight this could be made more space efficient using
		// a histogram implemented with and array, but HashMaps just make it so much easier to code.
		return str1Map.equals(str2Map);
	}
	
	public boolean checkStringForPermutationRecusion(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		// use the recursive helper function to populate a hashset of all possible permutations
		HashSet<String> wordMap = new HashSet<String>();
		
		// Engines Start
		permuteAndHashString("", str1, wordMap);

		return wordMap.contains(str2);
	}
	
	private void permuteAndHashString(String prefix, String str, HashSet<String> wordMap) {
		/*
		 * Concept:
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
		print( p.checkStringForPermutationIterative(str1, str2));
		print( p.checkStringForPermutationRecusion(str1, str2));
	}
	
	public static void print( Object obj ) {
		System.out.println(obj);
	}
}
