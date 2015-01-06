package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import test.java.com.townscript.imdb.ProjectProperties;


public class DeleteMovieTest {
	
	
	 private String baseUrl;
		
		public DeleteMovieTest() {
			super();
			
			baseUrl = ProjectProperties.getBaseUrl();
		}
		

	@Test
	public  void deleteMovieTest() {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	      driver.navigate().to(baseUrl+"/imdb/login");
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.name("emailid")).sendKeys("sanchit@gmail.com");
	      
		  driver.findElement(By.name("password")).sendKeys("sanchit123");

		  driver.findElement(By.xpath("html/body/div/fieldset/form/input[3]")).click();
		  
		  String URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL, baseUrl+"/imdb/homepage" );
	      System.out.println("URL for homepage matching --> Part executed");
      
		    
		  driver.findElement(By.xpath(".//*[@id='section']/div[15]")).click();
		  
		  URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL.replaceAll("\\d+$", ""), baseUrl+"/imdb/movipage?id=" );
	      System.out.println("URL for movi matching --> Part executed");
      
		  
		  driver.findElement(By.xpath("html/body/div[2]/a[1]")).click();
		  
		  String Actualtext = driver.findElement(By.xpath(".//*[@id='section']/div[14]/h3")).getText();
		  Assert.assertNotEquals(Actualtext, "Kick");                          
	      System.out.println("Kick movie is deleted --> Part executed");

		  
		  driver.findElement(By.xpath(".//*[@id='header']/a")).click();
          System.out.println("Running successfully!");
	      
	      driver.quit();



	}

}
