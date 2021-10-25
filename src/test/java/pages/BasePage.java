package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver = BaseTest.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public List<WebElement> getArrayWebElements(By element) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        List<WebElement> webElementArrayList = driver.findElements(element);
        return webElementArrayList;
            }



    public  double getIntValueFromElement(By element){
        WebElement element1 = driver.findElement(element);
        String pre_res = element1.getText().replaceAll("[а-я-А-Я-a-z-A-Z-$]","").trim();
        return Double.parseDouble(pre_res);

    }

    public void click(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).click();
    }



    public String getPageAddress(){
        return driver.getCurrentUrl();
    }








}
