package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.address = generateRandomString();
			contact.telephoneHome = generateRandomString();
			contact.telephoneMobile = generateRandomString();
			contact.telephoneWork = generateRandomString();
			contact.email = generateRandomString();
			contact.email2 = generateRandomString();				
			contact.secondaryAddress = generateRandomString();
			contact.secondaryHome = generateRandomString();
			list.add(new Object[] { contact });
		}		
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactCreation();
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

}