package com.shaojiexu.www;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WholeWeeks {

	public static void main(String... args) {

		WholeWeeks w = new WholeWeeks();
		System.out.println(w.solution(2015, "January", "December", "Wednesday"));

	}

	public int solution(int Y, String A, String B, String W) {

		
		LocalDate startMonday = getFirstMonday(Y, convertToMonth(A));
		LocalDate lastSunday = getLastSunday(Y, convertToMonth(B));
		
		long days = ChronoUnit.DAYS.between(startMonday, lastSunday.plusDays(1));
		int weeks = (int)days / 7;
		return weeks;
	}

	private static LocalDate getLastSunday(int y, int month) {
		
		LocalDate date = null;
		
		if(month != 12){
			
		    date=LocalDate.of(y,month+1, 1);
		    date=date.minusDays(1);
		    
		}else{
			
			date = LocalDate.of(y,month, 31);
		}
		
//	    date=date.minusDays(1);
	    
	    for(int i=date.lengthOfMonth(); i>1;i--){
	    	
	        if("Sunday".equalsIgnoreCase(date.getDayOfWeek().toString())){

	            break;
	            
	        }else{
	        	
	            date=date.minusDays(1);
	        }
	    }

	    System.out.println(date.getDayOfMonth());
	    
	    return date;
	}

	private int convertToMonth(String month) {
		
		switch (month) {
		  case "January":
		       return 1;
		  case "February":
			  	return 2;
		  case "March":
		       return 3;
		  case "April":
			  	return 4;
		  case "May":
		       return 5;
		  case "June":
			  	return 6;
		  case "July":
		       return 7;
		  case "August":
			  	return 8;
		  case "September":
		       return 9;
		  case "October":
			  	return 10;
		  case "November":
		       return 11;
		  case "December":
			  	return 12;
		 default:
		       throw new IllegalArgumentException();
		 }

	}

	private static LocalDate getFirstMonday(int year, int month) {
		
	    LocalDate date=LocalDate.of(year,month, 1);
	    
	    for(int i=0;i<date.lengthOfMonth();i++){
	    	
	        if("Monday".equalsIgnoreCase(date.getDayOfWeek().toString())){

	            break;
	            
	        }else{
	        	
	            date=date.plusDays(1);
	        }
	    }

	    System.out.println(date.getDayOfMonth());
	    
	    return date;
	}
	

}
