
/**
 * String Manipulation/Ciphers  
 * 
 * @discocorg
 * @08.08.19
 */
import edu.duke.*;

public class WordPlay {
    String vowels = "aeiouAEIOU";

    public boolean isVowel(char ch){
	for (int i =0; i< vowels.length(); i++){
	    char currChar = vowels.charAt(i);
	    int idx = vowels.indexOf(ch);
            if (idx != -1){
		return true;
	    }
	}
	return false;
    }

    public String replaceVowels(String phrase, char ch){
	String newPhrase = "";
	for (int i =0; i< phrase.length(); i++){
	    char currChar = phrase.charAt(i);
	    if (isVowel(currChar)){
		newPhrase = newPhrase + ch;
	    }
	    else{
		newPhrase = newPhrase + currChar;
	    }
	}
	return newPhrase;

    }
    
    public String emphasize(String phrase, char ch){
	String newPhrase = "";
	for (int i =0; i< phrase.length(); i++){
	    char currChar = phrase.charAt(i);
	    if (currChar == ch || currChar == Character.toUpperCase(ch)) {
		if (i%2 == 0){
		    newPhrase = newPhrase + "*";
		}
		else {
		    newPhrase = newPhrase + "+";
	        }
	    }
	    else {
		newPhrase = newPhrase + currChar;
	    }
	}
	return newPhrase;
    }

    public void testIsVowel() {
	char isA = 'A';
	System.out.println("This char, " + isA + " is a vowel: " + isVowel(isA));
	char isB = 'B';
	System.out.println("This char, " + isB + " is a vowel: " + isVowel(isB));
    }

    public void testReplaceVowels(){
	String newString = replaceVowels("Hello World", '*');
	System.out.println("\"Hello World\" is now " + newString);
    }

    public void testEmphasize(){
	System.out.println("\"Mary Bella Abracadabra\" is now " + emphasize("Mary Bella Abracadabra", 'a')); 
	System.out.println("\"Mary Bella Abracadabra\" is now " + emphasize("Mary Bella Abracadabra", 'm')); 
    }
}
