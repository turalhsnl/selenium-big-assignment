package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaticPageTest extends BaseTest {

    @Test
    public void testMainHeading() {
        driver.get("https://about.gitea.com");

        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Private, Fast, Reliable DevOps Platform')]"));

        String expectedText = "Private, Fast, Reliable DevOps Platform";
        Assert.assertEquals(heading.getText().trim(), expectedText, "Main heading text mismatch!");
    }
}
