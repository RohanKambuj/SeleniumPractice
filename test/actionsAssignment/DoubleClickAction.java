package actionsAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DoubleClickAction {
  
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @Test
  public void testDoubleClick() {
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	  
	  WebElement doubleClickButton = driver.findElement(By.xpath("//*[text()='Double-Click Me To See Alert']"));
	  
	  Actions builder = new Actions(driver);
	  builder.doubleClick(doubleClickButton).build().perform();
	  
	  Alert alert = driver.switchTo().alert();
	  assertEquals(alert.getText(),"You double clicked me.. Thank You..");
	  alert.accept();
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
