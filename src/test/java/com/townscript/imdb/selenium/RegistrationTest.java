package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RegistrationTest {

	@Test
	public void regTest() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	      driver.navigate().to("http://localhost:8080/imdb/login");
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.xpath("html/body/div/fieldset/form/a")).click();
	      
	      driver.findElement(By.name("username")).sendKeys("sayali");
	      
	      driver.findElement(By.name("emailid")).sendKeys("sayali@gmail.com");

	      driver.findElement(By.name("password")).sendKeys("sayali123");
	      
	      driver.findElement(By.name("confirmpsw")).sendKeys("sayali123");
	      
	      driver.findElement(By.xpath("html/body/div/fieldset/form/input[5]")).click();
	      
          System.out.println("Running successfully!");
	      
	      driver.quit();



	}

}
