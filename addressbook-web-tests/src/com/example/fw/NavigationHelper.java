package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()) {
			click(By.linkText("home"));
		}			
	}

	public void groupPage() {		
		if(!onGroupsPage()) {
			click(By.linkText("groups"));
		}		
	}
	
	protected boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() >0);
	}

	protected boolean onGroupsPage() {		
		if(driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size() >0) {
			return true;
		} else {
			return false;			
		}
	}
	
	
}
