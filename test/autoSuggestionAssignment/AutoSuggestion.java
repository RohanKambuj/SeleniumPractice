package autoSuggestionAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AutoSuggestion {
  
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.9.1\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @Test
  public void printAutoSuggestion() {
	  driver.get("https://www.google.co.in");
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.id("q")).sendKeys("Sachin");
	  
	  List<WebElement> allOptions = driver.findElements(By.xpath("//ul/li[@class='sbct']"));
	  System.out.println("Total auto suggestions: "+allOptions.size());
	  for(WebElement options: allOptions) {
		  String option = options.getText();
		  System.out.println(option);
	  }
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
