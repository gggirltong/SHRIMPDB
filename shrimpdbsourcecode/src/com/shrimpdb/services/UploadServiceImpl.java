package com.shrimpdb.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpdb.dao.QueryDao;
import com.shrimpdb.dao.UploadDao;
import com.shrimpdb.dao.UserDao;
import com.shrimpdb.dao.UserRoleDaoImpl;
import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;
import com.shrimpdb.entity.User;
import com.shrimpdb.entity.Process;
import com.shrimpdb.common.PYusertype;
@Service
public class UploadServiceImpl implements UploadService{
	@Autowired
	private UploadDao uploadDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private QueryDao queryDao;
	@Autowired
	private UserRoleDaoImpl userRoleDao;
	@Override
	public void insertData(Uploadcontents sample_detail) {
		uploadDao.insertData(sample_detail);
		Long id=sample_detail.getUserid();
		List<User> userlist=userDao.findbyid(id);
		Long type2=userlist.get(0).getType();
		String type1=type2.toString();
		int type=Integer.parseInt(type1);
		List<Sample_detail> list=queryDao.personSample(id);
		List<Sample_detail> openlist=queryDao.personopen(id);
		int personnumber=list.size();
		int opennumber=openlist.size();
		PYusertype pytype=new PYusertype();
		int usertype=pytype.compare(type, personnumber, opennumber);	
		if(usertype!=type)
		{
		userDao.updatetype(usertype,id);
        userRoleDao.updatetype(usertype, id);			
		}
		else
			;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertProject(Uploadcontents projects) {
		// TODO Auto-generated method stub
		uploadDao.insertProject(projects);
			
	}
	@Override
	public Project selectProject(String sysid)
{
	return 	uploadDao.selectProject(sysid);
	
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sample_detail selectsampledetail(String sysid)
 {
	return uploadDao.selectsampledetail(sysid);
		// TODO Auto-generated method stub
		
	}
	@Override
	public String saveFile(MultipartFile file, String path) {
		String saveName = "";
		try {			
        	// 锟斤拷取锟侥硷拷锟侥猴拷缀锟斤拷
        	String fileName = file.getOriginalFilename();
        	String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        	
        	// 锟斤拷锟绞憋拷锟斤拷锟�
        	String szTemp = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
        	
        	// 锟斤拷锟斤拷募锟斤拷谋锟斤拷锟斤拷锟斤拷郑锟斤拷锟斤拷锟缴碉拷时锟斤拷锟斤拷+原锟饺的猴拷缀  
        	//saveName = fileName + "." + fileNameExt;
        	saveName = fileName ;
        	// 锟斤拷锟斤拷锟侥硷拷
        	java.io.File localFile = new java.io.File(path, fileName);
			file.transferTo(localFile);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return saveName;
	}
	@Override
	public void saveValue() {
		// TODO Auto-generated method stub		
	}
	@SuppressWarnings("null")
	@Override
	public void CreateTestvalue(String fileName,String id) {		
		 try {
             String encoding="GBK";
             File file=new File(fileName);
             AnalyticalValue analyticalValue=new AnalyticalValue();
             Long sampleid=Long.parseLong(id);
       	     analyticalValue.setSample_id(sampleid);
       	     analyticalValue.setFileop(fileName);       
             if(file.isFile() && file.exists()){ //锟叫讹拷锟侥硷拷锟角凤拷锟斤拷锟�
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);//锟斤拷锟角碉拷锟斤拷锟斤拷锟绞�
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 String testvalue[]={null,null,null,null,null,null};
                     int count=0;
                 while((lineTxt = bufferedReader.readLine()) != null)
                 {               	  
                	 count++;
                	 if(count==3)
                	{
                		String[]  dd=lineTxt.split(",");                      
                        analyticalValue.setSpotname(dd[0]); 		            	               	                	 
                	}
                	 if(count==56)                       
                	 {
                		String[]	strr=lineTxt.split("\\s+");
                	    String b=strr[3];	
                	    if(b.length()>11)
                	    {
                	    	String age204=b.substring(0,10);
                	    	double  age204l=Double.parseDouble(age204);
                	    	String err=b.substring(10,b.length());
                	    	double err204=Double.parseDouble(err);
                	    	analyticalValue.setAge204(age204l);
                	    	analyticalValue.setErr204(err204);                	    	
                	    
                	    }
                	    else 
                	    	{
                	    	analyticalValue.setAge204(Double.parseDouble(strr[3]));
                	    	analyticalValue.setErr204(Double.parseDouble(strr[4]));                  	       
                	       
                	        }
                	 }
                	 if(count==66)                       
                	 {
                		String[]	strr=lineTxt.split("\\s+");
                	    String b=strr[3];	
                	    if(b.length()>11)
                	    {
                	    	String age208=b.substring(0,10);
                	    	double  age208l=Double.parseDouble(age208);
                	    	String err=b.substring(10,b.length());
                	    	double err208=Double.parseDouble(err);
                	    	analyticalValue.setAge208(age208l);
                	    	analyticalValue.setErr208(err208);                	    	
                	    	
                	    }
                	    else 
                	    	{
                	    	analyticalValue.setAge208(Double.parseDouble(strr[3]));
                	    	analyticalValue.setErr208(Double.parseDouble(strr[4]));  
                	       
                	  
                	        }
                	 }
                	 if(count==70)
                	 {
                		String[] U=lineTxt.split("\\s+");
                		testvalue[3]=U[0].split(":")[1];
                		testvalue[4]=U[2].split(":")[1];	
                		testvalue[5]=U[4].split(":")[1];
                		analyticalValue.setU(Double.parseDouble(testvalue[3]));
                		analyticalValue.setTh(Double.parseDouble(testvalue[4]));
                		analyticalValue.setUTh(Double.parseDouble(testvalue[5]));
                	
                	 }                   
                
                 }
                 read.close();
     }else{
         System.out.println("鎵句笉鍒版寚瀹氱殑鏂囦欢");
     }
             uploadDao.saveValue(analyticalValue);
     } catch (Exception e) {
         System.out.println("璇诲彇鏂囦欢鍐呭鍑洪敊");
         e.printStackTrace();
     }
 }
		
	
//为锟斤拷匹锟斤拷锟斤拷锟�
	@SuppressWarnings("null")
	@Override
	public void insertaccu(String fileName,String id) {		
		 try {
             String encoding="GBK";
             File file=new File(fileName);
             AnalyticalValue analyticalValue=new AnalyticalValue();
           //  Long sampleid=Long.parseLong(id);
       	     analyticalValue.setMountname(id);
       	     analyticalValue.setFileop(fileName);       
             if(file.isFile() && file.exists()){ //锟叫讹拷锟侥硷拷锟角凤拷锟斤拷锟�
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);//锟斤拷锟角碉拷锟斤拷锟斤拷锟绞�
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 String testvalue[]={null,null,null,null,null,null};
                     int count=0;
                 while((lineTxt = bufferedReader.readLine()) != null)
                 {               	  
                	 count++;
                	 if(count==3)
                	{
                		String[]  dd=lineTxt.split(",");                      
                        analyticalValue.setSpotname(dd[0]); 		            	               	 
                	    System.out.println(analyticalValue.getSpotname());
                	}
                	 if(count==56)                       
                	 {
                		String[]	strr=lineTxt.split("\\s+");
                	    String b=strr[3];	
                	    if(b.length()>11)
                	    {
                	    	String age204=b.substring(0,10);
                	    	double  age204l=Double.parseDouble(age204);
                	    	String err=b.substring(10,b.length());
                	    	double err204=Double.parseDouble(err);
                	    	analyticalValue.setAge204(age204l);
                	    	analyticalValue.setErr204(err204);                	    	
                	    	System.out.println(analyticalValue.getAge204());
                	    	System.out.println(analyticalValue.getErr204());
                	    }
                	    else 
                	    	{
                	    	analyticalValue.setAge204(Double.parseDouble(strr[3]));
                	    	analyticalValue.setErr204(Double.parseDouble(strr[4]));                  	       
                	        System.out.println( analyticalValue.getAge204());
                	        System.out.println( analyticalValue.getErr204());
                	        }
                	 }
                	 if(count==66)                       
                	 {
                		String[]	strr=lineTxt.split("\\s+");
                	    String b=strr[3];	
                	    if(b.length()>11)
                	    {
                	    	String age208=b.substring(0,10);
                	    	double  age208l=Double.parseDouble(age208);
                	    	String err=b.substring(10,b.length());
                	    	double err208=Double.parseDouble(err);
                	    	analyticalValue.setAge208(age208l);
                	    	analyticalValue.setErr208(err208);                	    	
                	    	System.out.println(analyticalValue.getAge208());
                	    	System.out.println(analyticalValue.getErr208());
                	    }
                	    else 
                	    	{
                	    	analyticalValue.setAge208(Double.parseDouble(strr[3]));
                	    	analyticalValue.setErr208(Double.parseDouble(strr[4]));  
                	       
                	        System.out.println( analyticalValue.getAge208());
                	        System.out.println( analyticalValue.getErr208());
                	        }
                	 }
                	 if(count==70)
                	 {
                		String[] U=lineTxt.split("\\s+");
                		testvalue[3]=U[0].split(":")[1];
                		testvalue[4]=U[2].split(":")[1];	
                		testvalue[5]=U[4].split(":")[1];
                		analyticalValue.setU(Double.parseDouble(testvalue[3]));
                		analyticalValue.setTh(Double.parseDouble(testvalue[4]));
                		analyticalValue.setUTh(Double.parseDouble(testvalue[5]));
                		System.out.println( testvalue[3]);
                		System.out.println( testvalue[4]);
                		System.out.println( testvalue[5]);
                	 }                   
                
                 }
                 read.close();
     }else{
         System.out.println("鎵句笉鍒版寚瀹氱殑鏂囦欢");
     }
             uploadDao.saveValue(analyticalValue);
     } catch (Exception e) {
         System.out.println("璇诲彇鏂囦欢鍐呭鍑洪敊");
         e.printStackTrace();
     }
 }
	@Override
	public void insertremark(AnalyticalValue spotchangevalue) {
		// TODO Auto-generated method stub
		uploadDao.insertremark(spotchangevalue);
	}
	@Override
	  public void readExcel(File file) {   {
		try { 
			Process analyticalValue=new Process();
			List<Process> processvalue=new ArrayList<Process>();
		
			
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            WorkbookSettings   workbookSettings=new   WorkbookSettings(); 
            workbookSettings.setEncoding("ISO-8859-1");   
            Workbook wb = Workbook.getWorkbook(is);  
               
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets(); 
            int tableindex=0;
            int rowstart=0;
            int rowend=0;
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
            
                Sheet sheet = wb.getSheet(index);  
                String sheetname=sheet.getName();
                String s2="Table";             
                if (sheetname.contains(s2))
                {  //sheet.getRows()
                	tableindex=index;
                	 for (int i = 0; i <sheet.getRows(); i++) {                		  	
                    // sheet.getColumns()返回该页的总列数  
                     for (int j = 0; j <sheet.getColumns(); j++) {                     	 
                    	 String cellinfo = sheet.getCell(j, i).getContents();
                    	 System.out.println(cellinfo);
                    	 if(cellinfo.contains("Spot"))
                    		 rowstart=i+1;
                    		 
                    	 if(cellinfo.contains("Errors"))
                    	 { rowend=i;
                    	 break;}
                    	 
                    	 }                                	
                       if (rowstart!=0&&rowend!=0) 
                    	   break;
                    }
                	
                }
                if(tableindex!=0)
                	break;              
                
        } 
            System.out.println(rowstart);
            System.out.println(rowend);	
            System.out.println(tableindex);	
            Sheet sheettable = wb.getSheet(tableindex);  
            for(int aa=rowstart;aa<rowend;aa++)
            {
            	for(int bb=0;bb<sheettable.getColumns();bb++)
            	{
            		 String cellinfo = sheettable.getCell(bb, aa).getContents();
                     
            		switch(bb)
                    {
                    case 0:analyticalValue.setSpotname(cellinfo);
                    break;
                    case 2:analyticalValue.setU(cellinfo);
                    break;
                    case 3:analyticalValue.setTh(cellinfo);
                    break;
                    case 4:analyticalValue.setThU(cellinfo);
                    break; 
                    case 5:analyticalValue.setRadio206pb(cellinfo);
                    break;
                    case 6:analyticalValue.setDiscondant(cellinfo);
                    break;
                    case 7:analyticalValue.setTotal86(cellinfo);
                    break;
                    case 8:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 9:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 10:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 11:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 12:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 13:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 14:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 15:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 16:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 17:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 18:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 19:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 20:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 21:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 22:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 23:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 24:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 25:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 26:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 27:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 28:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 29:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 30:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 31:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 32:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 33:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 34:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 35:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 36:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 37:analyticalValue.setTotal76(cellinfo);
                    break;
                    case 38:analyticalValue.setTotal76(cellinfo);
                    break;
                   
                    default: break;
                    } 
              processvalue.add(analyticalValue);
            	}
            }
            System.out.print(processvalue);
		}  
	  catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	}
}
	
	

	
