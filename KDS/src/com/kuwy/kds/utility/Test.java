package com.kuwy.kds.utility;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	      // declare and initialize variables
	      int    creditScore;
	      double rate = 0;
         int percentage=75;	    
       
	      String instructions = "This program calculates rating"
	                          + "based on a credit score.\n\n";
	      String output;

	      Scanner input = new Scanner( System.in ); // for receiving input from keyboard

	      // get input from user
	      System.out.println( instructions );

	    

	      System.out.print( "Enter the credit score: " );
	      creditScore = input.nextInt();

	      System.out.println(); // print blank line

	      // process data
	      if( creditScore > 700 )
	    	  rate = percentage * 1.0/10;
	      else if( creditScore < 700 && creditScore >650)
	    	  rate = percentage * 0.9/10;  		
	      else if( creditScore < 650 && creditScore >600)
	    	  rate = percentage * 0.8/10;
	      else if( creditScore < 600 && creditScore >550)
	    	  rate = percentage * 0.7/10;
	      else if( creditScore < 550 && creditScore >500)
	    	  rate = percentage * 0.5/10;
	      else if( creditScore < 500 )
	    	  rate = percentage * 0.4/10;	    	  
	   
	      // output
	      output = "rate $ " + rate ; 

	      // display output
	      System.out.println( output );

	   } // end main

	

}


