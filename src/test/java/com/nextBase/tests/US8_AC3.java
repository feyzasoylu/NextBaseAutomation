package com.nextBase.tests;

import com.nextBase.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US8_AC3 {
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
    public void test1_selectAllCheckboxes(){
        driver.findElement(By.cssSelector("input[class='main-grid-checkbox main-grid-row-checkbox main-grid-check-all']")).click();
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[name='ID[]']"));
        for(WebElement each : checkBoxes){
            System.out.println(each.getAttribute("value"));
            Assert.assertTrue(each.isSelected());
        }
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
}
