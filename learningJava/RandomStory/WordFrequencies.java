
/**
 * Count Word Frequencies in a file.
 * 
 * @discocorg
 * @08.15.19
 */
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
	myWords = new ArrayList<String>();
	myFreqs = new ArrayList<Integer>();
    }

    public void findUnique(){
	FileResource resource = new FileResource();

	for (String s: resource.words()){
	    s = s.toLowerCase();
	    int index = myWords.indexOf(s);
	    if (index == -1){
		myWords.add(s);
		myFreqs.add(1);
	    }
	    else {
		int value = myFreqs.get(index);
		myFreqs.set(index, value+1);
	    }
	}
    }
    
    public int findIndexOfMax(){
        int indexOfMax = 0;
	for (int k = 0; k<myWords.size(); k++){
	    if (myFreqs.get(k) > indexOfMax){
		indexOfMax = myFreqs.get(k); 
	    }
	}
	return indexOfMax;
    }

    public void tester(){
	findUnique();
	System.out.println("# of unique words " 	+ myWords.size());
	for (int k = 0; k<myWords.size(); k++){
	    System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
	}
	System.out.println("The word that appears most often and it's count are, " + findIndexOfMax() + " " +myWords.get(myFreqs.indexOf(findIndexOfMax())) );
    }
}
