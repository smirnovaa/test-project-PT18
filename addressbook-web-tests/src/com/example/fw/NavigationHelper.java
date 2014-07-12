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
	
}
