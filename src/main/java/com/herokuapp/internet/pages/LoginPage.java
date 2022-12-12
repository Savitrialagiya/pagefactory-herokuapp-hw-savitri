package com.herokuapp.internet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordFiled;

    @CacheLookup
    @FindBy(xpath = "//i[@class=\"fa fa-2x fa-sign-in\"]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area. When you are done click logout below.')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"flash error\"]")
    WebElement usernameInvalidText;

    @CacheLookup
    @FindBy(xpath = "//div[@class=\"flash error\"]")
    WebElement passwordInvalidText;


    public void enterUsername(String username) {
        Reporter.log("Enter username " + username + " to username field" + usernameField.toString());
        sendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS,"Enter Username " + username);
    }

    public void enterPassword(String password) {
        Reporter.log(" Enter password " + password + "  to password field " + passwordFiled.toString());
        sendTextToElement(passwordFiled, password);
        CustomListeners.test.log(Status.PASS,"Enter Password" + password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"clickOnLoginButton");
    }

    public String getWelcomeText() {
        Reporter.log("get Welcome Text" + welcomeText.toString());
        CustomListeners.test.log(Status.PASS,"get Welcome Text");
        return getTextFromElement(welcomeText);

    }

    public String getUserNameInvalidText() {
        Reporter.log("get UserName Invalid Text" + usernameInvalidText.toString());
        CustomListeners.test.log(Status.PASS,"get UserName Invalid Text");
        return getTextFromElement(usernameInvalidText);
    }

    public String getPasswordInvalidText() {
        Reporter.log("get Password Invalid Text" + passwordInvalidText.toString());
        CustomListeners.test.log(Status.PASS,"get Password Invalid Text");
        return getTextFromElement(passwordInvalidText);
    }

}


