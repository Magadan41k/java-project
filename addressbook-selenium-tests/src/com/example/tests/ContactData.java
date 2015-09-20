package com.example.tests;

public class ContactData implements Comparable<ContactData> {

	public String firstName;
	public String lastName;
	public String address;
	public String telephoneHome;
	public String telephoneMobile;
	public String telephoneWork;
	public String email;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String group;
	public String secondaryAddress;
	public String secondaryHome;

	@Override
	public String toString() {
		return "ContactData [email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.email.toLowerCase().compareTo(other.email.toLowerCase());
	}

}