package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[text()=' Log in ']"));
    }


    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        //pause(2000);
        return wd.findElement(By.xpath("//h2[contains(@class,'message')]")).getText();
    }

//    public String getWrongRegistrationMessage() {
//
//        return wd.findElement(By.xpath("//h2[contains(@class,'error')]")).getText();
//    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()= ' Logout ']"));
    }


    public void logout() {
        click(By.xpath("//*[text()= ' Logout ']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }


    //*********************************Regstration********************

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("password"), user.getPassword());
        type(By.id("name"), user.getFirsName());
        type(By.id("lastName"), user.getLastName());

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());


    }

    public void checkPolicy() {
      //  click(By.id("terms-of-use"));
        //click(By.cssSelector("label[for='terms-of-use']"));

        //variant 2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }
    public List<String> getAllErrorTexts() {
        List<WebElement> errorElements = wd.findElements(By.cssSelector(".error"));
        List<String> errors = new ArrayList<>();
        for (WebElement element : errorElements) {
            errors.add(element.getText());
        }
        return errors;
    }
}
