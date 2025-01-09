package com.wiki.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.wiki.utils.Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
    AndroidDriver driver;

    private By explore = AppiumBy.xpath("//*[@content-desc='Explore']//android.widget.ImageView");
    private By myLists = AppiumBy.xpath("//*[@content-desc='My lists']//android.widget.ImageView");
    private By history = AppiumBy.xpath("//*[@content-desc='History']//android.widget.ImageView");
    private By nearby = AppiumBy.xpath("//*[@content-desc='Nearby']//android.widget.ImageView");
    private By searchField = AppiumBy.id("org.wikipedia.alpha:id/fragment_feed_header");
    private By searchBox = AppiumBy.id("org.wikipedia.alpha:id/search_src_text");
    private By searchBar = AppiumBy.id("org.wikipedia.alpha:id/fragment_search_results");
    private By searchItems = AppiumBy.xpath("//*[@resource-id='org.wikipedia.alpha:id/page_list_item_title']");
    private By closeBtn = AppiumBy.id("org.wikipedia.alpha:id/search_close_btn");
    private By menu = AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button");
    private By settings = AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings");
    private By settingOptions = AppiumBy
            .xpath("//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget']");
    private By backBtn = AppiumBy.accessibilityId("Navigate up");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollDown() {
        int counter = 0;
        while (counter < 7) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
                counter++;
            } catch (Exception e) {
                System.out.println("Reached the bottom of the scrollable view.");
                break;
            }
        }
        System.out.println("Scrolled down");
    }

    public void clickOnIcons() {
        driver.findElement(myLists).click();
        Utils.wait(3);
        driver.findElement(history).click();
        Utils.wait(3);
        driver.findElement(nearby).click();
        Utils.wait(3);
        driver.findElement(explore).click();
        System.out.println("Icons are clicked");
    }

    public void scrollUp() {
        int counter = 0;
        while (counter < 7) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
                counter++;
            } catch (Exception e) {
                System.out.println("Reached the bottom of the scrollable view.");
                break;
            }
        }
        System.out.println("Scrolled Up");
    }

    public void searchWiki(String search) {
        driver.findElement(searchField).click();
        driver.findElement(searchBox).sendKeys(search);
        // Check if search Bar is expanded
        List<WebElement> elements = driver.findElements(searchBar);
        System.out.println("Search Bar size: " + elements.size());
        Assert.assertTrue(elements.size() > 0, "Search Bar is not expanded");
        System.out.println("Search Bar is expanded");
    }

    public void verifyItemsInSearchBar(String search) {
        // Check if each item in search Bar contains the search text
        List<WebElement> items = driver.findElements(searchItems);
        System.out.println("Search Bar Items: " + items.size());
        for (WebElement item : items) {
            Assert.assertTrue(item.getText().contains(search),
                    "Search item" + item.getText() + "does not contain the search text");
        }
        System.out.println("All items in search bar contain the search text");
    }

    public void closeSearchBar() {
        WebElement close = driver.findElement(closeBtn);
        Actions actions = new Actions(driver);
        actions.click(close)
                .pause(Duration.ofMillis(100)) // Short pause between clicks
                .click(close)
                .perform();
        System.out.println("Search Bar is closed");
    }

    public void goToSettings() {
        driver.findElement(menu).click();
        driver.findElement(settings).click();
        System.out.println("Settings is opened");
    }

    public void disableSettingOptions() {
        List<WebElement> options = driver.findElements(settingOptions);
        for (WebElement option : options) {
            if (option.getAttribute("checked").equals("true")) {
                option.click();
            }
        }
        System.out.println("Settings options are disabled");
    }

    public void goBackToHomePage() {
        driver.findElement(backBtn).click();
        System.out.println("Back to Home Page");
    }

}