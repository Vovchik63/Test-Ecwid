package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.SizeFilters;
import util.Sort;

import java.util.ArrayList;
import java.util.List;

import static util.SizeFilters.*;
import static util.Sort.NEW;


public class SearchDemoShopTest extends BaseTest {
    @Test
    public void mensApparelFilterTest(){
       steps.executeCheckForManApparelFilter()
               .verifyThatMensApparelFilterIsWork();
    }
    @Test
    public void womanApparelFilterTest(){
        steps.executeCheckForWomanApparelFilter()
                .verifyThatWomanApparelFilterIsWork();
    }
    @Test
    public void surfboardsFilterTest(){
        steps.executeCheckForSurfboardsFilter()
                .verifySurboardsFilterIsWork();
    }
    @Test(dataProvider = "dataProviderSizeFilters")
    public void sizeFilterTest(SizeFilters filters){
        steps.executeCheckForSizeFilter(filters)
                .verifySizeFilterIsWork(filters);
}

    @Test
    public void priceFilterTest(){

     try {
         steps.executeMovePriceSlider()
                 .verifyFilterPriceIsWork();
     }catch (org.openqa.selenium.StaleElementReferenceException ex){
         steps.executeMovePriceSlider()
                 .verifyFilterPriceIsWork();
     }

    }

    @Test(dataProvider = "dataProviderSort")
    public void SortRelevance(Sort sort){
    steps.executeClickForSortButton(sort)
            .verifySortButtonIsWork(sort);
    }










}
