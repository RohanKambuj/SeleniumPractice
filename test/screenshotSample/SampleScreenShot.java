package screenshotSample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class SampleScreenShot {
	
	WebDriver driver;
  @Test
  public void takeScreenShot() throws IOException {
	  
	  //Casting
	  TakesScreenshot capture = (TakesScreenshot) driver;
	  
	  //Taking screenshot
	  File actualScreenshot = capture.getScreenshotAs(OutputType.FILE);

	  //Create a new file for copying
	  String filename =  new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	  File myFile = new File("screenshot_"+filename+".png");
	  
	  //Copy screenshot to myFile
	  FileUtils.copyFile(actualScreenshot, myFile);
  }  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
		driver = new FirefoxDriver();
		driver.get("https://google.co.in");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
