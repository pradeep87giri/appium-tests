package com.wiki.tasks;

import com.wiki.base.BaseTest;
import com.wiki.pages.HomePage;

public class Task3 extends BaseTest {

	public static void main(String[] args) {
		Task3 task = new Task3();

		task.setUp(
				"/Users/pradeep_giri/Documents/Code/wiki-e2e-mobile-soar/wiki/src/main/java/com/wiki/resources/WikipediaSample.apk");

		// Scroll down
		HomePage homePage = new HomePage(task.driver);
		homePage.goToSettings();
		homePage.disableSettingOptions();
		homePage.goBackToHomePage();
	}
}
