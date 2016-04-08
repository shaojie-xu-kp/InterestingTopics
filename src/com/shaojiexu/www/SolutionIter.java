package com.shaojiexu.www;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionIter implements Iterable<Integer> {

	public static void main(String... args) {

		for (Integer x : new SolutionIter()) {
			System.out.println(x);
		}
	}

	
	private String alphabet_pattern = ".*[a-zA-Z]+.*";
	
	private char plus = '+';
	
	private int min = -1_000_000_000;
	
	private int max = 1_000_000_000;

	public SolutionIter(Reader inp) {

	}

	public SolutionIter() {

	}

	@Override
	public Iterator<Integer> iterator() {

		List<Integer> numbers = new ArrayList<>();

		try {

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			
			String thisLine = null;

			while ((thisLine = br.readLine()) != null) {
				
				thisLine = thisLine.trim();
				
				int number = 0;
				
				if(thisLine.matches(alphabet_pattern)){
					continue;
				}
				
				if(countOccurrences(thisLine, plus) > 1) {
					continue;
				}
				
				if(containsBlank(thisLine)) {
					continue;
				}

				if(leadingZero(thisLine)) {
					continue;
				}
				
				try {
					
					number = Integer.parseInt(thisLine);
					
					if(withInRange(number)){
//						System.out.println(number);
						numbers.add(number);
					}
					
				} catch (NumberFormatException e) {
					continue;
				}			
				

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return numbers.iterator();
	}
	
	private boolean leadingZero(String thisLine) {
		
		try{
			
			int digit = Integer.parseInt(thisLine.substring(0, 1));
			
			if( digit == 0) {
				return true;
			}
			
		}catch(NumberFormatException e) {
			
			return false;
			
		}
		
		return false;
	}

	public static int countOccurrences(String line, char needle)
	{
	    int count = 0;
	    for (int i=0; i < line.length(); i++)
	    {
	        if (line.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
	
	public static boolean containsBlank(String line){
		
    	Pattern pattern = Pattern.compile("\\s");
    	Matcher matcher = pattern.matcher(line);
    	boolean found = matcher.find();

    	return found;
	}
	
	public boolean withInRange(int i){
		
		if(i >= min && i <= max){
			return true;
		}
		
		return false;
	}
	

	

}
