/*
 * The radius of the circle in this program is 50
 * This means that random numbers generated in this program
 * to serve as coordinates need to be between -50 and 50, inclusive
 */
import java.util.Random;
import java.util.Scanner;

public class PiApproximator {
	
	private static final int RADIUS = 50;						//Radius of circle on coordinate system whose center is at point (0,0)
	private static final int COORDINATES = 1000000;				//Number of coordinates used in this code
	private static Scanner inputC = new Scanner(System.in);		//I'll probably never use this but what the hell
	private static Random randomGenerator = new Random();
	
	/*Implements geometric "Distance Formula"*/
	public static double distanceFromOrigin(double x, double y) {
		
		/*Second point is origin, so no need to subtract x's and y's*/
		double xSquared = Math.pow(x, 2);
		double ySquared = Math.pow(y, 2);
		
		return (Math.sqrt(xSquared + ySquared));
		
	}

	public static void main(String[] args) {
		
		/*Declare relevant variables and objects*/
		int[][] coordinateList = new int[COORDINATES][2];		//each row represents a coordinate (first column = x, second column = y)
		int coordinatesInsideCircle = 0;	
		int coordinatesOutsideCircle = 0;
		double ratio = 0.0;										//points inside circle divided by total points
		double piValue;											//calculated later (ratio * 4)
		
		/*Populate coordinate list*/
		for(int i = 0; i < coordinateList.length; ++i) {
			/*These values will serve as x and y values of current coordinate of coordinateList*/
			int randomXValue = randomGenerator.nextInt(RADIUS * 2 + 1) - RADIUS;
			int randomYValue = randomGenerator.nextInt(RADIUS * 2 + 1) - RADIUS;
			
			/*assign randomXValue and randomYValue*/
			coordinateList[i][0] = randomXValue;
			coordinateList[i][1] = randomYValue;
			
		}
		
		for(int i = 0; i < coordinateList.length; ++i) {
			/*Calculate distance of current point, update coordinatesInside/OutsideCircle variable(s)*/
			double currentDistance = distanceFromOrigin(coordinateList[i][0], coordinateList[i][1]);
			
			boolean insideCircle = (currentDistance < ((double) RADIUS));
			if(insideCircle) {
				++coordinatesInsideCircle;
			}else {
				++coordinatesOutsideCircle;
			}
		}
		
		ratio = ((double)coordinatesInsideCircle) / (coordinatesOutsideCircle + coordinatesInsideCircle);
		piValue = ratio * 4;
		
		System.out.println("PI VALUE:  " + piValue);

	}
}
