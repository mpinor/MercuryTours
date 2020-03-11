package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FlightsPage;

public class FlightsTest {
    FlightsPage objFp;

    @BeforeClass
    public void setup(){
        objFp = new FlightsPage();
    }

    @Test(priority = 1)
    public void canSearchAflight(){
        String expectedResult;
        String actualResult;

        //objFp.waitForVideo();
        objFp.selectType("oneway");
        objFp.selectPassengers("3");
        objFp.selectDepartingFrom("London");
        objFp.selectOnMonth("4");
        objFp.selectOnDay("3");
        objFp.selectArrivingIn("Frankfurt");
        objFp.selectReturningMonth("5");
        objFp.selectReturningDay("1");
        objFp.selectClass("First");
        objFp.selectAirline("Unified Airlines");
        objFp.searchFlight();

        expectedResult = "After flight finder - No Seats Avaialble";
        actualResult = objFp.getDriver().findElement(By.xpath("//td/p/font/b/font[1]")).getText().trim();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void tearDown(){
        objFp.closeDriver();
    }
}
