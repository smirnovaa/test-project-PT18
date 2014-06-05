package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
 
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    gotoAddNew();
    ContactData contact = new ContactData();
	contact.firstname = "Ivan";
	contact.lastname = "Ivanov";
	contact.address = "address";
	contact.telephonehome = "111-11-11";
	contact.mobilephone = "+11 (111) 111-11-11";
	contact.email = "mail@mail";
	contact.email2 = "mail2@mail";
	contact.bday = "5";
	contact.bmonth = "June";
	contact.byear = "1960";
	contact.belonggroup = "Rob";
	contact.address2 = "address2";
	contact.home = "home";
    fillContactForm(contact);
    submitContactCreation();
    returnHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    gotoAddNew();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "-", "-", "", "", "", "");
    fillContactForm(contact);
    submitContactCreation();
    returnHomePage();
  }
 
}
