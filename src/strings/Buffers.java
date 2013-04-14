package strings;

import java.util.ArrayList;

/**
 * Implementations of String Buffers and Character Buffers to be used in the program
 */

public class Buffers {
	
	public static class CharBuffer {

		private ArrayList<Character> characterList = new ArrayList<Character>();

		public void append( char c ) {
			characterList.add(c); 
		} 

		@Override
		public String toString() {
			String output = "";

			for ( char c : characterList ) {
				output += c;
			}

			return output;
		}
	}
	
	public static class StringBuffer {
		private ArrayList<String> stringList = new ArrayList<String>();
		
		public void append( String str ) {
			stringList.add( str );
		}
	
		@Override
		public String toString() {
			String output = "";

			for ( String str : stringList ) {
				output += str;
			}

			return output;
		}
	}

}
