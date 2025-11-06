package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//a[normalize-space()='Join Us']
	//a[normalize-space()='Login']
	//i[@class='ace-icon fa fa-caret-down']
	//a[@href='https://www.medimention.com/home/delCity']
	
	@FindBy(xpath="//a[normalize-space()='Join Us']")
	@CacheLookup
	WebElement lnk_Join_us;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	@CacheLookup
	WebElement lnk_Login;
	
	public void clickJoinUs()
	{
		lnk_Join_us.click();
	}
	
	public void clickLogin()
	{
		lnk_Login.click();
	}
}
