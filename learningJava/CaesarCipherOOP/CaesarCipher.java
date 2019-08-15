
/**
 * Caesar Cipher in OOP style
 * 
 * @discocorg
 * @08.14.19
 */
public class CaesarCipher {
    private String alphabet;
    private String lowerAlphabet; 
    private String shiftedAlphabet;
    private String shiftedLowerAlphabet;
    private int mainKey;

    public CaesarCipher(int key) {
	alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
	shiftedLowerAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
	mainKey = key;
    }

    public String encrypt(String input){
	StringBuilder encrypted = new StringBuilder(input);
	
	for (int i =0; i< encrypted.length(); i++){
	    char currChar = encrypted.charAt(i);
	    boolean isUpperCase = Character.isUpperCase(currChar);
	    if (isUpperCase){
		int idx = alphabet.indexOf(currChar);
		if (idx != -1){
		    char newChar = shiftedAlphabet.charAt(idx);
		    encrypted.setCharAt(i, newChar);
		}
	    }
	    else {
		int idx = lowerAlphabet.indexOf(currChar);
		if (idx != -1){
		    char newChar = shiftedLowerAlphabet.charAt(idx);
		    encrypted.setCharAt(i, newChar);
	        }
	    }
        }
	return encrypted.toString();
   }

    public String decrypt(String encrypted){
	CaesarCipher cc = new CaesarCipher(26 - mainKey);
	return cc.encrypt(encrypted); 
    }

/*
    public String encryptTwoKeys(String input, int key1, int key2){
	StringBuilder encrypted = new StringBuilder(input);
         
	for (int i =0; i< encrypted.length(); i++){
		if (i%2 == 0){
		    char newChar = encrypt(Character.toString(encrypted.charAt(i)), key1).charAt(0);
		    encrypted.setCharAt(i, newChar);
		}
		else {
		    char newChar = encrypt(Character.toString(encrypted.charAt(i)), key2).charAt(0);
		    encrypted.setCharAt(i, newChar);
		}
	}
	return encrypted.toString();
    }


    public void testCryptTwoKeys(){
	System.out.println("Encrypt my message. Encyrption: " + encryptTwoKeys("Encrypt my message.", 3, 4));
	System.out.println("First Legion Encryption: " + encryptTwoKeys("First Legion", 23, 17));
	System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
*/
}
