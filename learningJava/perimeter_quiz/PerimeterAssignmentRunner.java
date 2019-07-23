import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints = 0;
        for (Point p: s.getPoints()) {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
	double totalPer = getPerimeter(s);
	int numPoints = getNumPoints(s);
	double averageLength = totalPer / numPoints;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
	double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
            for (Point currPt : s.getPoints()) {
                // Find distance from prevPt point to currPt 
                double currDist = prevPt.distance(currPt);
        	if (currDist > largestSide) {
        	    largestSide = currDist;
        	}
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
	double largestX = 0.0;
        for (Point currPt : s.getPoints()) {
	        
	    if (currPt.getX() > largestX) {
		largestX = currPt.getX();
	    }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
	DirectoryResource dr = new DirectoryResource();
	double bPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
	    Shape s = new Shape(fr);
	    double sPerimeter = getPerimeter(s); 
	    if (sPerimeter > bPerimeter) {
		bPerimeter = sPerimeter;
	    }
        }
        return bPerimeter;
    }

    public String getFileWithLargestPerimeter() {
	DirectoryResource dr = new DirectoryResource();
	double bPerimeter = 0.0;
	File fileLargest = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
	    Shape s = new Shape(fr);
	    double sPerimeter = getPerimeter(s); 
	    if (sPerimeter > bPerimeter) {
		bPerimeter = sPerimeter;
		fileLargest = f;
	    }
        }
        return fileLargest.getName();
	    
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + getNumPoints(s));
        System.out.println("average distance between points= " + getAverageLength(s));
        System.out.println("largest side= " + getLargestSide(s));
        System.out.println("largest X= " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        double biggestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("biggest perimeter in files = " + biggestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
	String biggestPerimeterFile = getFileWithLargestPerimeter();
        System.out.println("file with biggest perimeter in files = " + biggestPerimeterFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
	pr.testPerimeterMultipleFiles();
	pr.testFileWithLargestPerimeter();
    }
}

