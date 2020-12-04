package tryout;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class PracticeForm 
{
	WebDriver driver;
	@BeforeMethod
	public void setUpBrowser() 
	{
		  System.setProperty("webdriver.chrome.driver","/Users/shivanikumari/Downloads/selenium jars/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		  
     }
    @Test
    public void test()throws InterruptedException 
    {
	   driver.get("https://demoqa.com/automation-practice-form");
	   WebElement firstname=driver.findElement(By.id("firstName"));
	   firstname.clear();
	   firstname.sendKeys("Shivani");
	   WebElement lastname=driver.findElement(By.id("lastName"));
	   lastname.clear();
	   lastname.sendKeys("Jha");
	   WebElement emailid=driver.findElement(By.id("userEmail"));
	   emailid.clear();
	   emailid.sendKeys("t4saitshivani@gmail.com");
	   String gender="Female";
	   List<WebElement> gendertype=new ArrayList<>();
	   gendertype=driver.findElements(By.xpath("//*[contains(@class,'custom-control custom-radio') ]//label"));
	   for(WebElement a:gendertype)
	   {
		   if(a.getText().equalsIgnoreCase(gender))
		   {
			   a.click();
		   }
	   }
	   WebElement usernumber=driver.findElement(By.id("userNumber"));
	   usernumber.clear();
	   usernumber.sendKeys("9113991103");
	   WebElement dob=driver.findElement(By.id("dateOfBirthInput"));
	   dob.click();
	   WebElement year=driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
	   Select y=new Select(year);
	   y.selectByValue("1996");
	   WebElement month=driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
	   Select m=new Select(month);
	   m.selectByValue("10");
	   List<WebElement> day=new ArrayList<>();
	   day=driver.findElements(By.xpath("//*[contains(@class,'react-datepicker__day react-datepicker__day--0')]"));
	   for(WebElement days:day)
	   {
		   if(days.getText().equals("18"))
		   {
			   days.click();
			   break;
			   
		   }
	   }
	   List<WebElement> hobbies=new ArrayList<>();
	   hobbies=driver.findElements(By.xpath("//*[contains(@class,'custom-control custom-checkbox')]//label"));
	   for(WebElement hobby:hobbies)
	   {
		   hobby.click();
		   
	   }
	   WebElement upload=driver.findElement(By.id("uploadPicture"));
	   upload.sendKeys("/Users/shivanikumari/Downloads/online.jpg");
	   WebElement currentadd=driver.findElement(By.id("currentAddress"));
	   currentadd.clear();
	   currentadd.sendKeys("Vaishali,Ghaziabad");
	   WebElement Submit=driver.findElement(By.id("submit"));
	   Submit.click();
	   
	   
	   
	   
    }
    @Test
	  public void validateColor() throws InterruptedException
	  {
		  driver.get("https://demoqa.com/automation-practice-form");
		  WebElement firstName = driver.findElement(By.id("firstName"));
		  firstName.clear();
		  WebElement lastName = driver.findElement(By.id("lastName"));
		  lastName.clear();
		  WebElement userNumber = driver.findElement(By.id("userNumber"));
		  userNumber.clear();
		  WebElement btn_Submit = driver.findElement(By.id("submit"));
		  btn_Submit.sendKeys(Keys.PAGE_DOWN);
		  btn_Submit.click();
		  
		  String mandatoryFieldBorderColour = "#dc3545";
		  String firstnameColour = firstName.getCssValue("border-color");
		  String firstnameHexColor = Color.fromString(firstnameColour).asHex();
		  Assert.assertEquals(firstnameHexColor, mandatoryFieldBorderColour);
		  String lastnameColour = lastName.getCssValue("border-color");
		  String lastnameHexColor = Color.fromString(lastnameColour).asHex();
		  Assert.assertEquals(lastnameHexColor, mandatoryFieldBorderColour);
		  List<WebElement> genderType = new ArrayList<>();
		  genderType = driver.findElements(By.xpath("//*[contains(@class,'custom-control custom-radio') ]//label"));
		  for(WebElement g:genderType)
		  {
			  String genderColour = g.getCssValue("color");
			  String genderHexColor = Color.fromString(genderColour).asHex();
			  Assert.assertEquals(genderHexColor, mandatoryFieldBorderColour);
		  }
		  String numberColour = userNumber.getCssValue("border-color");
		  String numberHexColor = Color.fromString(numberColour).asHex();
		  Assert.assertEquals(numberHexColor, mandatoryFieldBorderColour);
	  }
	@AfterMethod
	public void afterMethod() 
	{
		//driver.close();
	}

}
