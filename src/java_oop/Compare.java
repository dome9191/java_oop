package java_oop;
import java.util.*;
import java.io.*;

public class Compare
{
	public static void main(String[] args) throws IOException
	    {
	        Scanner keyboard = new Scanner(System.in);
	        System.out.print("Enter first file's name: ");
	        String file1 = keyboard.next();
	        System.out.print("Enter second file's name: ");
	        String file2 = keyboard.next();
	        System.out.println(" ");
	        File inputFile1 = new File(file1);
	        Scanner infile1 = new Scanner(inputFile1);
	        File inputFile2 = new File(file2);
	        Scanner infile2 = new Scanner(inputFile2);
	        compareFiles(infile1,infile2);
	    }
	public static void compareFiles(Scanner infile1, Scanner infile2) throws IOException
	        {
	                int counter = 0;
	                String line1 = readFrom(infile1);
	                String line2 = readFrom(infile2);
	                int answer_plus = line1.compareTo(line2);
	                    if(answer_plus != 0)
	                    {
	                        System.out.println("Difference found:");
	                        printLine("<",line1);
	                        printLine(">",line2);
	                        counter++;
	                    }
	                while(infile1.hasNextLine() || infile2.hasNextLine())
	                {
	                   if(infile1.hasNextLine())
	                   {
	                    	line1=readFrom(infile1);
	                   }
	                   if(infile2.hasNextLine())
	                   {
	                    	line2=readFrom(infile2);
	                   }
	                    int answer = line1.compareTo(line2);
	                    if(answer != 0)
	                    {
	                        System.out.println("Difference found:");
	                        printLine("<",line1);
	                        printLine(">",line2);
	                        counter++;
	                    }
	                }
	                if(counter == 0)
	                {
	                	System.out.println("The test passed");
	                }
	                else
	                {
	                	System.out.println("The test failed");
	                }
	        }
	        public static String readFrom(Scanner infile) throws IOException
	        {
	            String line = infile.nextLine();
	            if(line==null)
	            return null;
	            else
	            return line;
	        }
	        public static void printLine(String prefix, String line)
	        {
	            System.out.println(prefix + line);
	        }
	    }

