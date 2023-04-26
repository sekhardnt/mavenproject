package sekhar.samplepr;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDF {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", ".//Drivers/geckodriver.exe");
		WebDriver d= new FirefoxDriver();
		d.get("http://www.google.com");
		FileInputStream f= new FileInputStream("D://POM.xlsx");
		Workbook w=new XSSFWorkbook(f);
		Sheet s= w.getSheet("sheet1");
		for(int i=0;i<=s.getLastRowNum();i++) {
		Row r=s.getRow(i);
		if(i==2||i==7) {
			double dd=r.getCell(0).getNumericCellValue();
			String s1=String.valueOf(dd);
			System.out.println(s1);
		}
		else
		{
			
			System.out.println(r.getCell(0).getStringCellValue());
			
		}
		
		}
		
		
		
		

	}

}
