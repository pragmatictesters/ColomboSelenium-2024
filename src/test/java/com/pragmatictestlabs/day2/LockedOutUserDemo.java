package com.pragmatictestlabs.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LockedOutUserDemo {


    @Test
    public void helloSelenium2(){

        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();

        //Open a web browser (Chrome browser)
        WebDriver driver = new ChromeDriver();

        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");

        //Type username standard_user
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        //Type password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click the login
        driver.findElement(By.id("login-button")).click();


        //Verify/check the Product label is available in the landing page after login
        Assert.assertEquals( driver.findElement(By.cssSelector("h3[data-test='error']")).getText() ,"Epic sadface: Sorry, this user has been locked out.");


        //Close the browser
        driver.quit();

    }

}
