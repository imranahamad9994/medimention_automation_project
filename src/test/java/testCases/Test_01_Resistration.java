package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BaseClass;
import PageObjects.EntryPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;

public class Test_01_Resistration extends BaseClass {
	
	@Test
	void testResgistration()
	{
		
		EntryPage ep = new EntryPage(driver);
		ep.clickHome();
		
		HomePage hp = new HomePage(driver);
		hp.clickJoinUs();
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		String password = randomAlphaNumeric();
		String username = randomString();
		String name = randomString();
		rp.clickSelectGroup();
		rp.selectDrop(1);
		rp.inputName(name);
		rp.inputUserName(username);
		rp.inputEmail(randomString()+"@aol.in");
		rp.inputPassword(password);
		rp.reInputPassword(password);
		rp.clickTerms();
		rp.clickRegister();
		
		System.out.println(username);
		System.out.println(password);
		p.put("username", username);
		p.put("password", password);
		boolean successMsg = driver.findElement(By.xpath("//p[@class='text-success']")).isDisplayed();
		Assert.assertTrue(successMsg);
	}
	

}
