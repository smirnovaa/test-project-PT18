package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactEdit(ContactData contact) {
		app.navigateTo().mainPage();

	    // save old state
		SortedListOf<ContactData> oldList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().modifyContactEdit(indexForModify, contact);	    
			     
	    // save new state
		SortedListOf<ContactData> newList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(indexForModify).withAdded(contact))); 	   
	}
	
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactModify(ContactData contact) {
		
	    // save old state
		SortedListOf<ContactData> oldList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().modifyContactDetails(indexForModify, contact);
	    
	    // save new state
		SortedListOf<ContactData> newList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(indexForModify).withAdded(contact))); 		
	}

}
