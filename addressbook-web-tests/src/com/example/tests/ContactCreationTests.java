package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactFromXmlFile;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactFromFile () throws IOException {
		return wrapContactForProvider(loadContactFromXmlFile(new File ("contacts.xml"))).iterator();
	}  

@Test(dataProvider = "contactFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    
    // save old state
	  SortedListOf<ContactData> oldList 
	  	= new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
    
    // actions    
    app.getContactHelper().createContact(contact);    
        
    // save new state
    SortedListOf<ContactData> newList = new SortedListOf<ContactData>(app.getHibernateHelper().listContact());
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));          
  }
   
}
