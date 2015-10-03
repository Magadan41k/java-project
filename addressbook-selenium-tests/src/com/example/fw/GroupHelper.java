package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper createGroup(ApplicationManager applicationManager, TestBase testBase, GroupData group) {
		testBase.app.getNavigationHelper().openMainPage();
		testBase.app.getNavigationHelper().gotoGroupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public void submitGroupModification() {
		click(By.name("update"));

	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}

}