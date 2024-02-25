package org.thetestingacademy.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.thetestingacademy.base.BasePage;

public class DashboardPage_POM extends BasePage {
    DashboardPage_POM(){
    }
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    public String loggedInUserName(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
