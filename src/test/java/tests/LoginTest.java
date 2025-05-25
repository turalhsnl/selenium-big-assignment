package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        driver.get("https://gitea.com/user/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("togrulqululu2@gmail.com");
        loginPage.enterPassword("3031505tT.");
        loginPage.clickSignIn();

        String expectedTitle = "Your Dashboard"; 
        Assert.assertTrue(driver.getTitle().contains("Dashboard") || !loginPage.isErrorMessageDisplayed(),
                "Login failed or dashboard not loaded.");
    }
}
