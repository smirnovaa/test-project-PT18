package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String telephonehome;
	public String mobilephone;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String belonggroup;
	public String address2;
	public String home;

	public ContactData() {
		
	}
	public ContactData(String firstname, String lastname, String address,
			String telephonehome, String mobilephone, String email,
			String email2, String bday, String bmonth, String byear,
			String belonggroup, String address2, String home) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.telephonehome = telephonehome;
		this.mobilephone = mobilephone;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.belonggroup = belonggroup;
		this.address2 = address2;
		this.home = home;
	}
}