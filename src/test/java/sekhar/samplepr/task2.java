package sekhar.samplepr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task2 {
	WebDriver d;
	@BeforeMethod
	public void OpeningBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 d= new ChromeDriver();
		d.get("https://ricky-morty-fan-page.vercel.app");
		d.manage().window().maximize();
		login("root_user@gmail.com", "root_password@gmail.com");
	}
	@Test
	public void TC1() throws InterruptedException
	{
		Thread.sleep(2000);
		String str="JerrySmith";
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e=d.findElement(By.id("search-characters"));
		Actions a=new Actions(d);
		Thread.sleep(3000);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		a.sendKeys(e, "Jerry Smith").perform();
                
        WebElement searchResult = d.findElement(By.xpath("//li"));
        Thread.sleep(3000);
        int x=d.findElements(By.xpath("//li/a")).size();
        Assert.assertEquals(x, 3);
        WebElement b=d.findElement(By.xpath("//li/button"));
        
        Assert.assertFalse(b.isDisplayed());
	}
	
	 private void login(String email, String password) throws InterruptedException {
		 	
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/div/input[1]")).sendKeys(email);
	        //Thread.sleep(2000);
	        d.findElement(By.xpath("//input[@class='login-input password']")).sendKeys(password);
	       // Thread.sleep(2000);
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/button")).click();
	    }
		

}
