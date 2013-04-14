package strings;

/**
 * Checks for duplicate character without a datastructure
 */
public class CheckDuplicates {

	// O(2n) procedure to check for duplicate chars
	public boolean checkForDuplicates( String a ) {
		for ( int i = 0; i < a.length(); i++ ) {
			if (i+1 >= a.length()) break;
			for ( int j = i+1; j < a.length(); j++ ) {
				if ( a.charAt(i) == a.charAt(j) ) {
					return false;
				} 
			}
 		}
 		return true; // no duplicates
	}

	public static void main( String[] args ) {
		String str1="ABCDEA";
		String str2="ABCDEF";
		
		CheckDuplicates fcn = new CheckDuplicates();
		print( fcn.checkForDuplicates(str1) );
		print( fcn.checkForDuplicates(str2) );
	}
	
	public static void print( Object obj ) {
		System.out.println(obj);
	}
}
