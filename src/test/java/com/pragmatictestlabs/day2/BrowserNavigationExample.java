package com.pragmatictestlabs.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationExample {


    @Test
    public void testWithEdge(){

        //Setup web browser driver (Edge driver)
        WebDriverManager.edgedriver().setup();

        //Open a web browser (Edge browser)
        WebDriver driver = new EdgeDriver();


        //Navigate to the login screen (Type URL https://www.saucedemo.com/)
        //driver.get("https://www.saucedemo.com/");
        driver.navigate().to("https://www.saucedemo.com");
        System.out.println(driver.getPageSource());
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        driver.navigate().refresh(); //To refresh the browser
        driver.navigate().back(); //To click back button in the browser
        driver.navigate().forward(); //



        //Type username standard_user

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("AA");

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
