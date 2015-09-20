package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void NonEmptyContactCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.firstName = "Misha";
		contact.lastName = "Tishin";
		contact.address = "Podolsk";
		contact.telephoneHome = "8905";
		contact.telephoneMobile = "8916";
		contact.telephoneWork = "8926";
		contact.email = "tishin@mail.ru";
		contact.birthDay = "14";
		contact.birthMonth = "April";
		contact.birthYear = "1988";
		contact.group = "group name 1";
		contact.secondaryAddress = "Podolsk2";
		contact.secondaryHome = "Podolsk3";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactForm();
		app.getContactHelper().returnToGroupPage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

	
	
	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactCreation();
		app.getContactHelper().submitContactForm();
		app.getContactHelper().returnToGroupPage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		Collections.sort(oldList);
		Collections.sort(newList);
	}

}