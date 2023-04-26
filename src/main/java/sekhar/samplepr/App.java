package sekhar.samplepr;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\wed driver\\geckodriver.exe");
		FirefoxDriver d= new FirefoxDriver();
		d.get("https://www.google.com");
		d.manage().window().maximize();
		//WebElement w=d.findElement(By.linkText("Gmail"));
//		Actions a=new Actions(d);
//		a.contextClick(w).perform();
		//a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//a.keyDown(Keys.CONTROL).click(w).keyUp(Keys.CONTROL).build().perform();
		//a.contextClick(w).sendKeys("B").build().perform();
		

    }
}
