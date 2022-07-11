package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContact() {
        click(By.cssSelector("button b"));
    }

    public void saveContact2() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);

    }

    public boolean isContactAddedByName(String name) { //правда ли создан такой контакт.     у каждого проверить имя и сравнить
        List<WebElement> names = wd.findElements(By.cssSelector("h2"));//собрать в лист все имена

        for (WebElement el : names) { //на каждой итеррации обходя лист , я получаю то чем он наполнен. он наполнен WebElemets, на каждой итерации вычитываю по одному элементу. заходить в лист , , если нет выкидывать
            if (el.getText().equals(name)) {//если я заберу текст вдруг он уже равен моему. брать первый контакт и сравнивать с моим
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> phones = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : phones) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public void openContacts() {
        click(By.cssSelector(".active"));
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!= 0) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(300);
        }
    }
}
