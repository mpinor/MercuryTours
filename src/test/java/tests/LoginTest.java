package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    LoginPage lp;
    WebDriver driver;
    By tagMensaje;
    String mensaje;
    String actualResult;
    String expectedResult;

    @BeforeTest
    public void setup(){
        lp = new LoginPage();
        driver = lp.getDriver();
    }

    @Test
    public void loginSuccessfully(){
        lp.typeUsername("hola@hola.com");
        lp.typePassword("1234");
        lp.clickOnSubmit();

        tagMensaje = By.xpath("//tr[1]/td/h3");
        actualResult = driver.findElement(tagMensaje).getText();
        expectedResult = "Login Successfully";

        Assert.assertEquals(actualResult,expectedResult);

    }
}
