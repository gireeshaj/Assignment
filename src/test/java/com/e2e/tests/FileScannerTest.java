package com.e2e.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report_test_fileScanner","json:target/basicreport_test_FileScanner.json" }, 
		glue = { "com.e2e.steps" },
		//dryRun=true,
		features = { "classpath:features/"}
		,tags ={"@FileScannerTest"}
		,monochrome=true
)
public class FileScannerTest {

}
