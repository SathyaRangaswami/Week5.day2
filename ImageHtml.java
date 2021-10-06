package week5.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageHtml extends LeafGround {
	@Test
public void imageLeaftabs() {
	
	driver.get("http://leafground.com/pages/Image.html");
	driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
	driver.navigate().back();
	String src = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).getAttribute("src");
	System.out.println("src image"+src);
	driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
	System.out.println("Broken image");
	driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
	String title=driver.getTitle();
	System.out.println("title of home page"+title);
}
	@Test
	public void mouseHover()
	{
		driver.get("http://leafground.com/pages/mouseOver.html");
		WebElement courses = driver.findElement(By.linkText("TestLeaf Courses"));
		Actions builder=new Actions(driver);
		builder.moveToElement(courses).click().perform();
		List<WebElement> listCourses = driver.findElements(By.xpath("//li/ul/li"));
		List<String> list=new ArrayList<String>();
		for (WebElement eachItem : listCourses) {
			String courseNo = eachItem.getText();
			list.add(courseNo);
					
		}
		System.out.println("list of courses"+list);
		WebElement courseClick = driver.findElement(By.linkText("Selenium"));
		builder.moveToElement(courseClick).click().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
}
