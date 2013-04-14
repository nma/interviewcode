package strings;

import java.util.Iterator;

/**
 *  Create a simple String compression function.
 *  Where aabbcccccaaa becomes a2b2c5a3. 
 *  If the compressed length is not smaller than the original then return the original.
 */

public class StringCompression {

	public String compressString( String str ) {

		Buffers.StringBuffer myStringBuffer = new Buffers.StringBuffer();
		
		char currentChar = str.charAt(0);
		myStringBuffer.append(Character.toString(currentChar));
		int currentCount = 0;
		for ( char c : str.toCharArray() ) {
			if ( currentChar == c ) {
				currentCount += 1;
			} 

			if ( currentChar != c ) {
				myStringBuffer.append(Integer.toString(currentCount));
				currentChar = c;
				currentCount = 1;
				myStringBuffer.append( Character.toString(c)) ;
			}
		}
		myStringBuffer.append(Integer.toString(currentCount));
		
		String output = myStringBuffer.toString();
		if (output.length() < str.length()) {
			return output;
		}
		return str;
	}
	
	public static void main( String[] argv ) {
		String inputstr = "aabbcccccaaa";
		String inputstr2 = "aabbccddaa";
		
		StringCompression fcn = new StringCompression();
		print( fcn.compressString( inputstr ) );
		print( fcn.compressString( inputstr2 ) );
	}

	public static void print( Object obj ) {
		System.out.println( obj );
	}
	
	
	// just for fun character iterator over a string
	class CharacterIterator implements Iterator<Character> {
		
		private final String str;
		private int pos = 0;
		
		public CharacterIterator( String str ) {
			this.str = str;
		}
		
		@Override
		public boolean hasNext() {
			return pos < str.length();
		}

		@Override
		public Character next() {
			return str.charAt(pos++);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
}