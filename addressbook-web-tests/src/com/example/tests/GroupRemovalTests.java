package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deliteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnGroupPage();
	}
	
	@Test
	public void deliteSomeGroups() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().deleteGroups(1,6);
		app.getGroupHelper().returnGroupPage();
	}

}
