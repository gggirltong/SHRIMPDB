package com.shrimpdb.common;
public class PYusertype{
	public int compare(int type, int personnumber,int opennumber) {
		if(type==7)
		{
		 if(personnumber>5000&&opennumber>=3000)						
			    type=3;	     		
		 else if(personnumber>2000&&opennumber>=1000)		
			type=6;			
		 else if(personnumber>500&&opennumber>=300)
			type=5;		    
		 else if(personnumber>100&&opennumber>=100) 
			 type=4;			    
		}
		else if(type==4)
		{
			 if(personnumber>5000&&opennumber>=3000)			
				    type=3;
			 else if(personnumber>2000&&opennumber>=1000)
				type=6;			
			 else if(personnumber>500&&opennumber>=300)
				type=5;		    
		}
		else if(type==5)
		{	
			if(personnumber>5000&&opennumber>=3000)			
		    type=3;
			else if(personnumber>2000&&opennumber>=1000)
		    type=6;					
		}
		else if(type==6)
		{
			if(personnumber>5000&&opennumber>=3000)			
			    type=3;
		}
		
		
		
		 
		return type;
		
	}
}
