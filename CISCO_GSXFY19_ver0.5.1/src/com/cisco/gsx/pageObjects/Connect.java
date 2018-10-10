 package com.cisco.gsx.pageObjects;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Connect {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	public static List<WebElement> list = null;
	private static String Expected=null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	//updated Methods-vijaya
	public static void SocialPage()
	{
		
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.connect.link"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.connect.link"));
		Connect.ValidateConnection(elementProperties.getProperty("cisco.connect.header"),Requiredelement);

		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.social.link"));
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Attendees"));
		//CommonUtil.waitForPageload();
		Connect.ValidateConnection(elementProperties.getProperty("cisco.social.header"),"Social Connections");

		
		
	}
	//Attendee Link in Connect Page
	public static void Attendees()
	{
		
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.connect.link"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.attendee.link"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.attendee.link"));
		Connect.ValidateConnection(elementProperties.getProperty("cisco.attendee.header"),Requiredelement);
	
	}
	public static void FAQ(){
		
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.connect.link"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.faq.link"));
		CommonUtil.waitForPageload();
	//	Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.attendee.link"));
		Connect.ValidateConnection(elementProperties.getProperty("cisco.faq.header"),
				commonProperties.getProperty("cisco.faq.title"));
		
		
	}
	
	
	//crated Methods-vijaya
	public static void ConversationsPage()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.Connect"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.Connect.Conversations"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Conversations"));
		CommonUtil.waitForPageload();
		Connect.ValidateConnection(elementProperties.getProperty("cisco.gsx.Connect.Conversations.title"),Requiredelement);
	}
	//crated Methods-vijaya
	public static void CreateNewPost()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.Connect"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		//Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.Connect.Conversations"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Conversations"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Conversations.Createnewpost"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.Connect.Conversations.TextArea"), "TestCreation");
		CommonUtil.explicitlyWait(1);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Conversations.submit"));
		

		//Attendees.ValidateConnection(elementProperties.getProperty("cisco.gsx.Connect.Conversations.title"),Requiredelement);
	}

	public static void ValidateConnection(String expected, String actual) {
	
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		System.out.println("actualMsg : "+actual+ "......"+"expectedMsg : "+expected);

		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println("actualMsg : "+actualMsg+ "......"+"expectedMsg : "+expectedMsg);
		CommonUtil.explicitlyWait(2);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actual + "page is displayed successfully";
			expectedMsg = actual + "page should display successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual + "page  not displayed";
			expectedMsg = actual + "page should display successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
		

	
	

	
}
