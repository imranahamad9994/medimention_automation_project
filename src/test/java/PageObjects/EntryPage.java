package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class EntryPage extends BasePage

{

	public EntryPage(WebDriver driver) {
		
		super(driver);
	}
	

	//a[normalize-space()='Home']
	//a[normalize-space()='About']
	//a[normalize-space()='Features']
	//a[normalize-space()='Bottom']
	//input[@id='banner-name']
	//input[@id='banner-email']
	//input[@id='banner-phone']
	//button[@id='touchget']
	//a[normalize-space()='Get started']
	
	@FindBy(xpath="//a[text()='Home']")
	@CacheLookup
	WebElement btn_home;
	
	@FindBy(xpath="//a[normalize-space()='About']")
	@CacheLookup
	WebElement btn_about;
	
	@FindBy(xpath="//a[normalize-space()='Features']")
	@CacheLookup
	WebElement btn_features;
	
	public void clickHome()
	{
		btn_home.click();
	}
	
	public void clickAbout()
	{
		btn_about.click();
	}
	
	public void clickFeatures()
	{
		btn_features.click();
	}
}
