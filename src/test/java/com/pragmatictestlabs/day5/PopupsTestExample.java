package com.pragmatictestlabs.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsTestExample {

    WebDriver driver;

    @BeforeMethod
    public void testBeforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/Alerts.html");
    }

    @AfterMethod
    public void afterMethod(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Test
    public void testAlert(){
        driver.findElement(By.id("alert")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "This is a simple Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "Alert was closed!");
        driver.findElement(By.id("prompt")).click();

    }


    @Test
    public void testConfirmation(){

    }

    @Test
    public void testSelect(){
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.findElement(By.id("btnRegister")).click();
        Select selContinent = new Select( driver.findElement(By.id("continents")));
        selContinent.selectByIndex(2);

    }


}
