package week5.day2.assignment;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelService {
	public static  String[][] readData(String fileName) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
	int rowCount = ws.getLastRowNum();
	int columnCount = ws.getRow(0).getLastCellNum();
	String[][] data=new String[rowCount][columnCount];
	for (int i = 1; i <=rowCount; i++)
	{
		for (int j = 0; j < columnCount; j++) 
		{
			String cellvalue= ws.getRow(i).getCell(j).getStringCellValue();
			System.out.println("cell value: "+cellvalue);
			data[i-1][j]=cellvalue;
			
		}
		
	}
	wb.close();
	return data;
		
		
	}

}
