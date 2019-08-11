
/**
 * Java programs for counting word length.  
 * 
 * @discocorg
 * @8.10.19
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int [] counts){
	
	for (String word : resource.words()) {
	    int wordLength = 0;
	    for (int i =0; i< word.length(); i++){
		if (word.charAt(i) == '-' || word.charAt(i) == '\'' ||
                    Character.isLetter(word.charAt(i))){
			wordLength++;
		}
	    }
	    counts[wordLength]++;
        }
	for (int i =0; i < counts.length; i++){
	    int x = counts[i];
	    System.out.println(i + " " + x);
	}
	int mostLengthWords = indexOfMax(counts);
	System.out.println("The most words are of length:  " + mostLengthWords);

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

    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int [] counts = new int [31];
        countWordLengths(fr, counts);
    }
}
