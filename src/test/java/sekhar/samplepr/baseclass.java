package sekhar.samplepr;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class baseclass {
	WebDriver d;
	FileInputStream f;
	Workbook w;
	Sheet s;
	Row r;
	baseclass(WebDriver driver) throws IOException
	{
		this.d=driver;
		PageFactory.initElements(driver, this);
		f= new FileInputStream("D://hydri.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet("sheet1");
	}
	
	@FindBy(name="firstname")WebElement Fname;
	@FindBy(name="lastname")WebElement Lname;
	@FindBy(name="phone")WebElement Phone;
	@FindBy(name="year")WebElement Year;
	@FindBy(name="month")WebElement Month;
	@FindBy(name="date")WebElement Date;
	@FindBy(name="licenceperiod")WebElement Licenceperiod;
	@FindBy(name="occupation")WebElement Occupation;
	@FindBy(name="street")WebElement Street;
	@FindBy(name="city")WebElement City;
	@FindBy(name="county")WebElement County;
	@FindBy(name="post_code")WebElement Post_code;
	@FindBy(name="email")WebElement Email;
	@FindBy(name="password")WebElement Password;
	@FindBy(name="c_password")WebElement C_password;
	@FindBy(name="submit")WebElement Submit;
	
	
	public void fname() throws InterruptedException
	{
		r=s.getRow(1);
		Fname.sendKeys(r.getCell(1).getStringCellValue());
		Thread.sleep(2000);
	}
	
	public void lname()
	{	r=s.getRow(2);
		Lname.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void phone()
	{	r=s.getRow(3);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Phone.sendKeys(s);
	}
	public void year()
	{
		r=s.getRow(4);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Year.sendKeys(s);
	}
	
	public void month()
	{	
		r=s.getRow(5);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Month.sendKeys(s);
	}
	public void date()
	{	r=s.getRow(6);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Date.sendKeys(s);
	}
	public void licenceperiod()
	{	
		r=s.getRow(7);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Licenceperiod.sendKeys(s);
	}
	public void occupation()
	{	r=s.getRow(8);
		Occupation.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void street()
	{	
		r=s.getRow(9);
		Street.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void city()
	{	
		r=s.getRow(10);
		City.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void county()
	{	
		r=s.getRow(11);
		County.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void post_code()
	{	
		r=s.getRow(12);
		double dd=r.getCell(1).getNumericCellValue();
		String s=String.valueOf(dd);
		Post_code.sendKeys(s);
	}
	public void email()
	{	r=s.getRow(13);
		Email.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void password()
	{
		r=s.getRow(14);
		Password.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void c_password()
	{
		r=s.getRow(15);
		C_password.sendKeys(r.getCell(1).getStringCellValue());
	}
	public void submit()
	{
		Submit.click();
	}
	
	

}
