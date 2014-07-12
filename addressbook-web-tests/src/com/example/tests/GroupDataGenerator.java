package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GroupDataGenerator {
	
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
		
		List<GroupData> groups = generateRandomGroups(amount);
		if("csv".equals(format)) {
			saveGroupToCsvFile(groups, file);
		} else if("xml".equals(format)) {
			saveGroupToXmlFile(groups, file);
		} else {
			System.out.println("Unknow format" + format);
			return;
		}
	}

	private static void saveGroupToXmlFile(List<GroupData> groups, File file) {
		
	}

	private static void saveGroupToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (GroupData group : groups) {
			writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + "\n");
		}
		writer.close();
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
		for (int i=0; i<amount; i++) {
			GroupData group = new GroupData()
				.withName(generateRandomGroupString())
				.withHeader(generateRandomGroupString())
				.withFooter(generateRandomGroupString());			
			list.add(group);
		}
		return list;		
	}
	
	public static String  generateRandomGroupString() {
		Random rnd = new Random();	
		if(rnd.nextInt(3) == 0){
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

}
