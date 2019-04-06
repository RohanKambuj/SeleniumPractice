package triphoboAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Triphobo {
  
	WebDriver driver;
	
	WebDriverWait wait;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver,20);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }
  
  @Test
  public void tripPlanning() {
	  driver.get("https://www.triphobo.com/");
	  
	  driver.findElement(By.xpath("//button[text()='Later']")).click();
	  
	  driver.findElement(By.id("spl-autocomplete-search")).sendKeys("Houston");
	  
	  List <WebElement> citySuggestionList = driver.findElements(By.xpath("//div[@id='js-suggestions']/ul//li"));
	  
	  for(WebElement selectCity: citySuggestionList) {
		  String city = selectCity.getAttribute("value");
		  assertEquals(city,"Texas, United States, North America");
		  selectCity.click();
	  }
	  
	  driver.findElement(By.xpath("//div[@class='step-1-action-button']/button[2]")).click();
	  
	  driver.findElement(By.xpath("//span[@id='js_close_hotel_combine']")).click();
	  
	  driver.findElement(By.id("hotel_step_popup_skip_hotel")).click();
	  
	  driver.findElement(By.xpath("//div[@class='btn-group']/button[@id='js_add_activity']")).click();
	  
	  WebElement splashTownOption = driver.findElement(By.xpath("//img[@alt='Splash Town']"));
	  
	  Actions builder = new Actions(driver);
	  builder.moveToElement(splashTownOption).click(splashTownOption).build().perform();
	  
	  driver.findElement(By.xpath("//a[@class='js_add_activity_to_select_day']//label[text()='Day 2']")).click();
	  
	  driver.findElement(By.xpath("//*[@class='global-drawer-overlay'][2]//a[@id='close']")).click();
	  
	  driver.findElement(By.xpath("//*[@class='global-side-drawer']/a[@id='close']")).click();
	  
	  WebElement splashTownActivity = driver.findElement(By.xpath("//h4[text()='Splash Town']"));
	  
	  WebElement dropToDayThree = driver.findElement(By.xpath("//ul[@id='js_day_container']//li[@id='js_iti_day_3']"));
	  
	  builder.dragAndDrop(splashTownActivity, dropToDayThree).build().perform();
	  
	  driver.findElement(By.xpath("//div[@class='btn-group']/button[@class='btn btn-success js_finish_planning_btn']")).click();
	  
	  driver.findElement(By.xpath("//a[@class='fin-plan-btn']")).click();
  }
 

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
