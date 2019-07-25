
/**
 * Find a sub-string in a String.
 * 
 * @discocorg (your name) 
 * @7.23.19
 */
import edu.duke.*;
import java.io.File;

public class Part1 {

    public String findSimpleGene(String dna){
	int startSequence = dna.indexOf("ATG");
	int endSequence = dna.indexOf("TAA", startSequence + 3);
	if (startSequence == -1 || endSequence == -1){
	    return "";
	}
	String result = "";	
	int sequenceLength = endSequence - startSequence; 
	  
	if (sequenceLength % 3 == 0){
	   result = dna.substring(startSequence, endSequence + 3); 
	   return result; 
	}
	return "";

    }

    public void testSimpleGene() {
	String dnaNoATG = "ATTGGTTAAGTC";
	String testdnaNoATG = findSimpleGene(dnaNoATG); 
        System.out.println("Should show no string, no ATG: " + testdnaNoATG);

	String dnaNoTAA = "ATGGGTTAGGTC";
	String testdnaNoTAA = findSimpleGene(dnaNoTAA);
        System.out.println("Should show no string, no TAA: " + testdnaNoTAA);

	String dnaNoATGorTAA = "ACGGGTTAGGTC";
	String testdnaNoATGorTAA= findSimpleGene(dnaNoATGorTAA); 
        System.out.println("Should show no string,not ATG or TAA: " + testdnaNoATGorTAA);
	
	String dnaWithATGnTAAWrongLength = "ATGGCGTTAAGTC";
	String testdnaWithATGnTAAWrongLength = findSimpleGene(dnaWithATGnTAAWrongLength); 
        System.out.println("Should not show a string, substring too long: " + testdnaWithATGnTAAWrongLength);

	String dnaWithATGnTAA = "ATGGGTTAAGTC";
	String testdnaWithATGnTAA = findSimpleGene(dnaWithATGnTAA); 
        System.out.println("Should show a string: " + testdnaWithATGnTAA);
    }
    public static void main (String[] args) {
	Part1 p1 = new Part1();
	p1.testSimpleGene();
    }
}
