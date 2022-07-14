package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String errorUsername = "locked_out_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    String errorText = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPasswordError = "Epic sadface: Password is required";
    String emptyPassword = "";
    String wrongPassword = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void verifySuccesfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void verifyUnSuccesfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(errorUsername, password);
        loginPage.verifyUnSuccesfulLogin(errorText);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }

    }
    
    @Test
    public void verifyEmtyUsernameError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emptyUsername, password);
        loginPage.verifyUnSuccesfulLogin(emptyUsernameError);    
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void verifyEmtyPasswordError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, emptyPassword);
        loginPage.verifyUnSuccesfulLogin(emptyPasswordError);
    
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }
    @Test
    public void verifyWrongPasswordError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, wrongPassword);
        loginPage.verifyUnSuccesfulLogin(wrongPassword);
    
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }
}

