package WebTableAssign;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webTableAssign {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.id("users"));
		
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		List <WebElement> cols = table.findElements(By.xpath("//table[@id='users']/thead//td"));
		
		int rowSize = rows.size();
		int colSize = cols.size();
		
		System.out.println("No. of rows are: "+rowSize);
		System.out.println("No. of columnms are: "+colSize);
		
		for(int i=0;i<rowSize;i++) {
			for(int j=0;j<colSize;j++) {
				WebElement searchRow = getTableRow(table, i);
				WebElement searchCol = getTableCol(j, searchRow);
				System.out.println(getCellData(searchCol));
			}
		}				
   }
	
	//WebElement secondRow = getTableRow(table,2);
	//WebElement thirdCol = getTableCol(3, secondRow);
	
	//WebElement browserCheckbox = thirdCol.findElement(By.xpath("//*[@id='user220_browser']"));
	

	private String getCellData(WebElement searchCol) {
		return searchCol.getText();
	}

	private WebElement getTableCol(int colIndex, WebElement searchRow) {
		return searchRow.findElements(By.tagName("td")).get(colIndex);
	}

	private WebElement getTableRow(WebElement table, int rowIndex) {
		return table.findElements(By.tagName("tr")).get(rowIndex);
	}
}
