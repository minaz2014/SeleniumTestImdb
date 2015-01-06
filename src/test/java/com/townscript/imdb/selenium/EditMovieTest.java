package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import test.java.com.townscript.imdb.ProjectProperties;


public class EditMovieTest {

	/*private JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getInstance();

	@Before
	public void clearDbBeforeTest() {
		clear();
	}
	
	@After
	public void clearDbAfterTest() {
		clear();
	}
	
	/*private void clear() {
		jdbcTemplate.update("DELETE FROM MOVIE");
	}*/
	
	private String baseUrl;
	
	public EditMovieTest() {
		super();
		
		baseUrl = ProjectProperties.getBaseUrl();
	}


@Test
	public void editMovieTest() {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	      driver.navigate().to("http://localhost:8080/imdb/login");
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.name("emailid")).sendKeys("addy@gmail.com");
	      
		  driver.findElement(By.name("password")).sendKeys("addy1234");

		  driver.findElement(By.xpath("html/body/div/fieldset/form/input[3]")).click();
		  
		  String URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL, baseUrl+"/imdb/homepage" );
	      System.out.println("URL for homepage matching --> Part executed");
      
		  
		  		  
		  driver.findElement(By.xpath(".//*[@id='section']/div[11]")).click();
		  
		  URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL.replaceAll("\\d+$", ""), baseUrl+"/imdb/movipage?id=" );
	      System.out.println("URL for movi matching --> Part executed");
      
	      String Actualtext = driver.findElement(By.xpath(".//*[@id='header']/h1")).getText();
	      Assert.assertEquals(Actualtext, "Exodus: Gods n Kings");
	      System.out.println("Title Exodus matching --> Part executed");

		  
		  driver.findElement(By.xpath("html/body/div[2]/a[2]")).click();
		  
		  URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL.replaceAll("\\d+$", ""), baseUrl+"/imdb/createnewpage?show=edit&id=" );
	      System.out.println("URL for edit movi matching --> Part executed");
      
	      
	      Actualtext = driver.findElement(By.xpath(".//*[@id='form']/h1")).getText();
	      Assert.assertEquals(Actualtext, "CREATE NEW REVIEW");
		  System.out.println("Title-CREATE NEW REVIEW --> Part executed");

		  driver.findElement(By.name("director")).clear();
		  driver.findElement(By.name("director")).sendKeys("RajKumar Hirani");
		  
		  driver.findElement(By.name("cast")).clear();
		  driver.findElement(By.name("cast")).sendKeys("Aamir, Anushka");

		  driver.findElement(By.name("description")).clear();
		  driver.findElement(By.name("description")).sendKeys("good movie!!");
		  
		  driver.findElement(By.xpath(".//*[@id='form']/fieldset/input[6]")).click();
		  
		// driver.findElement(By.xpath(".//*[@id='section']/div[4]")).click();
		 
		  
		  Actualtext = driver.findElement(By.xpath(".//*[@id='header']/p[1]")).getText();
	      Assert.assertEquals(Actualtext, "DIR:RajKumar Hirani");
		  System.out.println("director matching");

		  Actualtext = driver.findElement(By.xpath(".//*[@id='header']/p[2]")).getText();
	      Assert.assertEquals(Actualtext, "WITH:Aamir, Anushka");
		  System.out.println("cast matching");

	     
	      Actualtext = driver.findElement(By.xpath(".//*[@id='header']/p[3]")).getText();
	      Assert.assertEquals(Actualtext, "CRITIC:adarsha");
		  System.out.println("critic matching");

	      
	      Actualtext = driver.findElement(By.xpath(".//*[@id='header']/p[4]")).getText();
	      Assert.assertEquals(Actualtext, "DESCRIPTION:good movie!!");
		  System.out.println("description matching");


		  System.out.println("Modified details are executed");
		  
		  
		  driver.findElement(By.xpath("html/body/div[2]/a[4]")).click();
	      System.out.println("Running successfully!");
	      
	      driver.quit();

	}

}
