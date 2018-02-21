package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.collections.Lists;


import java.util.List;

public class Helper {
    private WebDriver driver;
    public void openInNewTab(String Url){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        List<String> windowHandleList = Lists.newArrayList(driver.getWindowHandles());
        int number = windowHandleList.size();
        String tab = windowHandleList.get(number - 1);
        driver.switchTo().window(tab);
        driver.get(Url);

    }

}
