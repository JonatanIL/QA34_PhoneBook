package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLoginRegistrationForm(User user) {

        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public boolean isLogged() {
        //Sign out present? ---> logged
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }


    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(4)).until(ExpectedConditions.alertIsPresent());
        //веб драйвер 4 секунды будет находится в состоянии wait , но если Allertpresent отрисуется раньше, то вебдрайвер выйдет раньще из состояния Wait
        if (alert == null) {
            return false;
        } else {
            return true;
        }

    }
    public boolean isErrorFormatDisplayed() {
        Alert alert = wd.switchTo().alert();

        String errorText = alert.getText();
        System.out.println(errorText);
        alert.accept();

//        alert.getText();/// get text
//        alert.sendKeys("hello"); //type text
//        alert.accept();//click OK button
//        alert.dismiss(); //click Cancel button
        return errorText.contains("Wrong email or password format");
    }
}
