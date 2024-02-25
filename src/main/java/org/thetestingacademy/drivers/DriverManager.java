package org.thetestingacademy.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManager {
    //We are using DriverManager because driver is common across all the
    //pages. Eg - suppose in future chrome driver will have to change, then
    //in this case you will only change driver manager class and not the other code.
    //There are two ways you can DriverManager
    //1- static method - Shared by all the Testcases - Here parallel execution
    //may have some problem.
    //2- Thread local - 1 class or test per Driver - If you implement by this
    //then you can run parallel.
    static WebDriver driver ;

    //Before running any method, i want to check if my driver is created or not
    //Before running any testcase, new driver will be created
    //and after running testcase, aftermethod will be done.
    //init, down will be automatically called before and after method
    @BeforeMethod
    static void init(){
        //init basically means initialization like open browser
        if(driver == null){
            driver = new ChromeDriver();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    @AfterMethod
    static void down(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
