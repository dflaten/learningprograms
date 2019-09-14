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
	int[] keys = tryKeyLength(encrypted, 5, 'e');
	VigenereCipher vc = new VigenereCipher(keys);
	String decrypted = vc.decrypt(encrypted);
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

    public String breakForLanguage(String encyrpted, HashSet<String> dictionary){
        return "Complete Me!";	
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
