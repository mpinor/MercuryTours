package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.WebDrivers;

public class RegisterPage extends WebDrivers {
    private WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(){
        super.setDriver("http://demo.guru99.com/test/newtours/");
        this.driver = super.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="flow_close_btn_iframe")
    WebElement videoDiv;

    @FindBy(linkText="REGISTER")
    WebElement lnkReg;

    @FindBy(xpath="//td[2]/input")
    WebElement txt_fname;

    @FindBy(name="lastName")
    WebElement txt_lname;

    @FindBy(name="phone")
    WebElement txt_phone;

    @FindBy(id="userName")
    WebElement txt_username;

    @FindBy(name="address1")
    WebElement txt_address;

    @FindBy(name="city")
    WebElement txt_city;

    @FindBy(name="state")
    WebElement txt_state;

    @FindBy(name="postalCode")
    WebElement txt_pcode;

    @FindBy(name="country")
    WebElement cbo_country;

    @FindBy(id="email")
    WebElement txt_email;

    @FindBy(name="password")
    WebElement txt_password;

    @FindBy(name="confirmPassword")
    WebElement txt_password_repeat;

    @FindBy(name="submit")
    WebElement btn_submit;

    public void hideVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(videoDiv));
    }

    public void clickOnRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkReg));
        lnkReg.click();
    }

    public void typeFirstName(String fname){
        txt_fname.sendKeys(fname);
    }

    public void typeLastName(String lname){
        txt_lname.sendKeys(lname);
    }

    public void typePhone(String phone){
        txt_phone.sendKeys(phone);
    }

    public void typeUserName(String userName){
        txt_username.sendKeys(userName);
    }

    public void typeAddress(String address){
        txt_address.sendKeys(address);
    }

    public void typeCity(String city){
        txt_city.sendKeys(city);
    }

    public void typeState(String state){
        txt_state.sendKeys(state);
    }

    public void typePostalCode(String pcode){
        txt_pcode.sendKeys(pcode);
    }

    public void selectCountry(String country){
        Select combobox = new Select(cbo_country);
        combobox.selectByValue(country);
    }

    public void typeEmail(String email){
        txt_email.sendKeys(email);
    }

    public void typePassword(String password){
        txt_password.sendKeys(password);
    }

    public void typeRepeatPassword(String passwordR){
        txt_password_repeat.sendKeys(passwordR);
    }

    public void clickOnSubmit(){
        btn_submit.click();
    }
}
