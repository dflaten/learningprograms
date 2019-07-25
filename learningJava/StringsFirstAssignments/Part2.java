
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){
	boolean dnaIsUpper; //Was adding this because instructions said changes were needed to make this work with lower/upper case chars but there aren't
        for (int i=0; i < dna.length(); i++){
	    if (!Character.isUpperCase(dna.charAt(i))){
	    dnaIsUpper = false; 
            }
	    dnaIsUpper = true; 
	}
	int startSequence = dna.indexOf(startCodon);
	int endSequence = dna.indexOf(stopCodon, startSequence + 3);
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
	String testdnaNoATG = findSimpleGene(dnaNoATG,"ATG", "TAA"); 
        System.out.println("Should show no string, no ATG: " + testdnaNoATG);

	String dnaNoTAA = "ATGGGTTAGGTC";
	String testdnaNoTAA = findSimpleGene(dnaNoTAA,"ATG", "TAA");
        System.out.println("Should show no string, no TAA: " + testdnaNoTAA);

	String dnaNoATGorTAA = "ACGGGTTAGGTC";
	String testdnaNoATGorTAA= findSimpleGene(dnaNoATGorTAA,"ATG", "TAA"); 
        System.out.println("Should show no string,not ATG or TAA: " + testdnaNoATGorTAA);
	
	String dnaWithATGnTAAWrongLength = "ATGGCGTTAAGTC";
	String testdnaWithATGnTAAWrongLength = findSimpleGene(dnaWithATGnTAAWrongLength,"ATG", "TAA"); 
        System.out.println("Should not show a string, substring too long: " + testdnaWithATGnTAAWrongLength);

	String dnaWithATGnTAA = "ATGGGTTAAGTC";
	String testdnaWithATGnTAA = findSimpleGene(dnaWithATGnTAA,"ATG", "TAA"); 
        System.out.println("Should show a string: " + testdnaWithATGnTAA);
    }
    public static void main (String[] args) {
	Part1 p1 = new Part1();
	p1.testSimpleGene();
    }
}
