package com.cisco.gsx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.TestNG;

public class IdeabytesTestRunner {
	private static Set<String> methodSet = new HashSet<String>();
	public static Properties commonProperties = null;

	static {

		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	@SuppressWarnings("unchecked")
	public static void runGSXTestCases() {

		try {

			Set<String> testMethodSet = null;			
			
			
//**************************** Login ****************************
			
			//methodSet.add("validateinvalidlogin");
			//methodSet.add("validatelogout");		
			
// ********************** OnSite Guide ************************************************ 
	   methodSet.add("verifyCheckinPage");
		 methodSet.add("verifyGettingAroundPage");
		 methodSet.add("verifyWellness");
		 methodSet.add("verifyGlobalCelebrations");
		 methodSet.add("verifyFaqPage");
			
// ********************** GSX For Good ************************************************ 
		 methodSet.add("verifyGSXForGood");
		 
	
// ********************** Connect ************************************************ 
		 
		   methodSet.add("verifySocialPage");
		   methodSet.add("verifyattendeespage");
		   methodSet.add("verifyFAQpage");
	
			
		

//****************************************** My Gsx **********************************	
		//	methodSet.add("verifyMyGSX");
			//methodSet.add("verifyRecommandations");
			//methodSet.add("verifyRecommandationsActivities");
			//methodSet.add("verifyRecommandationsSessions");
			
			//methodSet.add("verifySessionInterests");
			//methodSet.add("verifyMyProfile");
			//methodSet.add("verifyMyAccount");
			
			
		   // methodSet.add("verifyMyAgendapageminus");
			
			//methodSet.add("verifyMyaccountinbox");
			//methodSet.add("verifyMyaccountnotes");
			//////////////////methodSet.add("verifyMyAgendapageplus");
			/////////////////methodSet.add("");
			
			
			//methodSet.add("verifySessionInterstTitleAndTime");
			//methodSet.add("verifySessionInterestsTimeDetails");
			//methodSet.add("verifySessionAddRemoveInMyinterests");
			//methodSet.add("verifySessionAddRemoveInMyinterests1");
			

			

//*********************************************** Schedule *********************************
			methodSet.add("verifyMySchedulerpageplus");
			
			methodSet.add("verifysessionsspeakerorder");
			methodSet.add("verifysessionsspeakerdetailspage");
			methodSet.add("verifysessionsaddtomyagenda");
			methodSet.add("verifySessionDetailsLayout");
			methodSet.add("verifySessionVenueDetails");
			
			//////methodSet.add("verifyfullagendaSessionSpeakerDetails");
			//methodSet.add("verifyAgendapage");
			//methodSet.add("verifyFiltermenu");
			//methodSet.add("verifyAgendaDatePage");
			
			
//************************************************ Global Search ***************************
	
		methodSet.add("validatesearchpage");
		   methodSet.add("verifySearchTextInTabs");
			methodSet.add("validateSearchWithInvaliddata");
			
//************************************************ Filters ***************************
			
			
			methodSet.add("verifyPillarSessions");
			methodSet.add("verifyPillarFiltertypes");
			methodSet.add("verifyCategoryFiltertypes");
			methodSet.add("verifyTypeFilterstypes");
		   methodSet.add("verifyTrackFiltertypes");
			methodSet.add("verifyFilterCategorytypes");
			methodSet.add("verifySessiosInCategoryFilters");
			methodSet.add("verifyTrackFilterSessions");
			methodSet.add("verifyTypeFilterSessions");
			
			
			// ********************** THE HUB ************************************************ 
			
			//methodSet.add("test");
			/*methodSet.add("verifyTheHubTittle");
			methodSet.add("verifyTheHubCultureTittle");
			methodSet.add("verifyTheHubCiscoShowcaseTittle");
			methodSet.add("verifyTheHubPartnerShowcaseTittle");
			methodSet.add("verifyTheHubTheWinRoomTittle");
			methodSet.add("verifyTheHubSellerEnablementTittle");
			methodSet.add("verifyTheHubAfterHoursTittle");
			methodSet.add("verifyTheHubInnovateParkTittle");//8
*/
			/*methodSet.add("verifyTheHubCultureDemo");
			//methodSet.add("verifyTheHubMakerspace");//not implement
			methodSet.add("verifyTheHubCulturegsxforgods");//3
			
			methodSet.add("verifyTheHubCiscoShowcaseDemoActivity");
			methodSet.add("verifyTheHubCiscoShowcaseHubTalksActivity");//2
						
			methodSet.add("verifyTheHubPartnerShowcaseDemoActivity");//1
				
			methodSet.add("verifyTheHubInnovateParkDemoActivity");
			methodSet.add("verifyTheHubInnovateParkLabsActivity");
			methodSet.add("verifyTheHubInnovateParkDevNetWorkshopsActivity");//conflict
			methodSet.add("verifyTheHubInnovateParkSEDesignWorkshopsActivity");//conflict//4
			
			
			
			//methodSet.add("verifyTheHubTheWinRoomMeettheExpertsActivity");//not implemented
			methodSet.add("verifyTheHubTheWinRoomWorkshopsActivity");
			methodSet.add("verifyTheWinRoomHubTalks");//3
			
			
			methodSet.add("verifySellerEnablementDemoActivity");
			methodSet.add("verifySellerEnablementHubTalksActivity");//2
	
			
			
		
			methodSet.add("verifyTheHubAfterHoursHubTriviaActivity");
			methodSet.add("verifyTheHubSchedulableActivity");//2
*/
			//methodSet.add("verifyTheHubWalkUpsActivity");

			//methodSet.add("verifyTheHubMakerspace");//not implement

			//methodSet.add("verifyTheHubTheWinRoomMeettheExpertsActivity");//not implemented

			//25
			

	

//*******************************************MyGSX*******
			/*methodSet.add("verifyActivityOnmygsx");	
			methodSet.add("verifyActivityRecommendationsOnmygsx");	
			
			methodSet.add("verifyRecommendationsessionOnmygsx");
			methodSet.add("verifymycalederrecommendationOnmygsx");//4
*/
			/*methodSet.add("verifyMyGSXtittle");	
			methodSet.add("verifymyCalendertittle");	
			methodSet.add("verifyMyActivitiestittle");
			methodSet.add("verifySessionRecommendationstittle");
			methodSet.add("verifyActivityRecommendationstittle");	
			methodSet.add("verifyMySurveystittle");	
			methodSet.add("verifyLearningCurriculumtittle");//7
		//11

// ********************** Profile ************************************************ 
		methodSet.add("verifymyProfileEdit");	
		methodSet.add("verifymyProfileQuestion");	
		methodSet.add("verifymyProfileTravel");	
	    methodSet.add("verifymyProfileHotel");	
	    //4
// ********************** GSX_LOGO ************************************************ 
			methodSet.add("verifyBuildYourScheduletittle");	
			methodSet.add("verifyFAQandPolicies");	
			methodSet.add("verifySeetheFinalists");	
		   methodSet.add("verifyViewtheweek");		
				//4					
*/
//*****************************************Conflict*****************************
					    methodSet.add("verifyRegionalConflict");
						methodSet.add("verifySuperSessionConflict");
						methodSet.add("verifyBreakSessionConflict");
		
//******************************************* Customized buttons *******************************
			
			methodSet.add("verifyrequiredSession");
          /*methodSet.add("verifysessionEnded");*/
		//	methodSet.add("verifysessionAllmostFull");
		//	methodSet.add("verifysessionFull");
	
			
//********************************************** Role based permissions ****************************
			 
			/*   
			 methodSet.add("verifyAttendeerole");
			  methodSet.add("verifyHallofFamerole");
			  methodSet.add("verifyAmericaGSPSession");
			  methodSet.add("verifyManagerExcellence");
			  methodSet.add("verifychairmansClub");
			  methodSet.add("verifyAchiever");
			  methodSet.add("verifySaleschampion");
			 methodSet.add("verifyExecutive");		   
			   
		        methodSet.add("verifyEventstaff");
			 methodSet.add("verifySupportStaff");
			   methodSet.add("verifyHubStaff");*/
			  
			  
			 methodSet.add("verifyGeneralsession");
			   
			  methodSet.add("verifyMealsSessions");
			  methodSet.add("verifyAmericaSession");
			  methodSet.add("verifyAmericaGSPSession");
			   methodSet.add("verifyEMEARSession");
			 methodSet.add("verifyAustraliaSession");
			 methodSet.add("verifyChinaSession");
			   
			  // methodSet.add("verifySurveyOnlySpaeaker");
			   //methodSet.add("verifymoderatorSpaeaker");
			   //methodSet.add("verifydisplayAndSurveySpaeaker");
			   //methodSet.add("verifyDisplayOnlySpaeaker");
			Map<String, Set<String>> q2oTestCasesMap = new HashMap<String, Set<String>>();
			q2oTestCasesMap.put("com.cisco.gsx.testsuites.GSX", methodSet);
			System.out.println("0.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			TestNG testng = new TestNG();
			System.out.println("1.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			Class classObj[] = new Class[q2oTestCasesMap.keySet().size()];
			System.out.println("2.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			int i = 0;

			for (Iterator iterator = q2oTestCasesMap.keySet().iterator(); iterator
					.hasNext(); i++) {
				String className = (String) iterator.next();
				System.out.println("vv:" + className);
				classObj[i] = Class.forName(className.trim());

				 methodSet.addAll(q2oTestCasesMap.get(className));
			}

			testng.setTestClasses(classObj);
			testng.addListener(new com.cisco.gsx.reports.IdeabytesListener());

			System.out.println("MethodSet :" + methodSet.size());
			testng.setMethodInterceptor(new IMethodInterceptor() {

				@Override
				public List<IMethodInstance> intercept(
						List<IMethodInstance> inMethod, ITestContext arg1) {
					List<IMethodInstance> methodList = new ArrayList<IMethodInstance>();

					for (IMethodInstance m : inMethod) {
						String methodName = m.getMethod().getMethodName();
						System.out.println("x:" + methodName);
						if (methodSet.contains(methodName)) {
							methodList.add(m);
							System.out.println("If loop in Ideabytes Test RUnner");
						}
						System.out.println("For loop in Ideabytes Test RUnner");
					}
					System.out.println("intercept function in Ideabytes Test RUnner");
					return methodList;
				}
			});
			System.out.println("Testng is about to run"); 
			testng.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
