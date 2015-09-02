package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		GroupData group = new GroupData();
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		group.name = "group name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		GroupData group = new GroupData("", "", "");
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
		app.getGroupHelper().createGroup(app, this, group);
	}
}
