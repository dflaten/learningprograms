
/**
 * Ready lines from http://www.dukelearntoprogram.com/course2/data/manylinks.html 
 * and print each link that is a link to youtube.com
 * @author discocorg 
 * @version July 28, 2019
 */
import edu.duke.*;

public class Part4 {

    public void findYoutube(){
	URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
	for (String s : ur.lines()) {
            String myStringLower = s.toLowerCase();
	    int foundYoutubeLink = myStringLower.indexOf("youtube.com");
	    if (foundYoutubeLink != -1) {
		int startQuote = myStringLower.lastIndexOf("\"", foundYoutubeLink);
		int endQuote = myStringLower.indexOf("\"", foundYoutubeLink);
		if (startQuote != -1 && endQuote != -1){
//		System.out.println(startQuote + " " + endQuote);
		        String justLink = s.substring(startQuote+1, endQuote);
			System.out.println(justLink);
		    }
	    }
//	    else if (foundYoutubeLink == -1){
//		    System.out.println("No Youtube " +s);
//	    }
	 }
	
    }
    public static void main (String[] args) {
	Part4 p4 = new Part4();
	p4.findYoutube();
    }

}
