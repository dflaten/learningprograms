
/**
 * Will use data on baby name use to answer questions about the data. 
 * 
 * @discocorg
 * @08-08-19
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class babyNamesProject {
   public void printNames() {
       FileResource fr = new FileResource();
       for (CSVRecord rec : fr.getCSVParser(false)){
	   int numBorn = Integer.parseInt(rec.get(2));
	   if (numBorn <= 100){
	       System.out.println("Name " + rec.get(0) + 
				 " Gender " + rec.get(1) +
				 " Num Born " + rec.get(2));
	   }
       }
   }
   
   public void totalBirths(FileResource fr){
       int totalBorn = 0;
       int totalBoys = 0;
       int totalGirls = 0;
       for (CSVRecord rec : fr.getCSVParser(false)){
	   int numBorn = Integer.parseInt(rec.get(2));
	   totalBorn += numBorn;
	   if (rec.get(1).equals("M")){
	       totalBoys += numBorn;
	   }
	   else {
	       totalGirls += numBorn;
	   }
       }
       System.out.println("total births = " + totalBorn);
       System.out.println("total boy births = " + totalBoys);
       System.out.println("total girl births = " + totalGirls);
   }

   public int getRank(int year, String name, String gender, DirectoryResource dr){
       for (File f : dr.selectedFiles()){
           if (f.getName().contains(Integer.toString(year))){
               FileResource fr = new FileResource(f);
	   int nameRank = 0;
           for (CSVRecord rec : fr.getCSVParser(false)){
	       if (rec.get(1).equals(gender)){
		   nameRank += 1;
                   if (rec.get(0).equals(name)){
		       return nameRank;
		   }
	       }
	   }
	   }
       }
       return -1;
   }

   public String getName(int year, int rank, String gender, DirectoryResource dr){
       for (File f : dr.selectedFiles()){
           if (f.getName().contains(Integer.toString(year))){
               FileResource fr = new FileResource(f);
	   int nameRank = 0;
           for (CSVRecord rec : fr.getCSVParser(false)){
	       if (rec.get(1).equals(gender)){
	       	   nameRank += 1;
                   if (nameRank == rank){
		       return rec.get(0);
		   }
	       }
	   }
	   }
       }
       return "NO NAME";
   }

   public void whatIsNameInYear(String name, int year, int newYear, String gender, DirectoryResource dr){
       int birthYearNameRank = getRank(year,name,gender, dr);
       String newName = getName(newYear, birthYearNameRank, gender, dr);
       System.out.println("If your name was " + name + " in " + year + " your name would be "
	                  + newName + " in " + newYear);
   }

   public int yearOfHighestRank(String name, String gender, DirectoryResource dr){
       int highestNameRank = 0;
       int highestYear = 0;
       for (File f : dr.selectedFiles()){
	   int year = Integer.parseInt(f.getName().substring(3,6));
	   int currentFileNameRank = 0;
	   for (File f1 : dr.selectedFiles()){
	       if (f1.getName().contains(Integer.toString(year))){
		   FileResource fr1 = new FileResource(f1);
	       int nameRank = 0;
	       for (CSVRecord rec : fr1.getCSVParser(false)){
		   if (rec.get(1).equals(gender)){
		       nameRank += 1;
		       if (rec.get(0).equals(name)){
			   currentFileNameRank = nameRank;
		       }
		   }
	       }
	       }
	   }
	   if (currentFileNameRank > highestNameRank) {
               highestYear = year;
	       highestNameRank = currentFileNameRank;
	   }
       }
       if (highestYear == 0){
           return -1;
       }
       else{
	   return highestYear;
       }

   }

   public void testTotalBirths(){
       FileResource fr = new FileResource();
       totalBirths(fr);
   }

   public void testgetRank(){
       DirectoryResource dr = new DirectoryResource();
       int davidRank = getRank(1986, "David", "M", dr); 
       System.out.println("In 1986 the name David for males was rank " + davidRank);
       int david2Rank = getRank(1990, "David", "M", dr); 
       System.out.println("In 1990 the name David for males was rank " + david2Rank);
       int masonRank = getRank(2012, "David", "F", dr); 
       System.out.println("In 2012 the name David for females was rank " + masonRank);
   }

   public void testgetName(){
       DirectoryResource dr = new DirectoryResource();
       String nameAt145 = getName(1986, 145, "F", dr);
       System.out.println("In 1986 the 145th most popular girls name was: "+ nameAt145);
       String nameAt6 = getName(1990, 6, "M", dr);
       System.out.println("In 1990 the 6th most popular boys name was: "+ nameAt6);
   }

   public void testWhatIsNameInYear(){
       DirectoryResource dr = new DirectoryResource();
       whatIsNameInYear("David", 1986, 1990, "M", dr);
   }
   public void testYearOfHighestRank(){
       DirectoryResource dr = new DirectoryResource();
       int myyear = yearOfHighestRank("David", "M", dr);
       System.out.println("David, male, had the highest rank in " + myyear);
   }
}
