package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeOptionsTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");  
        options.addArguments("--disable-extensions"); 
        options.addArguments("--window-size=1920,1080"); 
        options.addArguments("--disable-gpu"); 
        options.addArguments("--start-maximized"); 

        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenGiteaHomePage() {
        driver.get("https://gitea.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
