package sekhar.samplepr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day1 {
	WebDriver d;

	public void chrome() {
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
		d.get("http://www.google.com");
		d.manage().window().maximize();
		d.findElement(By.name("q")).sendKeys("sekhar");
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.findElement(By.name("btnK")).click();

	}

}
