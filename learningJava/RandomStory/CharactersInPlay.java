/**
 * Counts occurences of characters in the play
 * 
 * @discocorg
 * @08.15.19
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> characterName;
    private ArrayList<Integer> nameOccurences;

    public CharactersInPlay(){
       characterName = new ArrayList<String>();
       nameOccurences = new ArrayList<Integer>();
    }

    public void update(String person){
	person = person.toLowerCase();
	int index = characterName.indexOf(person);
	if (index == -1){
	    characterName.add(person);
	    nameOccurences.add(1);
        } 
        else {
           int value = nameOccurences.get(index);
           nameOccurences.set(index, value+1);
        }
    }

    public void findAllCharacters(){
       FileResource fr = new FileResource();
       characterName.clear();
       nameOccurences.clear();
       for (String line : fr.lines()){
	   line = line.toLowerCase();
	   if (line.indexOf('.') != -1) {
	       update(line.substring(0,line.indexOf('.')));
	       }
	   }
    }

    public void tester(){
	findAllCharacters();
	for (int k = 0; k<characterName.size(); k++){
	    if(nameOccurences.get(k)>=2){ 
		System.out.println(nameOccurences.get(k) + "\t" + characterName.get(k));
	    }
	}
	//System.out.println("The word that appears most often and it's count are, " + findIndexOfMax() + " " +myWords.get(myFreqs.indexOf(findIndexOfMax())));

    }
    
}
