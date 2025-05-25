package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverProductsMenu() {
        driver.get("https://about.gitea.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productsMenuDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'relative') and contains(., 'Products')]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(productsMenuDiv).perform();

        WebElement dropdownItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'relative')]//a[contains(text(),'Gitea Cloud')]")));

        Assert.assertTrue(dropdownItem.isDisplayed(), "'Products' dropdown menu did not appear on hover");
    }
}
