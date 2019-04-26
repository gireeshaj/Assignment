package com.e2e.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;

public class SharedSteps extends CommonSteps{

	
	/**
	 * Take screen shot
	 * @param scenario
	 */
    @After
	public void embedScreenshot(Scenario scenario) {  
        	System.out.println(("Scenario Completed"));
            try {  
            	byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            	scenario.embed(bytes, "image/png");
            } catch (WebDriverException wde) {  
                System.err.println(wde.getMessage());  
            } catch (ClassCastException cce) {  
                cce.printStackTrace();  
            } catch (Exception e){
            	e.printStackTrace();
            }
        driver.close();
        driver=null;
    }
	

}
