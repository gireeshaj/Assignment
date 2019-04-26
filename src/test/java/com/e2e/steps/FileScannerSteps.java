package com.e2e.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.e2e.filescanner.FileScanner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FileScannerSteps {

	public FileScanner fileScanner;
	
	public static String directoryName;
	
	@Autowired
	public FileScannerSteps(FileScanner fileScanner) {
		this.fileScanner=fileScanner;
	}
	
	@Given("^I have specified directory \"([^\"]*)\" in the file system$")
	public void i_have_specified_directory_in_the_file_system(String fileDir) throws Throwable {
		directoryName=fileDir;
	}


	@Then("^I should retrieve all the supported files information$")
	public void i_should_retrieve_all_the_supported_files_information() throws Throwable {
		fileScanner.readFileScanner(directoryName);
	}	
}
