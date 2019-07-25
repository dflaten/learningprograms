
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
	int firstOccurrence = stringb.indexOf(stringa);
	if (firstOccurrence == -1) {
	    return false;
	}
	int secondOccurrence = stringb.indexOf(stringa, firstOccurrence);
	if (secondOccurrence == -1) {
	    return false;
	}
	return true;
    }

    public void testing(){
	Boolean test1result = twoOccurrences("ATC", "abdk34vATCdkfiATC"); 
	System.out.println("Should show true: " + test1result);
	Boolean test2result = twoOccurrences("bTC", "abdk34vATCdkfiATC"); 
	System.out.println("Should show false: " + test2result);
    }
    public static void main (String[] args) {
	Part3 p3 = new Part3();
	p3.testing();
    }
}
