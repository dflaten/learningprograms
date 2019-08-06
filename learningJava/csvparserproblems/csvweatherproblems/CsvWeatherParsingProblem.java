
/**
 * Write a description of CsvWeatherParsingProblem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CsvWeatherParsingProblem {

    public CSVRecord coldestHourInFile(CSVParser parser){
	CSVRecord coldest = null;
	for (CSVRecord currentRow: parser){
	    if (coldest == null){
		coldest = currentRow;
	    }
	    else {
		double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
		double lowestTemp = Double.parseDouble(coldest.get("TemperatureF"));

		if (currentTemp == -9999){
		    //Do nothing
		    }
		else if (currentTemp < lowestTemp){
		    lowestTemp = currentTemp;
		}
	    }
	}
	return coldest;
    }

    public String fileWithColdestTemperature (){
        DirectoryResource dr = new DirectoryResource();
	    File coldestday = null;
	for (File f : dr.selectedFiles()){
	    FileResource fr = new FileResource(f);
	    CSVParser parser = fr.getCSVParser();
	    CSVRecord coldesthour = coldestHourInFile(parser);
	    if (coldestday == null){
		coldestday = f;
	    }
	    else {
		FileResource frcoldest = new FileResource(coldestday);
		CSVParser coldestparser = frcoldest.getCSVParser();
		CSVRecord coldestdaycoldesthour = coldestHourInFile(coldestparser);
		double currentFileColdest = Double.parseDouble(coldesthour.get("TemperatureF"));
		double coldesthour_coldestday = Double.parseDouble(coldestdaycoldesthour.get("TemperatureF"));

		if (currentFileColdest < coldesthour_coldestday){
		    coldestday = f;
		}
	    }
	}
	return coldestday.getName();
    }

    public void testColdestHourInFile() {
	FileResource fr = new FileResource("/Users/davidflaten/Desktop/nc_weather/2013/weather-2013-07-01.csv");
	CSVParser parser = fr.getCSVParser();
	CSVRecord coldestrow = coldestHourInFile(parser);
	System.out.println("coldest hour in file  was " + coldestrow.get("DateUTC")+ " with a temperature of " + coldestrow.get("TemperatureF"));

    }

    public void testFileWithColdestTemperature(){
        System.out.println("File with coldest temperature in a day " + fileWithColdestTemperature());
    }

}
