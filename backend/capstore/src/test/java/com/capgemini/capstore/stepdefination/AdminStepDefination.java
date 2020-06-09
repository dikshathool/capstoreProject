package com.capgemini.capstore.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	WebDriver driver;

	@Given("^Admin has loaded the Application in the browser$")
	public void admin_has_loaded_the_Application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^Admin Clicks on login Link$")
	public void admin_Clicks_on_login_Link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter valid email Id$")
	public void admin_enter_valid_email_Id() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("samsung123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter valid password$")
	public void admin_enter_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("samsung@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Then("^admin should get navigated to admin home page$")
	public void admin_should_get_navigated_to_admin_home_page() throws Throwable {
		driver.findElement(
				By.xpath("/html/body/app-root/app-front-page/section/app-navbar/nav/div/div[2]/ul[1]/li[3]/a")).click();
	}

	// Add Product
	@Given("^Admin on Admin Home Page$")
	public void admin_on_Admin_Home_Page() throws Throwable {
		driver.findElement(
				By.xpath("/html/body/app-root/app-front-page/section/app-navbar/nav/div/div[2]/ul[1]/li[3]/a")).click();
	}

	@When("^Admin clicks on add product button$")
	public void admin_clicks_on_add_product_button() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add Product']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product name in productName textbox$")
	public void admin_enter_product_name_in_productName_textbox() throws Throwable {
		driver.findElement(By.name("productName")).sendKeys("Fan");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product brand in productBrand textbox$")
	public void admin_enter_product_brand_in_productBrand_textbox() throws Throwable {
		driver.findElement(By.name("productBrand")).sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter price in productPrice textbox$")
	public void admin_enter_price_in_price_textbox() throws Throwable {
		driver.findElement(By.name("productPrice")).sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product category in productCategory textbox$")
	public void admin_enter_product_category_in_productCategory_textbox() throws Throwable {
		driver.findElement(By.name("productCategory")).sendKeys("Home Appliances");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product Quantiy in productQuantity textbox$")
	public void admin_enter_product_Quantiy_in_productQuantity_textbox() throws Throwable {
		driver.findElement(By.name("productQuantity")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product Image in productImage textbox$")
	public void admin_enter_product_Image_in_productImage_textbox() throws Throwable {
		driver.findElement(By.name("productImage"))
				.sendKeys("https://cdn.pixabay.com/photo/2010/12/13/10/05/air-2260__340.jpg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter discount on product in productDiscount textbox$")
	public void admin_enter_discount_on_product_in_productDiscount_textbox() throws Throwable {
		driver.findElement(By.name("productDiscount")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter product discount Expiry Date in productDiscoutExpireDate textbox$")
	public void admin_enter_product_discount_Expiry_Date_in_productDiscoutExpireDate_textbox() throws Throwable {
		driver.findElement(By.name("productDiscountExpiryDate")).sendKeys("2020-08-08");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin enter email Id in email textbox$")
	public void admin_enter_email_Id_in_email_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("samsung123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin Clicks on add product button$")
	public void admin_Clicks_on_add_product_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add Product']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Then("^show all product page must be displayed$")
	public void show_all_product_page_must_be_displayed() throws Throwable {
		//driver.findElement(By.xpath("/html/body/app-root/app-home/section/app-header/nav/div/ul/div/button[1]")).click();
	}
	
	
	//Update Product
	@Given("^Admin on Products Page$")
	public void admin_on_Products_Page() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/section/app-header/nav/div/ul/div/button[1]")).click();
	}

	@When("^Admin clicks on update product button$")
	public void admin_clicks_on_update_product_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Update Product']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^enter price in productPrice textbox$")
	public void enter_price_in_productPrice_textbox() throws Throwable {
		driver.findElement(By.name("productPrice")).sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^enter product Quantiy in productQuantity textbox$")
	public void enter_product_Quantiy_in_productQuantity_textbox() throws Throwable {
		driver.findElement(By.name("productQuantity")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^enter discount on product in productDiscount textbox$")
	public void enter_discount_on_product_in_productDiscount_textbox() throws Throwable {
		driver.findElement(By.name("productDiscount")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Click on update button$")
	public void click_on_update_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	//Delete Product***********************************************************
	@When("^Admin clicks on Products button$")
	public void admin_clicks_on_Products_button() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@When("^Admin clicks on delete button for a particular product$")
	public void admin_clicks_on_delete_button_for_a_particular_product() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Then("^show all products page must be displayed$")
	public void show_all_products_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}


}
