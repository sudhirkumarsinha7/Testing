package com.cisco.gsx.pageObjects;



import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Conflicts {

	public static Properties elementProperties=null;
	public static Properties commonProperties=null;
	private static String Mouseoverelement=null;
	private static String actualMsg=null;
	private static String expectedMsg=null;
	private static String actualMsglist = null;
	private static String expectedMsglist = null;
	private static String status=null;
	private static List<String> Expected=null;
	private static List<String> Actual=null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Actuallist = new ArrayList<String>();
	private static String Expected1=null;
	private static String Expectedfilter=null;
	private static String filter=null;
	private static List<WebElement> list = null;
	private static String SessionImage =null;
	private static int PlusCount =0;
	private static int MinusCount =0;
	private static int flag =0;

	//new ArrayList<String>();
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void Scheduler(){
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
	

		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsxheader"),
				commonProperties.getProperty("cisco.schedule"));
		/*CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.recommendation"));*/
		CommonUtil.waitForPageload();

		CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.TuesTab"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
	}
	public static void regionalsegmentSessions(){
		
		Scheduler();
		
		
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.RegionSegmentSession"));
		CommonUtil.explicitlyWait(6);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));

		for(int i=1;i<=list.size();i++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type").endsWith("plus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
				System.out.println("Session Image PlusCount:"+SessionImage );
				PlusCount =PlusCount+1;
				
			}else if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type").endsWith("minus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
				System.out.println("Session Image MinusCount:"+SessionImage );
				MinusCount = MinusCount+1;
			}
		}
		System.out.println("***************PlusCount:"+PlusCount+"*********MinusCount"+MinusCount );

	
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
			System.out.println("Session Image :"+SessionImage );
			if(SessionImage.equalsIgnoreCase("plus")){
				System.out.println("MinusCount :"+MinusCount );

				 CommonUtil.click(elementProperties.getProperty("SessionTitle").replaceAll("VarX", Integer.toString(i)));
				 CommonUtil.explicitlyWait(3);
				 CommonUtil.click(elementProperties.getProperty("plus"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(6);
			if(MinusCount==0){
				flag= 1;
			}
			else{
				flag= 0;
			}
			
				 MinusCount = MinusCount+1;
					System.out.println("after clicking minus count :"+MinusCount );

				// System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 if(MinusCount>1 && flag==0 ){
					 if(CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")))
					 {
						 SessionImage =null;
							System.out.println("In Alert");
							actualMsg = "Observed alert when two sessions scheduled at the same time";
							expectedMsg = "Observed alert when two sessions scheduled at the same time";
							status = "PASS";
							CommonUtil.logMessage(expectedMsg, actualMsg, status);
							System.out.println("click on proceed");
							CommonUtil.click(elementProperties.getProperty("Proceed"));
							CommonUtil.waitForPageload();
							 CommonUtil.explicitlyWait(6);
							SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("plus"),"type");
							System.out.println("Session Image :"+SessionImage );
							validateSessionConflict(SessionImage,"minus");
							CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
							break;
						}else{
							 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
							 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
						}
					
			}else{
				 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.explicitlyWait(3);
			}
		
				
		}
			//System.out.println("forloop done :"+SessionImage );
	
		}	
		PlusCount=0;
		MinusCount=0;
	
	}
	public static void supersession(){
			
		Scheduler();
		
		
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.SuperSession"));
		CommonUtil.explicitlyWait(6);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));

		for(int j=1;j<=list.size();j++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(j)),"type").endsWith("plus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(j)),"type");
				System.out.println("Session Image PlusCount:"+SessionImage );
				PlusCount =PlusCount+1;
				
			}else if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(j)),"type").endsWith("minus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(j)),"type");
				System.out.println("Session Image MinusCount:"+SessionImage );
				MinusCount = MinusCount+1;
			}
		}
		System.out.println("***************PlusCount:"+PlusCount+"*********MinusCount"+MinusCount );

	
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));
		for(int i=1;i<=list.size();i++){
			SessionImage =null;
			System.out.println("for loop");
			System.out.println("Session Image :"+SessionImage );
			SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
			System.out.println("Session Image :"+SessionImage );
			if(SessionImage.equalsIgnoreCase("plus")){
				System.out.println("MinusCount :"+MinusCount );

				 CommonUtil.click(elementProperties.getProperty("SessionTitle").replaceAll("VarX", Integer.toString(i)));
				 CommonUtil.explicitlyWait(3);
				 CommonUtil.click(elementProperties.getProperty("plus"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(6);
			if(MinusCount==0){
				flag= 1;
			}
			else{
				flag= 0;
			}
			
				 MinusCount = MinusCount+1;
					System.out.println("after clicking minus count :"+MinusCount );

				// System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 if(MinusCount>1 && flag==0 ){
					 if(CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")))
					 {
						 SessionImage =null;
							System.out.println("In Alert");
							actualMsg = "Observed alert when two sessions scheduled at the same time";
							expectedMsg = "Observed alert when two sessions scheduled at the same time";
							status = "PASS";
							CommonUtil.logMessage(expectedMsg, actualMsg, status);
							System.out.println("click on proceed");
							CommonUtil.click(elementProperties.getProperty("Proceed"));
							CommonUtil.waitForPageload();
							 CommonUtil.explicitlyWait(6);
							SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("plus"),"type");
							System.out.println("Session Image :"+SessionImage );
							validateSessionConflict(SessionImage,"minus");
							CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
							break;
						}else{
							 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
							 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
						}
					
			}else{
				 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.explicitlyWait(3);
			}
		
				
		}
			//System.out.println("forloop done :"+SessionImage );
	
		}	
		
		
	
		PlusCount=0;
		MinusCount=0;
		
	}
	
	public static void breakoutSession(){
		
		Scheduler();
		
		
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.BreakoutSession"));
		CommonUtil.explicitlyWait(3);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));

		for(int i=1;i<=list.size();i++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type").endsWith("plus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
				System.out.println("Session Image PlusCount:"+SessionImage );
				PlusCount =PlusCount+1;
				
			}else if(CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type").endsWith("minus")){
				SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
				System.out.println("Session Image MinusCount:"+SessionImage );
				MinusCount = MinusCount+1;
			}
		}
		System.out.println("***************PlusCount:"+PlusCount+"*********MinusCount"+MinusCount );

	
		list=CommonUtil.findElements(elementProperties.getProperty("sessionCount"));
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("sessionImage").replaceAll("VarX", Integer.toString(i)),"type");
			System.out.println("Session Image :"+SessionImage );
			if(SessionImage.equalsIgnoreCase("plus")){
				System.out.println("MinusCount :"+MinusCount );

				 CommonUtil.click(elementProperties.getProperty("SessionTitle").replaceAll("VarX", Integer.toString(i)));
				 CommonUtil.explicitlyWait(3);
				 CommonUtil.click(elementProperties.getProperty("plus"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(6);
			if(MinusCount==0){
				flag= 1;
			}
			else{
				flag= 0;
			}
			
				 MinusCount = MinusCount+1;
					System.out.println("after clicking minus count :"+MinusCount );

				// System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 if(MinusCount>1 && flag==0 ){
					 if(CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")))
					 {
						 SessionImage =null;
							System.out.println("In Alert");
							actualMsg = "Observed alert when two sessions scheduled at the same time";
							expectedMsg = "Observed alert when two sessions scheduled at the same time";
							status = "PASS";
							CommonUtil.logMessage(expectedMsg, actualMsg, status);
							System.out.println("click on proceed");
							CommonUtil.click(elementProperties.getProperty("Proceed"));
							CommonUtil.waitForPageload();
							 CommonUtil.explicitlyWait(6);
							SessionImage = CommonUtil.getAttribute(elementProperties.getProperty("plus"),"type");
							System.out.println("Session Image :"+SessionImage );
							validateSessionConflict(SessionImage,"minus");
							CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
							break;
						}else{
							 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
							 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
							 CommonUtil.explicitlyWait(3);
						}
					
			}else{
				 //System.out.println("if- else done :"+CommonUtil.isElmentPrsent(elementProperties.getProperty("popup")) );
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.explicitlyWait(3);
			}
		
				
		}
			//System.out.println("forloop done :"+SessionImage );
	
		}	
		
		PlusCount=0;
		MinusCount=0;	
	

}

	public static void validateSessionConflict(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsglist = Actual;
		expectedMsglist = Expected;
		
		if (actualMsglist.equalsIgnoreCase(expectedMsglist)) {
			System.out.println("passsss");
			actualMsg = " Session Conflict popup message dispalyed";
			expectedMsg = "Session Conflict popup message should be display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("faill");
			actualMsg = "Session Conflict popup message is not dispalying";
			expectedMsg = "Session Conflict popup message should be dispaly";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	






}

