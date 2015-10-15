package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupsGenerator")
	public void modifySomeGroup(GroupData group) {

		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getGroupHelper().modifyGroup(index, group);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
