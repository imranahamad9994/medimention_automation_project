package PageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	public String entrypageHandle;
	public String URL= "https://www.medimention.com/";

@BeforeClass
@Parameters({"Browser"})
	public void setup(String br) throws IOException
	{
		
	FileReader file = new FileReader(".\\config.properties");
	p = new Properties();
	p.load(file);
	
	
	switch(br)
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser"); return;
		}
		
		
		driver.get(URL);
		entrypageHandle = driver.getWindowHandle();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString+generatedNumber;
	}
}
