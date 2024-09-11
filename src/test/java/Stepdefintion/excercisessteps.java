package Stepdefintion;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class excercisessteps {

	WebDriver driver;

	@Given("the user is on the Automation Exercise product page")
	public void the_user_is_on_the_automation_exercise_product_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/products");
	}
	@When("the user retrieves the product names and prices")
	public void the_user_retrieves_the_product_names_and_prices() throws IOException {
		
//		 Get list of product names
		        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		
		        // Get list of product prices
		        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='productinfo text-center']/h2"));
		
		        // Print product details
		        for (int i = 0; i < productNames.size(); i++) {
		            String productName = productNames.get(i).getText();
		            String productPrice = productPrices.get(i).getText();
		            System.out.println("Product: " + productName + " | Price: " + productPrice);
		            
		          //capture the screenshot
					String screenshotPath = "C:\\Users\\DELL\\eclipse-workspace\\Project1\\BddAutomation\\path\\to\\save\\Screenshots.png";
					screenshotUtilities.captureScreenshot(driver, screenshotPath);
		        }
	}
		
	
	@Then("the system prints the product details and their corresponding prices")
	public void the_system_prints_the_product_details_and_their_corresponding_prices() {
		driver.close();
		
	}
}
