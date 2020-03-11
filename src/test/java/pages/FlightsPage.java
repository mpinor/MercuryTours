package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.WebDrivers;

import java.util.List;

public class FlightsPage extends WebDrivers{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//*[@id=\"primis_playerSekindoSPlayer5e614fab09a52\"]")
    WebElement divVideo;

    @FindBy(name="tripType")
    List <WebElement> chk_type;

    @FindBy(name="passCount")
    WebElement sel_passengers;

    @FindBy(name="fromPort")
    WebElement sel_departing_from;

    @FindBy(name="fromMonth")
    WebElement sel_departing_month;

    @FindBy(name="fromDay")
    WebElement sel_departing_day;

    @FindBy(name="toPort")
    WebElement sel_to_port;

    @FindBy(name="toMonth")
    WebElement sel_to_month;

    @FindBy(name="toDay")
    WebElement sel_to_day;

    @FindBy(name="servClass")
    List <WebElement> chk_serv_class;

    @FindBy(name="airline")
    WebElement sel_airline;

    @FindBy(css="input[name='findFlights']")
    WebElement btn_submit;

    public FlightsPage(){
        super.setDriver("http://demo.guru99.com/test/newtours/reservation.php");
        this.driver = super.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void waitForVideo( ) {
        wait.until(ExpectedConditions.elementToBeClickable(divVideo));
    }

    public void selectType(String one_way) {
        selectRadioButton(chk_type, one_way);
    }

    public void selectPassengers(String s) {
        selectOption(sel_passengers, s);
    }

    public void selectDepartingFrom(String london) {
        selectOption(sel_departing_from, london);
    }

    public void selectOnMonth(String april) {
        selectOption(sel_departing_month, april);
    }

    public void selectOnDay(String s) {
        selectOption(sel_departing_day, s);
    }

    public void selectArrivingIn(String frankfurt) {
        selectOption(sel_to_port, frankfurt);
    }

    public void selectReturningMonth(String may) {
        selectOption(sel_to_month, may);
    }

    public void selectReturningDay(String s) {
        selectOption(sel_to_day, s);
    }

    public void selectClass(String first_class) {
        selectRadioButton(chk_serv_class, first_class);
    }

    public void selectAirline(String unified_airlines) {
        selectOption(sel_airline, unified_airlines);
    }

    public void searchFlight() {
        btn_submit.click();
    }

    //selecciona la opción deseada en el campo select señalado.
    public void selectOption(WebElement select_input, String value_input){
        Select lista = new Select(select_input);
        if(select_input.equals(sel_airline)){
            lista.selectByVisibleText(value_input);
        }else{
            lista.selectByValue(value_input);
        }
    }

    //selecciona el radio button a partir del valor entregado.
    public void selectRadioButton(List<WebElement> radio_group, String radio_value){
        for(WebElement tipo : radio_group){
            wait.until(ExpectedConditions.elementToBeClickable(tipo));
            String tipo_value = tipo.getAttribute("value");
            if(tipo_value.compareToIgnoreCase(radio_value) == 0){
                wait.until(ExpectedConditions.elementToBeClickable(tipo)).click();
            }
        }
    }
}
