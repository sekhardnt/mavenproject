package sekhar.samplepr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefox{

	public void firefox() throws InterruptedException {
		// TODO Auto-generated method stub
		String path=System.getProperty("user.dir");
		System.out.println(path);
		//String p="C:\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sekhar\\eclipse-workspace\\WebDriver3\\samplepr\\Drivers\\geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions o=new FirefoxOptions();
//		o.addArguments("--remote-allow-origins=*");
		WebDriver d= new FirefoxDriver();
		//d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("http://www.google.com");
		d.manage().window().maximize();
		d.findElement(By.name("q")).sendKeys("manual testing");
		//d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		d.findElement(By.name("btnK")).click();
		

	}
	public static void main(String[] args) throws InterruptedException
	{
		firefox f= new firefox();
		f.firefox();
		//f.chrome();
		
	}
}

