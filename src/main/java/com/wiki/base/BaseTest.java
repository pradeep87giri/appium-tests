package com.wiki.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AndroidDriver driver;

	public void setUp(String appPath) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "11.0");
		cap.setCapability("appium:deviceName", "Pixel_7_API_30");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:app", appPath);

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		System.out.println(" App is launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
