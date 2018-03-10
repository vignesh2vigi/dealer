package com.kuwy.kds.utility;

import java.util.Scanner;

public class bank {
	public static void main(String[] args) {
	      // declare and initialize variables
		
	     String statement;
	      double rate = 0;
	      int percentage=5;

	      String instructions = "This program calculates ratng\n"
	                          + "based on bank statement.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the bank statement" );
	      statement = input.nextLine();

	      System.out.println(); // print blank line

	      // process data
	      if( statement.equals("Statement eFetched&26AS linked"))
	    	  rate = percentage*1.0/10;
	      else if( statement.equals("Statement eFetched"))
	    	  rate = percentage*1.0/10;
	      else if( statement.equals("Statement PDF Uploaded -Manual"))
	    	  rate = percentage*0.9/10;
	      else if( statement.equals("Statement Photo uploaded"))
	    	  rate = percentage*0.6/10;
	      else if( statement.equals("Not Available"))
	    	  rate = percentage*0.1/10;
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } 
}
