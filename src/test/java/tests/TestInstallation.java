package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ReadProperty;


public class TestInstallation {
    private WebDriver driver;
    private WebDriverWait wait;
    private ReadProperty reader = new ReadProperty();


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();

    }
    @Test

    public void checkInstallation() {
        Helper openNewlink = new Helper();
        driver.get("https://qa.gosimplr.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div[2]/a[1]/button"))).click();
        driver.findElement(By.xpath("//*[@id=\"signInUsername\"]")).sendKeys(reader.getPropValues("business.name"));
        driver.findElement(By.xpath("//*[@id=\"signInPassword\"]")).sendKeys(reader.getPropValues("business.password"));
        driver.findElement(By.xpath("/html/body/div/form/div[3]")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/div[2]/div[4]/div[10]/div"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div"))).click();
       //driver.findElement(By.xpath("//*[@id=\"app_id\"]")).sendKeys("bybmbjhg");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"testPlatform\"]"))).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"next\"]"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div/img")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div/img")));
        openNewlink.openInNewTab("https://www.google.com.ua/");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}