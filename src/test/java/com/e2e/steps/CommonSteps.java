package com.e2e.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.e2e.driver.WebDriverManager;


public class CommonSteps {

	public static WebDriver driver;

	public CommonSteps() {
		if (driver == null) {
			try {
				driver = WebDriverManager.getDriverDynamic();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}