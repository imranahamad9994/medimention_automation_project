package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.AccountPage;
import PageObjects.BaseClass;
import PageObjects.EntryPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import utilities.DataProviders;

@Test(dataProvider = "LoginwithInValidData", dataProviderClass = DataProviders.class)
public class Test_01_LoginDataDriven extends BaseClass {

	
	public void verifyLogin(String username, String password, String exp)
	{
		SoftAssert softasert = new SoftAssert();
		try {
			
		
		EntryPage ep = new EntryPage(driver);
		ep.clickHome();
		
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		AccountPage ap = new AccountPage(driver);
		
		if(exp.equals("Valid"))
		{
		boolean dashboard = driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		ap.clickDropdown();
		ap.clickLogout();
		System.out.println("dashboard="+dashboard);
		
		softasert.assertTrue(dashboard);
		
		}
		
		else if(exp.equals("Invalid")){
		
			boolean errormsg = lp.isErrorMessageDisplayed();
			System.out.println("errormsg="+errormsg);
			
			softasert.assertTrue(errormsg);
			
		}
		
		
		}
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
		softasert.assertAll();
	driver.navigate().to(URL);
	
	}
	
}
