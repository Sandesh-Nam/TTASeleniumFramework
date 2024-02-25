package org.thetestingacademy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.thetestingacademy.drivers.DriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    //Always create a default const for BasePage, its a good practice
    public BasePage(){
        //If you want to call something before every page object calls call, Put your code here
        //open file, open DB connection - you can write code here
    }
    //Waits (Implicit wait)
    public void implicitWait(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Click
    public void clickElement(By by){
        DriverManager.getDriver().findElement(by).click();
    }
    //Waits (Explicit wait)
    public WebElement presenceOfElement(final By elementLocation){
        return new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(20)).until
                (ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public WebElement visiblityOfElement(final By elementLocation){
        return new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(20)).until
                (ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void iWaitForElementToBeVisible(WebElement loc, String url){
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
            wait.until(ExpectedConditions.urlContains(url));
;
        }catch (Exception e){
            System.out.println("Failed to Wait!: " + e.toString());

        }
    }

   //send keys methods
    protected void enterInput(By by, String key){
        DriverManager.getDriver().findElement(by).sendKeys(key);
    }
    //get element
    protected WebElement getElement(By key){
        return DriverManager.getDriver().findElement(key);
    }

}
