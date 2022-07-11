package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test
    public void RemoveContacts() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("jonatan@gmail.com", "Jj12345$");
        app.getHelperUser().submitLogin();
        app.contact().openContacts();
        app.contact().removeAllContacts();
        Assert.assertTrue(app.getHelperUser().isTextDisplayed());
    }
}

