package manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  HelperUser extends HelperBase{

    public HelperUser(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm(){
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));

    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));

    }

    public void confirmLogin() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void logout() {
        click(By.cssSelector("a[href='/logout?url=%2Fsearch']")
        );
    }

    public boolean isLogged() {
        return isElementPresent(By.cssSelector("a[href='/logout?url=%2Fsearch']")
        );
    }



}
