package framesAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class ToolsqaFrames {

	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @Test
  public void testFrame() {
	  driver.get("http://toolsqa.com/iframe-practice-page/");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
	  System.out.println("The total number of iframes are " + totalFrames.size());
	  
	  driver.switchTo().frame("IF1");
	  
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame("IF2");
	  
	  driver.switchTo().defaultContent();
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
