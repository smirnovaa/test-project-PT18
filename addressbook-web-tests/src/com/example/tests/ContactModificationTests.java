package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactEdit(ContactData contact) {
		app.getNavigationHelper().openMainPage();

	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().initContactEdit(indexForModify);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnHomePage();	
			     
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(indexForModify);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactModify(ContactData contact) {
		app.getNavigationHelper().openMainPage();

	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().initContactDetails(indexForModify);
		app.getContactHelper().initContactModify();		
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnHomePage();	
	     
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(indexForModify);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
