
/**
 * Decrypts words scrabled with Caesar Cypher, two keys.
 * 
 * @discocorg
 * @08/11/19
 */
public class CaesarCipherDecrypter {

    public int [] countLetterOccurences(String message){
	String alpha = "abcdefghijklmnopqrstuvwxyz";
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

    public void testDecrypt(){
	String encryptedString = "Hqfubsw pb phvvdjh.";
	System.out.println("My decrypted string: " + decrypt(encryptedString));
    }

}
