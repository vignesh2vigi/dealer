package com.kuwy.kds.utility;

import java.util.Scanner;

public class pan {
	
	public static void main(String[] args) {
	      // declare and initialize variables
		
	     String panout;
	      double rate = 0;
	      int percentage=5;	 

	      String instructions = "This program calculates ratng\n"
	                          + "based on pan.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the Pan response" );
	      panout = input.nextLine();

	      System.out.println(); // print blank line

	      // process data
	      if( panout.equals("Available- API Verified"))
	    	  rate = percentage * 1.0/10;
	      else if( panout.equals("Not Verified"))
	    	  rate = percentage * 0.9/10;
	      else if( panout.equals("Fake Pan"))
	    	  rate = percentage * -20.0/10;
	   
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } 
}
