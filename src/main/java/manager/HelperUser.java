package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

//    public String getMessage() {
//
//        return wd.findElement(By.xpath("//h2[contains(text(), 'Login or Password incorrect')]")).getText();
//    }

    public String getMessage() {
        try {
            return wd.findElement(By.xpath("//h2[contains(text(), 'Login or Password incorrect')]")).getText();
        } catch (NoSuchElementException e) {
            try {
                return wd.findElement(By.xpath("//div[contains(text(), 'Email is required')]")).getText();
            } catch (NoSuchElementException e1) {
                try {
                    return wd.findElement(By.xpath("//div[contains(text(), 'Password is required')]")).getText();
                } catch (NoSuchElementException e2) {
                    try {
                        return wd.findElement(By.xpath("//div[contains(text(), \"It'snot look like email\")]")).getText();
                    } catch (NoSuchElementException e3) {
                        return "No error message";
                    }
                }
            }
        }
    }


    public void clickOKButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.cssSelector("a[href='/logout?url=%2Fsearch']"));
    }


    public void logout() {
        click(By.xpath("//*[text()= ' Logout ']"));
    }

    public boolean isLoginButtonDisabled() {
        WebElement loginButton = wd.findElement(By.xpath("//button[text()='Y’alla!']"));
        return !loginButton.isEnabled();
    }

}