package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLeaf extends BaseCreateLead {
@Test(dataProvider="fetchData")
	public void editLead(String fname, String companyName) throws InterruptedException
	{
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		System.out.println("name: "+text);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		
		 String view = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		 if(view.equals("View Lead"))
		 {
			 System.out.println("view Lead is verified");
		 }
		 else
		 {
			 System.out.println("Title not verified");
		 }
		
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			//driver.findElement(By.xpath("//span[text()='Company Name']")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			String text2 = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();	
			 System.out.println("newcompanyName: "+text2);
			 if(text2.contains(companyName))
			 {
				 System.out.println("Comapny name is updated");
			 }
			 else
			 {
				 System.out.println("Comapny name is not updated");
			 }
			 Thread.sleep(2000);
	}
			
			 @DataProvider(name = "fetchData")
			public String[][] sendData() throws IOException {
					return ExcelDataProvider.readData("EditLead");

	}

}
