package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if SignOut present --->logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ilost1@gmail.com", "898756542321Qq#");
        app.getHelperUser().submitLogin();
        app.getHelperUser().confirmLogin();
        app.getHelperUser().pause(5);

        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ilost1@gmail.com", "898756542321Qq#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
