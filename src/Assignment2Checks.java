import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Assignment2Checks {

	public static String getOutputAsString(Runnable r) {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
		// Print some output: goes to your special stream
		r.run();
		// Put things back
		System.out.flush();
		System.setOut(old);

		return baos.toString();
	}

	public static void checkProblem1(int numStars) {

		String expected = "";
		for (int i = 0; i < numStars; i++) {
			for (int j = 0; j < numStars - i; j++) {
				expected += "*";
			}
			expected += "\n";
		}

		for (int i = numStars - 1; i >= 0; i--) {
			for (int j = 0; j < numStars - i; j++) {
				expected += "*";
			}
			expected += "\n";
		}

		String actual = getOutputAsString(() -> {
			RecursiveMethods.printStars(numStars);
		});

		if (expected.equals(actual)) {
			System.out.println("Problem 1 passed the check!");

		} else {
			System.out.println("printStars failed!");
			System.out.println("Expected: ");
			System.out.println("------------------------------\n");
			System.out.println(expected);
			System.out.println("\n------------------------------\n");

			System.out.println("Actual: ");
			System.out.println("------------------------------\n");
			System.out.println(actual);
			System.out.println("\n------------------------------\n\n");

			System.out.println("Test Data: ");
			System.out.println("------------------------------\n");
			System.out.println("input = " + numStars);
			System.out.println("\n------------------------------\n\n");

		}

	}

	public static void checkProblem2(int base, int exponent) {

		int actual = RecursiveMethods.power(base, exponent);
		int expected = (int) Math.pow(base, exponent);

		if (expected == actual) {
			System.out.println("Problem 2 passed the check!");

		} else {
			System.out.println("power failed!");
			System.out.println("Expected: ");
			System.out.println("------------------------------\n");
			System.out.println(expected);
			System.out.println("\n------------------------------\n");

			System.out.println("Actual: ");
			System.out.println("------------------------------\n");
			System.out.println(actual);
			System.out.println("\n------------------------------\n\n");

			System.out.println("Test Data: ");
			System.out.println("------------------------------\n");
			System.out.println("base = " + base);
			System.out.println("exponent = " + exponent);
			System.out.println("\n------------------------------\n\n");

		}
	}

	public static void checkProblem3() {
		char[][] actual = { 
					{ '*', '-', '-', '-', '-' }, 
					{ '*', '-', '*', '*', '-' }, 
					{ '*', '-', '-', '*', '-' },
					{ '*', '*', '*', '*', '-' }, 
					{ '-', '-', '-', '-', '*' }, 
				};
		
		String initial = "";
		for (int i = 0; i < actual.length; i++) {
			for (int j = 0; j < actual[i].length; j++)
				initial += actual[i][j];
			initial += '\n';
		}
		
		RecursiveMethods.showMines(actual, 3, 2);
		
		char[][] expected = { 
				{ '*', '3', '2', '2', '1' }, 
				{ '*', '4', '*', '*', '2' }, 
				{ '*', '6', '6', '*', '3' },
				{ '*', '*', '*', '*', '3' }, 
				{ '-', '-', '-', '-', '*' }, 
			};
		
		
		String actualAsString = "";
		for (int i = 0; i < actual.length; i++) {
			for (int j = 0; j < actual[i].length; j++)
				actualAsString += actual[i][j];
			actualAsString += '\n';
		}
		
		String expectedAsString = "";
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[i].length; j++)
				expectedAsString += expected[i][j];
			expectedAsString += '\n';
		}
		
		if (Arrays.deepEquals(actual, expected))
			System.out.println("Problem 4 passed the check!");
		else {
			System.out.println("showMines failed!");
			System.out.println("Expected: ");
			System.out.println("****************************\n");
			System.out.println(expectedAsString);
			System.out.println("\n****************************\n");
	
			System.out.println("Actual: ");
			System.out.println("****************************\n");
			System.out.println(actualAsString);
			System.out.println("\n****************************\n\n");
	
			System.out.println("Test Data: ");
			System.out.println("****************************\n");
			System.out.println(initial);
			System.out.println("\n****************************\n\n");
		}
	}
}