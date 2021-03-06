package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{


    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }

    }

    @Test
    public void registrationSuccess(){
        int i = (int)System.currentTimeMillis()/1000;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("jonatan"+i+"@gmail.com","Jj12345$");
        app.getHelperUser().submitRegistration();

    }


}