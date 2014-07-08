package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;



public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();			
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	    
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupsGenerator () {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<2; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomGroupString())
				.withHeader(generateRandomGroupString())
				.withFooter(generateRandomGroupString());			
			list.add(new Object[]{group});
		}
		return list.iterator();
	}

	public String  generateRandomGroupString() {
		Random rnd = new Random();	
		if(rnd.nextInt(3) == 0){
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator () {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<7; i++) {
			ContactData contact = new ContactData()
			.withFirstname(generateRandomContactString())
			.withLastname(generateRandomContactString())
			.withAddress(generateRandomContactString())
			.withTelephonehome(generateRandomContactString())
			.withMobilephone(generateRandomContactString())
			.withEmail(generateRandomContactString())
			.withEmail2(generateRandomContactString())
			.withBday(generateRandomDayString())
			.withBmonth(generateRandomMonthString())
			.withByear(generateRandomYearString())
			.withAddress2(generateRandomContactString())
			.withPhone2(generateRandomContactString());
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

	private String generateRandomContactString() {
		Random rnd = new Random();	
		if(rnd.nextInt(3) == 0){
			return "";
		} else {
			return "name" + rnd.nextInt();
		}
	}
	
	private String generateRandomDayString() {
		Random rnd = new Random();
		int dayhNum = rnd.nextInt(32);
		if(dayhNum == 0){
			return "-";
		} else {
			return String.valueOf(dayhNum);
		}
	}
		
	private String generateRandomMonthString() {
		Random rnd = new Random();
		String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int monthNum = rnd.nextInt(13);
		if (monthNum == 0){
			return "-";
		} else {
			return month[monthNum];
		}
	}

	private String generateRandomYearString() {
		Random rnd = new Random();
		int yearNum = 1900 + rnd.nextInt(115);
		if (yearNum == 1900){
			return "";
		} else {
			return String.valueOf(yearNum);
		}
	}
	

}
