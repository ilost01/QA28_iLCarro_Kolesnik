package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

//    @BeforeMethod
//    public void preCondition(){
//        if (app.getHelperUser().isLogged()){
//            app.getHelperUser().logout();
//        }
//    }

    @BeforeMethod
    public void preCondition() {
        // Если пользователь залогинен, разлогин
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

        //Если кнопка "Login" неактивна, переходим на форму регистрации
        if (app.getHelperUser().isLoginButtonDisabled()) {
            app.getHelperUser().openLoginForm();
        }
    }


    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ilost1@gmail.com", "898756542321Qq#");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        //Assert.assertTrue(app.getHelperUser().getMessage().contains("Login or Password incorrect"));
        app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("ilost1@gmail.com").setPassword("898756542321Qq#");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        //Assert.assertTrue(app.getHelperUser().getMessage().contains("Login or Password incorrect"));
        app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ilost1@gmail.com", "898756542321Qq#");
        app.getHelperUser().submitLogin();
        //Assert.assertFalse(app.getHelperUser().getMessage().contains("Login or Password incorrect"));
        app.getHelperUser().clickOKButton();

    }

    @Test
    public void loginWrongEmail() {
        User user = new User().setEmail("ql@gmail.com").setPassword("Mmgjf56$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("Login or Password incorrect"));
        app.getHelperUser().clickOKButton();

    }

    //@AfterMethod
//    public void postCondition(){
//        app.getHelperUser().clickOKButton();
//    }

    @Test
    public void loginWithEmptyEmail() {
        User user = new User().setEmail("").setPassword("Mmgjf56$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        Assert.assertEquals(app.getHelperUser().getMessage(), "Email is required");

    }

    @Test
    public void loginWithEmptyPassword() {
        User user = new User().setEmail("test@gmail.com").setPassword("");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        Assert.assertFalse(app.getHelperUser().getMessage().contains("Password is required"));

    }
    @Test
    public void loginWithInvalidEmail() {
        User user = new User().setEmail("wrongemail.com").setPassword("Mmgjf56$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("It'snot look like email"));

    }

    @Test
    public void loginWithEmailWithoutDomain() {
        User user = new User().setEmail("user@").setPassword("Mmgjf56$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("It'snot look like email"));

    }
    @Test
    public void loginWithOnlyLettersPassword() {
        User user = new User().setEmail("test@gmail.com").setPassword("passwordonly");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("Login or Password incorrect"));
        app.getHelperUser().clickOKButton();
    }


}