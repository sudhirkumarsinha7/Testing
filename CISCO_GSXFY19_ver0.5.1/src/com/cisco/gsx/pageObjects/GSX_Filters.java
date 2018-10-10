package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_Filters {

	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String Mouseoverelement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static List<String> actualMsglist = null;
	private static List<String> expectedMsglist = null;
	private static String status = null;
	private static List<String> Expected = null;
	private static List<String> Actual = null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Actuallist = new ArrayList<String>();
	private static String Expected1 = null;
	private static String Expectedfilter = null;
	private static String filter = null;
	public static List<WebElement> checkboxes = null;
	public static List<WebElement> checkboxes1 = null;
	private static String Filterlist = null;
	private static String realtedActualMsg = null;
	// new ArrayList<String>();
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	public static void scheduler(){
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.TuesTab"));
		CommonUtil.waitForPageload();
	/*	CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.recommendation"));*/
		CommonUtil.waitForPageload();
		
	}

	public static void Filters() {

		// System.out.println("entered into fullagenda");
		
		scheduler();
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		List<WebElement> list = CommonUtil.findElements(elementProperties
				.getProperty("cisco.filter.count"));

		System.out.println("list.size()" + list.size());

		Expectedlist.clear();
		Actuallist.clear();
		for (WebElement e : list) {
			System.out.println(e.getText());
			Expectedlist.add(e.getText());

		}

		Actuallist.add("Type");
		Actuallist.add("Track");
		Actuallist.add("Specialty/Category");
		Actuallist.add("Pillar");
		System.out.println(Actuallist);
		System.out.println(Expectedlist);

		GSX_Filters.validateFilterTypes(Expectedlist, Actuallist);
	}

	public static void validateFilterTypes(List<String> Expected,
			List<String> Actual) {
		CommonUtil.waitForPageload();
		actualMsglist = Actual;
		expectedMsglist = Expected;

		if (actualMsglist.containsAll(expectedMsglist)) {
			System.out.println("Pass");
			actualMsg = " Three Type categories are dispalyed Successfully ";
			expectedMsg = "Three Type categories are  dispalyed Successfully ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("fail");
			actualMsg = "Three Type categories are not  dispalyed Successfully ";
			expectedMsg = "Three Type categoriesare  dispalyed Successfully ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void verifyPillarCategory() {

		scheduler();

		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));

		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);

		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("cisco.pillar.RelatedStrategicPillar"));
		System.out.println("Type" + checkboxes.size());
		Expectedlist.clear();
		Actuallist.clear();
		for (int i = 0; i < 5; i++) {

			List<WebElement> list = CommonUtil.findElements(elementProperties
					.getProperty("cisco.tarck.count").replaceAll("VarX",
							Integer.toString(i + 1)));

			System.out.println("list.size()" + list.size());

			for (WebElement e : list) {
				System.out.println(e.getText());
				String s = e.getText();
				String reg = s.replaceAll("[^a-z A-Z-/]", "");
				// String t2 = "!@#$%^&*()-';,./?><+abdd";

				Expectedlist.add(reg.trim());

			}

		}

		Actuallist.clear();

		Actuallist.add("Create Meaningful Experiences");
		Actuallist.add("Increased Pace of Innovation");
		Actuallist.add("None of the Above");
		Actuallist.add("Power a Multicloud World");
		Actuallist.add("Reinvent the Network");
		Actuallist.add("Security is Foundational");
		Actuallist.add("Unlock the Power of Data");
		Actuallist.add("Create Meaningful Experiences");
		Actuallist.add("Increased Pace of Innovation");
		Actuallist.add("Not Applicable");
		Actuallist.add("Power a Multicloud World");
		Actuallist.add("Reinvent the Network");
		Actuallist.add("Security is Foundational");
		Actuallist.add("Unlock the Power of Data");
		System.out.println(Actuallist);
		System.out.println(Expectedlist);
		if (Actuallist.containsAll(Expectedlist)) {

			actualMsg = "Pillar filter options are displayed Successfully ";
			expectedMsg = "Pillar options sholud display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {

			actualMsg = "Pillar filter options are not displayed Successfully ";
			expectedMsg = "Pillar options sholud display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	public static void CategoryFilter() {

		scheduler();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
		CommonUtil.explicitlyWait(2);
		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.All"));
		System.out.println("Type" + checkboxes.size());
		// String[] trackValues = new String[3];
		Expectedlist.clear();
		Actuallist.clear();
		for (int i = 0; i < checkboxes.size(); i++) {
			String xpath = elementProperties.getProperty("cisco.tarck.count")
					.replaceAll("VarX", Integer.toString(i + 1));
			String s = CommonUtil.getText(xpath);
			String reg = s.replaceAll("[^a-z A-Z-/]", "");
			// String t2 = "!@#$%^&*()-';,./?><+abdd";

			Expectedlist.add(reg.trim());

		}

		Actuallist.clear();
		Actuallist.add("Analytics");
		Actuallist.add("Cisco Capital");
		Actuallist.add("Collaboration");
		Actuallist.add("Customer Experience");
		Actuallist.add("Data Center and Cloud");
		Actuallist.add("Enterprise Networking");
		Actuallist.add("IoT and Industry Digitization");
		//Actuallist.add("Other");
		Actuallist.add("Partner Ecosystem");
		Actuallist.add("People and Culture");
		Actuallist.add("Security");
		Actuallist.add("Seller Enablement");
		Actuallist.add("Selling Software");
		Actuallist.add("Service Provider Technology");

		// Actuallist.add("specifyText");

		System.out.println(Actuallist);
		System.out.println(Expectedlist);

		if (Actuallist.containsAll(Expectedlist)) {

			actualMsg = "Category Type Filter options are dispalyed Successfully ";
			expectedMsg = "Category filter option should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {

			actualMsg = "Primary Category  Filters are not dispalyed Successfully ";
			expectedMsg = "Primary Category  Filters are dispalyed Successfully ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	public static void TrackFilters() {

		scheduler();

		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
		CommonUtil.explicitlyWait(2);
		String AcutalXpath = elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontrack.All");

		System.out.println("AcutalXpath" + AcutalXpath);
		// String[] trackValues = new String[3];
		Expectedlist.clear();
		Actuallist.clear();
		for (int i = 1; i <= 3; i++) {
			String xpath = elementProperties.getProperty("cisco.tarck.count")
					.replaceAll("VarX", Integer.toString(i));
			String s = CommonUtil.getText(xpath);
			String reg = s.replaceAll("[^a-z A-Z-]", "");
			// String t2 = "!@#$%^&*()-';,./?><+abdd";

			Expectedlist.add(reg.trim());

		}

		Actuallist.clear();

		Actuallist.add("AM - Go To Market");
		Actuallist.add("SE - Technical Solutions");
		Actuallist.add("Sales Culture and Enablement");

		System.out.println(Actuallist);
		System.out.println(Expectedlist);

		if (Actuallist.containsAll(Expectedlist)) {

			actualMsg = "TRACK Type Filters are dispalyed Successfully ";
			expectedMsg = "TRACK Type Filters are dispalyed Successfully ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {

			actualMsg = "TRACK Type Filters are not dispalyed Successfully ";
			expectedMsg = "TRACK Type Filters are dispalyed Successfully ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void SessionTypeFilters() {

		scheduler();

		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.explicitlyWait(2);
		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.All"));
		System.out.println("Type" + checkboxes.size());
		// String[] trackValues = new String[3];
		Expectedlist.clear();
		Actuallist.clear();
		for (int i = 0; i < checkboxes.size(); i++) {
			String xpath = elementProperties.getProperty("cisco.tarck.count")
					.replaceAll("VarX", Integer.toString(i + 1));
			String s = CommonUtil.getText(xpath);
			String reg = s.replaceAll("[^a-z A-Z-/]", "");
			// String t2 = "!@#$%^&*()-';,./?><+abdd";

			Expectedlist.add(reg.trim());

		}

		Actuallist.clear();

		Actuallist.add("Breakout Session");
		Actuallist.add("DevNet Session");
		Actuallist.add("Global Session");
		Actuallist.add("Meal");
		Actuallist.add("Special Activity");
		Actuallist.add("Super Session");
		Actuallist.add("The Hub");
		Actuallist.add("Hub After Hours");
		Actuallist.add("WWSE Session");
		
		System.out.println(Actuallist);
		System.out.println(Expectedlist);
		/*
		 * for(String option:Actuallist){
		 * System.out.println("Actuallistvalues :"+option); }
		 */

		if (Actuallist.containsAll(Expectedlist)) {
			System.out
					.println("TYPE Filter options are dispalyed Successfully ");
			actualMsg = "TYPE Filters are dispalyed Successfully ";
			expectedMsg = "TYPE Filters are dispalyed Successfully ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("TYPE Filters are not dispalyed Successfully ");
			actualMsg = "TYPE Filters are dispalyed Successfully ";
			expectedMsg = "TYPE Filters are dispalyed Successfully ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);

		}

	}

	// ################################### Set Category Filter
	// #######################
	public static void filtersCount(int exp, int act, String Type) {
		actualMsg = Integer.toString(exp);
		expectedMsg = Integer.toString(act);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = "Session Category " + Type + "  Count is " + actualMsg;
			expectedMsg = "Session Category " + Type + " Count Should display "
					+ expectedMsg;
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = "Session Category " + Type + " Filter Count is "
					+ actualMsg;
			expectedMsg = "Session Category " + Type
					+ "Count Should be matched with " + expectedMsg;
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}

	}

	public static void verifyPillarSessions() {
		scheduler();
		
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));

		CommonUtil.waitForPageload();
		//CommonUtil.explicitlyWait(3);
		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.SessionPillar.All"));
		System.out.println("Track" + checkboxes.size());
		// filtersCount(checkboxes.size(),12,"Pillar");
		CommonUtil.explicitlyWait(1);

		for (int i = 0; i < 5; i++) {
			System.out.println("Outerforloop");

			List<WebElement> list = CommonUtil.findElements(
					elementProperties.getProperty(
							"Cisco.Sessioncatalog.Sessiontype.single")
							.replaceAll("VarX", Integer.toString(i + 1)));

			System.out.println("list.size()" + list.size());
			
			for (int z = 0; z < 1; z++) {
				System.out.println("Inner For loop"+list.size());
				actualMsg =list.get(0) .getAttribute("name");
				realtedActualMsg =list.get(1) .getAttribute("name");
				
				System.out.println("actualMsg" + actualMsg + realtedActualMsg);

				if (actualMsg.equalsIgnoreCase("1004791981")) {

					System.out.println("CreatingMeaningFullExperience");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.CreatingMeaningFullExperience"));
					System.out.println("Selected CreatingMeaningFullExperience checkbox");
					CommonUtil.waitForPageload();
					 CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Create Meaningful Experiences", "Primary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.CreatingMeaningFullExperience"));
					CommonUtil.explicitlyWait(2);
					System.out.println("*******************Done");


				} else if (actualMsg.equalsIgnoreCase("708662224")) {

					System.out.println("IncreacedPaceofInnovation");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.IncreacedPaceofInnovation"));
					System.out.println("Selected Cisco Capital checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Increased Pace of Innovation", "Primary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.IncreacedPaceofInnovation"));
					CommonUtil.explicitlyWait(3);

				}/*
				 * else
				 * if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase
				 * ("1707638804")) {
				 * 
				 * System.out.println("IncreacedPaceofInnovation");
				 * CommonUtil.isChecked(elementProperties.getProperty(
				 * "Cisco.SessionCatalog.Primary.PoweraMulticloudWorld"));
				 * System.out.println("Selected Cisco Capital checkbox");
				 * CommonUtil.waitForPageload(); CommonUtil.ESCAPE();
				 * CommonUtil.explicitlyWait(2);
				 * CommonUtil.click(elementProperties
				 * .getProperty("cisco.Category.link"));
				 * CommonUtil.explicitlyWait(1);
				 * 
				 * SessionCatalog.validatePillar(elementProperties.getProperty(
				 * "Cisco.Pillar.text"), "Power a Multicloud World","Primary");
				 * CommonUtil.click(elementProperties.getProperty(
				 * "Cisco.SessionCatalog.Primary.PoweraMulticloudWorld"));
				 * CommonUtil.explicitlyWait(2);
				 * CommonUtil.isChecked(elementProperties.getProperty(
				 * "Cisco.SessionCatalog.Primary.IncreacedPaceofInnovation"));
				 * CommonUtil.explicitlyWait(2); }
				 */else if (actualMsg.equalsIgnoreCase("1541914573")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.ReinventtheNetwork"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Reinvent the Network", "Primary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.ReinventtheNetwork"));
					CommonUtil.explicitlyWait(2);

				} else if (actualMsg.equalsIgnoreCase("1029766233")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.SecurityFoundational"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Security is Foundational", "Primary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.SecurityFoundational"));
					CommonUtil.explicitlyWait(2);

				} else if (actualMsg.equalsIgnoreCase("132867579")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.UnlockPowerOfData"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Unlock the Power of Data", "Primary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Primary.UnlockPowerOfData"));
					CommonUtil.explicitlyWait(2);

				} else if (realtedActualMsg.equalsIgnoreCase("849600347")) {

					System.out
							.println("Secondary - CreatingMeaningFullExperience");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.CreatingMeaningFullExperience"));
					System.out
							.println("Selected CreatingMeaningFullExperience checkbox");
					CommonUtil.waitForPageload();
					// CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Create Meaningful Experiences", "Secondary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.CreatingMeaningFullExperience"));
					CommonUtil.explicitlyWait(2);

				} else if(realtedActualMsg.equalsIgnoreCase("958481482")) {

					System.out.println("IncreacedPaceofInnovation");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.IncreacedPaceofInnovation"));
					System.out.println("Selected Cisco Capital checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Increased Pace of Innovation", "Secondary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.IncreacedPaceofInnovation"));
					CommonUtil.explicitlyWait(3);

				}/*
				 * else
				 * if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase
				 * ("429190853")) {
				 * 
				 * System.out.println("IncreacedPaceofInnovation");
				 * CommonUtil.isChecked(elementProperties.getProperty(
				 * "Cisco.SessionCatalog.Primary.PoweraMulticloudWorld"));
				 * System.out.println("Selected Cisco Capital checkbox");
				 * CommonUtil.waitForPageload(); CommonUtil.ESCAPE();
				 * CommonUtil.explicitlyWait(2);
				 * CommonUtil.click(elementProperties
				 * .getProperty("cisco.Category.link"));
				 * CommonUtil.explicitlyWait(1);
				 * 
				 * SessionCatalog.validatePillar(elementProperties.getProperty(
				 * "Cisco.Pillar.text"),
				 * "Power a Multicloud World","Secondary");
				 * CommonUtil.click(elementProperties
				 * .getProperty("Cisco.SessionCatalog.Primary.PoweraMulticloudWorld"
				 * )); CommonUtil.explicitlyWait(2);
				 * CommonUtil.isChecked(elementProperties.getProperty(
				 * "Cisco.SessionCatalog.Primary.IncreacedPaceofInnovation"));
				 * CommonUtil.explicitlyWait(2); }
				 */else if (realtedActualMsg.equalsIgnoreCase("293603205")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.ReinventtheNetwork"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Reinvent the Network", "Secondary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.ReinventtheNetwork"));
					CommonUtil.explicitlyWait(2);

				} else if (realtedActualMsg.equalsIgnoreCase("293603205")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.SecurityFoundational"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Security is Foundational", "Secondary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.SecurityFoundational"));
					CommonUtil.explicitlyWait(2);

				} else if (realtedActualMsg.equalsIgnoreCase("2075593516")) {

					System.out.println("CIsco Captial");
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.UnlockPowerOfData"));
					System.out
							.println("Selected PoweraMulticloudWorld checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties
							.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);

					validatePillar(
							elementProperties.getProperty("Cisco.Pillar.text"),
							"Unlock the Power of Data", "Secondary");
					CommonUtil
							.click(elementProperties
									.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil
							.isChecked(elementProperties
									.getProperty("Cisco.SessionCatalog.Secondary.UnlockPowerOfData"));
					CommonUtil.explicitlyWait(2);

				}
			}

		}

	}

	public static void validatePillar(String sessionTypeXpath,
			String sessionTypeName, String PillarType) {
		CommonUtil.explicitlyWait(1);
		expectedMsg = sessionTypeName;// AM - Go To Market
		System.out.println("Expected Message : " + expectedMsg);

		List<WebElement> list = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Pillar.text.count"));
		System.out.println("Track List Count : " + list.size());

		for (int i = 1; i <= list.size(); i++) {

			if (PillarType.equals("Primary"))
				actualMsg = CommonUtil.getText(elementProperties.getProperty(
						"Cisco.Pillar.text").replaceAll("VarX",
						Integer.toString(i)));
			else
				actualMsg = CommonUtil.getText(elementProperties.getProperty(
						"Cisco.Pillar.Second.text").replaceAll("VarX",
						Integer.toString(i)));

			if (actualMsg.contains(expectedMsg))
				break;
		}
		System.out.println("Actual Message : " + actualMsg);

		if (actualMsg.contains(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " Track is successfully verified";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			CommonUtil.click(elementProperties
					.getProperty("cisco.session.Close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);

		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName + " Track verification is failed";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}

	}

	public static void setCategoryFilters() {
		scheduler();
	//	CommonUtil.click(elementProperties
		//		.getProperty("cisco.scheduler.TuesTab"));
		//CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
		System.out.println("Category");
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
		CommonUtil.explicitlyWait(2);

		checkboxes1 = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessioncategory.All"));
		System.out.println("Track" + checkboxes1.size());
		filtersCount(checkboxes1.size(), 12, "Category");
		CommonUtil.explicitlyWait(1);

		for (int i = 0; i < checkboxes1.size(); i++) {
			actualMsg = CommonUtil.getAttribute(
					elementProperties.getProperty(
							"Cisco.Sessioncatalog.Sessiontype.single")
							.replaceAll("VarX", Integer.toString(i + 1)),
					"name");

			System.out.println("actualMsg" + actualMsg);
			if (actualMsg.equalsIgnoreCase("1013663199")) {

				System.out.println("Analytics");
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.Analytics"));
				System.out.println("Selected Analytics checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				boolean b = CommonUtil.isAlertPresent();
				System.out.println("boolean" + b);
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Analytics");
				CommonUtil.explicitlyWait(3);
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.Analytics"));
				CommonUtil.explicitlyWait(3);

			} else if (actualMsg.equalsIgnoreCase("70393164")) {

				System.out.println("Cisco Captial");
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.CiscoCaptial"));
				System.out.println("Selected Cisco Capital checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Cisco Capital");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.CiscoCaptial"));
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("1937947358")) {
				System.out.println("EnetPriseNetworking");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.DataAndCloud"));
				System.out.println("Selected EnetPrise Networking checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Data Center and Cloud");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.DataAndCloud"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("1480483528")) {
				System.out.println("EnetPriseNetworking");

				CommonUtil
						.isChecked(elementProperties
								.getProperty("Cisco.SessionCategory.EnetPriseNetworking"));
				System.out.println("Selected EnetPrise Networking checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Enterprise Networking");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil
						.isChecked(elementProperties
								.getProperty("Cisco.SessionCategory.EnetPriseNetworking"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("1519479855")) {
				System.out.println("People and Culture");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.PeopleAndCulture"));
				System.out.println("Selected People and Culture checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"People and Culture");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.PeopleAndCulture"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("1610391797")) {
				System.out.println("Security");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.Security"));
				System.out.println("Selected Security checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Security");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.Security"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("1153040361")) {
				System.out.println("SellerEnablement");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.SellerEnablement"));
				System.out.println("Selected SellerEnablement checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Seller Enablement");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.SellerEnablement"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("2013690847")) {
				System.out.println("SellerEnablement");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.SellingSoftWare"));
				System.out.println("Selected Selling Software checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateCategory(
						elementProperties.getProperty("Cisco.Category.text"),
						"Selling Software");
				CommonUtil
						.click(elementProperties
								.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.SessionCategory.SellingSoftWare"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			}

		}
	}

	public static void validateCategory(String sessionTypeXpath,
			String sessionTypeName) {
		CommonUtil.explicitlyWait(3);
		expectedMsg = sessionTypeName;
		System.out.println("Expected Message : " + expectedMsg);

		actualMsg = CommonUtil.getText(sessionTypeXpath);
		// CommonUtil.scroll(CommonUtil.findElement(elementProperties.getProperty("Cisco.Category.Paragraph")));
		// CommonUtil.explicitlyWait(1);
		System.out.println("Actual Message : " + actualMsg);

		// System.out.println("Description :"+CommonUtil.getText(elementProperties.getProperty("Cisco.Category.Paragraph")));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " Category is successfully verified";
			expectedMsg = sessionTypeName
					+ " Category is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			CommonUtil.click(elementProperties
					.getProperty("cisco.session.Close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);
			// Scheduler.ValidateSessions(elementProperties.getProperty("cisco.scheduler.header"),"Build Your Schedule");

			// CommonUtil.ESCAPE();
			// CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);

		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName + " Category verification is failed";
			expectedMsg = sessionTypeName
					+ " Category is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void setTrackFilters() {

		scheduler();
		
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
		CommonUtil.explicitlyWait(2);

		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontrack.All"));
		System.out.println("Track" + checkboxes.size());
		CommonUtil.explicitlyWait(1);
		// filtersCount(checkboxes.size(),3,"Track");

		for (int i = 0; i < checkboxes.size(); i++) {
			actualMsg = CommonUtil.getAttribute(
					elementProperties.getProperty(
							"Cisco.Sessioncatalog.Sessiontype.single")
							.replaceAll("VarX", Integer.toString(i + 1)),
					"name");

			System.out.println("actualMsg" + actualMsg);
			if (actualMsg.equalsIgnoreCase("1619782344")) {
				//
				System.out.println("stageric");
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontrack.AMGoToMarket"));
				System.out.println("click is working");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(3);
				System.out.println("Alert");
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				System.out.println("Alert");
				validateTrack(
						elementProperties.getProperty("cisco.Track.text.count"),
						"AM - Go To Market");

				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontrack.AMGoToMarket"));
				CommonUtil.explicitlyWait(2);

				System.out.println("After If");

			} else if (actualMsg.equalsIgnoreCase("974002996")) {

				System.out.println("SE");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.SETechnicalSolutions"));
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(2);
				validateTrack(
						elementProperties.getProperty("cisco.Track.text.count"),
						"SE - Technical Solutions");
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);
				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.SETechnicalSolutions"));
				CommonUtil.explicitlyWait(1);
			} else if (actualMsg.equalsIgnoreCase("1432497143")) {
				System.out.println("Sales");

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.SalesCulture"));
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(1);
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				validateTrack(
						elementProperties.getProperty("cisco.Track.text.count"),
						"Sales Culture and Enablement");
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);

			}

			CommonUtil.waitForPageload();
			/*
			 * System.out.println("After Wait");
			 * CommonUtil.click(elementProperties.getProperty("Test"));
			 * CommonUtil.explicitlyWait(2);
			 * 
			 * CommonUtil.click(elementProperties.getProperty(
			 * "Cisco.Sessioncatalog.Sessiontype.Track"));
			 * CommonUtil.explicitlyWait(2);
			 */
		}
	}

	public static void validateTrack(String sessionTypeXpath,
			String sessionTypeName) {
		CommonUtil.explicitlyWait(1);
		expectedMsg = sessionTypeName;// AM - Go To Market
		System.out.println("Expected Message : " + expectedMsg);

		List<WebElement> list = CommonUtil.findElements(elementProperties
				.getProperty("cisco.Track.text.count"));
		System.out.println("Track List Count : " + list.size());

		for (int i = 1; i <= list.size(); i++) {

			actualMsg = CommonUtil
					.getText(elementProperties.getProperty("cisco.Track.text")
							.replaceAll("VarX", Integer.toString(i)));
			System.out.println("actualMsg" + i + actualMsg);
			if (actualMsg.contains(expectedMsg))
				break;
		}
		System.out.println("Actual Message : " + actualMsg);

		// CommonUtil.scroll(CommonUtil.findElement(elementProperties.getProperty("Cisco.Category.Paragraph")));
		// CommonUtil.explicitlyWait(1);
		System.out.println("Actual Message : " + actualMsg);
		if (actualMsg.contains(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " Track is successfully verified";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			CommonUtil.click(elementProperties
					.getProperty("cisco.session.Close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);

		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName + " Track verification is failed";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void setTypeFilters() {

		scheduler();
	
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.explicitlyWait(2);
		checkboxes = CommonUtil.findElements(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.All"));
		System.out.println("Type" + checkboxes.size());
		CommonUtil.explicitlyWait(1);
		// filtersCount(checkboxes.size(),3,"Type");

		for (int k = 0; k < checkboxes.size(); k++) {
			actualMsg = CommonUtil.getAttribute(
					elementProperties.getProperty(
							"Cisco.Sessioncatalog.Sessiontype.single")
							.replaceAll("VarX", Integer.toString(k + 1)),
					"name");

			System.out.println("actualMsg" + actualMsg);

			if (actualMsg.equalsIgnoreCase("194243063")) {

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.BreakoutSession"));
				CommonUtil.explicitlyWait(2);

				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(3);

				validateType(
						elementProperties.getProperty("cisco.Track.text.count"),
						"Breakout Session");

				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.BreakoutSession"));
				CommonUtil.explicitlyWait(2);

			} else if (actualMsg.equalsIgnoreCase("1279275194")) {
				System.out.println("DevNetSession");
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.DevNetSession"));
				CommonUtil.explicitlyWait(1);

				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(3);
				System.out.println("Alert");
				// CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				System.out.println("Alert");
				validateType(
						elementProperties.getProperty("cisco.Track.text.count"),
						"DevNet Session");

				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.DevNetSession"));
				CommonUtil.explicitlyWait(1);

			} else if (actualMsg.equalsIgnoreCase("275451120")) {

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.SuperSession"));
				CommonUtil.explicitlyWait(1);
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(3);
			
				validateType(
						elementProperties.getProperty("cisco.Track.text.count"),
						"Super Session");

				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
				CommonUtil.explicitlyWait(2);

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.Sessiontype.SuperSession"));
				CommonUtil.explicitlyWait(1);
				
				CommonUtil.click(elementProperties.getProperty("cisco.scheduler.MondayTab"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.sessiontype.WWSE"));
				CommonUtil.explicitlyWait(1);
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties
						.getProperty("cisco.Track.link"));
				CommonUtil.explicitlyWait(3);
			
				validateType(
						elementProperties.getProperty("cisco.Track.text.count"),
						"WWSE Session");

				CommonUtil.click(elementProperties
						.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
				CommonUtil.explicitlyWait(2);

				CommonUtil.isChecked(elementProperties
						.getProperty("Cisco.sessiontype.WWSE"));

			}
		}
		CommonUtil.waitForPageload();
	}

	public static void validateType(String sessionTypeXpath,
			String sessionTypeName) {
		CommonUtil.explicitlyWait(1);
		expectedMsg = sessionTypeName;// AM - Go To Market
		System.out.println("Expected Message : " + expectedMsg);

		List<WebElement> list = CommonUtil.findElements(elementProperties
				.getProperty("cisco.Type.text.count"));
		System.out.println("Track List Count : " + list.size());

		for (int i = 1; i <= list.size(); i++) {

			actualMsg = CommonUtil.getText(elementProperties.getProperty(
					"cisco.Type.text").replaceAll("VarX", Integer.toString(i)));
			System.out.println("actualMsg" + i + actualMsg);
			if (actualMsg.contains(expectedMsg))
				break;
		}
		System.out.println("Actual Message : " + actualMsg);

		// CommonUtil.scroll(CommonUtil.findElement(elementProperties.getProperty("Cisco.Category.Paragraph")));
		// CommonUtil.explicitlyWait(1);
		System.out.println("Actual Message : " + actualMsg);
		if (actualMsg.contains(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " Track is successfully verified";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			CommonUtil.click(elementProperties
					.getProperty("cisco.session.Close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);

		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName + " Track verification is failed";
			expectedMsg = sessionTypeName + " Track is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void validateSessionTypes(String sessionTypeXpath,
			String sessionTypeName, String realCount) {

		CommonUtil.explicitlyWait(1);
		String count = CommonUtil.getText(realCount);

		String[] arrOfStr = count.split(" ");

		for (String a : arrOfStr) {
			System.out.println(a);
		}
		// System.out.println(">>>>>>>>>>>>>>"+arrOfStr[2].substring(1, 2));
		String sessions = arrOfStr[2].substring(1, 3);
		System.out.println(sessions);

		List<WebElement> SessionTitles = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.Sessiontype.titles"));
		System.out.println("Session Titles Count " + SessionTitles.size());
		CommonUtil.explicitlyWait(1);
		// List<WebElement>
		// sessionTypeNames=CommonUtil.findElements(sessionTypeXpath);
		actualMsg = sessions;
		expectedMsg = Integer.toString(SessionTitles.size());
		System.out.println("Number " + actualMsg + "*****" + expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + "Count is " + actualMsg;
			expectedMsg = sessionTypeName + "Count Should be matched with "
					+ expectedMsg;
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName + "Count is " + actualMsg;
			expectedMsg = sessionTypeName + "Count Should be matched with "
					+ expectedMsg;
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}

	}

}
