package com.wiki.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AndroidDriver driver;

	public static String getAppPath() {
		Properties properties = new Properties();
		try (FileInputStream input = new FileInputStream("src/main/java/com/wiki/resources/config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileName = properties.getProperty("app.path");
		return new File(fileName).getAbsolutePath();
	}

	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "11.0");
		cap.setCapability("appium:deviceName", "Pixel_7_API_30");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:app", getAppPath());

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
