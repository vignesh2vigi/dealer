package com.kuwy.kds.utility;

import java.util.Scanner;

public class hunter {
	public static void main(String[] args) {
	      // declare and initialize variables
		
	     String hunter;
	      double rate = 0;
	    
	      int percentage=5;
	      String instructions = "This program calculates ratng\n"
	                          + "based on aadhar.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the hunter response" );
	      hunter = input.nextLine();

	      System.out.println(); // print blank line

	      // process data
	      if( hunter.equals("Whitelisted"))
	    	  rate = percentage*1.0/10;
	      else if( hunter.equals("Blacklisted"))
	    	  rate = percentage*-20.0/10;
	      
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } 
}
