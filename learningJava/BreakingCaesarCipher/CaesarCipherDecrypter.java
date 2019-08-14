
/**
 * Decrypts words scrabled with Caesar Cypher, two keys.
 * 
 * @discocorg
 * @08/11/19
 */
public class CaesarCipherDecrypter {

    public int [] countLetterOccurences(String message){
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	message = message.toLowerCase();
	int [] counts = new int[26];
	for (int k=0; k<message.length(); k++){
	    char ch = Character.toLowerCase(message.charAt(k));
	    int dex = alpha.indexOf(ch);
	    if (dex != -1){
		counts[dex]++;
	    }
	}
	return counts;
    }

    public String decrypt(String encrypted){
	CaesarCipher cc = new CaesarCipher();
        WordLengths wl = new WordLengths();
	int [] freqs = countLetterOccurences(encrypted);
	int maxDex = wl.indexOfMax(freqs);
	int dkey = maxDex - 4;
	if (maxDex < 4){
	    dkey = 26 - (4-maxDex);
	}
	return cc.encrypt(encrypted, 26-dkey);
    }

    public String halfOfString(String message, int start){
	StringBuilder halfString = new StringBuilder();
	    for (int i = start; i< message.length(); i+=2){
		halfString.append(message.charAt(i));
	    }
	return halfString.toString();
    }

    public int getKey(String s){
        int [] letterCounts = countLetterOccurences(s);
	WordLengths wl = new WordLengths();
	int maxDex = wl.indexOfMax(letterCounts);
	return maxDex;
    }

    public String decryptTwoKeys(String encrypted){
	System.out.println("Here is the encrypted whole String: " + encrypted);

	String encryptedHalf0 = halfOfString(encrypted, 0);
	System.out.println("Here is the zero half encrypted: " + encryptedHalf0 );
	int zeroKey = getKey(encryptedHalf0);
	System.out.println("Here is the zero key: " + zeroKey);
	String decryptedHalf0 = decrypt(encryptedHalf0);

	String encryptedHalf1 = halfOfString(encrypted, 1);
	System.out.println("Here is the one half encrypted: " + encryptedHalf1 );
	int oneKey = getKey(encryptedHalf1);
	System.out.println("Here is the one key: " + oneKey);
	String decryptedHalf1 = decrypt(encryptedHalf1);

	String decryptedMessage = "";
	int maxLoop = encryptedHalf0.length() > encryptedHalf1.length() ? encryptedHalf0.length() : encryptedHalf0.length();
	
	for (int i = 0; i < maxLoop; i++){
            char firstChar = '\0';
            char secondChar = '\0';
	    if (i < encryptedHalf0.length()){
		firstChar = decryptedHalf0.charAt(i);
	    }
	    if (i < encryptedHalf1.length()){
		secondChar = decryptedHalf1.charAt(i);
	    }
            decryptedMessage = decryptedMessage + firstChar + secondChar;
	}
	return decryptedMessage;
    }

    public void testDecryptTwoKeys(){
	String encryptedString = "Io iwjv jz dv bcm kjvamzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmzmmmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!";
	//String encryptedString = "Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!";
	System.out.println("My decrypted string: " + decryptTwoKeys(encryptedString));
    }

    public void testGetKey(){
        String encryptedMessage = "Hqfubsw pb phvvhhhhdjh.";
	int key = getKey(encryptedMessage);
	System.out.println("Should be H or 7, is: " + key);
    }

    public void testDecrypt(){
	String encryptedString = "Hqfubsw pb phvvdjh.";
	System.out.println("My decrypted string: " + decrypt(encryptedString));
    }

    public void testHalfOfString(){
	String encryptedString ="abcdefghijklmN.opqrstuvwxyz";
	String halfString0 = halfOfString(encryptedString, 0);
	String halfString1 = halfOfString(encryptedString, 1);
	System.out.println("First half from zero: " + halfString0);
	System.out.println("Second half from one: " + halfString1);
    }

}
