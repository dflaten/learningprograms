
/**
 * Counts the words in a number of files.
 * 
 * @discocorg
 * @08.17.19
 */
import java.util.*;
import java.io.*;
import edu.duke.*;

public class WordsInFiles {
    private HashMap<String,ArrayList<String>> fileMap;
    
    public WordsInFiles(){
	fileMap = new HashMap<String,ArrayList<String>>();
    }

    public void addWordsFromFile(File f){
	FileResource fr = new FileResource(f);
	for (String word : fr.words()) {
	    if(fileMap.containsKey(word)) {
		ArrayList<String> curFileList = fileMap.get(word);
		if(!curFileList.contains(f.getName())) {
		    curFileList.add(f.getName());
		}
	    }
	    else {
		ArrayList<String> newList = new ArrayList<String>();
	        newList.add(f.getName());	
                fileMap.put(word, newList); 
	    }
	    
        }
    }

    public void buildWordFileMap(){
	fileMap.clear();
	DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
	    addWordsFromFile(f);
	}
    }

    public int maxNumber(){
	int maxNumber = 0;
	for (String w: fileMap.keySet()){
	    ArrayList<String> curFileList = fileMap.get(w);
            int  curNurFiles = curFileList.size();
	    if (curNurFiles > maxNumber) {
		maxNumber = curNurFiles;
	    }
	}
	return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordsInFiles = new ArrayList<String>();
	for (String w: fileMap.keySet()){
	    if (fileMap.get(w).size() == number){ 
	        wordsInFiles.add(w);
	    }
	}
	return wordsInFiles;
    }

    public void printFilesIn(String word){
	for(String f : fileMap.get(word)){
	    System.out.println(f);
	}
    }

    public void tester(){
	buildWordFileMap();
        int maxNumber = maxNumber();
	ArrayList<String> mywords = wordsInNumFiles(maxNumber);
 	for (String word: mywords){
	    System.out.println("Files that have the word \"" + word + "\" in them:");
 	    printFilesIn(word);
 	}
    }
}
