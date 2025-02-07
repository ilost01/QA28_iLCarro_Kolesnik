package tests;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ilost1@gmail.com", "898756542321Qq#");
        app.getHelperUser().submitLogin();
        app.getHelperUser().confirmLogin();

    }
}
