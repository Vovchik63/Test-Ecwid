package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.SizeFilters;
import util.Sort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SearchDemoShopPage extends BasePage {
    String mensApparelFilter ="checkbox-category-20671018";
    String surfboardsFilter = "checkbox-category-20671017";
    String womenApparelFilter = "checkbox-category-20671019";
    String instockFilter = "checkbox-in_stock";
    final String NEW_SORT_ID = "radio-sortBy-addedTimeDesc";
    final String LOW_TO_HIGH_SORT_ID = "radio-sortBy-priceAsc";
    final String HIGH_TO_LOW_SORT_ID = "radio-sortBy-priceDesc";
    final String TITLE_A_TO_Z_SORT_ID = "radio-sortBy-nameAsc";
    final String TITLE_Z_TO_A_SORT_ID = "radio-sortBy-nameDesc";
    final String PRICE_SLIDER_LEFT_RUNNER_SELECTOR = "div.ec-range__runner.ec-range__runner--left";




    public SearchDemoShopPage(){
        super();
    }



    public void clickMensApparel(){
    click(By.id(mensApparelFilter));
    }

    public void clickWomenApparelFilter(){
        click(By.id(womenApparelFilter));
    }

    public void clickSurfboardsFilter(){
        click(By.id(surfboardsFilter));
    }

    public void clickInstockFilter(){
        click(By.id(instockFilter));

    }
    public void clickSizeFilter(SizeFilters size){

        switch (size){
            case THIRTY -> click(By.id("checkbox-option-Size-30"));
            case THIRTY_TWO -> click(By.id("checkbox-option-Size-32"));
            case THIRTY_FOUR -> click(By.id("checkbox-option-Size-34"));
            case THIRTY_SIX -> click(By.id("checkbox-option-Size-36"));
            case THIRTY_EIGHT -> click(By.id("checkbox-option-Size-38"));
            case SMALL -> click(By.id("checkbox-option-Size-Small"));
            case MEDIUM -> click(By.id("checkbox-option-Size-Medium"));
            case LARGE -> click(By.id("checkbox-option-Size-Large"));
            case XLARGE -> click(By.id("checkbox-option-Size-XLarge"));

        }


    }
    public void clickOnSortButton(Sort sort){
        click(By.cssSelector("div.ec-filter.ec-filter--sortby.ec-filter--section-sticky-bar div.ec-filter__head div.ec-filter__name.ec-header-h6"));
        switch (sort){

            case NEW -> click(By.id(NEW_SORT_ID));
            case LOW_TO_HIGH -> click(By.id(LOW_TO_HIGH_SORT_ID));
            case HIGH_TO_LOW -> click(By.id(HIGH_TO_LOW_SORT_ID));
            case TITLE_A_TO_Z -> click(By.id(TITLE_A_TO_Z_SORT_ID));
            case TITLE_Z_TO_A -> click(By.id(TITLE_Z_TO_A_SORT_ID));
        }


    }

    public void MoveSlider(int xOffset,int yOffset) {

        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PRICE_SLIDER_LEFT_RUNNER_SELECTOR)));
        WebElement slider = driver.findElement(By.cssSelector(PRICE_SLIDER_LEFT_RUNNER_SELECTOR));
        action.dragAndDropBy(slider,xOffset,yOffset).build().perform();

    }













}
