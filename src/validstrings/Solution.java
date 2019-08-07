package validstrings;

/**
 * Problem 
 *
 *   Sherlock considers a string to be valid if all characters of the string appear the same 
 *   number of times. It is also valid if he can remove just 1 character at 1 index in the 
 *   string, and the remaining characters will occur the same number of times. Given a string 
 *   s, determine if it is valid. If so, return YES, otherwise return NO.
 *   
 *   For example, if s = abc, it is a valid string because frequencies are {a:1,b:1,c:1}. 
 *   So is s = abcc because we can remove one c and have 1 of each character in the remaining 
 *   string. If s= abccc however, the string is not valid as we can only remove 1 occurrence 
 *   of c. That would leave character frequencies of (a:1, b:1,c:2).
 *   
 * Function Description
 * 
 *   Complete the isValid function in the editor below. It should return either the string YES 
 *   or the string NO.
 *   
 *   isValid has the following parameter(s):
 *   - s: a string
 *   
 * Input Format
 * 
 *   A single string s.
 *   
 * Constraints
 * 
 *   - 1 <= |s| <= 10 pow 5
 *   - Each character s[i] belongs to the set ascii[a-z] 
 * 
 * Output Format
 * 
 *    Print YES if string  is valid, otherwise, print NO.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

		String valid = "YES";
    	
    	// Count occurrences of each character
    	char[] chars = s.toCharArray();
    	Map<Character,Integer> charMap = new HashMap<>(26);
    	for (char c :chars) {
    		charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    	}

    	// Count frequency of each count total
    	Map<Integer,Integer> charFrequencyMap = new HashMap<>(26);
    	Iterator<Integer> charCountIterator = charMap.values().iterator();
		System.out.print("Char counts: ");
    	while (charCountIterator.hasNext()) {
    		Integer count = charCountIterator.next();
    		System.out.print(count + ",");
    		charFrequencyMap.put(count, charFrequencyMap.getOrDefault(count, 0) + 1);
    	}
		System.out.println();
    	
    	// Count number of frequencies occurring.
		// Also count how many frequencies occur more than once.
    	Iterator<Integer> charFrequencyIterator = charFrequencyMap.values().iterator();
    	int frequency = 0;
    	int frequencies = 0;
    	int frequenciesOccurringMoreThanOnce = 0;
		System.out.print("Frequencies: ");
    	while (charFrequencyIterator.hasNext()) {
    		frequency = charFrequencyIterator.next();
    		System.out.print(frequency + ",");
    		frequencies++;
    		if (frequency > 1) {
    			frequenciesOccurringMoreThanOnce++;
    		}
    	}
		System.out.println();

		// Check count frequency data to determine if string is valid.

		if (valid.equals("YES")) {
			// If there are more than 2 frequencies, then invalid.
			// - e.g. aaabbc = (3,1),(2,1),(1,1))
			if (frequencies > 2) {
	    		valid = "NO";
	    	}
		}

		if (valid.equals("YES")) {
			// If there are more than 1 frequency with 2 or more occurrences, then invalid.
			// - e.g aabbcd = (2,2),(1,2), then invalid.
			if (frequenciesOccurringMoreThanOnce > 1) {
	    		valid = "NO";
	    	}
		}
		
		if (valid.equals("YES")) {
			// If there are 2 frequencies (e.g. aaabc = (3,1),(1,2)),
			//   and the difference between the frequency values is more than 1 (e.g. 3 - 1 > 1) 
			//       provided there is no frequency of 1 which only occurs once, i.e (1,1),
			// then invalid.
			if (frequencies == 2) {
				// Extract values from the HashMap into Collection
				Collection<Integer> collection = charMap.values();
				// Convert the Collection to an Array
				Integer[] ints = collection.toArray(new Integer[collection.size()]);
				// Process array calculating differences between frequencies.
				for (int i = 0; i < ints.length; i++) {
					Integer left = ints[i];
					for (int j = i+1; j < ints.length; j++) {
						Integer right = ints[j];
						System.out.print(Math.abs(left - right) + ",");
						if ((Math.abs(left - right) > 1) 
						 && (charFrequencyMap.getOrDefault(1, 0) != 1)) {
				    		valid = "NO";
						}
					}
				}
				System.out.println();
			}
		}
    	
    	System.out.println(valid);
    	return valid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));
	    
        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
