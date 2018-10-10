package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;


public class Scheduler {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	public static String expected = null;
	private static String Expected=null;
	//public static List<WebElement> list = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	//New Methods-vijaya
	public static void buildYourSchedule()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Scheduler.ValidateSessions(elementProperties.getProperty("cisco.scheduler.header"),"Build Your Schedule");
	}
	//New Method
//	public static void buildYourSchedule()
	/*{
		CommonUtil.waitForPageload();
	//	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.BUILDYOURSCHEDULE"));
		CommonUtil.waitForPageload();
		//Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		//CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Scheduler.ValidateSessions(elementProperties.getProperty("cisco.gsx.BUILDYOURSCHEDULE.header"),"Build Your Schedule");
	}*/
	public static void tabs()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
		
		Validateaddtomyagenda(elementProperties.getProperty("cisco.scheduler.Monday"),"Monday Aug 20");

	}
	public static void sessionsPlusverification()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
		/*CommonUtil.click(elementProperties.getProperty("cisco.scheduler.recommendation"));
		CommonUtil.waitForPageload();
		*/
		ValidateTabs(elementProperties.getProperty("cisco.scheduler.MondayLabel"),"Monday Aug 20");
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.TuesTab"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.BreakoutSession"));
		CommonUtil.explicitlyWait(3);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);
		String sessionStatus = CommonUtil.getAttribute(
				elementProperties.getProperty("cisco.sessions.status"), "type");
		CommonUtil.click(elementProperties.getProperty("cisco.sessions.secondsession"));
		CommonUtil.waitForPageload();
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"));
		//if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.details.plus")) || CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.details.minus" )))
		//{
		if(sessionStatus.equals("plus"))
		
		{
			System.out.println("plus");
			CommonUtil.click(elementProperties.getProperty("cisco.scheduler.plus"));
			CommonUtil.waitForPageload();
			if(CommonUtil.isAlertPresent())
			{
				System.out.println("In Alert");
				actualMsg = "Observed alert when two sessions scheduled at the same time";
				expectedMsg = "Observed alert when two sessions scheduled at the same time";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				System.out.println("click on proceed");
				CommonUtil.click(elementProperties.getProperty("Proceed"));
				CommonUtil.waitForPageload();
				Validateaddtomyagenda(elementProperties.getProperty("cisco.scheduler.minus"),"minus");

			}
			else
			{
				System.out.println("plus else");
				CommonUtil.explicitlyWait(3);
				Validateaddtomyagenda(elementProperties.getProperty("cisco.scheduler.minus"),"minus");
			}
		}
		else
		{
			System.out.println("minus");
			CommonUtil.click(elementProperties.getProperty("cisco.details.plus"));
			//CommonUtil.handleAlert();
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			Validateaddtomyagenda(elementProperties.getProperty("cisco.scheduler.plus"), "plus");
			}
		//}
		/*else
		{
			System.out.println("failed");
			actualMsg = "Lock icon is present instead of plus or minus to add the session to my agenda";
			expectedMsg = "Plus or minus is present to add the session to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}*/
		}
	
	
	public static void Validateaddtomyagenda(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected, "type");
		System.out.println(expectedMsg+actualMsg);
		if (expectedMsg.contains(actualMsg)) {
			actualMsg = "Session successfully added to my Agenda";
			expectedMsg = "Session successfully added to my Agenda";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session is not added to my Agenda";
			expectedMsg = "Session successfully added to my Agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void ValidateTabs(String expected, String actual) {
			
			CommonUtil.waitForPageload();
			actualMsg = actual;
			expectedMsg = CommonUtil.getText(expected);
			System.out.println(expectedMsg+"   "+actualMsg);
			if (expectedMsg.contains(actualMsg)) {
				System.out.println(expectedMsg+"   "+actualMsg+"pass");
				actualMsg = "Session successfully added to my Agenda";
				expectedMsg = "Selected session should add to MYGSX";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				System.out.println(expectedMsg+"   "+actualMsg+"Fail");
				actualMsg = "Session is not added to my Agenda";
				expectedMsg = "Selected session should add to MYGSX";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
		}

	public static void ValidateSessions(String expected, String actual) {
			
			CommonUtil.waitForPageload();
			actualMsg = actual;
			expectedMsg = CommonUtil.getText(expected);
			System.out.println("expectedMsg :"+expectedMsg+"*******************");
	
			System.out.println("actualMsg :"+actual+" expectedMsg :"+expectedMsg);
			if (actualMsg.equalsIgnoreCase(expectedMsg)) {
				
				actualMsg = actual + "page is displayed";
				expectedMsg = actual + "page should disply";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				actualMsg = actual + "page is not displayed";
				expectedMsg = actual + "page should disply";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
		}
	



}
