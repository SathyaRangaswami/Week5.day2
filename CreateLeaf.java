package week5.day2;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class CreateLeaf extends BaseCreateLead {

  @Test(dataProvider="fetchdata")
  public void createdData(String companyname, String fname,String lname,String phno) 
  {
	  driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();	
  }
  @DataProvider(name="fetchdata")//not give name we should give  @Test(dataProvider="senddata")
  public String[][] senddata() throws IOException
  {
	  	  return ExcelDataProvider.readData("CreateLead");
  }
  
 
}

 

