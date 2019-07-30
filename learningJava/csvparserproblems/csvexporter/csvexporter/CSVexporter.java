/**
 * countryInfo
 * Take a csvparser and String(Country) and return information from the 
 * csv about the country if it is found, if not found return "Not Found"
 * 
 * Method 2:
 * Take a csvparser and String(export item) and return the number of
 * countries that export that item
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVexporter {
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record: parser){
	    String countryinfo = record.get("Country");
	    if (countryinfo.contains(country)){
		String exports = record.get("Exports");
		String value = record.get("Value (dollars)");
		return country + ": " + exports + ": " + value; 
	    }
	}
	return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
        for (CSVRecord record: parser){
	    String exports = record.get("Exports");
	    if (exports.contains(exportitem1) && exports.contains(exportitem2)){
		String country = record.get("Country");
		System.out.println(country);
	    }
	}
    }

    public Integer numberOfExporters(CSVParser parser, String exportitem){
	Integer countExporters = 0;
        for (CSVRecord record: parser){
	    String exports = record.get("Exports");
	    if (exports.contains(exportitem)){ 
		countExporters++;
	    }
	}
	return countExporters;
    }

    public void bigExporters(CSVParser parser, String ammount){
        for (CSVRecord record: parser){
	    String value = record.get("Value (dollars)");
	    if (value.length() > ammount.length()){
		String country = record.get("Country");
		System.out.println(country + " " + value );
	    }
	}
    }

    public void testing(){
	FileResource fr = new FileResource();
	CSVParser parser = fr.getCSVParser();
	//Call countryInfo
	String countryinfo = countryInfo(parser, "Malawi");
	System.out.println(countryinfo);
	//Call listExportersTwoProducts
	CSVParser parser2 = fr.getCSVParser();
	listExportersTwoProducts(parser2, "coffee", "tea");
	//Call numberOfExporters
	CSVParser parser3 = fr.getCSVParser();
	Integer theNumber = numberOfExporters(parser3, "coffee");
	System.out.println(theNumber);
	//Call bigExporters
	CSVParser parser4 = fr.getCSVParser();
	bigExporters(parser4, "$1,000,000,000");
    }


    public static void main (String[] args) {
	CSVexporter csv = new CSVexporter();
	csv.testing();
    }

}
