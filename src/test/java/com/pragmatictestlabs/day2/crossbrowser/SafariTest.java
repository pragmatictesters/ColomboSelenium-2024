package com.pragmatictestlabs.day2.crossbrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafariTest {


    @Test
    public void testWithSafari(){

        //Setup web browser driver (Safari driver)
        WebDriverManager.safaridriver().setup();

        //Open a web browser (Safari browser)
        WebDriver driver = new SafariDriver();


        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");

        //Type username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click the login
        driver.findElement(By.id("login-button")).click();


        //Verify/check the Product label is available in the landing page after login
        Assert.assertEquals( driver.findElement(By.cssSelector("span.title")).getText() ,"Products");


        //Close the browser
        driver.quit();

    }

}
