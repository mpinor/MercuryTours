package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.WebDrivers;

public class LoginPage extends  WebDrivers{
    private WebDriver driver;

    public LoginPage(){
        super.setDriver("http://demo.guru99.com/test/newtours/");
        driver = super.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="userName")
    WebElement user;

    @FindBy(name="password")
    WebElement pass;

    @FindBy(name="submit")
    WebElement submit;

    public void typeUsername(String username){
        user.sendKeys(username);
    }

    public void typePassword(String password){
        pass.sendKeys(password);
    }

    public void clickOnSubmit(){
        submit.click();
    }
}
