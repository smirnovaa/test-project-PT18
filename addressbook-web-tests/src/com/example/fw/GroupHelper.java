package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void initGroupCreation() {
		click(By.name("new"));
		}

	public void fillGroupForm(GroupData group) {
			type(By.name("group_name"), group.name);
			type(By.name("group_header"), group.header);
			type(By.name("group_footer"), group.footer);		   
		}

	public void submitGroupCreation() {
		click(By.name("submit"));
		}

	public void returnGroupPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int indexGroup) {
		selectGroupByIndex(indexGroup);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int indexGroup) {
		click(By.xpath("//input[@name='selected[]'][" + (indexGroup+1) + "]"));
	}

	public void initGroupModification(int indexGroup) {
		selectGroupByIndex(indexGroup);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));		
	}

	public void deleteGroups(int...indexGroups) {
		for (int indexGroup : indexGroups) {
			selectGroupByIndex(indexGroup);
		} 
		click(By.name("delete"));		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();	
			String title = checkbox.getAttribute("title");			
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}

}
