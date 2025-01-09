package com.wiki.tasks;

import com.wiki.base.BaseTest;
import com.wiki.pages.HomePage;

public class Task2 extends BaseTest {

	public static void main(String[] args) {
		Task2 task = new Task2();

		task.setUp(
				"/Users/pradeep_giri/Documents/Code/wiki-e2e-mobile-soar/wiki/src/main/java/com/wiki/resources/WikipediaSample.apk");

		// Scroll down
		HomePage homePage = new HomePage(task.driver);
		homePage.searchWiki("New York");
		homePage.verifyItemsInSearchBar("New York");
		homePage.closeSearchBar();
	}
}
