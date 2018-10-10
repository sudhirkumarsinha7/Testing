package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class TheHub {
	static int flag =0;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	private static String sessionTitle = null;
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
	//update Method- sudhir 1
	public static void TheHub()
	{
		
		CommonUtil.waitForPageload();
		System.out.println("Hub");
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub"));
	
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.title"),Requiredelement);
		CommonUtil.explicitlyWait(3);
	}
	//update Method- sudhir 2
	
		public static void Culture()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture"));
			CommonUtil.waitForPageload();
			Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.Culture"));
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Culture.title"),Requiredelement);
		}
		
		public static void CultureDemoActivity()
		{
			
			Culture();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
			CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.minusplus"),Requiredelement);
		
			/*//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.Anatomy.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.Anatomy.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.Anatomy"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.Anatomy.minusplus"),Requiredelement);
		
		*/
		}
		public static void Makerspace()
		{
			
			Culture();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Makerspace"));
			CommonUtil.waitForPageload();
			String makermomment = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.Makerspace.text"));
			System.out.println("makermomment : "+makermomment);
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Makerspace.text"),"Configure Meeting – Makerspace\nPlease note, a space reservation does not guarantee a space.");
			CommonUtil.waitForPageload();
			Participants();
		
			CommonUtil.click(elementProperties.getProperty("cisco.thhub.makerspace.slot"));
			CommonUtil.explicitlyWait(5);
			
			CommonUtil.click(elementProperties.getProperty("Submit"));
			CommonUtil.explicitlyWait(5);
			TheHub.Validatehub(elementProperties.getProperty("cisco.thehub.Configuremessage"),"Congratulations!");
			CommonUtil.waitForPageload();
				
		}
		public static void Culturegsxforgods()
		{
			
			Culture();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.gsxforgods"));
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.gsxforgods"),"GSX for Good");
			CommonUtil.explicitlyWait(2);
							
		}
	//update Method- sudhir 3
		public static void CiscoShowcase()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase"));
			CommonUtil.waitForPageload();
			Requiredelement ="Cisco Showcase";
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.title"),Requiredelement);
		}
		public static void CiscoShowcaseDemoActivity()
		{
			CiscoShowcase();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
			CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test1.minusplus"),Requiredelement);
		
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Demo.Activity.test2.minusplus"),Requiredelement);
		
		
		}
		public static void CiscoShowcaseHubTalksActivity()
		{
			CiscoShowcase();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.CiscoShowcaseHubTalks"));
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.CiscoShowcaseHubTalks"),"Cisco Showcase Hub Talks");
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test1.minusplus"),Requiredelement);
			
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			
			//2nd click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.CiscoShowcase.Theater.Activity.test2.minusplus"),Requiredelement);
			
		
		}
		//update Method- sudhir 4
		public static void PartnerShowcase()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase"));
			CommonUtil.waitForPageload();
			Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase"));
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.title"),Requiredelement);
		}
		
		public static void PartnerShowcaseDemoActivity()
		{
			PartnerShowcase();
			//CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
			//CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test1.minusplus"),Requiredelement);
		
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.PartnerShowcase.Demo.Activity.test2.minusplus"),Requiredelement);
		
		
		
		}
		
		//update Method- sudhir 5
		public static void InnovatePark()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark"));
			CommonUtil.waitForPageload();
			Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark"));
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.title"),Requiredelement);
		}
		
		
		public static void InnovateParkDemoActivity()
		{
			InnovatePark();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
			CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test1.minusplus"),Requiredelement);
		
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Demo.Activity.test2.minusplus"),Requiredelement);
		
				
		}
		
		public static void InnovateParkLabsActivity()
		{
			InnovatePark();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Labs"));
			CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test1.minusplus"),Requiredelement);
		
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.Labs.Activity.test2.minusplus"),Requiredelement);
		
		
		
		}
		
		public static void InnovateParkDevNetWorkshopsActivity()
		{
			InnovatePark();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.DevNetWorkshop"));
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.DevNetWorkshop"),"DevNet Workshops");

			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.DevNetWorkshop.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.DevNetWorkshop.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.DevNetWorkshop.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.DevNetWorkshop.Activity.test1.minusplus"),Requiredelement);
		
					
		
		
		
		}
		
		public static void InnovateParkSEDesignWorkshopsActivity()
		{
			InnovatePark();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.SEDesignWorkshop"));
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.SEDesignWorkshop"),"SE Design Workshops");
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test1.minusplus"),Requiredelement);
		
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.InnovatePark.SEDesignWorkshop.Activity.test2.minusplus"),Requiredelement);
		
		
		
		}
		//update Method- sudhir 6
		public static void TheWinRoom()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom"));
			CommonUtil.waitForPageload();
			Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom"));
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.title"),Requiredelement);
		}
		public static void TheWinRoomWorkshopsActivity()
		{
			TheWinRoom();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Workshops"));
			CommonUtil.waitForPageload();
			
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.Workshops.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.Workshops.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.Workshops.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.Workshops.Activity.test1.minusplus"),Requiredelement);
		
		
		
		}
		public static void RoomMeettheExpertsActivity()
		{
			
			TheWinRoom();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.MeettheExperts"));
			CommonUtil.waitForPageload();
		//	TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.MeettheExperts.text"),"Configure Meeting – The Win Room");
			String makermomment = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.Activity.MeettheExperts.text"));
			System.out.println("makermomment : "+makermomment);
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.MeettheExperts.text"),"Configure Meeting – The Win Room\nStart building your Win Room Meeting below");
			CommonUtil.waitForPageload();
			
			Participants();
		
			Experts();
			
			
			CommonUtil.click(elementProperties.getProperty("cisco.winroom.slot"));
			CommonUtil.explicitlyWait(5);
			
			CommonUtil.click(elementProperties.getProperty("Submit"));
			CommonUtil.explicitlyWait(5);
			TheHub.Validatehub(elementProperties.getProperty("cisco.thehub.Configuremessage"),"Success!");
			CommonUtil.waitForPageload();
				
		}
		public static void Participants(){
			CommonUtil.click(elementProperties.getProperty("cisco.thehub.makerspace.participants"));
			//CommonUtil.waitForPageload();
			CommonUtil.enterText(elementProperties.getProperty("cisco.thehub.makerspace.search"), "Sudhir");
			CommonUtil.waitForPageload();
			CommonUtil.clickEnter(elementProperties.getProperty("cisco.thehub.makerspace.search"),"");
			CommonUtil.explicitlyWait(5);
			CommonUtil.click(elementProperties.getProperty("cisco.participants.checkboxes"));
			CommonUtil.explicitlyWait(4);
		}
		public static void Experts(){
			CommonUtil.click(elementProperties.getProperty("cisco.winroom.expert.serach"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.winroom.expert"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.winroom.apply"));
			//CommonUtil.waitForPageload();
			
		}
		public static void CompetitiveTheaterActivity()
		{
			TheWinRoom();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.CompetitiveTheater"));
			CommonUtil.waitForPageload();
			
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.CompetitiveTheater.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.CompetitiveTheater.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.CompetitiveTheater.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.TheWinRoom.CompetitiveTheater.Activity.test1.minusplus"),Requiredelement);
			
		}
		//update Method- sudhir 7
		public static void SellerEnablement()
		{
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement"));
			CommonUtil.waitForPageload();
			Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement"));
			System.out.println(Requiredelement);
			
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.title"),Requiredelement);
		}
		
		
		public static void SellerEnablementDemoActivity()
		{
			SellerEnablement();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
			CommonUtil.waitForPageload();
			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test1.minusplus"),Requiredelement);
		
		/*	//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
			//2nd click +/-
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test2.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test2.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test2"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Demo.Activity.test2.minusplus"),Requiredelement);
		*/
		
		
		}
		
		public static void SellerEnablementHubTalks()
		{
			SellerEnablement();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablementHubTalks"));
			CommonUtil.waitForPageload();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablementHubTalks"),"Seller Enablement Hub Talks");

			//first click +/- ACI
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Theater.Activity.test1.plusminus"));
			CommonUtil.waitForPageload();

			Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Theater.Activity.test1.plusminus"),"type");
			System.out.println(Requiredelement);
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Theater.Activity.test1"));
			CommonUtil.waitForPageload();
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.SellerEnablement.Theater.Activity.test1.minusplus"),Requiredelement);
			
		
		
		}
		//update Method- sudhir 8
		public static void TheHubAfterHours()
		{
					CommonUtil.waitForPageload();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub"));
					CommonUtil.waitForPageload();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours"));
					CommonUtil.waitForPageload();
					Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours"));
					System.out.println(Requiredelement);
					
					CommonUtil.waitForPageload();
					TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.title"),Requiredelement);
			}
				
		public static void TheHubAfterHoursHubTriviaActivity()
				{
					TheHubAfterHours();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.HubTrivia"));
					CommonUtil.waitForPageload();
					TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.HubTrivia"),"Activities");

					//first click +/- ACI
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.Theater.Activity.test1.plusminus"));
					CommonUtil.waitForPageload();

					Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.Theater.Activity.test1.plusminus"),"type");
					System.out.println(Requiredelement);
					CommonUtil.waitForPageload();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.Theater.Activity.test1"));
					CommonUtil.waitForPageload();
					TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.Theater.Activity.test1.minusplus"),Requiredelement);
					
			
				
				}
		public static void TheHubAfterHoursSpeechlessLiveActivity()
		{
			TheHubAfterHours();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.SpeechlessLive"),"Speechless Live");

			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.SpeechlessLive"));
			CommonUtil.waitForPageload();

			
		}
		public static void TheHubAfterHoursSpeechlessWorkshopActivity()
		{
			TheHubAfterHours();
			TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.SpeechlessWorkshop"),"Speechless Workshop");

			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.TheHubAfterHours.SpeechlessWorkshop"));
			CommonUtil.waitForPageload();

			
		
		}
	
	
				
		public static void WalkUpsActivity()
				{
					TheHub();
					System.out.println("After Walkups");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Walkups"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(3);
					System.out.println("After Walkups");
					//first click +/- 
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Walkup.Activity.test1.plusminus"));
					CommonUtil.waitForPageload();

					Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.Walkup.Activity.test1.plusminus"),"type");
					System.out.println(Requiredelement);
					CommonUtil.waitForPageload();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Walkup.Activity.test1"));
					CommonUtil.waitForPageload();
					TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.Walkup.Activity.test1.minusplus"),Requiredelement);
				
	
				
				
				}	
				
	public static void SchedulableActivity()
		{
					TheHub();
					System.out.println("After Schedulable");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Schedulable"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(3);
					System.out.println("After Schedulable");
					//TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.Noresultsfound"),"No results found.");


					//first click +/- 
					/*CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Schedulable.Activity.test1.plusminus"));
					CommonUtil.waitForPageload();

					Requiredelement = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.thehub.Schedulable.Activity.test1.plusminus"),"type");
					System.out.println(Requiredelement);
					CommonUtil.waitForPageload();
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Schedulable.Activity.test1"));
					CommonUtil.waitForPageload();
					TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.thehub.Schedulable.Activity.test1.minusplus"),Requiredelement);
				
				*/
							
		}	
	public static void seeAll_link()
				{
					TheHub();
					System.out.println("After Schedulable");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.seeAll"));
					CommonUtil.waitForPageload();
					System.out.println("After Schedulable");
					

					Requiredelement = commonProperties.getProperty("cisco.gsx.mygsx.title");
										
					TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.Activity.Mygsx"),Requiredelement);
				
									
				
		}	
						
				
	
		

	public static void ScheduleVenudetails()
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
			TheHub.Validateaddremovetomygenda(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.symbol"), "recommended");
			System.out.println("actual"+actual);
			Expectedlist.add(actual);
			System.out.println("After actual");
			expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.myGsx1.sessionRecommendation.symbol"),"type");
			expectedMsg=expected+" Session";
			CommonUtil.logMessage(expectedMsg, actual, status);
		 CommonUtil.explicitlyWait(3);
		 System.out.println("before back");
		 CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
		 CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(3);
			
		}
		
	}						
				
				
	public static void Activity()
	{
		Culture();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.Demo"));
		CommonUtil.waitForPageload();
		String sessionStatus = CommonUtil.getAttribute(
				elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"), "type");
		

		System.out.println("loop" + sessionStatus);
		if (sessionStatus.equals("plus")) {
			System.out.println("loop");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"));
			CommonUtil.explicitlyWait(3);
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
		} else {
			System.out.println("minus");
			
			TheHub.Validateaddremovetomygenda(
					elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI.plusminus"), "minus");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Culture.Demo.Activity.ACI"));
			CommonUtil.explicitlyWait(3);
			sessionTitle = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.myGsx1.activity.recommendation.test1.tittle"));
			System.out.println("sessionTitle" + sessionTitle);
			//go back to demo
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.Activity.back"));
			CommonUtil.waitForPageload();
		}
		
	
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx1"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		
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
				
				
				
				
				
				
				
				
				
//comman method in hub by sudhir
	
public static void Validatehub(String expected, String actual) {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		System.out.println("actualMsg-"+actualMsg);
		System.out.println("expectedMsg-"+expectedMsg);
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
public static void Validateaddremovetomygenda(String expected, String actual) {
	  
	  CommonUtil.waitForPageload();
	  actualMsg = actual;
	  expectedMsg = CommonUtil.getAttribute(expected, "type");
	  System.out.println(actualMsg+ "......"+expectedMsg);

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

