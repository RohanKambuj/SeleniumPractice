package scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaTest {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D://Selenium 3.9.1//resources//geckodriver64bit.exe");
		
		//Open browser
	    driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.wikipedia.org");
		   
		Thread.sleep(3000);
		//Find English word and click on it
       driver.findElement(By.id("js-link-box-en")).click();
       Thread.sleep(3000);
       
       //Find search text box, enter selenium
       driver.findElement(By.id("searchInput")).sendKeys("Selenium");
       Thread.sleep(3000);
       
       //Click on search button
       driver.findElement(By.id("searchButton")).click();
       
       //Validation to see page title
       String actualTitle=driver.getTitle();
       if(actualTitle.equals("Selenium - Wikipedia")) {
    	   System.out.println("Title matched");
       }
       else {
    	   System.out.println("Title not matched");
       }
       
       Thread.sleep(3000);
       
       //Validate the search text
       String firstHeading=driver.findElement(By.id("firstHeading")).getText();
       if(firstHeading.equals("Selenium")) {
    	   System.out.println("Search text found");
       }
       else {
    	   System.out.println("Search text not found");
       }
	}

}
