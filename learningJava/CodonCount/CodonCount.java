
/**
 * Find out how many times a codon appears in a DNA Strand
 * 
 * @discocorg
 * @08.16.19
 */
import java.util.*;
import edu.duke.*;

public class CodonCount {
    private HashMap<String,Integer> map;

    public CodonCount (){
	map = new HashMap<String,Integer>();
    }

    public void buildCodonMap(int start, String dna){
	map.clear();
	for (int k = start; k < dna.length() - 3; k+=3){
	    String curDNA = dna.substring(k,k+3);
	    if (map.containsKey(curDNA)){
		map.put(curDNA, map.get(curDNA)+1);
	    }
	    else{
		map.put(curDNA,1);
	    }
	}
    }

    public String getMostCommonCodon(){
	String mostCommonCodon = "";
	int mostCommonLargest = 0;

	for (String w: map.keySet()){
	     int occurences = map.get(w);    
	     if (occurences > mostCommonLargest){
		 mostCommonLargest = occurences;
		 mostCommonCodon = w;
	     }
	}
	return mostCommonCodon;
    }

    public void printCodonCounts(int start, int end){
	for (String w: map.keySet()){
	     int occurences = map.get(w);    
	     if (occurences >= start && occurences <= end){
		 System.out.println(w + " " + map.get(w));
	     }
	}
    }

    public void tester(){
        FileResource fr = new FileResource();
        String codons = fr.asString();
        codons = codons.toUpperCase();
	for (int k = 0; k <= 2; k++){
	    buildCodonMap(k, codons);
	    System.out.println("Reading frame starting with " + k + " results in the most common codon, " 
		    + getMostCommonCodon() + " with " + map.get(getMostCommonCodon()) + " occurences.");
	    System.out.println("Counts between 1 and 100 are:");
	    printCodonCounts(1,100);
	    System.out.println();
        }
    }
}
