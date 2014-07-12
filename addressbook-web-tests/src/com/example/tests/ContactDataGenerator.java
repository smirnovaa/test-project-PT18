package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	
	public static void main(String[] args) throws IOException {
		if (args.length < 3){
			System.out.println("Please specify parameters: <amounts of test data>, <file>, <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new  File(args[1]);
		String format = args[2];	
		
		if(file.exists()){
			System.out.println("File exists, please remove it manually" + file);
			return;
		}
		
		List<ContactData> contact = generateRandomContacts(amount);
		if("csv".equals(format)) {
			saveContactToCsvFile(contact, file);
		} else if("xml".equals(format)) {
			saveContactToXmlFile(contact, file);
		} else {
			System.out.println("Unknow format" + format);
			return;
		}
	}

	private static void saveContactToXmlFile(List<ContactData> contact,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contact);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);		
	}

	private static void saveContactToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," 
					+ contact.getLastname() + "," 
					+ contact.getAddress() + "," 
					+ contact.getTelephonehome() + "," 
					+ contact.getMobilephone() + "," 
					+ contact.getEmail() + "," 
					+ contact.getEmail2() + "," 
					+ contact.getBday() + "," 
					+  contact.getBmonth() + "," 
					+ contact.getByear() + "," 
					+ contact.getAddress2() + "," 
					+ contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactFromCsvFile(File file) throws IOException{
		 List<ContactData> list = new ArrayList<ContactData>();
		 FileReader reader = new FileReader(file);
		 BufferedReader bufferedReader = new BufferedReader(reader);
		 String line = bufferedReader.readLine();		
		 while (line != null) {
			 String[] part = line.split(",");			 
			 ContactData contact = new  ContactData()
			 .withFirstname(part [0])
			 .withLastname(part [1])
			 .withAddress(part [2])
			 .withTelephonehome(part [3])
			 .withMobilephone(part [4])
			 .withEmail(part [5])
			 .withEmail2(part [6])
			 .withBday(part [7])
			 .withBmonth(part [8])
			 .withByear(part [9])			 
			 .withAddress2(part [10])
			 .withPhone2(part [11]);
			 list.add(contact);
			 line = bufferedReader.readLine();
		}
		 bufferedReader.close();
		 return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i<amount; i++) {
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
			list.add(contact);			
		}
		return list;
	}
	
	private static String generateRandomContactString() {
		Random rnd = new Random();	
		if(rnd.nextInt(3) == 0){
			return "";
		} else {
			return "name" + rnd.nextInt();
		}
	}
	
	private static String generateRandomDayString() {
		Random rnd = new Random();
		int dayhNum = rnd.nextInt(32);
		if(dayhNum == 0){
			return "-";
		} else {
			return String.valueOf(dayhNum);
		}
	}
		
	private static String generateRandomMonthString() {
		Random rnd = new Random();
		String[] month = new String[]{"-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int monthNum = rnd.nextInt(13);
		return month[monthNum];	
	}

	private static String generateRandomYearString() {
		Random rnd = new Random();
		int yearNum = 1900 + rnd.nextInt(115);
		if (yearNum == 1900){
			return "";
		} else {
			return String.valueOf(yearNum);
		}
	}

}
