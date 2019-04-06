package gmailTestNGAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GmailAssignment extends TestDataProvider {
  
	WebDriver driver;
	
	WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
	  driver = new FirefoxDriver();
	  
	 wait = new WebDriverWait(driver,10);
  }
  
  @Test(dataProvider="provideTestData")
  public void loginGmail(String userName, String passWord) {
	  driver.get("https://accounts.google.com/signin/v2/identifier?hl=en-GB&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  
	  driver.findElement(By.name("identifier")).sendKeys(userName);
		
      driver.findElement(By.id("identifierNext")).click();
      
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(passWord);
		
	  driver.findElement(By.id("passwordNext")).click();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
