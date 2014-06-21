package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactEdit(9);
		ContactData contact = new ContactData();
		contact.firstname = "Alex";
		contact.address = "address4";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnHomePage();		
	}
	
	@Test
	public void modifySomeContactModify() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactDetails(11);
		app.getContactHelper().initContactModify();		
		ContactData contact = new ContactData();
		contact.firstname = "John";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnHomePage();		
	}

}
