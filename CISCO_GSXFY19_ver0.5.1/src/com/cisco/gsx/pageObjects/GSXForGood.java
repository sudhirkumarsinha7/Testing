 package com.cisco.gsx.pageObjects;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSXForGood {
	
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
	public static void GSXForGood()
	{
		
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsxforgood.link"));

		CommonUtil.click(elementProperties.getProperty("cisco.gsxforgood.link"));
		CommonUtil.waitForPageload();
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.Connect.Attendees"));
		//CommonUtil.waitForPageload();
		ValidateConnection(elementProperties.getProperty("ccisco.gsxforgood.header"),Requiredelement);

		
		
	}
	
	public static void ValidateConnection(String expected, String actual) {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println("actualMsg : "+actualMsg+ "......"+"expectedMsg : "+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actual + "page is displayed successfully";
			expectedMsg = actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual + "page is not displayed";
			expectedMsg = actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
		

	
	

	
}
