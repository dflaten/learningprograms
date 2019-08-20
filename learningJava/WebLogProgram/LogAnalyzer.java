
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
	 records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
	FileResource fr = new FileResource(filename);
	for (String s: fr.lines()){
	    WebLogParser wlp = new WebLogParser();
	    LogEntry newEntry = wlp.parseEntry(s);
	    records.add(newEntry);
	}
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }

     public int countUniqueIPs(){
	 ArrayList<String> uniqueIps = new ArrayList<String>();
	 for (LogEntry curEntry : records){
	     String curIpAddress = curEntry.getIpAddress();
             if(!uniqueIps.contains(curIpAddress)){
		 uniqueIps.add(curIpAddress);
	     }
	 }
	 return uniqueIps.size();
     }

     public void printAllHigherThanNum(int num){
	 for (LogEntry curEntry : records){
	     int curStatusCode = curEntry.getStatusCode();
	     if (curStatusCode > num) {
		 System.out.println(curEntry);
	     }
	 }
     }

     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
	 ArrayList<String> uniqueIPVisits = new ArrayList<String>();
	 for (LogEntry curEntry : records){
	     String curDate = curEntry.getAccessTime().toString();
	     curDate = curDate.substring(4,10);
	     //System.out.println(curDate);
	    // System.out.println(someday);
	     if(someday.equals(curDate)){
		 if (!uniqueIPVisits.contains(curEntry.getIpAddress())){
		 uniqueIPVisits.add(curEntry.getIpAddress());
		 }
	     }
	 }
	 return uniqueIPVisits;
     }

     public int countUniqueIPsInRange(int low, int high){
	 ArrayList<String> uniqueIPs = new ArrayList<String>();
	 for (LogEntry curEntry : records){
	     int curStatusCode = curEntry.getStatusCode();
	     if (curStatusCode > low && curStatusCode < high) {
		 if (!uniqueIPs.contains(curEntry.getIpAddress())){
		      uniqueIPs.add(curEntry.getIpAddress());
		 }
	     }
	 }
	 return uniqueIPs.size();
      }

     public HashMap<String, Integer> countVisitsPerIP(){
	 HashMap<String, Integer> numberVisitsByIP = new HashMap<String, Integer>();
	 for (LogEntry curEntry : records){
             String curIP = curEntry.getIpAddress();
	     System.out.println(curIP);
	     if (numberVisitsByIP.containsKey(curIP)){
		 numberVisitsByIP.put(curIP, numberVisitsByIP.get(curIP) + 1);
	     }
	     else{
		 numberVisitsByIP.put(curIP, 1);
	     }
	 }
	 return numberVisitsByIP;
     }

     public int mostNumberVisitsByIP(HashMap<String, Integer> countVisitsIP){
	int mostNumberVisits = 0;
	for (String key : countVisitsIP.keySet()) {
             if (mostNumberVisits < countVisitsIP.get(key)){
		 mostNumberVisits = countVisitsIP.get(key); 
	     }
	}
        return mostNumberVisits; 
     }

     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> countVisitsIP){
	int mostNumberVisits = mostNumberVisitsByIP(countVisitsIP);
	ArrayList<String> iPsMostVisited = new ArrayList<String>();
	     for (String key : countVisitsIP.keySet()) {
		 if (mostNumberVisits == countVisitsIP.get(key) && !iPsMostVisited.contains(key)){
		     iPsMostVisited.add(key);
		 } 
	     }
	return iPsMostVisited;
     } 
}
