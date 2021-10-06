package week5.day2.assignment;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ServiceNowBase {
	public ChromeDriver driver;
    @Parameters({"url" ,"username", "password"})
	@BeforeMethod
	public void beforeMethod(String url,String uname, String pword) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		WebElement frameser = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameser);
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pword);
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		  driver.switchTo().defaultContent();
		  driver.close();
	}

}
