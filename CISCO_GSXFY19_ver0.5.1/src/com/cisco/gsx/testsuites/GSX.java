package com.cisco.gsx.testsuites;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;












import com.cisco.gsx.pageObjects.Agenda;
import com.cisco.gsx.pageObjects.Conflicts;
import com.cisco.gsx.pageObjects.Connect;
//import com.cisco.gsx.pageObjects.Attendees;
//import com.cisco.gsx.pageObjects.Customizedbuttons;

import com.cisco.gsx.pageObjects.Customizedbuttons;
import com.cisco.gsx.pageObjects.GSXForGood;
import com.cisco.gsx.pageObjects.GSX_DevNet;
import com.cisco.gsx.pageObjects.GSX_Filters;
import com.cisco.gsx.pageObjects.GSX_OnSiteGuide;
//import com.cisco.gsx.pageObjects.GSX_Filters;

import com.cisco.gsx.pageObjects.GSX_UserBasedRoles;
import com.cisco.gsx.pageObjects.GSXlogo;
import com.cisco.gsx.pageObjects.Globalsearch;
//import com.cisco.gsx.pageObjects.GSX_UserBasedRoles;
//import com.cisco.gsx.pageObjects.Globalsearch;
import com.cisco.gsx.pageObjects.LoginPage;
import com.cisco.gsx.pageObjects.MyGsx;
//import com.cisco.gsx.pageObjects.MyGsx;

import com.cisco.gsx.pageObjects.Scheduler;
import com.cisco.gsx.pageObjects.Sessions;
//import com.cisco.gsx.pageObjects.Sessions;
import com.cisco.gsx.pageObjects.TheHub;

import org.openqa.selenium.html5.SessionStorage;
import org.testng.annotations.Test;

