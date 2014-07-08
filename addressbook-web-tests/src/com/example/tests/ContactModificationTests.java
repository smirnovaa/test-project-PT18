package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactEdit(ContactData contact) {
		app.navigateTo().mainPage();

	    // save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().modifyContactEdit(indexForModify, contact);	    
			     
	    // save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(indexForModify);
	    oldList.add(contact);	    
	    assertEquals(newList, oldList);
	}
	
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactModify(ContactData contact) {
		
	    // save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().modifyContactDetails(indexForModify, contact);
	    
	    // save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(indexForModify);
	    oldList.add(contact);
	    assertEquals(newList, oldList);
	}

}
