import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyIntegration {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }
    @Test

    public void checkInstallation() throws InterruptedException{
        driver.get("https://qa.gosimplr.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div[2]/a[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"signInUsername\"]")).sendKeys("qa.automation+7@gosimplr.com");
        driver.findElement(By.xpath("//*[@id=\"signInPassword\"]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div/form/div[3]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("/html/body/div/form/div[2]/div[4]/div[10]/div")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app_id\"]")).sendKeys("bybmbjhg");
        driver.findElement(By.xpath("//*[@id=\"testPlatform\"]")).click();





    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}