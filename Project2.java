import java.util.*;
import java.io.*;

public class Project2 {

 	public static void main (String[] args)
 	{
     	//loops for user input
     	while (true)
     	{
         	BufferedReader in = null;
         	Scanner input = new Scanner(System.in);
         	//catches file errors based on user input
         	try
         	{
             	System.out.println("Enter the name of the file: ");
             	String filename = input.nextLine();
             	in = new BufferedReader(new FileReader(filename));
             	String line = in.readLine();
             	StringTokenizer st = new StringTokenizer(line, ",");
             	int size = st.countTokens();
             	int values[] = new int[size];
             	for (int i = 0; i < size; i++)
             	{
                 	values[i] = Integer.parseInt(st.nextToken());
             	}
             	//creates user command line menu
             	System.out.println("Which method would you like to run? Enter:");
             	System.out.println("a to run threeLoops");
             	System.out.println("b to run twoLoops");
             	System.out.println("c to run recursiveSequence");
             	System.out.println("d to run oneLoop");
             	System.out.println("e to run all 4 algorithms from a-d");
             	String answer = input.nextLine();
             	if (answer.equalsIgnoreCase("a"))
                 	threeLoops(values);
             	else if (answer.equalsIgnoreCase("b"))
                 	twoLoops(values);
             	else if (answer.equalsIgnoreCase("c"))
                 	recursiveSequence(values);
             	else if (answer.equalsIgnoreCase("d"))
                 	oneLoop(values);
             	else
             	{
                 	threeLoops(values);
                 	twoLoops(values);
                 	recursiveSequence(values);
                 	oneLoop(values);
             	}
         	}
         	catch (FileNotFoundException e)
         	{
             	System.out.println("File is not found in the current directory.");
         	}
         	catch (IOException e)
         	{
             	System.out.println(e.getMessage());
         	}
         	finally
         	{
             	if (in != null)
             	{
                 	try
                 	{ in.close();
                 	}
                 	catch (IOException e)
                 	{
                    	System.out.println("Error Closing");
                 	}
            	}
             	System.out.println("Would you like to run the program again? y for yes n for no");
             	String answer = input.nextLine();
             	if (answer.equalsIgnoreCase("n"))
             	{
                 	break;
             	}
         	}
     	}
 	}

 	public static void threeLoops(int[] values)
 	{
     	//starts timing, repeated in each function.
     	long totalTime = 0;
     	int maxSum = 0;
     	for (int z = 0; z < 50; z++)
     	{
     	long start = System.nanoTime();
     	int n = values.length;
     	maxSum = 0;
     	for (int i = 0; i < n; i++)
     	{
         	for (int j = i; j < n; j++)
         	{
             	int sum = 0;
             	for (int k = i; k <= j; k++) {
                 	sum += values[k];
             	}
             	if (sum > maxSum)
                 	maxSum = sum;
         	}
     	}
     	//ends timer, repeated in each function.
     	long end = System.nanoTime();
    	totalTime += (end - start);
     	}
     	System.out.println("threeLoops results:");
     	System.out.println("Average Execution Time: " + totalTime/50.0 + " nanoseconds");
     	System.out.println("Max Sum: " + maxSum);

 	}

 	public static void twoLoops(int[] values)
 	{
     	long totalTime = 0;
     	int maxSum = 0;
     	for (int z = 0; z < 50; z++)
     	{
     	long start = System.nanoTime();
     	int n = values.length;
     	maxSum = 0;
     	for (int i = 0; i < n; i++)
     	{
         	int sum = 0;
         	for (int j = i; j < n; j++)
         	{
             	sum += values[j];
             	if (sum > maxSum)
                 	maxSum = sum;
         	}
     	}
     	long end = System.nanoTime();
     	totalTime += (end - start);
     	}
     	System.out.println("twoLoops results:");
     	System.out.println("Average Execution Time: " + totalTime/50.0 + " nanoseconds");
     	System.out.println("Max Sum: " + maxSum);
 	}

 	public static void oneLoop(int[] values)
 	{
     	long totalTime = 0;
     	int maxSum = 0;
     	for (int z = 0; z < 50; z++)
     	{
     	long start = System.nanoTime();
     	int n = values.length;
     	maxSum = 0;
     	int sum = 0;
     	for (int i = 0; i < n; i++)
     	{
         	sum += values[i];
         	if (sum > maxSum)
             	maxSum = sum;
         	else
             	if (sum < 0)
                 	sum = 0;
     	}
     	long end = System.nanoTime();
     	totalTime += (end - start);
     	}
     	System.out.println("oneLoop results:");
     	System.out.println("Average Execution Time: " + totalTime/50.0 + " nanoseconds");
    	System.out.println("Max Sum: " + maxSum);
 	}

 	public static void recursiveSequence(int[] values)
 	{
     	int max = 0;
     	long totalTime = 0;
     	for (int z = 0; z < 50; z++)
    	{
         	long start = System.nanoTime();
         	max = recursiveSum(values);
         	long end = System.nanoTime();
         	totalTime += end - start;
     	}
     	System.out.println("recursiveSequence results:");
     	System.out.println("Average Execution Time: " + totalTime/50.0 + " nanoseconds");
     	System.out.println("Max Sum: " + max);
 	}

 	public static int recursiveSum(int[] values)
 	{
     	if (values.length == 1)
         	return values[0];
     	int[] leftValues = new int[values.length / 2];
     	int[] rightValues = new int[(values.length + 1) / 2];
     	for (int i = 0; i < values.length; i++)
     	{
         	if (i < leftValues.length)
            	leftValues[i] = values[i];
         	else
             	rightValues[i - values.length/2] = values[i];
     	}
     	//recursive calls
     	int maxLeftSum = recursiveSum(leftValues);
     	int maxRightSum = recursiveSum(rightValues);
     	int maxLeftBound = 0;
     	int maxRightBound = 0;
     	int sum = 0;

     	// get maxLeftBound
     	for (int j = values.length/2; j < values.length; j++)
     	{
         	sum += values[j];
         	if (sum > maxRightBound)
            	maxRightBound = sum;
     	}

     	// get maxRightBound
     	sum = 0;
     	for (int k = values.length/2 - 1; k >= 0; k--)
     	{
        	sum += values[k];
        	if (sum > maxLeftBound)
             	maxLeftBound = sum;
    	}

     	return Math.max(Math.max(maxLeftSum, maxRightSum), (maxLeftBound + maxRightBound));

 	}

} //end of class

