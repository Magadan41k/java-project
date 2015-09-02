package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.telephoneHome);
		type(By.name("mobile"), contact.telephoneMobile);
		type(By.name("work"), contact.telephoneWork);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.birthDay);
		selectByText(By.name("bmonth"), contact.birthMonth);
		type(By.name("byear"), contact.birthYear);
		// selectByText(By.name("new_group"), "group 1");
		type(By.name("address2"), contact.secondaryAddress);
		type(By.name("phone2"), contact.secondaryHome);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void returnToGroupPage() {
		click(By.linkText("home page"));
	}

}
