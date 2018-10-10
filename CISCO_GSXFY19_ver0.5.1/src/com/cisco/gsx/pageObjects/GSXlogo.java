package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSXlogo {
	static int flag =0;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	public static void BuildYourSchedule()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Mygsx");
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.text"),"Customize your schedule and make GSX all about you.");
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.LOGO.BuildYourSchedule"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.BuildYourSchedule"),"Build Your Schedule");
		CommonUtil.waitForPageload();
	}
	public static void Viewtheweek()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Mygsx");
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.text"),"Customize your schedule and make GSX all about you.");
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.LOGO.Viewtheweek"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.BuildYourSchedule"),"Build Your Schedule");
		CommonUtil.waitForPageload();
	}
	public static void SeetheFinalists()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Mygsx");
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.text"),"Customize your schedule and make GSX all about you.");
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.LOGO.SeetheFinalists"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.SeetheFinalists.text"),"Voting will begin on August 14, through GSX Mobile and be available in The Hub beginning August 20 so start thinking about who will get yours. We’ll announce the winner live during the Closing Global Session on Wednesday, August 22.");
		CommonUtil.waitForPageload();
	}
	
	public static void FAQandPolicies()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Mygsx");
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.text"),"Customize your schedule and make GSX all about you.");
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.LOGO.FAQandPolicies"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		GSXlogo.ValidateGSXLogo(elementProperties.getProperty("cisco.gsx.LOGO.FrequentlyAskedQuestions"),"Frequently Asked Questions");
		CommonUtil.waitForPageload();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ValidateGSXLogo(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println("actualMsg-"+actualMsg);
		System.out.println("expectedMsg-"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actual + "page is displayed successfully";
			expectedMsg =actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		} else {
			actualMsg =actual + "page is not displayed";
			expectedMsg = actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
			CommonUtil.waitForPageload();	
		}
}



