package com.kuwy.kds.utility;

public class KuwyRating {
	  double case0=0.0;
     double case1=1.0;
     double case2=0.9;
     double case3=0.8;
     double case4=0.7;
     double case7= 0.6;
     double case5= 0.5;
     double case6= 0.4;
     double case10=0.3;
     double case9= 0.2;
     double case11=0.1;
     double case8= -20.0;
      
	public double creditscore(int creditScore){
		
		double crate = 0;
	     
        int percentage=75;	    
        
	      if( creditScore >= 700 )
	    	  crate = percentage * case1/10;
	      else if( creditScore < 700 && creditScore >=650)
	    	  crate = percentage * case2/10;  		
	      else if( creditScore < 650 && creditScore >=600)
	    	  crate = percentage * case3/10;
	      else if( creditScore < 600 && creditScore >=550)
	    	  crate = percentage * case4/10;
	      else if( creditScore < 550 && creditScore >=500)
	    	  crate = percentage * case5/10;
	      else if( creditScore < 500 )
	    	  crate = percentage * case6/10;
	      else if(creditScore == 0)
	    	  crate = percentage * case0/10;
		return crate;
		
	}
	
	public double Pan(String panout){
		
	      double prate = 0;
      int percentage=5;	  
      
      if( panout.equals("Available- API Verified"))
    	  prate = percentage * case1 /10;
      else if( panout.equals("Not Verified"))
    	  prate = percentage * case2 /10;
      else if( panout.equals("Fake Pan"))
    	  prate = percentage * case8/10;
   
		return prate;
		
	}
	
	public double Aadhar(String aadhar){
		
	      double arate = 0;
    int percentage=5;	    
    if( aadhar.equals("Available-API Verified"))
	  arate = percentage*case1/10;
else if( aadhar.equals("Not Verified"))
	  arate = percentage*case7/10;
else if( aadhar.equals("Available - API Authenticated"))
	  arate = percentage*case1/10;
else if( aadhar.equals("Aadhaar Not Available"))
	  arate = percentage*case9/10;
else if( aadhar.equals("Fake Aadhaar"))
	  arate = percentage*case8/10;
		return arate;
	}
	
	public double Statement(String statement){
		
	      double srate = 0;
  int percentage=5;	    
  if( statement.equals("Statement eFetched&26AS linked"))
	  srate = percentage*case1/10;
  else if( statement.equals("Statement eFetched"))
	  srate = percentage*case1/10;
  else if( statement.equals("Statement PDF Uploaded -Manual"))
	  srate = percentage*case2/10;
  else if( statement.equals("Statement Photo uploaded"))
	  srate = percentage*case7/10;
  else if( statement.equals("Not Available"))
	  srate = percentage*case11/10;
		return srate;
	}
	
	public double Hunter(String hunter){
		
	      double hrate = 0;
int percentage=5;	    
if( hunter.equals("Whitelisted"))
	  hrate = percentage*case1/10;
else if( hunter.equals("Blacklisted"))
	  hrate = percentage*case8/10;
		return hrate;
	}
	
	public double Empbsm(String emp){	
	      double erate = 0;
int percentage=5;	    
if( emp.equals("Tier 1 Company Employer (Pvt)"))
	 erate = percentage*case1/10;
else if( emp.equals("Tier 2 Company Employer (Pvt)"))
	  erate = percentage*case2/10;
else if( emp.equals("Tier 3 Company Employer"))
	  erate = percentage*case3/10;
else if( emp.equals("Government"))
	  erate = percentage*case1/10;
else if( emp.equals("Startup"))
	  erate = percentage*case3/10;
else if( emp.equals("Business- Annual Returns Filed & GST Available"))
	  erate = percentage*case1/10;
else if( emp.equals("Business - Annual Returns Not Filed & GST NA"))
	  erate = percentage*case7/10;
		return erate;
	}

	
	public static void main(String[] args) {
		
		KuwyRating cs=new KuwyRating();
		KuwyRating pn=new KuwyRating();
		KuwyRating aa=new KuwyRating();
		KuwyRating stm=new KuwyRating();
		KuwyRating hn=new KuwyRating();
		KuwyRating em=new KuwyRating();
		
		double csr=cs.creditscore(789);
		double pnr=pn.Pan("Available- API Verified");
		double aar=aa.Aadhar("Fake Aadhaar");
		double str=stm.Statement("Not Available");
		double hnr=hn.Hunter("Blacklisted");
		double emr=em.Empbsm("Business - Annual Returns Not Filed & GST NA");
		
		System.out.println("verify credit---->"+csr);
		System.out.println("verify pan---->"+pnr);
		System.out.println("verify aadhar---->"+aar);
		System.out.println("verify statement---->"+str);
		System.out.println("verify hunter---->"+hnr);
		System.out.println("verify employer/business---->"+emr);
	    System.out.println("total===>"+(csr+pnr+aar+str+hnr+emr));
	
	}
	
	
}
