package week5.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class IncidentCreate extends ServiceNowBase {
	@Test(invocationCount=3, priority=-1)
	public void  createService()
	{
		long start = System.currentTimeMillis();
		driver.switchTo().frame("gsft_main");//switch to frame
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("incident.short_description")).sendKeys("Testing from test leaf");
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident no:" +incidentNo);		
		driver.findElement(By.id("sysverb_insert")).click();
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(incidentNo+ Keys.ENTER);
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("incidient No from search :"+text);
		if(text.equals(incidentNo))
		{
			System.out.println("Incident number are created and are equal ");
		}
		else
		{
			System.out.println("Incident number are not created");
		}
		
		long end = System.currentTimeMillis();
		long time=start+end;
		System.out.println("Time for create"+time);
	}

}
