package com.capgemini.capstore.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MerchantŚtepDefination {
	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

	}
	WebDriver driver;

	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}
@When("^Click on add to cart button$")
public void click_on_add_to_cart_button() throws Throwable {
  driver.findElement(By.xpath("//a[text()='add to cart']")).click();
}

@Then("^Required product should be added to the cart$")
public void required_product_should_be_added_to_the_cart() throws Throwable {
   
}

@When("^User clicks on show all cart products button$")
public void user_clicks_on_show_all_cart_products_button() throws Throwable {
   driver.findElement(By.xpath("//a[text()='all cart products']")).click();
}

@Then("^It should show all cart products$")
public void it_should_show_all_cart_products() throws Throwable {
  driver.findElement(By.xpath("/html/body/app-root/app-cart-products/nav/div/ul[1]/li[4]/div/a[1]")).click();
}

@When("^User clicks on remove button for a particular product$")
public void user_clicks_on_remove_button_for_a_particular_product() throws Throwable {
   driver.findElement(By.xpath("/html/body/app-root/app-allProducts/app-Product/div/div/div/button[2]")).click();
}

@Then("^The product should get removed$")
public void the_product_should_get_removed() throws Throwable {
    driver.findElement(By.xpath("/html/body/app-root/app-viewProducts/app-view-products-details/div/div/div/button[2]")).click();
}

@Given("^Merchant has loaded the Application in the browser$")
public void merchant_has_loaded_the_Application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
}

@When("^Merchant enter valid email$")
public void merchant_enter_valid_email() throws Throwable {
  driver.findElement(By.name("email")).sendKeys("mayuri@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@Then("^Merchant enter valid password$")
public void merchant_enter_valid_password() throws Throwable {
  driver.findElement(By.name("password")).sendKeys("mayuri@08");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@When("^Merchant clicks on Profile button$")
public void merchant_clicks_on_Profile_button() throws Throwable {
   driver.findElement(By.xpath("//a[text()='Profile']")).click();
}

@Then("^Merchant view his/her profile$")
public void merchant_view_his_her_profile() throws Throwable {
 driver.findElement(By.xpath("//a[text()='Profile']")).click();
}

@When("^Merchant clicks on Products button$")
public void merchant_clicks_on_Products_button() throws Throwable {
   driver.findElement(By.xpath("/html/body/app-root/app-Products/div/div[1]/img")).click();
}

@Then("^Merchant can view his/her all products$")
public void merchant_can_view_his_her_all_products() throws Throwable {
  driver.findElement(By.xpath("//a[text()='All Products']")).click();
}

@When("^Merchant clicks on Customer Feedback button$")
public void merchant_clicks_on_Customer_Feedback_button() throws Throwable {
    driver.findElement(By.xpath("//a[text()='Customer Feedback']")).click();
}

@When("^read customer’s feedback on product$")
public void read_customer_s_feedback_on_product() throws Throwable {
  driver.findElement(By.xpath("//a[text()='Reply']")).click();
}

@Then("^Merchant click on Reply button$")
public void merchant_click_on_Reply_button() throws Throwable {
   driver.findElement(By.xpath("//a[text()='Reply']")).click();
}

@When("^Merchant can give reply to customer’s feedback$")
public void merchant_can_give_reply_to_customer_s_feedback() throws Throwable {
   
}

@Then("^Merchant click on submit Button$")
public void merchant_click_on_submit_Button() throws Throwable {
   driver.findElement(By.xpath("//a[text()='Submit']")).click();
}
}
