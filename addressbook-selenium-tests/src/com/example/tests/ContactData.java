package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String telephoneHome;
	public String telephoneMobile;
	public String telephoneWork;
	public String email;
	public String email2;
	public String birthdayDay;
	public String birthdayMonth;
	public String birthdayYear;
	public String group;
	public String secondaryAddress;
	public String secondaryHome;

	public ContactData() {
			}
	
	public ContactData(String firstName, String lastName, String address, String telephoneHome, String telephoneMobile,
			String telephoneWork, String email, String email2, String birthdayDay, String birthdayMonth,
			String birthdayYear, String group, String secondaryAddress, String secondaryHome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephoneHome = telephoneHome;
		this.telephoneMobile = telephoneMobile;
		this.telephoneWork = telephoneWork;
		this.email = email;
		this.email2 = email2;
		this.birthdayDay = birthdayDay;
		this.birthdayMonth = birthdayMonth;
		this.birthdayYear = birthdayYear;
		this.group = group;
		this.secondaryAddress = secondaryAddress;
		this.secondaryHome = secondaryHome;
}
}