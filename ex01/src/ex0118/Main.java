package ex0118;

public class Main {

	public static void main(String[] args) {
		
		int POINT = 90;
		int AVERAGE = 80;
		int STANDARD_DEVIATION = 10;
		int NUM_OF_STUDENT = 400;
		
		double percentage = (POINT - AVERAGE) / STANDARD_DEVIATION;
		percentage = 0.5 - getNormalDistribution(percentage);
		
		System.out.println((int)(NUM_OF_STUDENT * percentage));

	}
	
	private static double getNormalDistribution(double percentage) {
		if(percentage == 1.0) {
			return 0.3413;
		}
		
		return 0;
	}

}
