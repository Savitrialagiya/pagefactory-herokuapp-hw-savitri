package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }
    @Test(priority = 1,groups = {"sanity","regression"})
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(loginPage.getWelcomeText(),expectedMessage,"welcome text not displayed");

    }
    @Test(priority = 2,groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your username is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getUserNameInvalidText(),expectedMessage,"Username Invalid text not displayed");

    }
    @Test(priority = 3,groups = {"regression"})
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your password is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getPasswordInvalidText(),expectedMessage,"Password Invalid text not displayed");
    }
}
