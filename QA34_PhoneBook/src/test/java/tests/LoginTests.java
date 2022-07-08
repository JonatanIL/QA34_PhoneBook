package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

@BeforeMethod
public void preCondition(){
    if (app.getHelperUser().isLogged()){
        app.getHelperUser().logout();
    }

}


    @Test
    public void loginSuccess() {
        User user =new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$");
       app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() {
        User user =new User().setEmail("Noagmail.com").setPassword("Nnoa12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());

    }



}