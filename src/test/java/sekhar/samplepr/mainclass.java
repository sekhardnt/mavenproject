package sekhar.samplepr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mainclass {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[3]/a")).click();
		//Thread.sleep(3000);
		FileInputStream f= new FileInputStream("D://hydri.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(f);
		Sheet s=w.getSheet("sheet1");
		Row r=null;
		Cell c=null;
		Iterator<Row>i=s.iterator();
		driver.findElement(By.xpath("/html/body/div[3]/a")).click();
		baseclass b= new baseclass(driver);
		while(i.hasNext())
		{
			r=i.next();
			String str=r.getCell(0).getStringCellValue();
			if(str.equals("Fname"))
				b.fname();
			else if(str.equals("Lname"))
				b.lname();
			else if(str.equals("Phone"))
				b.phone();
			else if(str.equals("Year"))
				b.year();
			else if(str.equals("Month"))
				b.month();
			else if(str.equals("Date"))
				b.date();
			else if(str.equals("Period"))
				b.licenceperiod();
			else if(str.equals("Occupation"))
				b.occupation();
			else if(str.equals("Street"))
				b.street();
			else if(str.equals("City"))
				b.city();
			else if(str.equals("County"))
				b.county();
			else if(str.equals("Pincode"))
				b.post_code();
			else if(str.equals("Email"))
				b.email();
			else if(str.equals("Password"))
				b.password();
			else if(str.equals("Cpassword"))
				b.c_password();
			else if(str.equals("Submit"))
				b.submit();
		
		}
	}

}
