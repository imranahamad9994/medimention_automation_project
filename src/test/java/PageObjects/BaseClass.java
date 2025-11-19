package PageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		
	File extension = new File("C:\\Users\\Hp\\medimention -workspace\\Medimention_Automation\\uBlock.crx"); 
    ChromeOptions options = new ChromeOptions();
    options.addExtensions(extension); // for .crx
   
	
	FileReader file = new FileReader(".\\config.properties");
	p = new Properties();
	p.load(file);
	
	
	switch(br)
		{
		case "chrome" : driver = new ChromeDriver(options); break;
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
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
