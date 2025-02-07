package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void  type(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        if (text != null){
            element.sendKeys(text);
        }

    }

}
