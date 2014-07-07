package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupsGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();

	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions
		app.getGroupHelper().initGroupModification(indexForModify);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnGroupPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(indexForModify);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}


}
