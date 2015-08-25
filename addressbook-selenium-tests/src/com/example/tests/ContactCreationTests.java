package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		ContactData contact = new ContactData();
		contact.firstName = "Misha";
		contact.lastName = "Tishin";
		contact.address = "Podolsk";
		contact.telephoneHome = "8905";
		contact.telephoneMobile = "8916";
		contact.telephoneWork = "8926";
		contact.email = "tishin@mail.ru";
		contact.email2 = "tishin2@mail.ru";
		contact.birthDay = "14";
		contact.birthMonth = "April";
		contact.birthYear = "1988";
		contact.group = "group name 1";
		contact.secondaryAddress = "Podolsk2";
		contact.secondaryHome = "Podolsk3";
		
		openMainPage();
		initContactCreation();
		fillContactForm(contact);
		submitContactForm();
		returnToGroupPage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		openMainPage();
		initContactCreation();
		submitContactForm();
		returnToGroupPage();
	}
}
