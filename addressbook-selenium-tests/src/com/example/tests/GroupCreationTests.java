package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		GroupData group = new GroupData();
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		group.name = "group name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.groupHelper.fillGroupForm(group);
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		GroupData group = new GroupData("", "", "");
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		app.groupHelper.fillGroupForm(new GroupData("", "", ""));
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returnToGroupsPage();
		app.groupHelper.createGroup(app, this, group);
	}
}
