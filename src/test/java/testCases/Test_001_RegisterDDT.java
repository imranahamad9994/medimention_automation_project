package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.AccountPage;
import PageObjects.BaseClass;
import PageObjects.EntryPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import utilities.DataProviders;


public class Test_001_RegisterDDT extends BaseClass {
	
	@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)	
	void testResgistration(String fname, String username, String email, String password)
	{
		SoftAssert sf = new SoftAssert();
		try {
			
		
		EntryPage ep = new EntryPage(driver);
		ep.clickHome();
		
		HomePage hp = new HomePage(driver);
		hp.clickJoinUs();
		
		RegistrationPage rp = new RegistrationPage(driver);
		
//		String password = randomAlphaNumeric();
//		String username = randomString();
//		String name = randomString();
	
		rp.clickSelectGroup();
		rp.selectDrop(1);
		rp.inputName(fname);
		rp.inputUserName(username);
		rp.inputEmail(email);
		rp.inputPassword(password);
		rp.reInputPassword(password);
		rp.clickTerms();
		rp.clickRegister();
		
		System.out.println(username);
		System.out.println(password);
		p.put("username", username);
		p.put("password", password);
		boolean successMsg = driver.findElement(By.xpath("//p[@class='text-success']")).isDisplayed();
		AccountPage ap = new AccountPage(driver);
		ap.clickDropdown();
		ap.clickLogout();
		sf.assertTrue(successMsg);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			sf.fail();
		}
		
		driver.navigate().to(URL);
		sf.assertAll();
		

}
	
}
