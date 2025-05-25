package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

import java.time.Duration;

public class UserProfileUpdateTest extends BaseTest {

    @Test
    public void testUpdateFullName() {
        driver.get("https://gitea.com/user/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("togrulqululu2@gmail.com");
        loginPage.enterPassword("3031505tT.");
        loginPage.clickSignIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement profileDropdown = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("div.ui.dropdown.jump.item[data-tooltip-content^='Profile and Settings']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profileDropdown);

        WebElement settingsMenuItem = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'/user/settings')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", settingsMenuItem);

        WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@id='full_name']")));
        fullNameInput.clear();
        fullNameInput.sendKeys("Toghrul Gululu");

        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(@class,'ui primary button')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateProfileButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateProfileButton);

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.ui.positive.message.flash-success")));
        Assert.assertTrue(successMsg.isDisplayed(), "Profile update success message not displayed");
    }
}
