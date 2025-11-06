package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	//input[@id='UserUsername']
	//input[@id='UserPassword']
	//input[@id='UserRememberMe']
	//span[@class='bigger-110']
	
	@FindBy(xpath = "//input[@id='UserUsername']")
	@CacheLookup
	WebElement txt_login;
	
	@FindBy(xpath = "//input[@id='UserPassword']")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='UserRememberMe']")
	@CacheLookup
	WebElement chkbx_RememberMe;
	
	@FindBy(xpath = "//span[@class='bigger-110']")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath = "//p[@class='text-error']")
	@CacheLookup
	WebElement errormsg_login;
	
	
	
	public void setUsername(String username)
	{
		txt_login.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickRemenberMe()
	{
		chkbx_RememberMe.click();
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	
	public boolean isErrorMessageDisplayed()
	{
		boolean errormessage = errormsg_login.isDisplayed();
		return errormessage;
	}
	
	

}
