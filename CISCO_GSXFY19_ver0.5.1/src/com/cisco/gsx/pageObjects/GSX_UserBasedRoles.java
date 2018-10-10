package com.cisco.gsx.pageObjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_UserBasedRoles {
	
	public static Properties elementProperties=null;
	public static Properties commonProperties=null;
	private static String Mouseoverelement=null;
	private static String actualMsg=null;
	private static String expectedMsg=null;
	private static String status=null;
	private static String Expected=null;
	private static String Expectedclass=null;
	private static List<WebElement> list = null;
	private static List<WebElement> list1 = null;
	private static List<WebElement> Valuelist1 = null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Speakerlist = new ArrayList<String>();
	private static String user=null;
	

	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	
	
//############## User Roles General,Regional/segment,Invited##############################
	
	public static void attendeeRole(){
		
		
		CommonUtil.waitForPageload();
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "Attendee");
	}

	public static void HallofFame(){
		
		CommonUtil.waitForPageload();
	
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "HallofFame");
	}

	public static void ManagerExcellence(){
		
		CommonUtil.waitForPageload();
		//CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.managerexcellence.username"));
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "ManagerExcellence");
	}

	public static void chairmansClub(){
	
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "ChairmansClub");
	}
	
	public static void achiever(){
		
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(4);
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "Achiever");
		
	}

	public static void salesChampion(){
		
		CommonUtil.waitForPageload();
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "Saleschampion");
		
	}
	
	public static void executive(){
		
		CommonUtil.waitForPageload();
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "Executive");
		
	}	
//###################### User Roles Invited only ##############
public static void eventStaff(){
	
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	System.out.println(Expected);
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "EventStaff");
	
}


public static void hubStaff(){
	
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "HubStaff");
	
}


