package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class IntercomWidget {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();



    }

    @Test
    public void chatButton() throws InterruptedException {
        driver.get("https://qa.gosimplr.com/__/chatTestQA.html");
        Thread.sleep(5000);
        driver.switchTo().frame("intercom-launcher-discovery-frame");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("intercom-container-body"))).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("intercom-messenger-frame");
        driver.findElement(By.className("intercom-header-buttons-back-contents")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"intercom-container\"]/div/span[1]/div/div[3]/button"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"intercom-container\"]/div/span[1]/div/div[3]/div/textarea"))).sendKeys("Test message");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"intercom-container\"]/div/span[1]/div/div[3]/div/div/button[2]"))).click();
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.COMMAND + "t");
        driver.get("https://qa.gosimplr.com");

    }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

