StringBuffer jsonString = new StringBuffer();
 for(int j=0;j<1;j++){
 alert("dd");
		jsonString.append("[");
		for(int i=0;i<dataid.length;i++){
		    jsonString.append("{");	
			jsonString.append("\"id\":");
			jsonString.append(dataid[i].ssid);		
			jsonString.append("}");
		if(i<len-1)
		jsonString.append(",");		    
		}	
	    jsonString.append("]");		
}     