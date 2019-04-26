package com.e2e.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.e2e.ConfigUtils.ConfigUtils;


public class WebDriverManager {

	
	public static WebDriver getDriverDynamic() throws MalformedURLException {
		String defaultBrowser = ConfigUtils.getASpecificProperty("browser");
		
		WebDriver driver = null;
		if (defaultBrowser.equals("firefox") || defaultBrowser.equals("ff")) {
    			//String geckodriverPath = new File("").getAbsolutePath() + File.separatorChar + "src/test/resources" + File.separatorChar + "geckodriver.exe";
    			String geckodriverPath = "C://Gireesh//geckodriver";
    			
    			System.out.println(geckodriverPath);
			System.setProperty("webdriver.gecko.driver",geckodriverPath);
			
			// set driver properties
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (defaultBrowser.equals("chrome")){
			String chromedriverpath = "C://Users//Gireesh//chromedriver";
			
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
		}
		return driver;
	}

}
