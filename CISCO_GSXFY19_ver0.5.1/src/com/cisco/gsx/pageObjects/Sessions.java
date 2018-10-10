package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Sessions {

	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	public static String expected = null;
	private static String Expected = null;
	private static String sessionTitle = null;
	private static boolean flag = false;
	private static String personalTime = null;
	private static List<WebElement> list = null;
	// public static List<WebElement> list = null;

	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public static void sessionfullagenda() {
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Sessions.ValidateSessions(elementProperties
				.getProperty("cisco.gsx.sessions.fullagendapage"),
				Requiredelement);
	}

	public static void sessioncategoryguides() {
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions.categoryguide"));
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions.categoryguide"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Sessions.ValidateSessions(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions.categoryguidepage"),
				Requiredelement);
	}

	public static void sessionList() {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
		CommonUtil.waitForPageload();
	

		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsxheader"),
				commonProperties.getProperty("cisco.schedule"));
		/*CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.recommendation"));
		CommonUtil.waitForPageload();*/

		CommonUtil.click(elementProperties
				.getProperty("cisco.scheduler.TuesTab"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.list"));
		CommonUtil.waitForPageload();
	}

	public static void sessionsaddtomyagenda() {

		sessionList();
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
		CommonUtil.click(elementProperties
				.getProperty("cisco.sessions.secondsession"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);

		System.out.println("loop" + sessionStatus);
		/*if((CommonUtil.getAttribute(
				elementProperties.getProperty("cisco.details.plus"), "type").equals("plus"))||
				(CommonUtil.getAttribute(
						elementProperties.getProperty("cisco.details.plus"), "type").equals("minus"))){
			*/	if (sessionStatus.equals("plus")) {
					System.out.println("plus");
					CommonUtil.click(elementProperties.getProperty("cisco.mygsx.plus"));
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
					}
					System.out.println("After Alert");
					Sessions.Validateaddtomyagenda(
							elementProperties.getProperty("cisco.mygsx.minus"), "minus");
					sessionTitle = CommonUtil.getText(elementProperties
							.getProperty("cisco.sessionsetails.title"));
					System.out.println("sessionTitle" + sessionTitle);
				} else {
					System.out.println("minus");
					// CommonUtil.click(elementProperties.getProperty("cisco.scheduler.minus"));
					// CommonUtil.handleAlert();
					Sessions.Validateaddtomyagenda(
							elementProperties.getProperty("cisco.details.plus"), "minus");
					sessionTitle = CommonUtil.getText(elementProperties
							.getProperty("cisco.sessionsetails.title"));
					System.out.println("sessionTitle" + sessionTitle);
					// Validateaddtomyagenda(elementProperties.getProperty("cisco.scheduler.plus"),
					// "plus");
				}
		/*}else{
			System.out.println("failed");
			actualMsg = "Lock icon is present instead of plus or minus to add the session to my agenda";
			expectedMsg = "Plus or minus is present to add the session to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}*/

		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		Requiredelement = CommonUtil.getText(elementProperties
				.getProperty("cisco.mygsx"));
		System.out.println(Requiredelement);

		MyGsx.ValidateMyGsx(
				elementProperties.getProperty("cisco.gsx.mygsxheader"),
				Requiredelement);


				CommonUtil.click(elementProperties.getProperty("cisco.mygsx.list"));
				CommonUtil.explicitlyWait(2);
				List<WebElement> myAgendaList = CommonUtil.findElements(elementProperties
								.getProperty("cisco.role.mondaysessions"));
				System.out.println(myAgendaList.size());
				// myAgendaList.clear();

				for (int i = 1; i <= myAgendaList.size(); i++) {
					System.out.println("In for loop");
					//Verifing the Favorite Symbol status minus or Lock
					if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Mon.favoriteSymbol").replaceAll(
							"VarX", Integer.toString(i)), "type").equals("minus")){
						System.out.println("If minus");
						String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Mon.personaltime").replaceAll(
								"VarX", Integer.toString(i)));
						System.out.println("personalTime" + personalTime);
					
						//Verifing the PersonalTime Text
						if(personalTime.equals(commonProperties.get("personalTime"))){
							System.out.println("Personaltime Activity");
						}else{
							
							CommonUtil.click(elementProperties.getProperty(
									"cisco.role.mondaysessions.count.minus").replaceAll(
									"VarX", Integer.toString(i)));
		
							CommonUtil.waitForPageload();
		
							String expected = CommonUtil.getText(elementProperties
									.getProperty("cisco.MyGSX.Title"));
							System.out.println("expected" + expected);
		
							// Expectedlist.add(expected);
							System.out.println("After expected");
							if (expected.equalsIgnoreCase(sessionTitle)) {
								System.out.println("Session Title" + sessionTitle);
		
								actualMsg = "Session successfully added to My GSX ";
								expectedMsg = "Session successfully added to My GSX";
								status = "PASS";
								status = "Pass";
								CommonUtil.logMessage(expectedMsg, actualMsg, status);
								flag = true;
								break;
		
							}
		
							CommonUtil.explicitlyWait(3);
							System.out.println("After expected");
							CommonUtil.click(elementProperties
									.getProperty("cisco.role.session.back"));
							CommonUtil.waitForPageload();
							CommonUtil.explicitlyWait(3);
						
						}
					}else{
						System.out.println("Lock");
					}
				}
				if (!flag) {

					myAgendaList = CommonUtil.findElements(elementProperties
							.getProperty("cisco.role.tuesdaysessions"));
					System.out.println(myAgendaList.size());
					// Expectedlist.clear();

					for (int i = 1; i <= myAgendaList.size(); i++) {
						if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Tue.favoriteSymbol").replaceAll(
								"VarX", Integer.toString(i)), "type").equals("minus")){
					
							String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Tue.personaltime").replaceAll(
									"VarX", Integer.toString(i)));
							
							if(personalTime.equals(commonProperties.get("personalTime"))){
								System.out.println("Personaltime Activity");
							}else{
								System.out.println("No Personaltime Activity");
								CommonUtil.click(elementProperties.getProperty(
										"cisco.role.tuesdaysessions.count.minus").replaceAll(
										"VarX", Integer.toString(i)));
		
								CommonUtil.waitForPageload();
		
								String expected = CommonUtil.getText(elementProperties
										.getProperty("cisco.MyGSX.Title"));
								System.out.println("expected" + expected);
		
								// Expectedlist.add(expected);
								System.out.println("After expected");
								if (expected.equalsIgnoreCase(sessionTitle)) {
									System.out.println("After expected" + sessionTitle);
		
									actualMsg = "Session is  added to MY GSX";
									expectedMsg = "Selected session should display in the MYGSX screen";
									status = "Pass";
									CommonUtil.logMessage(expectedMsg, actualMsg,
											status);
									flag = true;
									break;
		
								}
		
								CommonUtil.explicitlyWait(3);
								System.out.println("After expected");
								CommonUtil.click(elementProperties
										.getProperty("cisco.role.session.back"));
								CommonUtil.waitForPageload();
								CommonUtil.explicitlyWait(3);
							}
						
						}else{
							System.out.println("Lock");
					    }
				    }
			   }
				if (!flag) {
					myAgendaList = CommonUtil.findElements(elementProperties
							.getProperty("cisco.role.weddaysessions.minus"));
					System.out.println(myAgendaList.size());
					// Expectedlist.clear();

					for (int i = 1; i <= myAgendaList.size(); i++) {
						
						if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Wed.facoriteSymbol").replaceAll(
								"VarX", Integer.toString(i)), "type").equals("minus")){
					
							String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Wed.personaltime").replaceAll(
									"VarX", Integer.toString(i)));
							
							if(personalTime.equals(commonProperties.get("personalTime"))){
								System.out.println("Personaltime Activity");
							}else{
								CommonUtil.click(elementProperties.getProperty(
										"cisco.role.weddaysessions.count.minus").replaceAll(
										"VarX", Integer.toString(i)));
		
								CommonUtil.waitForPageload();
		
								String expected = CommonUtil.getText(elementProperties
										.getProperty("cisco.MyGSX.Title"));
								System.out.println("expected" + expected);
		
								// Expectedlist.add(expected);
								System.out.println("After expected");
								if (expected.equalsIgnoreCase(sessionTitle)) {
									System.out.println("After expected" + sessionTitle);
		
									actualMsg = "Session is  added to MY GSX";
									expectedMsg = "Selected session should display in the MYGSX screen";
									status = "Pass";
									CommonUtil.logMessage(expectedMsg, actualMsg,
											status);
									flag = true;
									break;
		
								}
		
								CommonUtil.explicitlyWait(3);
								System.out.println("After expected");
								CommonUtil.click(elementProperties
										.getProperty("cisco.role.session.back"));
								CommonUtil.waitForPageload();
								CommonUtil.explicitlyWait(3);
							}
						}else{
							System.out.println("Lock");
						}
				   }
				}
				if (!flag) {

					actualMsg = "Session not added to MY GSX";
					expectedMsg = "Selected session should display in the MYGSX screen";
					status = "Pass";
					status = "Fail";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
				}	

	}

	public static void sessionsvenuedetails() {
		sessionList();
		list = CommonUtil.findElements(elementProperties.getProperty("scheduler.sessionscount"));
		System.out.println("list : " + list.size());
		VenueDetails(list);
		CommonUtil.click(elementProperties.getProperty("cisco.scheduler.MondayTab"));
		CommonUtil.waitForPageload();
		list = CommonUtil.findElements(elementProperties.getProperty("scheduler.sessionscount"));
		System.out.println("list : " + list);

		VenueDetails(list);
		CommonUtil.click(elementProperties.getProperty("cisco.scheduler.WednesTab"));
		CommonUtil.waitForPageload();
		list = CommonUtil.findElements(elementProperties.getProperty("scheduler.sessionscount"));
		System.out.println("list : " + list);

		VenueDetails(list);
	}
	public static void VenueDetails(List<WebElement> list){

		for (int i = 1; i <= list.size(); i++) {
			
			String sessionName = CommonUtil.getText(elementProperties
					.getProperty("scheduler.sessionName").replaceAll("VarX", Integer.toString(i)));
			System.out.println("sessionName : " + sessionName);
			
			String Venue = CommonUtil.getText(elementProperties
					.getProperty("cisco.session.venue").replaceAll("VarX", Integer.toString(i)));
			System.out.println("expected : " + Venue);
			
			CommonUtil.click(elementProperties.getProperty("cisco.session.Name").replaceAll("VarX", Integer.toString(i)));
			CommonUtil.waitForPageload();
			String Sessiodetails_Name = CommonUtil.getText(elementProperties.getProperty("Cisco.Venue.SessionName"));
			System.out.println("Session Name :" + Sessiodetails_Name);
			CommonUtil.explicitlyWait(4);
	
			//String Actual = CommonUtil.getText(elementProperties.getProperty("cisco.sessiondetails.venue"));
			//System.out.println("Actual : " + expected);
			
			ValidateVenueDetails(Venue,Sessiodetails_Name,sessionName);
			CommonUtil.click(elementProperties.getProperty("search.back"));
			CommonUtil.waitForPageload();
		}
	}
	public static void ValidateVenueDetails(String Venue, String ActualName,String expectedName) {

		CommonUtil.waitForPageload();
		
		if (ActualName.equalsIgnoreCase(expectedName)) {
			actualMsg = "Session Name : " + ActualName +"Venue Details : "+Venue+" displayed";
			expectedMsg = "Session Name : " + ActualName +"Venue Details : "+Venue+" should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Name : " + ActualName + "Venue Details : "+Venue+" displayed";
			expectedMsg = "Session Name : " + ActualName + "Venue Details : "+Venue+" should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void sessionsspeakerdetails() {

		sessionList();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.BreakoutSession"));
		CommonUtil.explicitlyWait(3);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);


		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.sessions.secondsession"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);

		if (CommonUtil.isElementPresent1(elementProperties
				.getProperty("cisco.session.speaker.label"))) {
			System.out.println("if loop");
			Sessions.ValidateSessions(elementProperties
					.getProperty("cisco.session.speaker.label"), "Speakers");
			Requiredelement = CommonUtil.getText(elementProperties
					.getProperty("cisco.session.speakertitle"));
			System.out.println("if loop" + Requiredelement);

			CommonUtil.click(elementProperties
					.getProperty("cisco.session.speakername"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSpeaker(elementProperties
					.getProperty("cisco.session.speakerheader"),
					Requiredelement);

			CommonUtil.click(elementProperties
					.getProperty("cisco.sessions.speaker.firstsession"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSessions(elementProperties
					.getProperty("cisco.session.speaker.label"), "Speakers");

		} else {
			actualMsg = "Speakers not displayed in session details page";
			expectedMsg = "Speakers is displayed in session details page";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void ValidateSpeaker(String expected, String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println();
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Sessions" + actual + "page is displayed successfully";
			expectedMsg = "Sessions" + actual
					+ "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Sessions" + actual + "page is not displayed";
			expectedMsg = "Sessions" + actual
					+ "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void validatesessionspeakerorder() {
		sessionList();
		// CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.BreakoutSession"));
		CommonUtil.explicitlyWait(3);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);

		CommonUtil.click(elementProperties
				.getProperty("cisco.sessions.secondsession"));
		CommonUtil.waitForPageload();
		// CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
		// "1 September, 2015");
		// CommonUtil.explicitlyWait(3);
		// CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.fullagendapage.secondsessionlist"));
		// CommonUtil.waitForPageload();
		// CommonUtil.explicitlyWait(3);
		if (CommonUtil.isElementPresent1(elementProperties
				.getProperty("cisco.session.speaker.label"))) {
			System.out.println("if loop");
			Sessions.ValidateSessions(elementProperties
					.getProperty("cisco.session.speaker.label"), "Speakers");
			// Requiredelement =
			// CommonUtil.getText(elementProperties.getProperty("cisco.session.speakertitle"));
			// System.out.println("if loop"+Requiredelement);

			CommonUtil.click(elementProperties
					.getProperty("cisco.session.speakername"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			if (CommonUtil.isElementPresent1(elementProperties
					.getProperty("cisco.session.speaker.title"))
					&& CommonUtil.isElementPresent1(elementProperties
							.getProperty("cisco.sessiom.speaker.image"))
					&& CommonUtil
							.isElementPresent1(elementProperties
									.getProperty("cisco.sessiom.speaker.sessionIncludes"))) {

				Point point1 = CommonUtil.findElement(
						elementProperties
								.getProperty("cisco.session.speaker.title"))
						.getLocation();
				Point point2 = CommonUtil.findElement(
						elementProperties
								.getProperty("cisco.sessiom.speaker.image"))
						.getLocation();
				Point point3 = CommonUtil
						.findElement(
								elementProperties
										.getProperty("cisco.sessiom.speaker.sessionIncludes"))
						.getLocation();
				System.out.println(point1 + "  " + point2 + "  " + point3);
				if (point1.y > point2.y || point2.y > point3.y) {
					expected = "True";
				} else {

					expected = "False";
				}
				Sessions.Validatefullagendasessionspeakeroder(expected, "True");

			}

			else {
				System.out.println("Speaker information is not accurate");
				actualMsg = "Speaker information is not accurate";
				expectedMsg = "Speaker information is accurate";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
		}
	}

	public static void sessionDetailsLayout() {

		sessionList();
		CommonUtil.click(elementProperties
				.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.isChecked(elementProperties
				.getProperty("Cisco.Sessiontype.BreakoutSession"));
		CommonUtil.explicitlyWait(3);
		CommonUtil.ESCAPE();
		CommonUtil.explicitlyWait(3);

		CommonUtil.click(elementProperties
				.getProperty("cisco.sessions.secondsession"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);

		if (CommonUtil.isElementPresent1(elementProperties
				.getProperty("cisco.session.title"))
				&& CommonUtil.isElementPresent1(elementProperties
						.getProperty("cisco.session.image"))
				&& CommonUtil.isElementPresent1(elementProperties
						.getProperty("cisco.session.catalog"))
				&& CommonUtil.isElementPresent1(elementProperties
						.getProperty("cisco.session.description"))
				&& CommonUtil.isElementPresent1(elementProperties
						.getProperty("cisco.session.times"))
				&& CommonUtil.isElementPresent1(elementProperties
						.getProperty("cisco.session.speakers")))

		{

			Point point1 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.title"))
					.getLocation();
			Point point2 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.image"))
					.getLocation();
			Point point3 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.catalog"))
					.getLocation();
			Point point4 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.description"))
					.getLocation();
			Point point5 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.times"))
					.getLocation();

			Point point6 = CommonUtil.findElement(
					elementProperties.getProperty("cisco.session.speakers"))
					.getLocation();

			// Point point4
			// =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.description")).getLocation();
			System.out.println(point1.y);
			System.out.println(point2.y);
			System.out.println(point3.y);
			System.out.println(point4.y);
			System.out.println(point5.y);
			System.out.println(point6.y);
			// System.out.println(point4.y);

			if (point2.y < point1.y && point3.y < point4.y
					&& point5.y < point6.y) {
				System.out.println("true");
				Expected = "True";
			} else {
				System.out.println("false");

				Expected = "False";
			}
			Validatefullagendasessionlayout(Expected, "True");

		}

		else {

			Validatefullagendasessioninformation("false", "True");
		}

	}

	private static void Validatefullagendasessioninformation(String expected,
			String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
			actualMsg = "Session Details page Layout is in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session information is not accurate";
			expectedMsg = "Session information should be accurate ";
			status = "FAIL";
			System.out.println("Session information not accurate  ");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	private static void Validatefullagendasessionlayout(String expected,
			String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
			actualMsg = "Session Details page Layout is in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "PASS";
			System.out.println("pass");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Details page Layout is  not in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	public static void ValidateSessions(String expected, String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println(expectedMsg + "----------------" + actualMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Sessions" + actual + "page is displayed successfully";
			expectedMsg = "Sessions" + actual
					+ "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Sessions" + actual + "page is not displayed";
			expectedMsg = "Sessions" + actual
					+ "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void Validateaddtomyagenda(String expected, String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected, "type");
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

	private static void Validatefullagendasessionspeakeroder(String expected,
			String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
			actualMsg = "Session Details page Layout is in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "PASS";
			System.out.println("pass");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Details page Layout is  not in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	// ##################### FULLAGENDA PAGE
	// VALIDATION###############################################

	public static void fullAgendaPage() {
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions"));
		CommonUtil.waitForPageload();
		Mouseoverelement = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.waitForPageload();
		String fullAgendaPageTitle = "Full Agenda";
		CommonUtil.explicitlyWait(5);
		System.out.println(fullAgendaPageTitle);
		Sessions.validateFullAgendaPage(fullAgendaPageTitle, Mouseoverelement);

	}

	public static void validateFullAgendaPage(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected;
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = Actual + "page is displayed successfully";
			expectedMsg = Actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = Actual + "page is display failed";
			expectedMsg = Actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	// ########################## SESSION TIME VALIDATION IN FULL AGENDA
	// PAGE###############################

	public static void fullAgendaDatePage() {

		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);

		List<WebElement> list = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
		for (int i = 1; i <= list.size(); i++) {

			Expected = CommonUtil.getText(elementProperties.getProperty(
					"cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1")
					.replaceAll("VarX", Integer.toString(i)));
			System.out.println(Expected);
			Sessions.validateThesessionDates(Expected, "25 Jun");
		}

		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
						"31 August, 2015");
		CommonUtil.explicitlyWait(5);
		List<WebElement> list1 = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
		for (int i = 1; i <= list1.size(); i++) {
			Expected = CommonUtil.getText(elementProperties.getProperty(
					"cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1")
					.replaceAll("VarX", Integer.toString(i)));
			System.out.println(Expected);
			Sessions.validateThesessionDates(Expected, "31 Aug");
		}
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
						"1 September, 2015");
		CommonUtil.explicitlyWait(5);
		List<WebElement> list2 = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
		for (int i = 1; i <= list2.size(); i++) {
			Expected = CommonUtil.getText(elementProperties.getProperty(
					"cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1")
					.replaceAll("VarX", Integer.toString(i)));
			System.out.println(Expected);
			Sessions.validateThesessionDates(Expected, "1 Sep");
		}
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
						"2 September, 2015");
		CommonUtil.explicitlyWait(5);
		List<WebElement> list3 = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
		for (int i = 1; i <= list3.size(); i++) {
			Expected = CommonUtil.getText(elementProperties.getProperty(
					"cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1")
					.replaceAll("VarX", Integer.toString(i)));
			System.out.println(Expected);
			Sessions.validateThesessionDates(Expected, "2 Sep");
		}
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
						"4 September, 2015");
		CommonUtil.explicitlyWait(5);
		List<WebElement> list4 = CommonUtil
				.findElements(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
		for (int i = 1; i <= list4.size(); i++) {
			Expected = CommonUtil.getText(elementProperties.getProperty(
					"cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1")
					.replaceAll("VarX", Integer.toString(i)));
			System.out.println(Expected);
			Sessions.validateThesessionDates(Expected, "4 Sep");
		}

		CommonUtil.waitForPageload();

	}

	public static void validateThesessionDates(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected.split(",")[0];

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = " Session Time Details displaced successfully ";
			expectedMsg = "Session Time Details displaced successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Time Details not Displayed";
			expectedMsg = "Session Time Details displaced successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	// ############################ SESSION DETAILS PAGE VALIDATION
	// ####################

	public static void fullagendaSessionDetailsPage() {

		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Expected = CommonUtil
				.getText(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionsdetailspagetitle"));
		Sessions.validateFullAgendaSessionDetailsPage(Expected,
				"Session Details");

		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.mouseOverOption(elementProperties
				.getProperty("cisco.gsx.mygsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"),
						"31 August, 2015");
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Expected = CommonUtil
				.getText(elementProperties
						.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionsdetailspagetitle"));
		Sessions.validateFullAgendaSessionDetailsPage(Expected,
				"Session Details");

	}

	public static void validateFullAgendaSessionDetailsPage(String Expected,
			String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected;

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = Actual + " page is displayed successfully";
			expectedMsg = Actual + " page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = Actual + " page is display failed";
			expectedMsg = Actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	private static void Validatefullagendaplusminus(String expected,
			String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
			actualMsg = actual + "is highlighted successfully";
			expectedMsg = actual + "is highlighted successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual + "is not highlighted";
			expectedMsg = actual + "is highlighted successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	// ########################### SESSION DETAILS PAGE
	// VALIDATION############################

}
