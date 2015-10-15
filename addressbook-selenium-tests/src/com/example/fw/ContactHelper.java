package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact, boolean formType) {
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
		if (formType == CREATION) {
		// selectByText(By.name("new_group"), "group 1");
		} else {
			if (driver.findElements(By.name("new group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.secondaryAddress);
		type(By.name("phone2"), contact.secondaryHome);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void returnToGroupPage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
        selectContactByIndex(index);
      click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initContactModification(int index) {
        selectContactByIndex(index);
    }

    public void updateContactModification() {
        click(By.xpath("//input[11]"));
    }

    private void selectContactByIndex(int index) {
            click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]/td/a/img[@title='Edit']"));
    }

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.name("entry"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData();		
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String name = cells.get(1).getText();
			contact.firstName=cells.get(2).getText();
			contacts.add(contact);
		}

		return contacts;
	}
	
	

}