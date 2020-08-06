package WebTableAssign;

//import static org.junit.Assert.*;

//import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webTablePagination {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		// Navigating to specified webpage
		driver.get("http://www.seleniumeasy.com/test/table-pagination-demo.html");
		Thread.sleep(5000);

		// Locating Webtable
		WebElement table = driver.findElement(By.xpath("//section//table[@class='table table-hover']"));

		// Finding no. of rows and cols
		// List <WebElement> rows = table.findElements(By.tagName("tr"));
		// List <WebElement> cols =
		// table.findElements(By.xpath("//table[@id='users']/thead//th"));

		// int rowSize = rows.size();
		// int colSize = cols.size();

		// System.out.println("No. of rows are: "+rowSize);
		// System.out.println("No. of columns are: "+colSize);

		printTableData(table);

		// Clicking on pagination 2
		WebElement clickOnPagination2 = driver.findElement(By.xpath("//ul[@id='myPager']/li/a[text()='2']"));
		clickOnPagination2.click();

		printTableData(table);

		// Clicking on pagination 3
		WebElement clickOnPagination3 = driver.findElement(By.xpath("//ul[@id='myPager']/li/a[text()='3']"));
		clickOnPagination3.click();

		printTableData(table);
	}

	// Function to print webtable data
	private void printTableData(WebElement table) {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {
				WebElement getCellData = driver
						.findElement(By.xpath("//*[@class='content']//table//tr[" + i + "]/td[" + j + "]"));
				System.out.println(getCellData.getText());
			}
		}
	}

}
