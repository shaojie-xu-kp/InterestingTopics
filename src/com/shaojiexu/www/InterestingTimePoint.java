package com.shaojiexu.www;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class InterestingTimePoint {
	
	
	private static final String BASE_TIME = "1985-09-20 ";
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private static final String SEPRATOR = ":";
	
	
	 public int solution(String S, String T) {
		 
		 int count = 0;
		 LocalDateTime dateTimeS = LocalDateTime.parse(BASE_TIME + S, formatter);
		 LocalDateTime dateTimeT = LocalDateTime.parse(BASE_TIME + T, formatter);

		 long seconds = ChronoUnit.SECONDS.between(dateTimeS, dateTimeT);
		 String timeString = null;
		 for(int i = 0 ; i <= seconds; i++) {
			 timeString =  dateTimeS.plusSeconds(i).format(DateTimeFormatter.ISO_LOCAL_TIME).toString();
			 if(isInterestingTimeStamp(timeString)) {
				 System.out.println(timeString);
				 count ++;
			 }
		 }
		 
		 	return count;
	    }
	 
	 
	 private boolean isInterestingTimeStamp(String timeString) {
		 
		String[] sts =  timeString.split(SEPRATOR);
		Set<Integer> digits = new HashSet<Integer>();
		
		
		for(String st : sts) {
			digits.add(Character.getNumericValue(st.charAt(0)));
			digits.add(Character.getNumericValue(st.charAt(1)));
		}
		
		return digits.size() <= 2;
	}


	 public static void main(String ... args){
		 InterestingTimePoint itp = new InterestingTimePoint();
		 System.out.println(itp.solution("15:15:00", "15:15:12"));
		 System.out.println(itp.solution("22:22:21", "22:22:22"));

	 }

}
