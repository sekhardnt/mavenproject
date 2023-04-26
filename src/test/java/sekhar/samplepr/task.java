package sekhar.samplepr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class task {
	WebDriver d;
	 
	 public void login(String email, String password) throws InterruptedException {
		 	
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/div/input[1]")).sendKeys(email);
	        Thread.sleep(2000);
	        d.findElement(By.xpath("//input[@class='login-input password']")).sendKeys(password);
	        Thread.sleep(2000);
	        d.findElement(By.xpath("//*[@id=\"root\"]/div/button")).click();
	    }
	 
	 public String getErrorMessage()
	 {
		 return d.findElement(By.xpath("//*[@id=\"root\"]/div/p")).getText();
	 }
	 public void loggout() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 d.findElement(By.xpath("//*[@id=\"root\"]/header/div/button[2]")).click();
	 }


}
