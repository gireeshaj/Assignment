package com.e2e.steps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.e2e.filescanner.FileScanner;
import com.e2e.pages.DVLAPage;
import com.e2e.utils.Vehicles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class DVLASteps extends CommonSteps {

	public FileScanner fileScanner;
	public DVLAPage dVLAPage;
	
	@Autowired
	public DVLASteps(FileScanner fileScanner) {
		this.fileScanner=fileScanner;
		dVLAPage= new DVLAPage(driver);
	}

	@Given("^I am on DVLA page$")
	public void i_am_on_DVLA_page() throws Throwable {
		dVLAPage.gotoHomePage();
		
	}

	@Then("^I should be able to search each vehicle defined in the CSV file$")
	public void i_should_be_able_to_search_each_vehicle_defined_in_the_CSV_file() throws Throwable {
		dVLAPage.clickButton();
		List<Vehicles> x=fileScanner.getDataFromCsv();
		for(int i=0;i<x.size();i++) {
			dVLAPage.enterVRM(x.get(i).getVehicleName());
			dVLAPage.clickButton();
			String vehicleColor=dVLAPage.getVehicleColor();
			assertEquals(x.get(i).getVehicleColor().toLowerCase(), vehicleColor.toLowerCase());
			dVLAPage.clickNotoContinue();
			dVLAPage.clickButton();
		}

	}
}