public static void supportStaff(){
	
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "SupportStaff");
	
}

	
	
	
public static String checkUserBasedsessions(){	
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));

		 
		
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.mondaysessions"));
		System.out.println(list.size());
		Expectedlist.clear();
		
		for(int i=1;i<=list.size();i++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Mon.favoriteSymbol").replaceAll(
					"VarX", Integer.toString(i)), "type").equals("minus")){
				String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Mon.personaltime").replaceAll(
						"VarX", Integer.toString(i)));
				
				if(personalTime.equals(commonProperties.get("PersonalTime"))){
					System.out.println("Personaltime Activity");
				}else{	
					CommonUtil.click(elementProperties.getProperty("cisco.role.mondaysessions.count").replaceAll("VarX",Integer.toString(i)));
					CommonUtil.waitForPageload();
					
					System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
					String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
					System.out.println("expected"+expected);	 
	
					Expectedlist.add(expected);
					System.out.println("After expected");
					
					
					 CommonUtil.explicitlyWait(3);
					 System.out.println("After expected");
					 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
					 CommonUtil.waitForPageload();
					 CommonUtil.explicitlyWait(3);
				}
			}else{
				CommonUtil.click(elementProperties.getProperty("cisco.role.mondaysessions.count").replaceAll("VarX",Integer.toString(i)));
				
				CommonUtil.waitForPageload();
				
				System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
				String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
				System.out.println("expected"+expected);	 

				Expectedlist.add(expected);
				
				
				 CommonUtil.explicitlyWait(3);
				 System.out.println("After expected");
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(3);
				
			}
			 
		}
		System.out.println("Expectedlistitems:"+Expectedlist); 
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.tuesdaysessions"));
		System.out.println(list.size());
		//Expectedlist.clear();
		
		for(int i=1;i<=list.size();i++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Tue.favoriteSymbol").replaceAll(
					"VarX", Integer.toString(i)), "type").equals("minus")){
				String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Tue.personaltime").replaceAll(
						"VarX", Integer.toString(i)));
				
				if(personalTime.equals(commonProperties.get("personalTime"))){
					System.out.println("Personaltime Activity");
				}else{
					CommonUtil.click(elementProperties.getProperty("cisco.role.tuesdaysessions.count").replaceAll("VarX",Integer.toString(i)));
					
					CommonUtil.waitForPageload();
					
						System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
						String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
						Expectedlist.add(expected);
					 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
					 CommonUtil.waitForPageload();
					 CommonUtil.explicitlyWait(3);
				}
			}else{
				CommonUtil.click(elementProperties.getProperty("cisco.role.tuesdaysessions.count").replaceAll("VarX",Integer.toString(i)));
				
				CommonUtil.waitForPageload();
				
					System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
					String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
					Expectedlist.add(expected);
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(3);
				
			}
			 
		}
		System.out.println("Expectedlistitems:"+Expectedlist); 
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.weddaysessions"));
		System.out.println(list.size());
		//Expectedlist.clear();
		
		for(int i=1;i<=list.size();i++){
			if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.Wed.favoriteSymbol").replaceAll(
					"VarX", Integer.toString(i)), "type").equals("minus")){
			
				System.out.println("for loop");
				String personalTime = CommonUtil.getText(elementProperties.getProperty("cisco.Wed.personaltime").replaceAll(
						"VarX", Integer.toString(i)));
				System.out.println("personalTime" + personalTime);
			
				//Verifing the PersonalTime Text
				if(personalTime.equals(commonProperties.get("personalTime"))){
					System.out.println("Personaltime Activity");
				}else{
					CommonUtil.click(elementProperties.getProperty("cisco.role.weddaysessions.count").replaceAll("VarX",Integer.toString(i)));
					
					CommonUtil.waitForPageload();
				
						System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
						String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
						Expectedlist.add(expected);
					
					
					 CommonUtil.explicitlyWait(3);
					 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
					 CommonUtil.waitForPageload();
					 CommonUtil.explicitlyWait(3);
				}
			}else{
				CommonUtil.click(elementProperties.getProperty("cisco.role.weddaysessions.count").replaceAll("VarX",Integer.toString(i)));
				
				CommonUtil.waitForPageload();
			
					System.out.println(CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type")));	 
					String expected=CommonUtil.getText(elementProperties.getProperty("cisco.role.session.type"));
					Expectedlist.add(expected);
				
				
				 CommonUtil.explicitlyWait(3);
				 CommonUtil.click(elementProperties.getProperty("cisco.role.session.back"));
				 CommonUtil.waitForPageload();
				 CommonUtil.explicitlyWait(3);
				
			}
					 
		}
		System.out.println("Expectedlistitems:"+Expectedlist); 
		
		
		//if((Expectedlist.contains("Invited Session - Mandatory"))&&(Expectedlist.contains("Region/Segment Session")))
		
		if((Expectedlist.contains("Global Session"))&&(Expectedlist.contains("Geo/Segment Session")))
		{
			Expected="True";
		}else
			Expected="False";
			
		return Expected;
}	
	
	
	
	
public static void validateUserBased(String expected, String actual) {
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		
		user=actual;
		if (expectedMsg.equalsIgnoreCase("True")) {
			actualMsg =   "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			expectedMsg = "General Sessions and Regional/Segment Sessions should Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			status = "PASS";
			System.out.println(actualMsg);
			System.out.println(expectedMsg);
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "General Sessions and Regional/Segment Sessions are  Pre-poulated and Invited sessions are Not Dispalyed for "+ user+" Role" ;
			expectedMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			status = "FAIL";
			System.out.println(actualMsg);
			System.out.println(expectedMsg);
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
		CommonUtil.waitForPageload();	

		
		
		}

public static void validateUserBasedInvitedonly(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;
	user=actual;
	System.out.println(expectedMsg);
	if (expectedMsg.equalsIgnoreCase("True")) {
		actualMsg =   "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions should Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "PASS";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}

public static void validateUserBasedInvitedonly1(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;
	user=actual;
	System.out.println(expectedMsg);
	if (expectedMsg.equalsIgnoreCase("True")) {
		actualMsg =   "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "PASS";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are NOT Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are NOT Dispalyed for "+ user+" Role" ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}




//######################PrePopulatedSessions ##############################

	public static void  globalGeneralSession()
	{	
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.globalsessions.title.count"));
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.globalsessions.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+SessionTitle );
			if(SessionTitle.equalsIgnoreCase("Opening Global Session")){
				System.out.println("Session title :"+SessionTitle );
				Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.globalsessions.icon").replaceAll("VarX", Integer.toString(i)),"type");
				break;
			}
		}	
				
			
		//Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.myagenda.generallockclass"), "class");
		
		System.out.println(Expected);
		GSX_UserBasedRoles.validateglobalGeneralSession(Expected,"lock");
		
			
		
			
	}	
	public static void validateglobalGeneralSession(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
	
		System.out.println("expectedMsg "+expectedMsg+"actualMsg "+actualMsg);
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =   "Global General Sessions isPre-poulated and Button is unselectable" ;
			expectedMsg = "Global General Sessions isPre-poulated and Button is unselectable" ;
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Global General Sessions is Pre-poulated and Button is selectable" ;
			expectedMsg = "Global General Sessions is Pre-poulated and Button is unselectable";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
		
		
		CommonUtil.waitForPageload();	
	
		
		
		}	

	public static void  mealsSession(){	
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.globalsessions.title.count"));
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.globalsessions.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+SessionTitle );
			if(SessionTitle.equalsIgnoreCase("Lunch")){
				System.out.println("Session title :"+SessionTitle );
				Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.globalsessions.icon").replaceAll("VarX", Integer.toString(i)),"type");
				break;
			}
		}	
		System.out.println(Expected);
		GSX_UserBasedRoles.validatelunchSession(Expected,"lock");
			
		
}		
	
	public static void validatelunchSession(String expected, String actual) {
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
	
		System.out.println("expectedMsg : "+expectedMsg+"actualMsg : "+actualMsg);
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =   "Meals Sessions isPre-poulated and Button is unselectable" ;
			expectedMsg = "Meals Sessions isPre-poulated and Button is unselectable" ;
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Meals Sessions is Pre-poulated and Button is selectable" ;
			expectedMsg = "Meals General Sessions is Pre-poulated and Button is unselectable";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
	}
		
	
	CommonUtil.waitForPageload();	

	
	
	}

	public static void  americaSession(DataPojoClass pojo){	
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.region.title.count"));
		System.out.println(list.size());
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.region.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+i+SessionTitle );
			if(pojo.getRegion().equals("Americas")||(pojo.getRegion().equals("Global Alignment"))){
				System.out.println("Americas "+pojo.getRegion());

				if(SessionTitle.equalsIgnoreCase("Transforming the Americas. Extraordinary Together!")){
					System.out.println("Session title :"+SessionTitle );
					Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.region.icon").replaceAll("VarX", Integer.toString(i)),"type");
					break;
				}
			}
		}
		
		System.out.println(Expected);
		validateRegionSession(Expected,"minus","Americas");
	

 }		
	public static void GSPSegmentSession(DataPojoClass pojo){
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.globalsessions.title.count"));
		System.out.println(list.size());
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.globalsessions.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+i+SessionTitle );
			
				if(SessionTitle.equalsIgnoreCase("Global Service Provider – You Say You Want a Revolution?")){
					System.out.println("Session title :"+SessionTitle );
					Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.globalsessions.icon").replaceAll("VarX", Integer.toString(i)),"type");
					break;
				}
					
			
		}	
		
		System.out.println(Expected);
		validateRegionSession(Expected,"minus","Americas");
	

	}
	public static void  emearSession(){	
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.region.title.count"));
		System.out.println(list.size());
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.region.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+i+SessionTitle );
			if(SessionTitle.equalsIgnoreCase("EMEAR Geo Session")){
				System.out.println("Session title :"+SessionTitle );
				Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.region.icon").replaceAll("VarX", Integer.toString(i)),"type");
				break;
			}
		}	
		System.out.println(Expected);
		validateRegionSession(Expected,"minus","EMEAR");
			

	}		
	public static void validateRegionSession(String expected, String actual,String value) {
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
	
		System.out.println("actualMsg : "+actualMsg+" expectedMsg :"+expectedMsg);
		if (expectedMsg.equals("minus")) {
			System.out.println("if block value : "+value);
			actualMsg =   value +"Regional Sessions is Pre-poulated and session is Removed" ;
			expectedMsg = value +"Regional Sessions is Pre-poulated and session is Removed" ;
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("actualMsg "+actualMsg+"expectedMsg"+expectedMsg);
			actualMsg = value +"Regional Sessions is Pre-poulated and Button is unselectable" ;
			expectedMsg = value +"Regional Sessions is Pre-poulated and session is Removed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
		CommonUtil.waitForPageload();
		
	
	}
	
	public static void AustraliaSession(){
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.List"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.enlarge"));
		CommonUtil.waitForPageload();
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.session.region.title.count"));
		System.out.println(list.size());
		for(int i=1;i<=list.size();i++){
			System.out.println("for loop");
			String SessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.session.region.title").replaceAll("VarX", Integer.toString(i)));
			System.out.println("Session title :"+i+SessionTitle );
			if(SessionTitle.equalsIgnoreCase("APJC Geo Session: Stronger Than Ever")){
				System.out.println("Session title :"+SessionTitle );
				Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.session.region.icon").replaceAll("VarX", Integer.toString(i)),"type");
				break;
			}
		}	
		System.out.println(Expected);
		validateRegionSession(Expected,"minus","APJC");
			

	}
	
	
	
