package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HistoryTest extends BaseTest {

    @Test
public void testBrowserBack() throws InterruptedException {
    driver.get("https://about.gitea.com");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement productsMenu = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//div[contains(@class,'relative') and contains(., 'Products')]")));
    productsMenu.click();

    Thread.sleep(1500); 

    WebElement giteaCloudLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(text(),'Gitea Cloud')]")));
    giteaCloudLink.click();

    Thread.sleep(2000);

    wait.until(ExpectedConditions.urlContains("/cloud"));

    driver.navigate().back();

    Thread.sleep(2000); 

    wait.until(ExpectedConditions.urlToBe("https://about.gitea.com/"));

    Assert.assertEquals(driver.getCurrentUrl(), "https://about.gitea.com/", "Browser did not navigate back to homepage");
}

}
