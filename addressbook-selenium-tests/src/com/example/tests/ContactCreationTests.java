package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
 
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
	initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "Misha";
    contact.lastName = "Tishin";
    contact.address = "Podolsk";
    contact.telephoneHome = "8905";
    contact.telephoneMobile = "8916";
    contact.telephoneWork = "8926";
    contact.email = "tishin@mail.ru";
    contact.email2 = "tishin2@mail.ru";
    contact.birthdayDay = "14";
    contact.birthdayMonth = "April";
    contact.birthdayYear = "1988";
    contact.group = "group name 1";
    contact.secondaryAddress = "Podolsk2";
    contact.secondaryHome = "Podolsk3";    												
	fillContactForm(contact);
    submitContactForm();
    returnToGroupPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
	initContactCreation();
    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "", ""));
    submitContactForm();
    returnToGroupPage();
  }
}
