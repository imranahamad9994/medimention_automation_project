package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//li[@class='green']//a[@role='button']
		//a[normalize-space()='Logout']
			
			@FindBy(xpath="//li[@class='green']//a[@role='button']")
			@CacheLookup
			WebElement drop_btn;
			
			@FindBy(xpath="//a[normalize-space()='Logout']")
			@CacheLookup
			WebElement btn_logout;
			
			public void clickDropdown()
			{
				drop_btn.click();
			}
			
			public void clickLogout()
			{
				btn_logout.click();
			}

}
