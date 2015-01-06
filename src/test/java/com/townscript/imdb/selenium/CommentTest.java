package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommentTest {

	
	@Test
	public void commentMovieTest()
	{
		WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	      driver.navigate().to("http://localhost:8080/imdb/login");
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.name("emailid")).sendKeys("minaz@gmail.com");
	      
		  driver.findElement(By.name("password")).sendKeys("minaz12345");

		  driver.findElement(By.xpath("html/body/div/fieldset/form/input[3]")).click();
		  
		  		  
		  driver.findElement(By.xpath(".//*[@id='section']/div[1]")).click();

		  driver.findElement(By.xpath(".//*[@id='commentbox']")).sendKeys("abc's");
		  
		  driver.findElement(By.xpath("html/body/div[2]/div/button")).click();
		  
		  driver.findElement(By.xpath("html/body/div[2]/a[4]")).click();
	      System.out.println("Running successfully!");
	      
	      driver.close();

		  
		  
		
	}
}
