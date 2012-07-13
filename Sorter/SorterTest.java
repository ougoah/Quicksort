package Sorter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;
import org.junit.Assert.*;


public class SorterTest {

	@Test
	public void test() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(out, true);
		System.setOut(p);
		Random rand = new Random();
		int numNumbers = rand.nextInt(10000)+1;
		int[] expected = new int[numNumbers];
		int[] actual = new int[numNumbers];
		String input = "";
		for(int i=0; i< numNumbers; ++i){
			expected[i] = rand.nextInt();
			input += expected[i]+" "; 
		}
		Sorter.main(input.trim().split(" "));
		
		Arrays.sort(expected);
		
		for(int i=0; i<expected.length/2; ++i){
			// swap i and it's other side because arrays.sort sorts it the other way
			int temp = expected[i];
			expected[i] = expected[(expected.length-1)-i];
			expected[(expected.length-1)-i] = temp;
		}
		
		Scanner in = new Scanner(out.toString());
		String output = in.nextLine();
		output = output.replace("[", "");
		output = output.replace("]", "");
		output = output.replaceAll(" ", "");
		String[] outputArr = output.split(",");
		for(int i=0; i < outputArr.length; ++i){
			actual[i] = Integer.parseInt(outputArr[i]);
		}
		assertArrayEquals(expected, actual);
	}

}