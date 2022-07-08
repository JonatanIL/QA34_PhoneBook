package tests;


import models.Contacts;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContacts extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
      User user = new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
    }


    @Test
    public void addNewContactSuccess() {

        Contacts cont = Contacts.builder()
                .name("Jimmy")
                .lastName("Henrics")
                .phone("6667799")
                .email("jimmy@gmail.com")
                .address("USA Origona")
                .description("He is 29 y.o.").build();

        app.cont().openADDForm();
        app.cont().fillContactsForm(cont);
        app.cont().submitContacts();

    }
}
