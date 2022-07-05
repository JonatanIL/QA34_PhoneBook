package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test (invocationCount = 5)
    public void registrationSuccess() {
        int i =(int) (System.currentTimeMillis()/100)%3600;
        User user =new User().setEmail("fox"+i+"@mail.com").setPassword("Ff12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
    }
}