package com.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomer {
	WebDriver d;
	@Given("user should be in telecom home page")
	public void user_should_be_in_telecom_home_page() {
	    System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\CucumberDemo\\Driver\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://demo.guru99.com/telecom/");
	    
	}

	@Given("user click on add customer button")
	public void user_click_on_add_customer_button() {
		d.findElement(By.xpath("/html/body/section/div/div[1]/div[1]/h3/a")).click();
	    	}

	@When("user enters all the fields with valid data")
	public void user_enters_all_the_fields_with_valid_data(DataTable cusDetails) {
		List<String> data=cusDetails.asList(String.class);
		d.findElement(By.xpath("/html/body/section/div/form/div/div[1]/label")).click();
	    d.findElement(By.name("fname")).sendKeys(data.get(0));
	    d.findElement(By.name("lname")).sendKeys(data.get(1));
	    d.findElement(By.name("emailid")).sendKeys(data.get(2));
	    d.findElement(By.name("addr")).sendKeys(data.get(3));
	    d.findElement(By.name("telephoneno")).sendKeys(data.get(4));
	    
	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
	    d.findElement(By.name("submit")).click();
	}

	@Then("user id should be displayed")
	public void user_id_should_be_displayed() {
	    WebElement s=d.findElement(By.xpath("/html/body/section/div/div/table/tbody/tr[1]/td[2]"));
	    System.out.println(s);
	    d.quit();
	}

}