public static void  invitedSession(){	

		CommonUtil.waitForPageload();
		//CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.invited.username"));
		//CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.invited.password"));
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isAlertPresent())
		CommonUtil.handleAlert();
		
		
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
	
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(8);
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.invited"));
		System.out.println("invited"+CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.invited12")));
		CommonUtil.explicitlyWait(6);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.invited12")))
		{
			System.out.println("invited session  found");
			Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.invitedclass"), "class");
			System.out.println(Expected);
			GSX_UserBasedRoles.validateSession(Expected,"locked");
			
		}
		else{
			System.out.println("invited session  not found");
			actualMsg = "Invited Session is NOT Pre-poulated " ;
			expectedMsg = "Invited Session should be Pre-poulated " ;
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	
	}		
		
public static void validateSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Invited Sessions is Pre-poulated and Button is unselectable";
		expectedMsg = "Invited Sessions is Pre-poulated and Button is unselectable";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Invited Sessions is Pre-poulated and selectable";
		expectedMsg = "Invited Sessions is Pre-poulated and Button is unselectable";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	
	CommonUtil.waitForPageload();	

	}
public static void validateSessionpresents(String expected) {
	CommonUtil.waitForPageload();
	
	expectedMsg = expected;

	System.out.println(expectedMsg);
	
		actualMsg = expectedMsg+" Session is NOT Pre-poulated " ;
		expectedMsg = expectedMsg+" Session should be Pre-poulated " ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}

