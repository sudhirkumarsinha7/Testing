package com.cisco.gsx.pageObjects;

import java.util.Properties;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_OnSiteGuide {
	
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Requiredelement = null;
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	public static void CheckinPage()
	{
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.click(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.waitForPageload();
		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.onsiteguide.header"),
				Requiredelement);
		//CommonUtil.click(elementProperties.getProperty("cisco.checkin.link"));
		//CommonUtil.waitForPageload();
		//Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.onsiteguide.arrivals"));
		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.checkin.header"),
				commonProperties.getProperty("cisco.checkin.title"));
	}
	public static void GettingAround()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gettingaround.link"));
		CommonUtil.waitForPageload();
		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.Shuttles.header"),
				commonProperties.getProperty("cisco.shuttle.title"));
	}
	public static void Wellness()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.wellness.link"));
		CommonUtil.click(elementProperties.getProperty("cisco.wellness.link"));
		CommonUtil.waitForPageload();

		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.wellness.header"),Requiredelement);
	}
	public static void GlobalCelebrations()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.globalcelebration.link"));
		CommonUtil.click(elementProperties.getProperty("cisco.globalcelebration.link"));
		CommonUtil.waitForPageload();
		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.globalcelebration.header"),Requiredelement);
	}
	
	public static void FAQPage(){
		
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.onsiteguide.link"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.faqs.link"));
		CommonUtil.click(elementProperties.getProperty("cisco.faqs.link"));
		CommonUtil.waitForPageload();
		GSX_OnSiteGuide.ValidateOnSite(elementProperties.getProperty("cisco.faq.header"),
				commonProperties.getProperty("cisco.faq.title"));
		
		}
	public static void validateFaq(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected;
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = Actual+"  page is displayed successfully";
			expectedMsg = Actual+"  page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = Actual+" page is display failed";
			expectedMsg = Actual+"  page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void ValidateOnSite(String expected, String actual) {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println(actualMsg+ "......"+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actual + "page is displayed successfully";
			expectedMsg = actual + "page should display successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual + "page is not displayed";
			expectedMsg = actual + "page should display successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
		
}
	
	
	
	
	
	
	


