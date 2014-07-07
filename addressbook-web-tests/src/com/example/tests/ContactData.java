package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	public String phone2;

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
	
	
	
}