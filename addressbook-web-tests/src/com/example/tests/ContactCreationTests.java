package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
 
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();

    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions    
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnHomePage();
        
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    AssertJUnit.assertEquals(newList, oldList);  
  }
  
//  @Test
  @Test
public void testEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();

    // save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions  
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "-", "-", "", "", "", "");
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    AssertJUnit.assertEquals(newList, oldList);  
  }
 
}
