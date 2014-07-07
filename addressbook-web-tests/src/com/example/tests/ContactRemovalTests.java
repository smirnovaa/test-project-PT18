package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deliteSomeContact() {
		app.getNavigationHelper().openMainPage();

	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions  
		app.getContactHelper().initContactEdit(3);
	    app.getContactHelper().deleteContact();
		app.getContactHelper().returnHomePage();
		
		 
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);  
	}

}
