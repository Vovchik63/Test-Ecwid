package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchDemoShopPageSteps;
import util.DriverFactory;
import util.PropertyReader;
import util.SizeFilters;
import util.Sort;

import static util.SizeFilters.*;
import static util.Sort.*;

public class BaseTest {
    private static WebDriver driver;
    protected SearchDemoShopPageSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp(){
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.manage().window().maximize();
        driver.get(PropertyReader.getUrl());
        steps = new SearchDemoShopPageSteps();
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    @AfterMethod
    public static void goBack(){
        driver.get("https://www.ecwid.ru/demo/search");

    }

    @DataProvider(name = "dataProviderSort")
    public Object[][] dataProviderSort() {
        return new Object[][]{{NEW},{HIGH_TO_LOW},{LOW_TO_HIGH},{TITLE_A_TO_Z},{TITLE_Z_TO_A}};
    }

    @DataProvider(name = "dataProviderSizeFilters")
    public Object[][] dataProviderSize() {
        return new Object[][]{{THIRTY},{THIRTY_TWO},{THIRTY_FOUR},{THIRTY_SIX},{THIRTY_EIGHT},{SMALL},{MEDIUM},{LARGE},{XLARGE}};
    }



}
