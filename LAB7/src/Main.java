public class Main {

    public static void main(String[] args) {
        long iterations = 10000000;
        int threads = 20;
	    MonteCarloSimulation pi = new MonteCarloSimulation(threads, iterations);
	    double piValue = 0;
	    try {
            piValue = pi.CalculatePi();
        }
	    catch (Exception e) {
	        System.out.println(e.getMessage());
        }

	    System.out.println("Calculated pi value: " + piValue);
	    System.out.println("Point inside a cycle quarter: " + pi.GetSuitablePoints());
	    System.out.println("Done iterations: " + pi.GetIterations());
    }
}
