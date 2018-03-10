package com.kuwy.kds.utility;

import java.util.Scanner;

public class empbus {
	public static void main(String[] args) {
	      // declare and initialize variables
		
	     String emp;
	      double rate = 0;
	    
	      int percentage=5;
	      String instructions = "This program calculates ratng\n"
	                          + "based on emp.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the Pan response" );
	      emp = input.nextLine();

	      System.out.println(); // print blank line

	      // process data
	      if( emp.equals("Tier 1 Company Employer (Pvt)"))
	    	  rate = percentage*1.0/10;
	      else if( emp.equals("Tier 2 Company Employer (Pvt)"))
	    	  rate = percentage*0.9/10;
	      else if( emp.equals("Tier 3 Company Employer"))
	    	  rate = percentage*0.8/10;
	      else if( emp.equals("Government"))
	    	  rate = percentage*1.0/10;
	      else if( emp.equals("Startup"))
	    	  rate = percentage*0.8/10;
	      else if( emp.equals("Business- Annual Returns Filed & GST Available"))
	    	  rate = percentage*1.0/10;
	      else if( emp.equals("Business - Annual Returns Not Filed & GST NA"))
	    	  rate = percentage*0.6/10;
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } 
}
