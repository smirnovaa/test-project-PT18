package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deliteSomeContact() {
		
		 // save old state
		SortedListOf<ContactData> oldList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    Random rnd = new Random ();
	    int indexForDel = rnd.nextInt(oldList.size()-1);
	    
	    // actions  
		app.getContactHelper().deleteContact(indexForDel);					
		 
	    // save new state
		SortedListOf<ContactData> newList 
			= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(indexForDel)));			
	}

}