import com.cisco.gsx.excelreader.Dataproviderclass;
import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX {
	// public static AddressManagementHarnessCodeImpl harness = new
	// AddressManagementHarnessCodeImpl();
	/**
	 * 
	 * Conformiq Designer generated test case Displays Informational message [in
	 * region To Verify that new siteID is created when user creates n~ install
	 * s~ id with n~ s~ address using a~ management option.] Name Digest
	 * (SHA-1), DO NOT REMOVE: 6d77d4f8db0e1134cef2b6385ada5ffb4233f830
	 */
	static Map<?, ?> map = null;
	static List<String> testlist;
	static int count;
	//private String testCaseName = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	// private boolean Q2O_ADDRESS_MGMT_ADDLINE = false;

	static {

		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public void setUp(String testcaseName) {
		System.out.println("=============================" + testcaseName
				+ " Started =============================");
		String browserType = "firefox";
		//String browserType = "chrome";
		System.out.println("DB - BrowserType" + browserType);
		CommonUtil.openBrowser(browserType);
		CommonUtil.openUrl(commonProperties.getProperty("cisco.gsx.url"));
		//CommonUtil.maximizeWindow();
	}

	public void tearDown(String testcaseName) {
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.logout"));
		CommonUtil.closeBrowser();
		System.out.println("=============================" + testcaseName
				+ " Ended =============================");
	}

//******************************* Login ****************************
	
	@Test
	public void validateinvalidlogin() throws Exception {
		this.setUp("Verify the login page with invalid credentials");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentialsforinvalidlogin();
		
		

		this.tearDown("Verify the login page with invalid credentials");
	}
	
	@Test
	public void validatelogout() throws Exception {
		this.setUp("Verify the logout page");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		LoginPage.Logout();
		
		this.tearDown("Verify the logout page");
	}
	
	
	
	
	

	
	//************************************************ GSX FOR Good ******************************************************
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyGSXForGood(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify GSXForGood page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSXForGood.GSXForGood();
			
			this.tearDown("verify GSXForGood page");
		}
			
	}
		
	
		
	//************************************************ ONSITE GUIDE ******************************************************	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyCheckinPage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Checkin page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSX_OnSiteGuide.CheckinPage();
			
			this.tearDown("verify Checkin page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyGettingAroundPage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Getting Around page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSX_OnSiteGuide.CheckinPage();
			
			this.tearDown("verify Getting Around page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyWellness(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Wellness page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSX_OnSiteGuide.Wellness();
			
			this.tearDown("verify Wellness page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyGlobalCelebrations(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify GlobalCelebrations page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSX_OnSiteGuide.GlobalCelebrations();
			
			this.tearDown("verify GlobalCelebrations page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyFaqPage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify FAQPage");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			GSX_OnSiteGuide.FAQPage();
			
			this.tearDown("verify FAQPage");
		}
			
	}
	
	


	//************************************************ CONNECT ******************************************************	
		
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySocialPage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Social page");
			LoginPage.validateLoginPage();

			LoginPage.login(pojo);
			
			Connect.SocialPage();
			
			this.tearDown("verify Social page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyattendeespage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Attendee page");
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			Connect.Attendees();
			
			this.tearDown("verify Attendee page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyFAQpage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify FAQ page");
			LoginPage.validateLoginPage();

			LoginPage.login(pojo);
			
			Connect.FAQ();
			
			this.tearDown("verify FAQ page");
		}
			
	}
	
	
	//***************************************  Filter *****************************************		
			//Completed all
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyFilterCategorytypes(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Filter Types");
			LoginPage.login(pojo);
			
			GSX_Filters.Filters();
			
			this.tearDown("verify Filters Types");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyTrackFiltertypes(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Track filter Types");
			LoginPage.login(pojo);
			
			GSX_Filters.TrackFilters();
			
			this.tearDown("verify Track filter Types");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyPillarFiltertypes(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Pillar filter Types");
			LoginPage.login(pojo);
			
			GSX_Filters.verifyPillarCategory();
			
			this.tearDown("verify pillar filter Types");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyCategoryFiltertypes(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Category filter Types");
			LoginPage.login(pojo);
			
			GSX_Filters.CategoryFilter();
			
			this.tearDown("verify Category filter Types");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyTypeFilterstypes(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Type filter Types");
			LoginPage.login(pojo);
			
			GSX_Filters.SessionTypeFilters();
			
			this.tearDown("verify Type filter Types");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySessiosInCategoryFilters(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verifying sessions according to selected category filter");
			LoginPage.login(pojo);
			
			GSX_Filters.setCategoryFilters();
			
			this.tearDown("verifying sessions according to selected category filter");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyTrackFilterSessions(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verifying sessions according to selected Track filter");
			LoginPage.login(pojo);
			
			GSX_Filters.setTrackFilters();
			
			this.tearDown("verifying sessions according to selected Track filter");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyTypeFilterSessions(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verifying sessions according to selected Type filter");
			LoginPage.login(pojo);
			
			GSX_Filters.setTypeFilters();
			
			this.tearDown("verifying sessions according to selected Type filter");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifyPillarSessions(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verifying Pillar sessions");
			LoginPage.login(pojo);
			
			GSX_Filters.verifyPillarSessions();
			
			this.tearDown("verifying Pillar sessions");
		}
			
	}
			
				
		
	//***************************************  Agenda *****************************************
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySessionVenueDetails(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Session Venue Details");			
			
			
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);			
			Sessions.sessionsvenuedetails();					
			
			this.tearDown("verify Session Venue Details");
		}
			
	}
	@Test
	public void verifyFiltermenu() throws Exception {
		
			this.setUp("verify Filter page");			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();				
			Agenda.AgendaDatePage();					
			
			this.tearDown("verify Filter page");
			
		}
	@Test
	public void verifyAgendaDatePage() throws Exception {
		
			this.setUp("verify AgendaDate page");			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();				
			Agenda.AgendaDatePage();					
			
			this.tearDown("verify AgendaDate page");
			
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifysessionsspeakerorder(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify speaker information order");
			LoginPage.login(pojo);
			
			Sessions.validatesessionspeakerorder();
			
			this.tearDown("verify speaker information order");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifysessionsspeakerdetailspage(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify sessions speaker details page");
			LoginPage.login(pojo);
			
			Sessions.sessionsspeakerdetails();
			
			this.tearDown("verify sessions speaker details page");
		}
			
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifysessionsaddtomyagenda(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify sessions add to MYGSX");
			LoginPage.login(pojo);
			
			Sessions.sessionsaddtomyagenda();
			
			this.tearDown("verify sessions add to MYGSX");
		}
			
	}
	
	

	//***************************************  Sessions *****************************************
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifySessionDetailsLayout(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify Session Details Layout page");
			LoginPage.login(pojo);
			
			Sessions.sessionDetailsLayout();
			
			this.tearDown("verify Session Details Layout page");
		}
			
	}
	
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)

	public void verifybuildYourSchedule(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("verify buildYourSchedule page");			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();				
			Scheduler.buildYourSchedule();					
			
			this.tearDown("verify buildYourSchedule page");
			
		}
	}
	@Test
	public void verifyMySchedulerpageplus() throws Exception {
		
		this.setUp("verify My Agenda plus is highlighted");
		
		
		
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
	
		
		Scheduler.sessionsPlusverification();
		
		
		this.tearDown("verify My Agenda plus is highlighted");
		
	}
	@Test
	public void verifyfullagendaSessionSpeakerDetails() throws Exception {
		
			this.setUp("Full Agenda Session Speaker Details ");		
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session speaker details layout in full agenda
			Agenda.validatesessionspeakerpage();
			
		
			this.tearDown("Full Agenda Session Speaker Details");
			
		}
	
	//***************************************  MY GSX *****************************************
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyActivityRecommendationsOnmygsx(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
		DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify RecommendationsActivity");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);		
		
		//Verify RecommendationsActivity page
		MyGsx.RecommendationsActivity();
		

		this.tearDown("Verify RecommendationsActivity");
		}
	}
	

	
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyRecommendationsessionOnmygsx(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
		DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify Recommendationsession");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);		
		
		//Verify Activity page
		MyGsx.Recommendationsession();
		
	
		this.tearDown("Verify Recommendationsession");
			}
}
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifymycalederrecommendationOnmygsx(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
		DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify mycalederrecommendation");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);		
		
		//Verify Activity page
		MyGsx.mycalederrecommendation();
		
	
		this.tearDown("Verify mycalederrecommendation");
			}
}

	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifymyProfileEdit(LinkedList<?> pojo1) throws Exception {
			for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Verify myProfileContactInformation");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);		
			
			//Verify Profile page
			MyGsx.ContactInformation();
			
		
			this.tearDown("Verify myProfileContactInformation");
				}
}
	
