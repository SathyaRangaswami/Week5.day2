package week5.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxHtml extends LeafGround{
	@Test
	public void checkboxLeaftabs() {
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		boolean selected = driver.findElement(By.xpath("(//div[@class='example'])[2]/div/input")).isSelected();
		// boolean selected = driver.findElement(By.xpath("//label[text()='Confirm
		// Selenium is checked']/following::input")).isSelected();-->correct
		if (selected == true) {
			System.out.println("checkbox  selected");
		} else {
			System.out.println("checkbox not selected");
		}
		boolean selected2 = driver.findElement(By.xpath("//div[3]/div[2]/input[@type='checkbox']")).isSelected();
		if (selected2 == true) {
			System.out.println("checkbox  selected");
			driver.findElement(By.xpath("//div[3]/div[2]/input[@type='checkbox']")).click();

		} else {
			System.out.println("checkbox not selected");
		}
		driver.findElement(By.xpath("//div[4][@class='example']/div[1]/input")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/div[2]/input")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/div[3]/input")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/div[4]/input")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/div[5]/input")).click();
		
		
	}

}
