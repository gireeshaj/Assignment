package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.e2e.ConfigUtils.ConfigUtils;


public class DVLAPage extends BasePage {

	private WebDriver driver;
	

	@FindBy(css=".button")
    private WebElement startButton;

	@FindBy(id="Vrm")
    private WebElement VRM;

	@FindBy(id="Correct_False")
    private WebElement NoOptionButton;

	@FindBy(css="li.list-summary-item:nth-child(3) > span:nth-child(2) > strong:nth-child(1)")
    private WebElement VehicleColor;

	public DVLAPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}
	
	public void gotoHomePage() {
		driver.get(ConfigUtils.getWebEndPoint());
	}

	public void clickButton() {
		clickElement(startButton);
	}
	
	public void enterVRM(String vehicleText) {
		enterText(VRM, vehicleText);
	}
	
	public String getVehicleColor() {
		return getText(VehicleColor);
	}
	
	public void clickNotoContinue() {
		clickElement(NoOptionButton);
	}
}
