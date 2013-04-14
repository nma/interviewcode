package strings;

/**
 * Replace all ' ' characters with "%20" assuming the char array has space to hold it.
 */

public class ReplaceSpaceCharacters {
	
	public String replaceCharactersInString( char[] str, char target ) {
		Buffers.CharBuffer myCharBuffer = new Buffers.CharBuffer();

		for ( char c : str ) {
			if ( c == target ) {
				myCharBuffer.append('%');
				myCharBuffer.append('2');
				myCharBuffer.append('0');
			} else {
				myCharBuffer.append(c);
			}
		}

		return myCharBuffer.toString();
	}

	public static void main ( String argv[] ) {
		String inputStr = "I am a meat popsicle.";

		ReplaceSpaceCharacters fcn = new ReplaceSpaceCharacters();
		print( fcn.replaceCharactersInString( inputStr.toCharArray(), ' ' ) );
	}

	public static void print( Object obj ) {
		System.out.println(obj);
	}
}