package gmailTestNGAssignment;

import encodePassword.*;
import org.testng.annotations.DataProvider;

public class TestDataProvider{
  
	@DataProvider
    public static Object[][] provideTestData() {

		Object[][] data = new Object[1][2];
		
		data[0][0]="rohankambuj1987";
		
		new EncodePassword();
		data[0][1]= EncodePassword.encodePassword();
		
		return data;
    }
}
