package com.pragmatictestlabs.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

public class RemoveInforbarExample {


    @Test
    public void testLoginWithInvalidPassword(){

        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));


        //Open a web browser (Chrome browser)
        WebDriver driver = new ChromeDriver(chromeOptions);

        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");

        //Type username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password secret_sauce
        driver.findElement(By.id("password")).sendKeys("invalid_password");

        //Click the login
        driver.findElement(By.id("login-button")).click();


        //Verify/check the Product label is available in the landing page after login
        Assert.assertEquals( driver.findElement(By.cssSelector("h3[data-test='error']")).getText() ,"Epic sadface: Username and password do not match any user in this service"
                );


        //Close the browser
        driver.quit();

    }

}
