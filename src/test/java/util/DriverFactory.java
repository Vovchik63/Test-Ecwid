package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

public class DriverFactory {
    private static final String DRIVER_PATH = "src/test/resources/";
    private static WebDriver driver;
    private static final String CHROME_NAME = "chromedriver.exe";
    private static final String FIREFOX_NAME = "geckodriver.exe";
    private static final String OPERA_NAME =  "operadriver.exe";


    public static WebDriver getDriver(Browsers browsers){
        File file;
        switch (browsers){

            case CHROME -> {
                file = new File(DRIVER_PATH+CHROME_NAME);
                System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                driver = new ChromeDriver();
            }
            case OPERA -> {
                file = new File(DRIVER_PATH+OPERA_NAME);
                System.setProperty("webdriver.opera.driver",file.getAbsolutePath());
                driver = new OperaDriver();
            }
            case FIREFOX -> {
                file = new File(DRIVER_PATH+FIREFOX_NAME);
                System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}
