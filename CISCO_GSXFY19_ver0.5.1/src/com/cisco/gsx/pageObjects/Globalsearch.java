package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Globalsearch {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	public static String Requiredelement = null;
	public static List<WebElement> List = null;
	public static ArrayList<String> arrList = new ArrayList<String>();

	private static String status1 =null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void verifysearchpage()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.search"));
		CommonUtil.waitForPageload();
		Globalsearch.Validateglobalsearch(elementProperties.getProperty("cisco.search.header"), "Search");
		
	}

	public static void verifySearchWithInvaliddata()
	{
		verifysearchpage();
		CommonUtil.enterText(elementProperties.getProperty("cisco.searchbox"), commonProperties.getProperty("cisco.gsx.search.searchentrytext2"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		expectedMsg = CommonUtil.getText(elementProperties.getProperty("cisco.noresults"));
		
		actualMsg = commonProperties.getProperty("cisco.search.noValue");
		System.out.println("expectedMsg "+expectedMsg+"actualMsg "+actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg))
		{
			actualMsg = "No matches found for given text";
			expectedMsg = "Application should display error message";		
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		else
		{
			actualMsg = "matches found for given text";
			expectedMsg = "Application should display error message";			
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	public static void verifysearchentrytextlimit()
	{
		verifysearchpage();
		CommonUtil.click(elementProperties.getProperty("cisco.search.Sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);		
		CommonUtil.enterText(elementProperties.getProperty("cisco.searchbox"), elementProperties.getProperty("cisco.gsx.search.searchentrytext1"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isAlertPresent())
		{
			actualMsg = "Three or more characters are entered successfully to perform search";
			expectedMsg = "Three or more characters are required to perform search";			
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			System.out.println("page is displayed");
		}
		else
		{
			actualMsg = "Please enter at least three characters to perform a search";
			expectedMsg = "Three or more characters are required to perform search";		
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			System.out.println("page is not displayed");
		}
	}
	public static void verifyTabs(String actual,String expected){
		System.out.println("actualMsg");
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		expectedMsg = expected;
		actualMsg = CommonUtil.getText(actual);
		System.out.println("actualMsg"+actualMsg+"..........."+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actualMsg+ "tab displays successfully";
			expectedMsg = actualMsg+ "tab should display";			
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actualMsg+ "tab not displayed successfully";
			expectedMsg = actualMsg+ "tab should display";		
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void verifyTitles(String actual,String expected){
		System.out.println("actualMsg"+expected);
		CommonUtil.waitForPageload();
		expectedMsg = CommonUtil.getText(actual);
		actualMsg = expected;
		System.out.println("actualMsg"+actualMsg+"..........."+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actualMsg+ "Session/Activities displays successfully";
			expectedMsg = actualMsg+ "Session/Activities should display";			
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actualMsg+ "Session/Activities not displayed successfully";
			expectedMsg = actualMsg+ "Session/Activities should display";		
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	public static void verifySearchTextInTabs()
	{
		verifysearchpage();
		CommonUtil.click(elementProperties.getProperty("cisco.search.Sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);		
		CommonUtil.enterText(elementProperties.getProperty("cisco.searchbox"), elementProperties.getProperty("cisco.gsx.search.searchentrytext1"));
		CommonUtil.waitForPageload();
	
		verifyTabs(elementProperties.getProperty("cisco.search.Sessions.label"),"Sessions/Hub Talks");
	  // CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.Session"));
	  //  {
	    	//System.out.println("loop");
	    	//CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.sessiontab"));
	    	//CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.search.results"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		System.out.println("loop");
	    		String req = CommonUtil.getText(elementProperties.getProperty("cisco.result.titles").replaceAll("VarX", Integer.toString(i)));
	    		CommonUtil.click(elementProperties.getProperty("cisco.results.links").replaceAll("VarX", Integer.toString(i)));
	    		CommonUtil.waitForPageload();
	    		
	    		verifyTitles(elementProperties.getProperty("cisco.session.titles"),req);
		    
	    		//System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.result.content")));
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.result.content").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    		{
	    			status1 = "false";
	    		}
	    		arrList.add(status1);
	    		CommonUtil.click(elementProperties.getProperty("search.back"));
				CommonUtil.waitForPageload();
	    		System.out.println("loop Sessions"+i);
	    		
	    	}
	    	System.out.println("loop Sessions");
	    	CommonUtil.explicitlyWait(5);
	   //System.out.println("ss"+CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.speakerstab"))); 
	   // if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.speakerstab")))
	   // {
	    	System.out.println("loop Attendees");
	    	CommonUtil.click(elementProperties.getProperty("cisco.search.Attendees"));
	    	CommonUtil.explicitlyWait(3);
	    	verifyTabs(elementProperties.getProperty("cisco.search.Attendees.label"),"Attendees");
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.search.results"));
	    	System.out.println("List.size()"+List.size());
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		System.out.println("loop");
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.result.titles").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    		{
	    			status1 = "false";
	    		}
	    		arrList.add(status1);
	    		
	    	}
	 
	    	CommonUtil.click(elementProperties.getProperty("cisco.search.Activities"));
	    	CommonUtil.explicitlyWait(3);
	    	verifyTabs(elementProperties.getProperty("cisco.search.Activities.label"),"Activities/Demos");

	    	

	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.search.results"));
	    	System.out.println("List.size()"+List.size());
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		System.out.println("loop");
	    		String req = CommonUtil.getText(elementProperties.getProperty("cisco.result.titles").replaceAll("VarX", Integer.toString(i)));
	    		CommonUtil.click(elementProperties.getProperty("cisco.results.links").replaceAll("VarX", Integer.toString(i)));
	    		CommonUtil.waitForPageload();
	    		
	    		verifyTitles(elementProperties.getProperty("cisco.activities.titles"),req);
		    			
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.result.content")).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    		{
	    			status1 = "false";
	    		}
	    		arrList.add(status1);
	    		CommonUtil.click(elementProperties.getProperty("cisco.hub.back"));
	    		CommonUtil.waitForPageload();
	    		
	    	}
	    	CommonUtil.click(elementProperties.getProperty("cisco.search.Speakers"));
	    	CommonUtil.explicitlyWait(3);
	    	verifyTabs(elementProperties.getProperty("cisco.search.Speakers.label"),"Speakers");

	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.search.results"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		System.out.println("loop");
	    		CommonUtil.click(elementProperties.getProperty("cisco.results.links").replaceAll("VarX", Integer.toString(i)));
	    		CommonUtil.waitForPageload();
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.result.content").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    		{
	    			status1 = "false";
	    		}
	    		arrList.add(status1);
	    		CommonUtil.click(elementProperties.getProperty("search.back"));
				CommonUtil.waitForPageload();
	    		
	    	}
//	}
//	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.search.Attendees")))
//	    {
//	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.attendeestab"));
//	    	CommonUtil.explicitlyWait(3);
//	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.attendeeslist"));
//	    	
//	    	for(int i=1;i<=List.size();i++)
//	    	{
//	    		
//	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.attendees").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
//	     		{
//	    			status1 = "true";	
//	    		}
//	    		else
//	    			status1= "false";
//	    	    arrList.add(status1);
//	    	}	
//	    }
//	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.webtab")))
//	    {
//	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.webtab"));
//	    	CommonUtil.explicitlyWait(3);
//	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.weblist"));
//	    	
//	    	for(int i=1;i<=List.size();i++)
//	    	{
//	    		
//	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.web").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
//	     		{
//	    			status1 = "true";	
//	    		}
//	    		else
//	    			status1 = "false";
//	    		arrList.add(status1);
//	    		
//	    	}	
//	    }	
//	    	
	    System.out.println(arrList);	
//	    if (arrList.contains("false")) 
//	    {
//	    	actualMsg = "Appropriate search results are not diaplayed";
//            expectedMsg = "Appropriate search results are diaplayed"; 
//            status = "FAIL";
//            CommonUtil.logMessage(expectedMsg, actualMsg, status);
//	    	
//	    		
//		}
//	    else
//	    {
//	    	actualMsg = "Appropriate search results are diaplayed";
//            expectedMsg = "Appropriate search results are diaplayed";   
//            status = "PASS";
//            CommonUtil.logMessage(expectedMsg, actualMsg, status);
//	    }
//	    
//	    
	}
	
	
	
	public static void verifysearch()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.button"));
		CommonUtil.waitForPageload();
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.Session"));
		//CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);		
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.search.searchbox"), "WW");
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(2);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")) || CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus" )))
		{
			System.out.println("No1");
			if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")))
			{
				System.out.println("plus");
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(2);
				
				
				if(CommonUtil.isElementPresent1(elementProperties.getProperty("Sessionconflict")))
				{
					actualMsg = "Observed alert when two sessions scheduled at the same time";
					expectedMsg = "Observed alert when two sessions scheduled at the same time";
					status = "PASS";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
					System.out.println("success");
					CommonUtil.click(elementProperties.getProperty("Proceed"));
					CommonUtil.explicitlyWait(3);


				}
				else
				{
					System.out.println("plus :Two Sessions not selected at same Time");
				CommonUtil.explicitlyWait(3);
				Agenda.Validateaddtomyagenda(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus"),"minus");
				}
			}
			else
			{
				System.out.println("minus:Session Selected");
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus"));
				//CommonUtil.handleAlert();
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(5);
				Agenda.Validateaddtomyagenda(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"), "plus");
			}
		}
		
	}
		
	
	public static void Validateglobalsearch(String expected, String actual) {
			
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			actualMsg = actual;
			expectedMsg = CommonUtil.getText(expected);
			System.out.println("actualMsg"+actualMsg+"..........."+expectedMsg);
			if (actualMsg.equalsIgnoreCase(expectedMsg)) {
				actualMsg = actual+ "page is displayed successfully";
				expectedMsg = actual+ "page is displayed successfully";			
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				actualMsg = actual+ "page is  not displayed";
				expectedMsg =  actual+ "page is displayed successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
		}
	}
