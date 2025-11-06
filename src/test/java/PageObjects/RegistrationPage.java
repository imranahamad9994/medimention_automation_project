package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//span[@class='filter-option pull-left']
	//input[@id='DetailName']
	//input[@id='UserUsername']
	//input[@id='UserEmail']
	//input[@id='UserPassword']
	//input[@id='UserPassword1']
	//input[@name='terms']
	//span[normalize-space()='Register']
	//span[normalize-space()='Reset']
	//a[normalize-space()='Back to login']
	
	
	@FindBy(xpath="//span[@class='filter-option pull-left']")
	@CacheLookup
	WebElement clickDrop;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu inner selectpicker']/li")
	@CacheLookup
	List <WebElement> selectGroup;
	

	@FindBy(xpath="//input[@id='DetailName']")
	@CacheLookup
	WebElement txt_name;
	
	@FindBy(xpath="//input[@id='UserUsername']")
	@CacheLookup
	WebElement txt_username;
	

	@FindBy(xpath="//input[@id='UserEmail']")
	@CacheLookup
	WebElement txt_email;
	

	@FindBy(xpath="//input[@id='UserPassword']")
	@CacheLookup
	WebElement txt_password;
	

	@FindBy(xpath="//input[@id='UserPassword1']")
	@CacheLookup
	WebElement txt_rePassword;
	

	@FindBy(xpath="//input[@name='terms']")
	@CacheLookup
	WebElement chkbx_terms;
	

	@FindBy(xpath="//span[normalize-space()='Register']")
	@CacheLookup
	WebElement btn_register;
	
	
	public void clickSelectGroup()
	{
		clickDrop.click();
	}
	
	public void selectDrop(int i)
	{
		WebElement select = selectGroup.get(i);
		select.click();
	}
	
	public void inputName(String name)
	{
		txt_name.sendKeys(name);
	}
	
	public void inputUserName(String name)
	{
		txt_username.sendKeys(name);
	}
	
	public void inputEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void inputPassword(String Password)
	{
		txt_password.sendKeys(Password);
	}
	
	public void reInputPassword(String rePassword)
	{
		txt_rePassword.sendKeys(rePassword);
	}
	
	public void clickTerms()
	{
		chkbx_terms.click();
	}
	
	public void clickRegister()
	{
		btn_register.click();
	}

}
