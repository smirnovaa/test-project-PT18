package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContactEdit() {
		int indexForModify = 9;
		app.getNavigationHelper().openMainPage();

	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions  
		app.getContactHelper().initContactEdit(indexForModify);
		ContactData contact = new ContactData();
		contact.lastname = oldList.get(indexForModify).lastname;
		contact.firstname = "peter";
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
	
	
	@Test
	public void modifySomeContactModify() {
		int indexForModify = 11;
		app.getNavigationHelper().openMainPage();

	    // save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    // actions  
		app.getContactHelper().initContactDetails(indexForModify);
		app.getContactHelper().initContactModify();		
		ContactData contact = new ContactData();
		contact.firstname = oldList.get(indexForModify).firstname;
		contact.lastname = "John";
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
