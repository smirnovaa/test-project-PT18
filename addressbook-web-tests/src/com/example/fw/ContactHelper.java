package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
		}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.telephonehome);
		type(By.name("mobile"), contact.mobilephone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);		
		selectByText(By.name("new_group"), contact.belonggroup);
		type(By.name("address2"), contact.address2);	
		type(By.name("phone2"), contact.phone2);		
		}

	public void submitContactCreation() {
		click(By.name("submit"));		
		}

	public void returnHomePage() {
		click(By.linkText("home"));	
	}

	public void deleteContact() {		
		click(By.xpath("(//input[@name='update'])[2]"));
	}

	public void initContactEdit(int indexContact) {
		click(By.xpath("(//img[@alt='Edit'])[" + indexContact + "]"));
	}	

	public void updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));		
	}

	public void initContactDetails(int indexContact) {
		click(By.xpath("(//img[@alt='Details'])[" + indexContact + "]"));
	}

	public void initContactModify() {
		click(By.xpath("(//input[@name='modifiy'])[1]"));		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();	
			String title = checkbox.getAttribute("title");
			String fullname = title.substring("Select (".length(), title.length() - ")".length());
			contact.firstname = fullname.substring(0, fullname.indexOf(' '));
			contact.lastname = fullname.substring(fullname.indexOf(' ') + 1 , fullname.length());
			contacts.add(contact);
		}
		return contacts;
	} 
	
	
	

	
	
}
