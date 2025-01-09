package com.wiki.tasks;

import com.wiki.base.BaseTest;
import com.wiki.pages.HomePage;

public class Task1 extends BaseTest {

	public static void main(String[] args) {
		Task1 task = new Task1();
		task.setUp();

		HomePage homePage = new HomePage(task.driver);
		homePage.scrollDown();
		homePage.clickOnIcons();
		homePage.scrollUp();
	}
}
