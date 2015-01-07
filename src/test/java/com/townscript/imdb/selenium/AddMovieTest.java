package test.java.com.townscript.imdb.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import test.java.com.townscript.imdb.ProjectProperties;



public class AddMovieTest {
	/*private JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getInstance();

	@Before
	public void clearDbBeforeTest() {
		clear();
	}
	
	@After
	public void clearDbAfterTest() {
		clear();
	}
	
	private void clear() {
		jdbcTemplate.update("DELETE FROM MOVIE");
	}*/
	
    private String baseUrl;
	
	public AddMovieTest() {
		super();
		
		baseUrl = ProjectProperties.getBaseUrl();
	}
	
	
	/*public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}*/
@Test
	public void addMovieTest(){
		WebDriver driver = new FirefoxDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.navigate().to(baseUrl+"/imdb/login");
	      driver.manage().window().maximize();

		  driver.findElement(By.name("emailid")).sendKeys("sanchit@gmail.com");
		  
		  driver.findElement(By.name("password")).sendKeys("sanchit123");

	      driver.findElement(By.xpath("html/body/div/fieldset/form/input[3]")).click();
	      
	     /* String Actualtext = driver.findElement(By.linkText("http://localhost:8080/imdb/homepage")).getText();
	      Assert.assertEquals(Actualtext, "http://localhost:8080/imdb/homepage" );
	      System.out.println("URL matching --> Part executed");*/
	      
	      String URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL, baseUrl+"/imdb/homepage" );
	      System.out.println("URL for homepage matching --> Part executed");
      
	      String Actualtext = driver.findElement(By.xpath(".//*[@id='header']/h1")).getText();
	      Assert.assertEquals(Actualtext, "Movie List");
	      System.out.println("Title-Movie List --> Part executed");

        driver.findElement(By.xpath(".//*[@id='header']/button")).click();
        
          URL = driver.getCurrentUrl();
	      Assert.assertEquals(URL, baseUrl+"/imdb/createnewpage" );
	      System.out.println("URL for createnewpage matching --> Part executed");
    
        
         Actualtext = driver.findElement(By.xpath("html/body/div/h1")).getText();
	     Assert.assertEquals(Actualtext, "CREATE NEW REVIEW");
	     System.out.println("Title-CREATE NEW REVIEW --> Part executed");
	      
	     driver.findElement(By.xpath("/html/body/div/fieldset/input")).sendKeys("C:\\Users\\Townscript\\Downloads\\kick.jpg");
    
        /*setClipboardData("C:\\Users\\Townscript\\Downloads\\kick.jpg");
        
      Robot robot;/html/body/div/fieldset/input
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.delay(5000);
		    }
		    catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }*/
        
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      

         driver.findElement(By.xpath("html/body/div/fieldset/button")).click();
         
         Alert alert = driver.switchTo().alert(); 
         
         Assert.assertEquals(alert.getText(),"file uploaded");
         System.out.println("Alert text maching");
         
         alert.accept();
         
         driver.findElement(By.xpath(".//*[@id='form']/input[2]")).sendKeys("Kick");
         
         driver.findElement(By.xpath(".//*[@id='form']/input[3]")).sendKeys("Sajid Nadiadwala");
         
         driver.findElement(By.xpath(".//*[@id='form']/input[4]")).sendKeys("Salman Khan, Jackeline");
         
         
         driver.findElement(By.xpath(".//*[@id='form']/textarea")).sendKeys("bore");
         
         driver.findElement(By.xpath(".//*[@id='form']/input[6]")).click();
         
       /* String NAME  = driver.findElement(By.xpath(".//*[@id='section']/div[15]")).getTagName();
         Assert.assertEquals(NAME, "kick" );
	      System.out.println("kick movie is added --> Part executed");*/

        
	      Actualtext = driver.findElement(By.xpath(".//*[@id='section']/div[15]/h3")).getText();
		  Assert.assertEquals(Actualtext, "Kick");
	      System.out.println("Kick movie is added --> Part executed");


		 driver.findElement(By.xpath(".//*[@id='header']/a")).click();
	      System.out.println("Running successfully!");
	      
	      driver.quit();
	}
	
}


