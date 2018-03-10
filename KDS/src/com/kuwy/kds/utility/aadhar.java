package com.kuwy.kds.utility;

import java.util.Scanner;

public class aadhar {
	public static void main(String[] args) {
	      // declare and initialize variables
		
	     String aadhar;
	      double rate = 0;
	    
	      int percentage=5;
	      String instructions = "This program calculates ratng\n"
	                          + "based on aadhar.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the aadhar" );
	      aadhar = input.nextLine();

	      System.out.println(); // print blank line

	      // process data
	      if( aadhar.equals("Available-API Verified"))
	    	  rate = percentage*1.0/10;
	      else if( aadhar.equals("Not Verified"))
	    	  rate = percentage*0.6/10;
	      else if( aadhar.equals("Available - API Authenticated "))
	    	  rate = percentage*1.0/10;
	      else if( aadhar.equals("Aadhaar Not Available"))
	    	  rate = percentage*0.2/10;
	      else if( aadhar.equals("Fake Aadhaar"))
	    	  rate = percentage*0.1/10;
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } 
}
