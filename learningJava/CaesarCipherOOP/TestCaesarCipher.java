
/**
 * Test the CaesarCipher Class 
 * 
 * @discocorg
 * @08.15.19
 */
public class TestCaesarCipher {
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

//    public String breakCaesarCipher(String input){
//    }

    public void simpleTests(){
	CaesarCipher cc = new CaesarCipher(15);
	String myEncryptedString = cc.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
	System.out.println(myEncryptedString);

    }

}
