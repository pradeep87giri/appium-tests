package com.wiki.tasks;

import com.wiki.base.BaseTest;
import com.wiki.pages.HomePage;

public class Task2 extends BaseTest {

	public static void main(String[] args) {
		Task2 task = new Task2();
		task.setUp();

		HomePage homePage = new HomePage(task.driver);
		homePage.searchWiki("New York");
		homePage.verifyItemsInSearchBar("New York");
		homePage.closeSearchBar();
	}
}
