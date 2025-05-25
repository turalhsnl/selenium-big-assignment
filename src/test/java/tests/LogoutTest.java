package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
public void testLogout() {
    driver.get("https://gitea.com/user/login");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsername("togrulqululu2@gmail.com");
    loginPage.enterPassword("3031505tT.");
    loginPage.clickSignIn();

    LogoutPage logoutPage = new LogoutPage(driver);
    logoutPage.logout();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    boolean loggedOut = wait.until(driver ->
        driver.getCurrentUrl().contains("/user/login") || driver.getCurrentUrl().contains("about.gitea.com")
    );

    Assert.assertTrue(loggedOut, "Logout failed: Unexpected landing page after logout");
}
}
