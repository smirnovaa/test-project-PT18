package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if(cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;		
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupPage();		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {			
			String title = checkbox.getAttribute("title");			
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData() .withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	returnGroupPage();	
    	rebuildCache();
    	return this;
    	}	
	
	public GroupHelper modifyGroup(int indexForModify, GroupData group) {
		initGroupModification(indexForModify);
		fillGroupForm(group);
		submitGroupModification();
		returnGroupPage();	
		rebuildCache();
		return this;
	}	
	
	public GroupHelper deleteGroup(int indexGroup) {
		selectGroupByIndex(indexGroup);
		submitGroupDeletion();
		returnGroupPage();
		rebuildCache();
		return this;
	}

	
	//---------------------------------------------------------------------------------------------------------------

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
		}

	public GroupHelper fillGroupForm(GroupData group) {
			type(By.name("group_name"), group.getName());
			type(By.name("group_header"), group.getHeader());
			type(By.name("group_footer"), group.getFooter());	
			return this;
		}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
		}

	public GroupHelper returnGroupPage() {
		click(By.linkText("group page"));
		return this;
	}
	
	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
	

	private void selectGroupByIndex(int indexGroup) {
		click(By.xpath("//input[@name='selected[]'][" + (indexGroup+1) + "]"));
	}

	public GroupHelper initGroupModification(int indexGroup) {
		selectGroupByIndex(indexGroup);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}
	
}
