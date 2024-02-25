package org.thetestingacademy.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.thetestingacademy.base.BasePage;
import org.thetestingacademy.utils.PropertyReader;

public class LoginPage_POM extends BasePage {
    public LoginPage_POM(){
        super(); //here super is calling Basepage default const
    }
    By username = By.id("login-username"); //By is an abstract class
    By password = By.id("login-password");
    By signInButton = By.id("js-login-btn");

    public void loginToVWO() throws Exception {
        enterInput(username , PropertyReader.readKey("username"));
        enterInput(password , PropertyReader.readKey("password"));
        clickElement(signInButton); //this defn is already present in BP
    }


}
