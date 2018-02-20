import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private WebDriver driver;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void userLogin(){
        driver.get("https://mail.ukr.net/desktop/login");
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"id-1\"]"));
        loginField.sendKeys("anastassya.kutnenko@ukr.net");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"id-2\"]"));
        passwordField.sendKeys("2010nastya2015");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/main/form/button"));
        loginButton.click();
        Assert.assertEquals("Freemail", driver.getTitle());
        WebElement sendLetter = driver.findElement(By.partialLinkText("Написать письмо"));
        sendLetter.click();
        WebElement recipientEmail = driver.findElement(By.xpath("//*[@id=\"toField\"]"));
        recipientEmail.click();
        recipientEmail.sendKeys("anastasia.kutnenko@mev.com");
        WebElement subjectField = driver.findElement(By.xpath("//*[@id=\"fake_sendmsg_form\"]/label[5]/span[2]/input"));
        subjectField.click();
        subjectField.sendKeys("Test Letter");
        WebElement bodyField = driver.findElement(By.xpath("//*[@id=\"sendmsg_form\"]/div[1]/div[2]"));
        bodyField.click();
        bodyField.sendKeys("Test Body");
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"sendmsg-page\"]/div[5]/span[2]/input"));
        sendButton.click();
    }


    @AfterClass
    public void tearDown() {

        WebElement logoutButton = driver.findElement(By.partialLinkText("Выйти"));
        logoutButton.click();
        driver.quit();
    }
}
