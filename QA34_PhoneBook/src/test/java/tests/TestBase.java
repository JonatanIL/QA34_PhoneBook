package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    static ApplicationManager app = new ApplicationManager(); //видимость которая распространяется на один пекедж

    @BeforeSuite
    public void setUp() {
        app.init();// первая строчка кода которая работает
    }


    @AfterSuite
    public void tearDown() { //app.stop();
    }
}

