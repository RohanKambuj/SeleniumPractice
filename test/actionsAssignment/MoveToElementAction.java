package actionsAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MoveToElementAction {
  
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.9.1\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @Test
  public void testMoveToElement() {
	  driver.get("https://www.annauniv.edu/");
	  
	  driver.findElement(By.linkText("Departments")).click();
	
	  WebElement facultyOfCivilEngg = driver.findElement(By.xpath("//*[@id='link3']/strong"));
	
	  WebElement oceanManagement = driver.findElement(By.xpath("//*[@id='link3']//tr[8]/td"));
	  
	  Actions builder = new Actions(driver);
	  
	  builder.moveToElement(facultyOfCivilEngg).moveToElement(oceanManagement).build().perform();

  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
