package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    public HelperUser userHelper;


    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ilcarro.web.app");
        userHelper = new HelperUser(driver);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public HelperUser getHelperUser() {
        return userHelper;
    }



    public void stop(){
       // driver.quit();
    }
}
