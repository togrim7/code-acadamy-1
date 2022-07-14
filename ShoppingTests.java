package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class ShoppingTests extends BaseTest{
    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    int numberOfAllItems = 6;

    @Test
    public void verifySuccesfulAddToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifyProductAddedToCart();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void numberOfItemsHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.numberOfProducts(numberOfAllItems);


    }

@Test
public void verifyAboutLink(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnHamburgerMenu();
    homePage.verifyAboutLink();

}

    
}
