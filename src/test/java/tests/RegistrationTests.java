package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
//
//    @Test
//    public void registrationSuccess() {
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        System.out.println(i);
//
//
//        System.out.println(System.currentTimeMillis());
//        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
//        System.out.println(z);
//
//        User user = new User()
//                .setFirsName("Lis1a")
//                .setLastName("Snow")
//                .setEmail("snow" + i + "@gmail.com")
//                .setPassword("Snow123456$");
//
//        app.getHelperUser().openRegistrationForm();
//        app.getHelperUser().fillRegistrationForm(user);
//        app.getHelperUser().checkPolicy();
//        app.getHelperUser().submit();
//        app.getHelperUser().pause(2000);
//        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
//
//
//    }


    @Test
    public void registrationWithEmptyFields() {
        User user = new User()
                .setFirsName("")
                .setLastName("")
                .setEmail("")
                .setPassword("");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();


        List<String> errors = app.getHelperUser().getAllErrorTexts();

        Assert.assertEquals(errors.get(0),"Name is required");
        Assert.assertEquals(errors.get(1),"Last name is required");
        Assert.assertEquals(errors.get(2),"Email is required");
        Assert.assertEquals(errors.get(3), "Password is required");

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }



    @Test
    public void registrationWrongEmail() {
        User user = new User()
                .setFirsName("")
                .setLastName("")
                .setEmail("snow1910@gmailcom")
                .setPassword("");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();


        List<String> errors = app.getHelperUser().getAllErrorTexts();

        Assert.assertEquals(errors.get(2), "Wrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .setFirsName("rhgfh")
                .setLastName("fgfg")
                .setEmail("snow1910@gmail.com")
                .setPassword("1");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();


        List<String> errors = app.getHelperUser().getAllErrorTexts();


        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Password must contain minimum 8 symbols"));
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }
    @Test
    public void registrationWithoutPolicyCheck() {

        User user = new User()
                .setFirsName("Lis1a")
                .setLastName("Snow")
                .setEmail("snow14@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }




}