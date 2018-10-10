package com.cisco.gsx.pageObjects;



import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;


public class MyGsx {
	static int flag =0;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	private static String Expected=null;
	
	private static String sessionTitle = null;
	private static List<WebElement> list = null;
	private static List<WebElement> list1 = null;
	private static List<WebElement> Valuelist1 = null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Speakerlist = new ArrayList<String>();
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	

	public static void MyAgendapageminusverification()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.mygsx.minus")))
		{

		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.mygsx.minus"), "type").equalsIgnoreCase("minus"))
		{
			CommonUtil.explicitlyWait(2);
			//CommonUtil.scroll(CommonUtil.findElements(elementProperties.getProperty("cisco.mygsx.sessions")));
			CommonUtil.click(elementProperties.getProperty("cisco.mygsx.list"));
			CommonUtil.explicitlyWait(2);
			List<WebElement> myAgendaList= CommonUtil.findElements(elementProperties.getProperty("cisco.mygsx.session.title"));

			for(int i=0;i<=myAgendaList.size();i++){
				  List<String> myAgendalistarray1 = new ArrayList<>();
				  	for(int j=0; j<myAgendaList.size(); j++) {
				  		myAgendalistarray1.add(myAgendaList.get(j).getText());
						System.out.println("Test : "+j +" ---- "+myAgendalistarray1.get(j));

				  } 
				  	Requiredelement = myAgendalistarray1.get(0);
					System.out.println("Requiredelement"+Requiredelement);
					//Requiredelement = myAgendalistarray1.get(1);
					//System.out.println("Requiredelement"+Requiredelement);

				  	
			}
		//	CommonUtil.click(elementProperties.getProperty("cisco.mygsx.minus"));
			
			//CommonUtil.handleAlert();
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);				
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.schedule"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.click(elementProperties.getProperty("cisco.scheduler.recommendation"));
			CommonUtil.explicitlyWait(3);

			List<WebElement> list=CommonUtil.findElements(elementProperties.getProperty("cisco.mygsx.schedule.title"));
			for(int i=0;i<=list.size();i++){
				System.out.println(list.size());
				List<String> Agendalistarray = new ArrayList<>();
				for(int j=0; j<list.size(); j++) {
					  Agendalistarray.add(list.get(j).getText());
				} 
					  	System.out.println(i+"---"+Agendalistarray.get(i));
				if(Agendalistarray.get(i).contains(Requiredelement)){
		  			CommonUtil.explicitlyWait(3);
		  			CommonUtil.click(elementProperties.getProperty("cisco.mygsx.schedule.sessiondetails.minusvalidation"));
		  			CommonUtil.waitForPageload();
		  			CommonUtil.explicitlyWait(3);
				  	if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.mygsx.minus")))
				  	{
		  				System.out.println("pass");
		  				actualMsg = "Session is  added to Agenda";
		  				expectedMsg = "Session is  added to Agenda";
		  				status = "Pass";
		  				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				  	}
				  	break;
				  }
				  else{
				  	System.out.println("Fail");
			  				
				  }
			
		  }
		
		}
		else
		{
			actualMsg = "Session is not added to my agenda";
			expectedMsg = "Session is  added to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		}
		else
		{
			System.out.println("failed");
			actualMsg = "Add/Remove +/- next to a session is not displayed";
			expectedMsg = "Add/Remove +/- next to a session is  displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	
/***********************************Sudhir**************************************************/	
	public static void RecommendationsActivity()
	{
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		String sessionStatus = CommonUtil.getAttribute(
				elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.plusminus"), "type");
		

		System.out.println("loop" + sessionStatus);
		if (sessionStatus.equals("plus")) {
			System.out.println("loop");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.plusminus"));
			CommonUtil.explicitlyWait(3);
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
		} else {
			System.out.println("minus");
			
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
		}
		list=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.list"));
		System.out.println(list.size());
		Expectedlist.clear();
		String expected=sessionTitle;
		for(int i=1;i<=list.size();i++){
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity").replaceAll("VarX",Integer.toString(i)));
			CommonUtil.waitForPageload();

			String actual=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.tittle"));
			System.out.println("actual"+actual);	 

			Expectedlist.add(actual);
			System.out.println("After actual");
			
			if (actual.equalsIgnoreCase(expected)) {
				actualMsg = actual + "page is displayed successfully";
				expectedMsg = actual + "page is displayed successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				break;
			} 
		 CommonUtil.explicitlyWait(3);
		 System.out.println("before back");
		 CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
		 CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(3);
			
		}
	
}
	
	
	

	
	
	

	
	
	
public static void Recommendationsession()
				{
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(3);
				
				
				list=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list"));
				System.out.println(list.size());
				Expectedlist.clear();
				String expected;
				for(int i=1;i<=list.size();i++){
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.activity").replaceAll("VarX",Integer.toString(i)));
				CommonUtil.waitForPageload();
				
				String actual=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.tittle"));
				TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.sessionRecommendation.symbol"), "recommended");
				System.out.println("actual"+actual);
				Expectedlist.add(actual);
				System.out.println("After actual");
				expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.symbol"),"type");
				expectedMsg=expected+" Session";
				System.out.println("After expectedMsg"+expectedMsg);
				//CommonUtil.logMessage(expectedMsg, actual, status);
				//CommonUtil.explicitlyWait(3);
				System.out.println("before back");
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(3);
				
				}

}	
public static void mycalederrecommendation()
			{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			String sessionStatus = CommonUtil.getAttribute(
				elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1.plusminus"), "type");
			
			
			System.out.println("loop" + sessionStatus);
			if (sessionStatus.equals("plus")) {
			System.out.println("loop");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1.plusminus"));
			CommonUtil.explicitlyWait(3);
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			} else {
			System.out.println("minus");
			
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.list.test1"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			}
			System.out.println("before calendar");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1.calender.lineview"));
			CommonUtil.waitForPageload();
			
			list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.mondaysessions"));
			System.out.println(list.size());
			Expectedlist.clear();
			String expected=sessionTitle;
			for(int i=1;i<=list.size();i++){
			CommonUtil.click(elementProperties.getProperty("cisco.role.mondaysessions.activity").replaceAll("VarX",Integer.toString(i)));
			CommonUtil.waitForPageload();
			
			String actual=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.tittle"));
			System.out.println("actual"+actual);	 
			
			Expectedlist.add(actual);
			System.out.println("After actual");
			
			if (actual.equalsIgnoreCase(expected)) {
				actualMsg = actual + "page is displayed successfully";
				expectedMsg = actual + "page is displayed successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				flag=1;
				break;
			} 
			CommonUtil.explicitlyWait(3);
			System.out.println("before back");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			}
			if(flag==0) {
			list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.tuesdaysessions"));
			System.out.println(list.size());
			Expectedlist.clear();
			
			for(int i=1;i<=list.size();i++){
			CommonUtil.click(elementProperties.getProperty("cisco.role.tuesdaysessions.activity").replaceAll("VarX",Integer.toString(i)));
			CommonUtil.waitForPageload();
			
			String actual=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.tittle"));
			System.out.println("actual"+actual);	 
			
			Expectedlist.add(actual);
			System.out.println("After actual");
			
			if (actual.equalsIgnoreCase(expected)) {
				actualMsg = actual + "page is displayed successfully";
				expectedMsg = actual + "page is displayed successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				break;
			} 
			CommonUtil.explicitlyWait(3);
			System.out.println("before back");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			}
			}
			
			if(flag==0) {
			list=CommonUtil.findElements(elementProperties.getProperty("cisco.role.weddaysessions"));
			System.out.println(list.size());
			Expectedlist.clear();
			
			for(int i=1;i<=list.size();i++){
				CommonUtil.click(elementProperties.getProperty("cisco.role.weddaysessions.activity").replaceAll("VarX",Integer.toString(i)));
				CommonUtil.waitForPageload();
			
				String actual=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.myactivity.tittle"));
				System.out.println("actual"+actual);	 
			
				Expectedlist.add(actual);
				System.out.println("After actual");
				
				if (actual.equalsIgnoreCase(expected)) {
					actualMsg = actual + "page is displayed successfully";
					expectedMsg = actual + "page is displayed successfully";
					status = "PASS";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
					break;
				} 
			 CommonUtil.explicitlyWait(3);
			 System.out.println("before back");
			 CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			 CommonUtil.waitForPageload();
			 CommonUtil.explicitlyWait(3);
			}
			}

}

	public static void cookies(){
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.cookiesPopUp"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
	}
	//by sudhir
	public static void ContactInformation()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Profile");
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx1.text"),"My GSX");
		System.out.println("after my gsx");
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.profile"));
		CommonUtil.waitForPageload();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx1.myprofile.text"),"My Profile");
		CommonUtil.explicitlyWait(2);
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.myprofile.editprofile"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.switchToFrame();
		cookies();
		CommonUtil.switchToDefault();
		System.out.println("After Accept cokkies");
		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame1"));
		CommonUtil.explicitlyWait(2);
		System.out.println("After FRame1");
		MyGsx.Validatemyprofilebutton(elementProperties.getProperty("cisco.mygsx.myprofile.return"),"Return to Edit Profile");

		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame2"));
		System.out.println("After FRame2");
		////CommonUtil.switchToDefault();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.mygsx.myprofile.editprofile.contactinfo.text"),"Contact Information");
	}		
	
	//by sudhir
	public static void AreaOfInterest()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Profile");
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx1.text"),"My GSX");
		System.out.println("after my gsx");
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.profile"));
		CommonUtil.waitForPageload();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx1.myprofile.text"),"My Profile");
		CommonUtil.explicitlyWait(2);
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.myprofile.profilQuestion"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.switchToFrame();
		cookies();
		CommonUtil.switchToDefault();
		System.out.println("After Accept cokkies");
		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame1"));
		CommonUtil.explicitlyWait(2);
		System.out.println("After FRame1");
		MyGsx.Validatemyprofilebutton(elementProperties.getProperty("cisco.mygsx.myprofile.return"),"Return to Edit Profile");

		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame2"));
		System.out.println("After FRame2");
		////CommonUtil.switchToDefault();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.mygsx.myprofile.editprofile.contactinfo.text"),"Areas of Interest");
	}		
	//by sudhir
	public static void FlightAndOnsite()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Profile");
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx1.text"),"My GSX");
		System.out.println("after my gsx");
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.profile"));
		CommonUtil.waitForPageload();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx1.myprofile.text"),"My Profile");
		CommonUtil.explicitlyWait(2);
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.myprofile.travel"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.switchToFrame();
		cookies();
		CommonUtil.switchToDefault();
		System.out.println("After Accept cokkies");
		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame1"));
		
		CommonUtil.explicitlyWait(2);
		System.out.println("After FRame1");
		MyGsx.Validatemyprofilebutton(elementProperties.getProperty("cisco.mygsx.myprofile.return"),"Return to Edit Profile");

		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame2"));
		System.out.println("After FRame2");
		////CommonUtil.switchToDefault();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.mygsx.myprofile.editprofile.contactinfo.text"),"Flight and Onsite Information");
	}		
	//by sudhir
	public static void Hotel()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Profile");
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx1.text"),"My GSX");
		System.out.println("after my gsx");
		
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.profile"));
		CommonUtil.waitForPageload();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx1.myprofile.text"),"My Profile");
		CommonUtil.explicitlyWait(2);
		CommonUtil.click(elementProperties.getProperty("cisco.mygsx.myprofile.Hotel"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.switchToFrame();
		cookies();
		CommonUtil.switchToDefault();
		System.out.println("After Accept cokkies");
		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame1"));
		CommonUtil.explicitlyWait(2);
		System.out.println("After FRame1");
		MyGsx.Validatemyprofilebutton(elementProperties.getProperty("cisco.mygsx.myprofile.return"),"Return to Edit Profile");

		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.mygsx.myprofile.frame2"));
		System.out.println("After FRame2");
		////CommonUtil.switchToDefault();
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.mygsx.myprofile.Hotelview.text"),"Hotels");
	}		
	
	//by sudhir
	
	//update Method- sudhir 1
			public static void MyGSXTitle()
			{
				
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(3);
				
				MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx1.text"),"My GSX");
				CommonUtil.explicitlyWait(3);
			}
	
	//update Method- sudhir 1
		public static void myCalendertittle()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.Calender"),"My Calendar");
			CommonUtil.explicitlyWait(3);
		}
	
		public static void MyActivities()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.MyActivities"),"My Activities");
			CommonUtil.explicitlyWait(3);
		}
		public static void SessionRecommendations()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.SessionRecommendations"),"Session Recommendations");
			CommonUtil.explicitlyWait(3);
		}
		public static void ActivityRecommendations()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.ActivityRecommendations"),"Activity Recommendations");
			CommonUtil.explicitlyWait(3);
		}
		public static void MySurveys()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.MySurveys"),"My Surveys");
			CommonUtil.waitForPageload();		}
		public static void LearningCurriculum()
		{
			MyGSXTitle();
			CommonUtil.waitForPageload();
			System.out.println("Mygsx");
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.LearningCurriculum"),"My GSX Learning Hours");
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.dashboard.MyAchievements"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.dashboard.MyAchievements.popup"),"A chance to win a prize and get company wide recognition - just for learning.");
			CommonUtil.waitForPageload();
		}
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void Validateaddsessiontomyinterest(String expected, String actual) {
	
			CommonUtil.waitForPageload();
			System.out.println("session is added");
			actualMsg = actual;
			expectedMsg = CommonUtil.getAttribute(expected, "class");
			System.out.println(actualMsg);
			System.out.println(expectedMsg);
			if (expectedMsg.contains(actualMsg)) {
			actualMsg = "Session successfully Removed from My interest session times";
			expectedMsg = "Session successfully Removed from My interest session times";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
			actualMsg = "Session not  Removed from My interest session times";
			expectedMsg = "Session successfully Removed from My interest session times";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
	}
	
	
	public static void Validateremovesessiontomyinterest(String expected, String actual) {
	
		CommonUtil.waitForPageload();
		System.out.println("session is removed");
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected, "class");
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		if (expectedMsg.contains(actualMsg)) {
		actualMsg = "Session successfully Removed from My interest session times";
		expectedMsg = "Session successfully Removed from My interest session times";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
		actualMsg = "Session successfully Removed from My interest session times";
		expectedMsg = "Session not Removed from My interest session times";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	
	
	
	
	
	
	
	
		
	public static void ValidateMyGsx(String expected, String actual) {
			
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println("actualMsg-"+actualMsg);
		System.out.println("expectedMsg-"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "MyGsx"  +actual + "page is displayed successfully";
			expectedMsg = "MyGsx"  +actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		} else {
			actualMsg = "MyGsx"  +actual + "page is not displayed";
			expectedMsg = "MyGsx"  +actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
			CommonUtil.waitForPageload();	
		}
	
	
	private static void Validatemyagendapage(String expected, String actual) {
		
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected,"class");
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =  actual+ "is highlighted successfully";
			expectedMsg = actual+ "is highlighted successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual+ "is not highlighted";
			expectedMsg = actual+ "is highlighted successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
	}
	
private static void Validatemyprofilebutton(String expected, String actual) {
		
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected,"value");
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =  actual+ "is highlighted successfully";
			expectedMsg = actual+ "is highlighted successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual+ "is not highlighted";
			expectedMsg = actual+ "is highlighted successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
	}




}