@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
public void verifymyProfileQuestion(LinkedList<?> pojo1) throws Exception {
			for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Verify AreaOfInterest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);		
			
			//Verify Profile page
			MyGsx.AreaOfInterest();
			
		
			this.tearDown("Verify AreaOfInterest");
				}
}
@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
public void verifymyProfileTravel(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
		DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify FlightAndOnsite");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);		
		
		//Verify Profile page
		MyGsx.FlightAndOnsite();
		
	
		this.tearDown("Verify FlightAndOnsite");
			}
}
@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
public void verifymyProfileHotel(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
		DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify Hotel");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);		
		
		//Verify Profile page
		MyGsx.Hotel();
		
		
		this.tearDown("Verify Hotel");
			}
}

	
			@Test
			public void verifyMyAgendapageminus() throws Exception {
				
					this.setUp("verify My Agenda minus is highlighted");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
				
					
					MyGsx.MyAgendapageminusverification();
					
					
					this.tearDown("verify My Agenda minus is highlighted");
					
				}
/*******************************************************dashboard***********/
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyMyGSXtittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify MyGSXTitle");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify MyGSXTitle page
					MyGsx.MyGSXTitle();
					
					
					this.tearDown("Verify MyGSXTitle");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifymyCalendertittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify myCalendertittle");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify myCalendertittle page
					MyGsx.myCalendertittle();
					
					
					this.tearDown("Verify myCalendertittle");
						}
			}

			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyMyActivitiestittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify MyActivities");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify MyActivities page
					MyGsx.MyActivities();
					
					
					this.tearDown("Verify MyActivities");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySessionRecommendationstittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify SessionRecommendations");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify SessionRecommendations page
					MyGsx.SessionRecommendations();
					
					
					this.tearDown("Verify SessionRecommendations");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyActivityRecommendationstittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify ActivityRecommendations");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify ActivityRecommendations page
					MyGsx.ActivityRecommendations();
					
					
					this.tearDown("Verify ActivityRecommendations");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyMySurveystittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify MySurveys");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify MySurveys page
					MyGsx.MySurveys();
					
					
					this.tearDown("Verify MySurveys");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyLearningCurriculumtittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify LearningCurriculum");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify LearningCurriculum page
					MyGsx.LearningCurriculum();
					
					
					this.tearDown("Verify LearningCurriculum");
						}
			}
			//************************************************ GSX LOGO by sudhir ******************************************************	
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyBuildYourScheduletittle(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify BuildYourSchedule");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify BuildYourSchedule page
					GSXlogo.BuildYourSchedule();
					
					
					this.tearDown("Verify BuildYourSchedule");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyFAQandPolicies(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify FAQandPolicies");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify FAQandPolicies page
					GSXlogo.FAQandPolicies();
					
					
					this.tearDown("Verify FAQandPolicies");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySeetheFinalists(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify SeetheFinalists");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify SeetheFinalists page
					GSXlogo.SeetheFinalists();
					
					
					this.tearDown("Verify SeetheFinalists");
						}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyViewtheweek(LinkedList<?> pojo1) throws Exception {
					for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify Viewtheweek");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);		
					
					//Verify Viewtheweek page
					GSXlogo.Viewtheweek();
					
					
					this.tearDown("Verify Viewtheweek");
						}
			}


			//****************************    THE HUB      ************************************************************
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("Verify The hub ");
					
					//Validate login page
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);			
					//Verify verifyTheHub page
					TheHub.TheHub();

					this.tearDown("Verify The hub");
				}
				}
			
			/*@Test
			public void verifyTheHub() throws Exception {
				this.setUp("Verify The hub ");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.enterCredentials();
				
				//Verify Overview page
				TheHub.TheHub();

				this.tearDown("Verify The hub");
			}*/
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCiscoShowcaseTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The hub CiscoShowcase");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheHubCiscoShowcase page
				TheHub.CiscoShowcase();

				this.tearDown("Verify The hub CiscoShowcase");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCultureTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The Culture");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheHubCulture page
				TheHub.Culture();

				this.tearDown("Verify The Culture");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubMakerspace(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The Makerspace");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify CultureChalenge page
				TheHub.Makerspace();

				this.tearDown("Verify The Makerspace");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCulturegsxforgods(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The Culturegsxforgods");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify Culturegsxforgods page
				TheHub.Culturegsxforgods();

				this.tearDown("Verify The Culturegsxforgods");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)	
			public void verifyTheHubPartnerShowcaseTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The hub PartnerShowcase");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);
				
				//Verify verifyTheHubPartnerShowcase page
				TheHub.PartnerShowcase();

				this.tearDown("Verify The hub PartnerShowcaset");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubInnovateParkTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The hub InnovatePark");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify Overview page
				TheHub.InnovatePark();

				this.tearDown("Verify The hub InnovatePark");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubTheWinRoomTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The hub TheWinRoom");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheHubInnovatePark page
				TheHub.TheWinRoom();

				this.tearDown("Verify The hub TheWinRoom");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubTheWinRoomMeettheExpertsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify RoomMeettheExpertsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify TheWinRoomWorkshopsActivity page
				TheHub.RoomMeettheExpertsActivity();

				this.tearDown("Verify RoomMeettheExpertsActivity");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubTheWinRoomWorkshopsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheWinRoomWorkshopsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify TheWinRoomWorkshopsActivity page
				TheHub.TheWinRoomWorkshopsActivity();

				this.tearDown("Verify TheWinRoomWorkshopsActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheWinRoomHubTalks(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify verifyTheWinRoomHubTalks");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheWinRoomHubTalks page
				TheHub.CompetitiveTheaterActivity();

				this.tearDown("Verify verifyTheWinRoomHubTalks");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubSellerEnablement(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify The hub SellerEnablement");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheHubSellerEnablement page
				TheHub.SellerEnablement();

				this.tearDown("Verify The hub SellerEnablement");
				}
			}
			
			
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubAfterHoursTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify  TheHubAfterHours");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				//Verify verifyTheHubAfterHours page
				TheHub.TheHubAfterHours();

				this.tearDown("Verify TheHubAfterHours");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubAfterHoursHubTriviaActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify  TheHubAfterHoursHubTriviaActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubAfterHoursTheaterActivity page
				TheHub.TheHubAfterHoursHubTriviaActivity();

				this.tearDown("Verify TheHubAfterHoursHubTriviaActivity");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubAfterHoursSpeechlessLiveActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify  TheHubAfterHoursSpeechlessLiveActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify TheHubAfterHoursSpeechlessLiveActivity page
				TheHub.TheHubAfterHoursSpeechlessLiveActivity();

				this.tearDown("Verify TheHubAfterHoursSpeechlessLiveActivity");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubAfterHoursSpeechlessWorkshopActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify  TheHubAfterHoursSpeechlessWorkshopActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify TheHubAfterHoursSpeechlessWorkshopActivity page
				TheHub.TheHubAfterHoursSpeechlessWorkshopActivity();

				this.tearDown("Verify TheHubAfterHoursSpeechlessWorkshopActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCultureDemo(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheHubCultureDemo");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubCultureDemo page
				TheHub.CultureDemoActivity();

				this.tearDown("Verify TheHubCultureDemo");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCiscoShowcaseDemoActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheHubCiscoShowcaseDemoActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubCiscoShowcaseDemoActivity page
				TheHub.CiscoShowcaseDemoActivity();

				this.tearDown("Verify TheHubCiscoShowcaseDemoActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubCiscoShowcaseHubTalksActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheHubCiscoShowcaseTheaterActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubCiscoShowcaseTheaterActivity page
				TheHub.CiscoShowcaseHubTalksActivity();

				this.tearDown("Verify TheHubCiscoShowcaseTheaterActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubPartnerShowcaseDemoActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheHubPartnerShowcaseDemoActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubPartnerShowcaseDemoActivity page
				TheHub.PartnerShowcaseDemoActivity();
				this.tearDown("Verify TheHubPartnerShowcaseDemoActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubInnovateParkDemoActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify TheHubInnovateParkDemoActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify verifyTheHubInnovateParkDemoActivity page
				TheHub.InnovateParkDemoActivity();
				

				this.tearDown("Verify TheHubInnovateParkDemoActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubInnovateParkLabsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify InnovateParkLabsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify InnovateParkLabsActivity page
				TheHub.InnovateParkLabsActivity();
				

				this.tearDown("Verify InnovateParkLabsActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubInnovateParkDevNetWorkshopsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify verifyTheHubInnovateParkDevNetWorkshopsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify InnovateParkDevNetWorkshopsActivity page
				TheHub.InnovateParkDevNetWorkshopsActivity();
				

				this.tearDown("Verify verifyTheHubInnovateParkDevNetWorkshopsActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubInnovateParkSEDesignWorkshopsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify InnovateParkSEDesignWorkshopsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify InnovateParkSEDesignWorkshopsActivity page
				TheHub.InnovateParkSEDesignWorkshopsActivity();
				

				this.tearDown("Verify InnovateParkSEDesignWorkshopsActivity");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubSellerEnablementTittle(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify SellerEnablement()");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify SellerEnablement() page
				TheHub.SellerEnablement();
				

				this.tearDown("Verify SellerEnablement");
				}
			}
			
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySellerEnablementDemoActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify SellerEnablementDemoActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify SellerEnablementDemoActivity page
				TheHub.SellerEnablementDemoActivity();
				

				this.tearDown("Verify SellerEnablementDemoActivity");
				}
			}
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySellerEnablementHubTalksActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify SellerEnablementHubTalks");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify SellerEnablementDemoActivity page
				TheHub.SellerEnablementHubTalks();
				

				this.tearDown("Verify SellerEnablementHubTalks");
				}
			}
			
			
			
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubWalkUpsActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify WalkUpsActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify WalkUpsActivity page
				TheHub.WalkUpsActivity();
				

				this.tearDown("Verify WalkUpsActivity");
				}
			}
			
			
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyTheHubSchedulableActivity(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify SchedulableActivity");
				
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);		
				
				//Verify WalkUpsActivity page
				TheHub.SchedulableActivity();
				

				this.tearDown("Verify SchedulableActivity");
				}
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyActivityOnmygsx(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
				DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
				this.setUp("Verify Activity");
			
				//Validate login page
				LoginPage.validateLoginPage();
				LoginPage.login(pojo);
				
				//Verify ActivityOnmygsx page
				TheHub.Activity();
			

				this.tearDown("Verify Activity");
				}
			
		}

			
			

			//**********************custamized buttons btach 8**********************
			@Test
			public void verifyrequiredSession() throws Exception {
				
					this.setUp("verifying REQUIRED SESSION");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					Customizedbuttons.requiredSession();
					
					
				
					this.tearDown("verifying REQUIRED SESSION");
					
				}
			@Test
			public void verifyaddMyAgenda() throws Exception {
				
					this.setUp("verifying session added to my agenda");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					Customizedbuttons.addMyAgenda();
					
					
				
					this.tearDown("verifying session added to my agenda");
					
				}
			@Test
			public void verifysessionFull() throws Exception {
				
					this.setUp("verifying SESSION FULL");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					Customizedbuttons.sessionFull();
					
					
				
					this.tearDown("verifying SESSION FULL");
					
				}
			@Test
			public void verifysessionAllmostFull() throws Exception {
				
					this.setUp("verifying session ALMOST FULL");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					Customizedbuttons.sessionAllmostFull();
					
					
				
					this.tearDown("verifying session ALMOST FULL");
					
				}
			@Test
			public void verifysessionEnded() throws Exception {
				
					this.setUp("verifying SESSION ENDED");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					Customizedbuttons.sessionEnded();
					
					
				
					this.tearDown("verifying SESSION ENDED");
					
				}
			@Test
			public void verifyinvitedSession() throws Exception {
				
					this.setUp("verifying invitedSession");
					
					
					
					LoginPage.validateLoginPage();
					LoginPage.enterCredentials();
					
					
					GSX_UserBasedRoles.invitedSession();
					
					
				
					this.tearDown("verifying invitedSession");
					
				}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyMealsSessions(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify Meals session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.mealsSession();
					
					this.tearDown("verifyMealsSessions");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyAmericaSession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify America session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.americaSession(pojo);
					
					this.tearDown("verifyAmericaSessions");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyAmericaGSPSession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify America-GlobalSP session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.GSPSegmentSession(pojo);
					
					this.tearDown("verifyAmerica-GlobalSPSessions");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyEMEARSession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify EMEAR session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.emearSession();
					
					this.tearDown("verifyEMEARSessions");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyAustraliaSession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify Australia session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.AustraliaSession();
					
					this.tearDown("verify Australia Sessions");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyChinaSession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify China session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.AustraliaSession();
					
					this.tearDown("verify China Sessions");
				}
					
			}
		
		
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyGeneralsession(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify Global General session");
					
					LoginPage.validateLoginPage();
					LoginPage.login(pojo);
					GSX_UserBasedRoles.globalGeneralSession();
					
					this.tearDown("verify Global General session");
				}
					
			}
			//################### user based roles ########################	
			
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyAttendeerole(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying Attendee Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.attendeeRole();
					
					this.tearDown("verifying Attendee Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyHallofFamerole(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying HallofFame Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.HallofFame();
					
					this.tearDown("verifying HallofFame Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyExecutive(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying executive Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.executive();
					
					this.tearDown("verifying executive Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyEventstaff(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying EventStaff Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.eventStaff();
					
					this.tearDown("verifying EventStaff Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyHubStaff(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying HubStaff Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.hubStaff();
					
					this.tearDown("verifying HubStaff Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySupportStaff(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying HubStaff Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.supportStaff();
					
					this.tearDown("verifying HubStaff Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyManagerExcellence(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying ManageExcellence Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.ManagerExcellence();
					
					this.tearDown("verifying ManageExcellence Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifychairmansClub(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying Chairmans Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.chairmansClub();
					
					this.tearDown("verifying Chairmans Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyAchiever(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying Archiver Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.achiever();
					
					this.tearDown("verifying Archiver Role");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySaleschampion(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying salesChampion Role");
					LoginPage.login(pojo);
					
					GSX_UserBasedRoles.salesChampion();
					
					this.tearDown("verifying salesChampion Role");
				}
					
			}
		
			
//#######################Conflicts	###########################		
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyRegionalConflict(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify RegionalConflict message");
					LoginPage.login(pojo);
					
					Conflicts.regionalsegmentSessions();
					
					this.tearDown("verify RegionalConflict message");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySuperSessionConflict(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify Super session conflict message");
					LoginPage.login(pojo);
					
					Conflicts.supersession();
					
					this.tearDown("verify Super session conflict message");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifyBreakSessionConflict(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verify BreakOut session conflict message");
					LoginPage.login(pojo);
					
					Conflicts.breakoutSession();
					
					this.tearDown("verify Breakout session conflict message");
				}
					
			}
			
			
		
			//************************************** Global Search ******************************************	
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void validatesearchpage(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying search page");
					LoginPage.login(pojo);
					
					Globalsearch.verifysearchpage();
					
					this.tearDown("verify search page");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void verifySearchTextInTabs(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifying search Text");
					LoginPage.login(pojo);
					
					Globalsearch.verifySearchTextInTabs();
					
					this.tearDown("verify search Text");
				}
					
			}
			@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
			public void validateSearchWithInvaliddata(LinkedList<?> pojo1) throws Exception {
				for (int a = 0; a < pojo1.size(); a++) {
					DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
					this.setUp("verifySearchWithInvaliddata");
					LoginPage.login(pojo);
					
					Globalsearch.verifySearchWithInvaliddata();
					
					this.tearDown("verifySearchWithInvaliddata");
				}
					
			}
			

	
}
