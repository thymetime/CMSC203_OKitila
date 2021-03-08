

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		boolean inBounds = true;
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				inBounds = false;
				break;
			}
		}
		
		return inBounds;
		//throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		if (!stringInBounds(plainText)) {
			return "";
		}
		
		key %= RANGE;
		char[] textArr = plainText.toCharArray();
		
		for (int i = 0; i < textArr.length; i++) {
			textArr[i] = (textArr[i] + key > UPPER_BOUND) ? (char) ((textArr[i] + key) - RANGE) : (char) (textArr[i] + key);
		}
			
		
		String encryptedText = new String(textArr);
		
		return encryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		if (!stringInBounds(plainText)) {
			return "";
		}
		
		char[] textArr = plainText.toCharArray();
		char[] bStr = bellasoStr.toCharArray();
		
		for (int i = 0; i < textArr.length; i++) {
			int index = i % bStr.length;
			
			if (textArr[i] + bStr[index] > UPPER_BOUND) {
				textArr[i] = (char) ((textArr[i] + bStr[index]) - RANGE);
			}
			else {
				textArr[i] = (char) (textArr[i] + bStr[index]);
			}
		}
		
		String encryptedText = new String(textArr);
		
		return encryptedText;
		
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		key %= RANGE;
		char[] textArr = encryptedText.toCharArray();
		
		for (int i = 0; i < textArr.length; i++) {
			textArr[i] = (textArr[i] - key < LOWER_BOUND) ? (char) ((textArr[i] - key) + RANGE) : (char) (textArr[i] - key);
		}
		
		String decryptedText = new String(textArr);

		return decryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		char[] textArr = encryptedText.toCharArray();
		char[] bStr = bellasoStr.toCharArray();
		
		for (int i = 0; i < textArr.length; i++) {
			int index = i % bStr.length;
			
			if (textArr[i] - bStr[index] < LOWER_BOUND) {
				textArr[i] = (char) ((textArr[i] - bStr[index]) + RANGE);
			}
			else {
				textArr[i] = (char) (textArr[i] - bStr[index]);
			}
		}
		
		String decryptedText = new String(textArr);
		
		return decryptedText;
		//throw new RuntimeException("method not implemented");
	}
}