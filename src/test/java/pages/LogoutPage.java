package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.ui.dropdown.jump.item[data-tooltip-content^='Profile and Settings']")
    private WebElement profileDropdown;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void logout() {
    try {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profileDropdown);
        System.out.println("Clicked profile dropdown.");

        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.menu.user-menu")
        ));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownMenu));
        System.out.println("Dropdown menu is visible and clickable.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            Thread.currentThread().interrupt();
        }

        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signOutButton = longWait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//a[contains(normalize-space(),'Sign Out')]")
        ));
        System.out.println("Sign Out button found with text: " + signOutButton.getText());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signOutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signOutButton);
        System.out.println("Clicked Sign Out button.");
    } catch (Exception e) {
        e.printStackTrace();
        throw e; 
    }
}


}
