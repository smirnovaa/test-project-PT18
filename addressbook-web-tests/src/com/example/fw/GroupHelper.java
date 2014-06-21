package com.example.fw;

import org.openqa.selenium.By;

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
		click(By.xpath("//input[@name='selected[]'][" + indexGroup + "]"));
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

}
