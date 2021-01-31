package com.nextBase.tests;

import com.nextBase.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US8_AC4 {
    //4. Verify users can access to any module by one click.
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://login2.nextbasecrm.com");
        driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("marketing28@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[title='Tasks']")).click();
    }
    @Test
    public void test_users_CanAccessAnyModule() throws InterruptedException {
        WebElement homeButton = driver.findElement(By.cssSelector("a[title='Home']"));
        homeButton.click();
        Thread.sleep(2000);

        WebElement taskModule = driver.findElement(By.cssSelector("a[title='Tasks']"));
        WebElement chatAndCallModule = driver.findElement(By.cssSelector("a[title='Chat and Calls']"));
        WebElement workGroupsModule = driver.findElement(By.cssSelector("a[title='Workgroups']"));
        WebElement activityStreamModule = driver.findElement(By.cssSelector("a[title='Activity Stream']"));
        WebElement driveModule = driver.findElement(By.cssSelector("a[title='Drive']"));
        Assert.assertTrue(taskModule.isEnabled());
        Assert.assertTrue(chatAndCallModule.isEnabled());
        Assert.assertTrue(workGroupsModule.isEnabled());
        Assert.assertTrue(activityStreamModule.isEnabled());
        Assert.assertTrue(driveModule.isEnabled());
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
}
