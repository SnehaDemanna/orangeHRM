package orangeHRM;
import java.io.FileReader;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class stepDefination extends actionDriver 
{
	static JSONObject jObj;    
	public JSONObject fileRead() throws Exception 
	{
		FileReader reader = new FileReader("src/test/resources/JSON_files/orangeHRM.json");
		JSONParser js = new JSONParser();
		Object obj = js.parse(reader);
		JSONObject jo = (JSONObject) obj;
		return jo;
	}

	

@Given("browser is open")
public void browser_is_open() throws Exception 
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	jObj = fileRead();		
}

@And("user is on login page {string}")
public void user_is_on_login_page(String string) 
{
	String url = (String) jObj.get(string);
	System.out.println(url);
	driver.get(url);

}

@When("user enters username {string} in {string} in {string} duration")
public void user_enters_username_in_in_duration(String string, String string2, String string3) 
{
	String username = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration = (String) jObj.get(string3);

	type( username, element, duration);
}

@And("user enters password {string} in {string} in {string} duration")
public void user_enters_password_in_in_duration(String string, String string2, String string3) 
{
	String password = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration = (String) jObj.get(string3);

	type( password, element, duration);
}

@And("clicks on {string} in {string} duration")
public void clicks_on_in_duration(String string, String string2) 
{
	String element = (String) jObj.get(string);
	String duration = (String) jObj.get(string2);
	click(element, duration);
}

@Then("User should be navigated to the Home Page with {string}")
public void user_should_be_navigated_to_the_home_page_with(String string) throws InterruptedException 
{
	String actualTitle = driver.getTitle();
	String expectedTitle= (String) jObj.get(string);
	assertText1(actualTitle ,expectedTitle);
}	



@Given("navigate to {string}")
public void navigate_to(String string) 
{
	String url = (String) jObj.get(string);
	driver.navigate().to(url);   
	
}

@And("enters Employee name {string} in {string} in {string} duration")
public void enters_employee_name_in_in_duration(String string, String string2, String string3) 
{
	String employeeName = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	type(employeeName,element,duration);
	
}

@Given("assert the text in {string} as {string} in {string} in {string}")
public void assert_the_text_in_as_in_in(String string, String string2, String string3, String string4)
{
	String element1 = (String) jObj.get(string);
	String expectedText = (String) jObj.get(string2);
	String element2= (String) jObj.get(string3);
	String duration= (String) jObj.get(string4);

	assertText2(element1,expectedText,element2,duration);
}


@And("click on {string} in {string} duration")
public void click_on_in_duration(String string, String string2) 
{
	String element = (String) jObj.get(string);
	String duration= (String) jObj.get(string2);
	click(element,duration);

}

@Given("enter first name {string} in {string} in {string} duration")
public void enter_first_name_in_in_duration(String string, String string2, String string3) 
{
	String firstName = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	type(firstName,element,duration);
}

@And("enter middle name {string} in {string} in {string} duration")
public void enter_middle_name_in_in_duration(String string, String string2, String string3) 
{
	String middleName = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	type(middleName,element,duration);
}

@Given("enter last name {string} in {string} in {string} duration")
public void enter_last_name_in_in_duration(String string, String string2, String string3) 
{
	String lastName = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	type(lastName,element,duration);
}

@Given("enter employee id in {string} in {string} in {string} duration")
public void enter_employee_id_in_in_in_duration(String string, String string2, String string3) 
{
	String employeeId = (String) jObj.get(string);
	String element = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	type(employeeId,element,duration);
}

@Given("click on save {string} in {string} duration")
public void click_on_save_in_duration(String string, String string2) 
{
	String element = (String) jObj.get(string);
	String duration = (String) jObj.get(string2);
	click(element, duration);
		
}

@And("assert the text in {string} as {string} in {string}")
public void assert_the_text_in_as_in(String string, String string2, String string3) throws InterruptedException 
{
	String element = (String) jObj.get(string);
	String expectedText = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);

	assertText3(element,expectedText,duration);

}

@And("select the option {string} in the leave type dropdown {string} in {string}")
public void select_the_option_in_the_leave_type_dropdown_in(String string, String string2, String string3) 
{
	String dropdownElement = (String) jObj.get(string2);
	String optionElement = (String) jObj.get(string);
	String duration = (String) jObj.get(string3);
	click(dropdownElement, duration);
	click(optionElement, duration);
	

}

@And("select from date {string} as {string} in {string}")
public void select_from_date_as_in(String string, String string2, String string3)
{	String element = (String) jObj.get(string);
	String from_date = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);
	click(element, duration);
	type(from_date,element,duration);
}

@And("select to date {string} as {string} in {string}")
public void select_to_date_as_in(String string, String string2, String string3) 
{
	String element = (String) jObj.get(string);
	String to_date = (String) jObj.get(string2);
	String duration= (String) jObj.get(string3);
	click(element, duration);
	type(to_date,element,duration);
}


@And("Assert the text in {string} as {string} in {string}")
public void assert_the_text_in_as_in1(String string, String string2, String string3) 
{
	String expectedText = (String) jObj.get(string2);
	String element = (String) jObj.get(string);
	String duration= (String) jObj.get(string3);

	assertText3( element, expectedText, duration);
}





}



