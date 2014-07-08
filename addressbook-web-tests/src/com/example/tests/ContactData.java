package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String telephonehome;
	private String mobilephone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String belonggroup;
	private String address2;
	private String phone2;

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
		this.phone2 = home;
	}
	
	
	
	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", telephonehome=" + telephonehome
				+ ", mobilephone=" + mobilephone + ", email=" + email
				+ ", email2=" + email2 + ", bday=" + bday + ", bmonth="
				+ bmonth + ", byear=" + byear + ", belonggroup=" + belonggroup
				+ ", address2=" + address2 + ", phone2=" + phone2 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;  
		return true;
	} 
	
	@Override
	public int compareTo(ContactData other) {
		int fileld1result = this.firstname.compareTo(other.firstname);
		if (fileld1result != 0) {
		  return fileld1result;
		} else {
		  return this.lastname.compareTo(other.lastname);
		}			
	}
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;		
		return this;
	}
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;		
		return this;
	}
	public ContactData withAddress(String address) {
		this.address = address;		
		return this;
	}
	public ContactData withTelephonehome(String telephonehome) {
		this.telephonehome = telephonehome;
		return this;
	}
	public ContactData withMobilephone(String Mobilephone) {
		mobilephone = Mobilephone;
		return this;
	}
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}
	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}
	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephonehome() {
		return telephonehome;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public String getEmail() {
		return email;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBday() {
		return bday;
	}
	public String getBmonth() {
		return bmonth;
	}
	public String getByear() {
		return byear;
	}
	public String getBelonggroup() {
		return belonggroup;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone2() {
		return phone2;
	}	
	
	
	
}