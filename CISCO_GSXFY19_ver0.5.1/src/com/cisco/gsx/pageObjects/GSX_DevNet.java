package com.cisco.gsx.pageObjects;

import java.util.Properties;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_DevNet {
	
	
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
	//crated Methods-vijaya
	public static void DevNetPage(){
		
		CommonUtil.waitForPageload();	
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.Devnet"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		String DevNetTitle= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.Devnet.title"));
		System.out.println(DevNetTitle);
		GSX_DevNet.validateDevNet(DevNetTitle,"DEVNET");
		CommonUtil.waitForPageload();	
		
		}
	
	public static void validateDevNet(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected;
		System.out.println("expectedMsg : "+Expected +"Actual : "+actualMsg);

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
		
		}
	
	
	
	
	
	
	


