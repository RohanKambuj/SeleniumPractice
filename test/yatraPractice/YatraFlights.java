package yatraPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YatraFlights {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void searchFlight() {
		driver.get("https://www.yatra.com/");

		driver.findElement(By.id("BE_flight_origin_city")).click();

		driver.findElement(By.id("BE_flight_origin_city")).sendKeys("Mum");

		String xpathExp = "//p[contains(text(),'%s')]";
		getXpath(xpathExp, "Mumbai").click();
		
		System.out.println("From Airport selected");
		
		driver.findElement(By.id("BE_flight_arrival_city")).click();
		
		driver.findElement(By.id("BE_flight_arrival_city")).sendKeys("Goa");
		
		//driver.findElement(By.xpath("//p[contains(text(),'Goa')]")).click();
		
		getXpath(xpathExp, "Goa").click();
		
//		String toAirportName = driver.findElement(By.xpath("//p[contains(text(),'Goa')]")).getText();
		
		System.out.println("To Airport selected");
		
		/*
		 * List<WebElement> airportNames =
		 * driver.findElements(By.xpath("//p[@class='ac_cityname']"));
		 * 
		 * for (WebElement airport : airportNames) { String airportName =
		 * airport.getText();
		 * 
		 * System.out.println(airportName);
		 * 
		 * if (airportName.equals("Mumbai (BOM)")) { airport.sendKeys(Keys.ENTER);
		 * 
		 * airport.sendKeys(Keys.DOWN);
		 * 
		 * } }
		 */
	}

	public WebElement getXpath(String xpath, String text) {
		return driver.findElement(By.xpath(String.format(xpath,text)));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
