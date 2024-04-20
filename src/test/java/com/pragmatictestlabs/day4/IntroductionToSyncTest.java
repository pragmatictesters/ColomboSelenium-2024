package com.pragmatictestlabs.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IntroductionToSyncTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://eviltester.github.io/synchole/collapseable.html");

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testCollapseDiv() throws InterruptedException {
        //Click the section
        driver.findElement(By.cssSelector("section.condense")).click();

        //Thread.sleep(5000); NEVER USE
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); Deprecated  and avoid using
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Click the About link
        driver.findElement(By.cssSelector("a#aboutlink")).click();

        //Verify that the URL contains about.html
        Assert.assertTrue(driver.getCurrentUrl().contains("about.html"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

    }

    @Test
    public void testWithExplicitWait() throws InterruptedException {
        //Click the section
        driver.findElement(By.cssSelector("section.condense")).click();


        //Explicit Wait
        //Wait till the link is visible
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NullPointerException.class)
                .withMessage("About link is not clickable")
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#aboutlink")));

        /**
         *  0 : Check condition : if satisfied continue else wait/sleep 500ms
         *  500 : Check condition : if satisfied continue else wait/sleep 500ms
         *  1000 : Check condition : if satisfied continue else wait/sleep 500ms
         *  1500 : Check condition : if satisfied continue else wait/sleep 500ms
         *  2000 : Check condition : if satisfied continue else wait/sleep 500ms
         *  2500 : Check condition : if satisfied continue else wait/sleep 500ms
         *  3000 : Check condition : if satisfied continue else wait/sleep 500ms
         *  3500 : Check condition : if satisfied continue else wait/sleep 500ms
         *  4000 : Check condition : if satisfied continue else wait/sleep 500ms
         *  4500 : Check condition : if satisfied continue else wait/sleep 500ms
         *  5000 : Check condition : if satisfied continue else wait/sleep Timeout Error
         */


        //Click the About link
        driver.findElement(By.cssSelector("a#aboutlink")).click();

        //Verify that the URL contains about.html
        Assert.assertTrue(driver.getCurrentUrl().contains("about.html"));


    }








}
