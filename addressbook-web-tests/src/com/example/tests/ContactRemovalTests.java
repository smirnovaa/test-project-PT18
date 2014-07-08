package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deliteSomeContact() {
		
		 // save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random ();
	    int indexForDel = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().deleteContact(indexForDel);					
		 
	    // save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(indexForDel);	   
	    assertEquals(newList, oldList);  
	}

}
