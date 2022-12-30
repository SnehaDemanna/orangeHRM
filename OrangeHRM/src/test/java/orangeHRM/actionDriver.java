package orangeHRM;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class actionDriver 
{
     static WebDriver driver;

	public void type(String value, String element, String duration)
	{
	    String s = Keys.chord(Keys.CONTROL, "a");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(duration)));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).sendKeys(s);;
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).sendKeys(value);;
	}

	public void click(String element,String duration)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(duration)));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(element))).click();
	}

	public void assertElement(String element, String duration)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(duration)));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}
	
	public void assertText1(String actualText,String expectedText)
	{
		Assert.assertEquals(actualText ,expectedText);
	}

	
	public void assertText2(String element1,String expectedText,String element2,String duration)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(duration)));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element1)));
		String actualText=driver.findElement(By.xpath(element2)).getText();
		Assert.assertEquals(actualText ,expectedText);
	}

	public void assertText3(String element,String expectedText,String duration)
	{
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(duration)));
		String s = w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getText();
		Assert.assertEquals(expectedText, s);

	}

	

	
}
