package com.pragmatictestlabs.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {


    @Test
    public void helloSelenium(){

        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();

        //Open a web browser (Chrome browser)
        WebDriver driver = new ChromeDriver();

        //Set implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");

        //Type username standard_user
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");

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
