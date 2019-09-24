import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
	String mySlice = "";
        for(int k=whichSlice; k < message.length(); k+=totalSlices){
             mySlice = mySlice + message.charAt(k);
	}
        return mySlice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];

	for (int k =0; k < klength; k++){
	    String encryptedSubString = encryptedSubString = sliceString(encrypted, k, klength);
	    CaesarCracker cc = new CaesarCracker(); 
	    key[k] = cc.getKey(encryptedSubString);
	}
        return key;
    }

    public void breakVigenere () {
	FileResource fr = new FileResource("/Users/dflaten/Projects/learningprograms/learningJava/VigenereProgram/messages/VigenereTestData/athens_keyflute.txt");
	FileResource frd = new FileResource("/Users/dflaten/Projects/learningprograms/learningJava/VigenereProgram/dictionaries/English");
	String encrypted = fr.asString();
	HashSet<String> dictionary = readDictionary(frd);
	String decrypted = breakForLanguage(encrypted, dictionary); 
	System.out.println(decrypted);
    }

    public HashSet<String> readDictionary(FileResource fr){
	HashSet<String> dictionary = new HashSet<String>();
	for (String line : fr.lines()){
            dictionary.add(line.toLowerCase());
	}
	return dictionary;
    }

    public int countWords(String message, HashSet<String> dictionary){
	ArrayList<String>  maybeValidWords = new ArrayList<String>();
	ArrayList<String> validWords = new ArrayList<String>();

	for (String maybeWord : message.split("\\W")){
	    maybeValidWords.add(maybeWord); 
	}
	
	for (String word : maybeValidWords){
	    if (dictionary.contains(word)){
		validWords.add(word);
	    }
	}

	return validWords.size();
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
	int mostWords = 0;
	int[] bestKeys = new int[0];
        for (int k=1; k < 101; k++){
            int[] keys = tryKeyLength(encrypted, k, 'e');
	    VigenereCipher vc = new VigenereCipher(keys);
	    String decrypted = vc.decrypt(encrypted);
	    int curWords = countWords(decrypted, dictionary); 
	    if (curWords > mostWords){
                mostWords = curWords;
		bestKeys = keys;
	    }
	}
	VigenereCipher vc = new VigenereCipher(bestKeys);
	return vc.decrypt(encrypted);
    }

    public void testBreakForLanguage(){
	FileResource fr = new FileResource("/Users/dflaten/Projects/learningprograms/learningJava/VigenereProgram/messages/VigenereTestData/athens_keyflute.txt");
	String encrypted = fr.asString();
        FileResource dict = new FileResource("/Users/dflaten/Projects/learningprograms/learningJava/VigenereProgram/dictionaries/English");
	String decrypted = breakForLanguage(encrypted, readDictionary(dict));
        System.out.println(decrypted);	
    }

    public void testSliceString(){
	System.out.println(sliceString("abcdefghijklm", 0, 3));
	System.out.println(sliceString("abcdefghijklm", 1, 3));
	System.out.println(sliceString("abcdefghijklm", 2, 3));
	System.out.println(sliceString("abcdefghijklm", 0, 4));
	System.out.println(sliceString("abcdefghijklm", 1, 4));
	System.out.println(sliceString("abcdefghijklm", 2, 4));
	System.out.println(sliceString("abcdefghijklm", 3, 4));
	System.out.println(sliceString("abcdefghijklm", 0, 5));
	System.out.println(sliceString("abcdefghijklm", 1, 5));
	System.out.println(sliceString("abcdefghijklm", 2, 5));
	System.out.println(sliceString("abcdefghijklm", 3, 5));
	System.out.println(sliceString("abcdefghijklm", 4, 5));
    }

    public void testTryKeyLength(){
	FileResource fr = new FileResource("/Users/dflaten/Projects/learningprograms/learningJava/VigenereProgram/messages/VigenereTestData/athens_keyflute.txt");
	String encrypted = fr.asString();
	int[] mykeys = tryKeyLength(encrypted, 5, 'e');
	System.out.println(Arrays.toString(mykeys));
    }
    
}
