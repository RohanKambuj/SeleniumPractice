package waitsAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DynamicLoadingWait {
  
	WebDriver driver;
	
	//WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
	  driver = new FirefoxDriver();
	  //wait = new WebDriverWait(driver,10);
  }

  @Test
  public void testWait() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  
	  //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
	  String text=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
	  
	  assertEquals(text,"Hello World!");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
