package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BaseClass;
import PageObjects.EntryPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class Test_01_Login extends BaseClass{
	
	@Test
	public void verifyLogin()
	{
		EntryPage ep = new EntryPage(driver);
		ep.clickHome();
		
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		boolean dashboard = driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		Assert.assertTrue(dashboard);
	}

}
