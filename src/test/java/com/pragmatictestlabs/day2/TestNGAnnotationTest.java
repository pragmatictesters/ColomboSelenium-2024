package com.pragmatictestlabs.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {

    private WebDriver driver;

    //This will be executed only once per the test suite
    @BeforeSuite
    public void beforeSuite(){
        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        //Open a web browser (Chrome browser)
        driver = new ChromeDriver();

        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(){
        //Close the browser
        if (driver!=null){
            driver.quit();
        }
        //driver.close();
    }

    @Test
    public void helloSelenium(){

        //Type username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click the login
        driver.findElement(By.id("login-button")).click();

        //Verify/check the Product label is available in the landing page after login
        Assert.assertEquals( driver.findElement(By.cssSelector("span.title")).getText() ,"Products");


    }


    @Test
    public void testMethod2(){
        System.out.println("Test method 2");
        //Selenium code will go here
    }

}
