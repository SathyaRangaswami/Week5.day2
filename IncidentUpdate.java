package week5.day2.assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IncidentUpdate extends ServiceNowBase {
	@Test(dataProvider="sendData")
	public void updateService(String urgency, String state)
	{
		   driver.switchTo().frame("gsft_main");
		  String incidentNo = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
			System.out.println("incidient No :"+incidentNo);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			driver.findElement(By.id("incident.urgency")).sendKeys(urgency);				
			driver.findElement(By.id("incident.state")).sendKeys(state);	
			driver.findElement(By.id("sysverb_update")).click();
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo+Keys.ENTER);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			String urgency1 = driver.findElement(By.xpath("//select[@id='incident.urgency']/option")).getText();
			System.out.println("urgency :"+urgency1);  
	        if(urgency.equals(urgency1))
	        {
	        	System.out.println("urgency is updated :" +urgency1);
	        }
	        String state1 = driver.findElement(By.xpath("(//select[@id='incident.state']/option)[2]")).getText();
	        System.out.println("State: "+state1);
	        if(state1.equals(state))
	        {
	        	System.out.println("State is updated :"+state1);
	        }
		
	}
	@DataProvider()
	public String[][] sendData() throws IOException
	{
		return ReadExcelService.readData("updateservice");
	}
	

}
