package pPack;

import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoTest {
WebDriver driver;
	@Test
	public  void loginTest() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("data.properties");
		prop.load(fis);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		/*prop.setProperty("result", "pass");
		FileOutputStream fos = new FileOutputStream("data.properties");
		prop.store(fos, null);
		System.out.println(prop.getProperty("result"));*/
	   }
	@AfterMethod
	public void closure() {
			driver.close();
		}
	

}
