package com.example.tests;

import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupsGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare states
		assertThat(newList, equalTo(oldList.without(group)));
	}

}