//###############  Speakers To dispaly  ################


	public static List<String> spekersToDisplay(){ 
		 CommonUtil.waitForPageload();
		 CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
		 CommonUtil.waitForPageload();
		 CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		 CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(3);
		 CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
		 CommonUtil.explicitlyWait(5);
		 
		 /**
		 CommonUtil.waitForPageload();
		 CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
		 CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(3);
		 CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MyAgenda"));
		 CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(5); 
		 */
		 for(int i=1;i<100;i++){
		    
	
		   if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.rolebased.speakers.donotdelete")))
		   {
		    CommonUtil.click(elementProperties.getProperty("cisco.gsx.rolebased.speakers.donotdelete"));
		    CommonUtil.waitForPageload();
		    CommonUtil.explicitlyWait(5);
		    break;
		   }
		   else{
		    CommonUtil.click(elementProperties.getProperty("cisco.gsx.rolebased.speaker.nextpage"));
		   CommonUtil.waitForPageload();
		   CommonUtil.explicitlyWait(5); 
		  }
		 }
	
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.mygsx.myagenda.donotdeletetestsession2.speakersList"));
		System.out.println(list.size());
		Speakerlist.clear();
	
		for(int i=1;i<=list.size();i++){
		Speakerlist.add(CommonUtil.getText(elementProperties.getProperty("cisco.mygsx.myagenda.donotdeletetestsession2.speakersNames").replaceAll("VarX", Integer.toString(i))));
		}
		System.out.println(Speakerlist);
	
	
		return Speakerlist;
		}
		
	
	
	public static void  surveyOnlySpaeaker(){	
		//pass Tricia Schaller notdisply
		System.out.println(Speakerlist);
		if (!Speakerlist.contains("Tricia Schaller")) {
			actualMsg = "Speakers who are Survey Only are not displayed";
			expectedMsg = "Speakers who are Survey Only are not displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Speakers who are Survey Only are displayed";
			expectedMsg = "Speakers who are Survey Only are not displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	
		
	
	}
	
	public static void  moderatorSpaeaker(){	
		//fail Matt Koellner display
		GSX_UserBasedRoles.spekersToDisplay();
		System.out.println(Speakerlist);
		if (Speakerlist.contains("Matt Koellner")) {
			actualMsg = "Speakers who are Moderator are displayed";
			expectedMsg = "Speakers who are Moderator are displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Speakers who are Moderator are not  displayed";
			expectedMsg = "Speakers who are Moderator are displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	
		
	
	}
	
	public static void  displayAndSurveySpaeaker(){	
		//pass  Test SPM DO NOT DELETE display
		GSX_UserBasedRoles.spekersToDisplay();
		System.out.println(Speakerlist);
		if (Speakerlist.contains("Test SPM DO NOT DELETE")) {
			actualMsg = "Speakers who are Display and Survey are displayed";
			expectedMsg = "Speakers who are Display and Survey are displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Speakers who are Display and Survey are not  displayed";
			expectedMsg = "Speakers who are Display and Survey are displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	
		
	}
	
	public static void  displayOnlySpaeaker(){	
		//pass Tina Mena display
		GSX_UserBasedRoles.spekersToDisplay();
		System.out.println(Speakerlist);
		if (Speakerlist.contains("Tina Mena")) {
			actualMsg = "Speakers who are Display Only are displayed";
			expectedMsg = "Speakers who are Display Only are displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Speakers who are Display Only are  not displayed";
			expectedMsg = "Speakers who are Display Only are displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	
		
	}
	
	
		
	
		
	
		

	


}
