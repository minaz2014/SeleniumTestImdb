package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {

	@Test
	public void loginTest() {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	      driver.navigate().to("http://localhost:8080/imdb/login");
	      driver.manage().window().maximize();

	     driver.findElement(By.name("emailid")).sendKeys("sanchit@gmail.com");
	      
	     driver.findElement(By.name("password")).sendKeys("sanchit123");

	      driver.findElement(By.xpath("html/body/div/fieldset/form/input[3]")).click();
	      
	      
	      driver.findElement(By.xpath(".//*[@id='header']/a")).click();
	      System.out.println("Running successfully!");
	      
	      driver.quit();

	      
	}

}
