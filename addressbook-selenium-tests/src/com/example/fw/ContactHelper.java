package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void deleteContact(int index) {
		selectContactByIndex(index);
		selectContactByEdit();
		click(By.xpath("(//input[@name='update'])[2]"));

	}

	private void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	private void selectContactByEdit() {
		click(By.cssSelector("img[alt=\"Edit\"]"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
		selectContactByEdit();
	}

	public void submitContactModification() {
		click(By.name("update"));
		click(By.linkText("home page"));

	}

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> checkboxes =  driver.findElements(By.name("selected[]"));

        for (WebElement checkbox : checkboxes){
            ContactData contact = new ContactData();
            String accept = checkbox.getAttribute("accept");
            contact.email= accept;
            contacts.add(contact);
        }
		return contacts;
	}

}
