package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null) {
			rebuildCacheContract();
		}
		return cachedContacts;		
	}
	
	private void rebuildCacheContract() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String fullname = title.substring("Select (".length(), title.length() - ")".length());
			String firstname = fullname.substring(0, fullname.indexOf(' '));
			String lastname = fullname.substring(fullname.indexOf(' ') + 1 , fullname.length());
			cachedContacts.add(new ContactData() .withFirstname(firstname) .withLastname(lastname));
		}
	}
		
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
    	fillContactForm(contact, CREATION);
    	submitContactCreation();
    	returnHomePage();
    	rebuildCacheContract();
		return this;
	} 
	
	public ContactHelper modifyContactEdit(int indexForModify, ContactData contact) {		
		initContactEdit(indexForModify);
		fillContactForm(contact, MODIFICATION);
		updateContact();
		returnHomePage();	
		rebuildCacheContract();
		return this;
	}
	
	public ContactHelper modifyContactDetails(int indexForModify, ContactData contact) {
		initContactDetails(indexForModify);
		initContactModify();
		fillContactForm(contact, MODIFICATION);
		updateContact();
		returnHomePage();	
		rebuildCacheContract();
		return this;
	}	
	
	public ContactHelper deleteContact(int indexForDel) {	
		initContactEdit(indexForDel);
		click(By.xpath("(//input[@name='update'])[2]"));
		returnHomePage();
		rebuildCacheContract();
		return this;
	}
	
//-------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
		}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getTelephonehome());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());	
		if (formType == CREATION) {
			// selectByText(By.name("new_group"), "group 1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		
		type(By.name("address2"), contact.getAddress2());	
		type(By.name("phone2"), contact.getPhone2());	
		return this;
		}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
		}

	public ContactHelper returnHomePage() {
		click(By.linkText("home"));	
		return this;
	}	

	public ContactHelper initContactEdit(int indexContact) {
		click(By.xpath("(//img[@alt='Edit'])[" + indexContact + "]"));
		return this;
	}	

	public ContactHelper updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));	
		return this;
	}

	public ContactHelper initContactDetails(int indexContact) {
		click(By.xpath("(//img[@alt='Details'])[" + indexContact + "]"));
		return this;
	}

	public ContactHelper initContactModify() {
		click(By.xpath("(//input[@name='modifiy'])[1]"));	
		return this;
	}
	
}
