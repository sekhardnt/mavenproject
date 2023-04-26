package sekhar.samplepr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

//@org.testng.annotations.Listeners(Listeners.class)
public class task1 {
		WebDriver d;
		@BeforeMethod
		public void OpeningBrowser()
		{
			WebDriverManager.chromedriver().setup();
			 d= new ChromeDriver();
			d.get("https://ricky-morty-fan-page.vercel.app/login");
			d.manage().window().maximize();
			
			
		}
		// @Parameters({"username","password"})
		 
		 @Test(dataProvider="getData")
		 public void TC1(String a,String b) throws InterruptedException {
			 	login(a, b);
		        String act=d.getCurrentUrl();
		        String exp="https://ricky-morty-fan-page.vercel.app/home";
		        Assert.assertEquals(act, exp);      
		    }
		 @Test
		 public void TC2() throws InterruptedException
		 {
			 login("root_user@gmail.com", "wrong_password");
		     Assert.assertEquals(getErrorMessage(), "Wrong password");
		 }
		 @Test
		 public void TC3() throws InterruptedException
		 {
			 login("root_usr@gmail.com", "root_password@gmail.com");
			 Assert.assertEquals(getErrorMessage(), "User not found");
		 }
		 @Test
		 public void TC4() throws InterruptedException
		 {
			 login("root_user@gmail.com", "root_password@gmail.com");
		        d.navigate().refresh();
		        String act=d.getCurrentUrl();
		        String exp="https://ricky-morty-fan-page.vercel.app/home";
			 Assert.assertEquals(act, exp);
		 }
		 @Test
		public void TC5() throws InterruptedException
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

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="root_user@gmail.com";
		data[0][1]="root_password@gmail.com";
		data[1][0]="system_user@gmail.com";
		data[1][1]="system_password@gmail.com";
		return data;
		
	}


}
