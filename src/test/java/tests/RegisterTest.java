package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest {
    RegisterPage objRegPage;

    @BeforeClass
    public void start(){
        objRegPage = new RegisterPage();
    }

    @Test(priority = 0)
    public void canRegisterNewUser(){
        String expectedResult1;
        String expectedResult2;
        String actualResult1;
        String actualResult2;

        objRegPage.clickOnRegister();
        objRegPage.hideVideo();
        objRegPage.typeFirstName("Juan");
        objRegPage.typeLastName("Perez");
        objRegPage.typePhone("912345678");
        objRegPage.typeUserName("jperez@gmail.com");
        objRegPage.typeAddress("Alameda 123");
        objRegPage.typeCity("Santiago");
        objRegPage.typeState("Metropolitana");
        objRegPage.typePostalCode("111111");
        objRegPage.selectCountry("CHILE");
        objRegPage.typeEmail("hola@hola.com");
        objRegPage.typePassword("1234");
        objRegPage.typeRepeatPassword("1234");
        objRegPage.clickOnSubmit();

        expectedResult1 = "Dear Juan Perez,";
        expectedResult2 = "Note: Your user name is hola@hola.com.";
        actualResult1 = objRegPage.getDriver().findElement(By.xpath("//p[1]/font/b")).getText();
        actualResult2 = objRegPage.getDriver().findElement(By.xpath("//p[3]/font/b")).getText();


        Assert.assertEquals(actualResult1, expectedResult1);

        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @AfterClass
    public void end(){
        objRegPage.closeDriver();
    }
}
