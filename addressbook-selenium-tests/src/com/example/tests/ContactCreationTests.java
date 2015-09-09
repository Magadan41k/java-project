package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {

		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldLists = app.getContactHelper().getContacts();

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
		contact.email2 = "tishin2@mail.ru"; 
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
		List<ContactData> newLists = app.getContactHelper().getContacts();

		// compare states
		assertEquals(newLists.size(), oldLists.size() + 1);
		
		oldLists.add(contact);
		Collections.sort(oldLists);
		assertEquals(newLists, oldLists);
	}

	// @Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().submitContactForm();
		app.getContactHelper().returnToGroupPage();
	}
}
