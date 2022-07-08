package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HelperContacts extends HelperBase {
    public HelperContacts(WebDriver wd) {
        super(wd);
    }


    public void openADDForm() {
        WebElement add = wd.findElement(By.cssSelector("div a[href*='/add']"));
        add.click();
    }

    public void fillContactsForm(Contacts contacts) {
        type(By.xpath("//*[@placeholder='Name']"), contacts.getName());
        type(By.xpath("//*[@placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//*[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//*[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//*[@placeholder='description']"),contacts.getAddress());
    }


    public void submitContacts() {
        wd.findElement(By.xpath("//b[.='Save']")).click();
    }
}
