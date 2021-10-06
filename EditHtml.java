package week5.day2.assignment;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class EditHtml extends LeafGround {
	@Test
	public void editLeaftabs() {
		
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("sathya@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("text to append");
		String value = driver.findElement(By.xpath("//input[@value=\"TestLeaf\"]")).getAttribute("value");
		System.out.println("default value"+value);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		
	}
	@Test
	public void tableLeaftabs()
	{
		driver.get("http://leafground.com/pages/table.html");
		driver.findElement(By.id("table_id"));
		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		System.out.println("row Size"+rowCount.size());
		List<WebElement> columnCount = driver.findElements(By.tagName("th"));
		System.out.println("column size"+columnCount.size());
		String text = rowCount.get(0).getText();//to read 2nd row data
		System.out.println("text" +text);
		//print all contents
		for (WebElement eachItem : rowCount) {
			String value = eachItem.getText();
			System.out.println("text in table :" +value);
			
		}
		//particular test
		System.out.println("percent of :"+driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following::td")).getText());
		//2nd column
		for (int i = 1; i < rowCount.size(); i++) {
			
				WebElement indivRow = rowCount.get(i);
				List<WebElement> findIndivRow = indivRow.findElements(By.tagName("td"));
				String text2 = findIndivRow.get(1).getText();
				System.out.println("2nd column : "+text2);
			   
		}
		List<WebElement> listper = driver.findElements(By.xpath("//td[2]"));
		List<Integer> comp=new ArrayList<Integer>();
		for (WebElement eachItem : listper) {
			
		String per = eachItem.getText().replace("%", "");
		comp.add(Integer.parseInt(per));
			
		}
		System.out.println("list"+comp);
		int min = Collections.min(comp);
		String compareValue = Integer.toString(min);
		System.out.println("Minimal percentage"+compareValue);
		}
	

}
