package sekhar.samplepr;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg {
	WebDriver d;
	@BeforeMethod
	public void OpeningBrowser()
	{
		WebDriverManager.chromedriver().setup();
		 d= new ChromeDriver();
		d.get("https://ricky-morty-fan-page.vercel.app/login");
		d.manage().window().maximize();
		
		
	}
	 @Test(priority = 1)
	    public void testValidCredentials() throws InterruptedException {
		 	login("root_user@gmail.com", "root_password@gmail.com");
	        String act=d.getCurrentUrl();
	        String exp="https://ricky-morty-fan-page.vercel.app/home";
	        Assert.assertEquals(act, exp);      
	    }
	 @Test(priority=2)
	 public void testWrongPassword() throws InterruptedException
	 {
		 login("root_user@gmail.com", "wrong_password");
	     Assert.assertEquals(getErrorMessage(), "Wrong password");
	 }
	 @Test(priority=3)
	 public void testUserNotFound() throws InterruptedException
	 {
		 login("root_usr@gmail.com", "root_password@gmail.com");
		 Assert.assertEquals(getErrorMessage(), "User not found");
	 }
	 @Test(priority=4)
	 public void testLogin() throws InterruptedException
	 {
		 login("root_user@gmail.com", "root_password@gmail.com");
	        d.navigate().refresh();
	        String act=d.getCurrentUrl();
	        String exp="https://ricky-morty-fan-page.vercel.app/home";
		 Assert.assertEquals(act, exp);
	 }
	 @Test(priority=5)
	public void logout() throws InterruptedException
	{
		 login("root_user@gmail.com", "root_password@gmail.com");
		 loggout();
		 Thread.sleep(2000);
		 d.navigate().refresh();
		 String act=d.getCurrentUrl();
	     String exp="https://ricky-morty-fan-page.vercel.app/login";
		 Assert.assertEquals(act, exp);
		 
		 
	}
	 
	 
	 
	 private void login(String email, String password) throws InterruptedException {
		 	
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/div/input[1]")).sendKeys(email);
	        Thread.sleep(2000);
	        d.findElement(By.xpath("//input[@class='login-input password']")).sendKeys(password);
	        Thread.sleep(2000);
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/button")).click();
	    }
	 
	 private String getErrorMessage()
	 {
		 return d.findElement(By.xpath("//*[@id=\"root\"]/div/p")).getText();
	 }
	 private void loggout() throws InterruptedException
	 {
		Thread.sleep(5000);
		 d.findElement(By.xpath("//*[@id=\"root\"]/header/div/button[2]")).click();
	 }

}
