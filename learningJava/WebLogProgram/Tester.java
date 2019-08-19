
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
	LogAnalyzer test = new LogAnalyzer();
	test.readFile("/Users/dflaten/Projects/learningprograms/learningJava/WebLogProgram/short-test_log");
	test.printAll();
	System.out.println("Unique IPs: " + test.countUniqueIPs());
	test.printAllHigherThanNum(300);
	ArrayList<String> uniqueIPVisits = test.uniqueIPVisitsOnDay("Sep 30");
	System.out.println("Should be 4, is: " + uniqueIPVisits.size());
	System.out.println("Should be 2, is: " + test.countUniqueIPsInRange(300,399));
    }
    
   
}
