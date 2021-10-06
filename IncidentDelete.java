package week5.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

public class IncidentDelete extends ServiceNowBase {
	
	@Test(priority=4, invocationCount=2)
	
	public void  deleteService() throws InterruptedException
	{
		driver.switchTo().frame("gsft_main");
		String incidentNo = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("incidient No :" + incidentNo);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
        driver.findElement(By.id("sysverb_delete")).click();
        driver.findElement(By.id("ok_button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(incidentNo+ Keys.ENTER);
		String delete = driver.findElement(By.xpath("//td[contains(text(),'No records to display')]")).getText();
		if(delete.contains("No records"))
		{
			System.out.println("Incidient id deleted");
		}

	}
	
}
