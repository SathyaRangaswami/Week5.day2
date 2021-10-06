package week5.day2.assignment;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ButtonHtml extends LeafGround {
	@Test
public  void buttonLeaftabs() {
	driver.get("http://leafground.com/pages/Button.html");
	driver.findElement(By.id("home")).click();
	System.out.println("Title"+driver.getTitle());
	System.out.println("Get url"+driver.getCurrentUrl());
	driver.findElement(By.linkText("Button")).click();
	int loc = driver.findElement(By.id("position")).getLocation().getY();
	System.out.println("Position of y :"+loc);
	
	String cssValue = driver.findElement(By.id("color")).getCssValue("background-color");
	System.out.println("Background color"+cssValue);
	System.out.println("Height"+driver.findElement(By.id("size")).getSize().getHeight());
	System.out.println("Width"+driver.findElement(By.id("size")).getSize().getWidth());
}
}
