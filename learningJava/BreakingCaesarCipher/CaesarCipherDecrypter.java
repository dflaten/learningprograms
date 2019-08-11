
/**
 * Decrypts words scrabled with Caesar Cypher, two keys.
 * 
 * @discocorg
 * @08/11/19
 */
public class CaesarCipherDecrypter {
    public String encrypt(String input, int key){
	StringBuilder encrypted = new StringBuilder(input);
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz"; 
	String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
	String shiftedLowerAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
	
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

    public int indexOfMax(int [] values){
	int maxIndex = -1;
	int maxValue = 0;
	for (int i =0; i < values.length; i++){
	    if (values[i] > maxValue){
		maxIndex = i;
		maxValue = values[i];
	    }
        }
	return maxIndex;
    }

    public int [] CountLetterOccurences(String message){
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	int [] counts = new int[26];
	for (int k=0; k<message.length(); k++){
	    char ch = Character.toLowerCase(message.charAt(k));
	    int dex = alph.indexOf(ch);
	    if (dex != -1){
		counts[dex]++;
	    }
	}
	return counts;
    }

    public String decrypt(String encrypted){
	CaesarCipher cc = new CaesarCipher();
	int [] freqs = countLetterOccurences(encrypted);
	int maxDex = indexOfMax(freqs);
	int dkey = maxDex - 4;
	if (maxDex < 4){
	    dkey = 26 - (4-maxDex);
	}
	return cc.encrypt(encrypted, 26-dkey);
    }

}
