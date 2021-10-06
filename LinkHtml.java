package week5.day2.assignment;


import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LinkHtml extends LeafGround{
	@Test
	public void linkLeaftabs() {
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Title"+driver.getTitle());
		System.out.println("Get url"+driver.getCurrentUrl());
		driver.findElement(By.linkText("HyperLink")).click();
		driver.findElement(By.xpath("//a[@href='Button.html']")).click();
		String title=driver.getTitle();
		System.out.println("Title "+title);
		if(title.contains("Interact with Buttons"))
		{
			System.out.println("navigated to the link");
		}
		else
		{
			System.out.println("Not navigated to the link");
		}
		
		driver.get("http://leafground.com/pages/Link.html");
		
	}
	
}
