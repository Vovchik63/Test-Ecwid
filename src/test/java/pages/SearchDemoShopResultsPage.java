package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.SizeFilters;
import util.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchDemoShopResultsPage extends BasePage {
    private final String REGEX_FOR_EXTRACT_FROM_CATEGORY_AND_SIZE_FILTERS = "Size=Large|Size=Medium|Size=Small|Size=XLarge|Size=\\d{2}";
    private final String REGEX_FOR_EXTRACT_FROM_IN_STOCK_FILTER = "inventory=instock";
    private final String REGEX_FOR_EXTRACT_FROM_NEW_SORT = "sort=addedTimeDesc";
    private final String REGEX_FOR_EXTRACT_FROM_PRICE_LOW_TO_HIGH_SORT = "sort=priceAsc";
    private final String REGEX_FOR_EXTRACT_FROM_PRICE_HIGH_TO_LOW_SORT = "sort=priceDesc";
    private final String REGEX_FOR_EXTRACT_FROM_TITLE_A_TO_Z_SORT = "nameAsc";
    private final String REGEX_FOR_EXTRACT_FROM_TITLE_Z_TO_Z_SORT = "sort=nameDesc";
    private final String REGEX_FOR_EXTRACT_FROM_PRICE = "priceFrom=";
    private final String MENS_APPAREL_FILTER = "20671018";
    private final String SURFBOARDS_FILTER = "20671017";
    private final String WOMAN_APPAREL_FILTER = "20671019";
    private String addressWithAllSizeFilters = "https://www.ecwid.ru/demo/search?option_Size=30,32,34,36,38,Large,Medium,Small,XLarge";

    private final String SIZE_FILTER_THIRTY = "Size=30";
    private final String SIZE_FILTER_THIRTY_TWO = "Size=32";
    private final String SIZE_FILTER_THIRTY_FOUR = "Size=34";
    private final String SIZE_FILTER_THIRTY_SIX = "Size=36";
    private final String SIZE_FILTER_THIRTY_EIGHT = "Size=38";
    private final String SIZE_FILTER_SMALL = "Size=Small";
    private final String SIZE_FILTER_MEDIUM = "Size=Medium";
    private final String SIZE_FILTER_LARGE = "Size=Large";
    private final String SIZE_FILTER_XLARGE = "Size=XLarge";
    private final String INVENTORY_INSTOCK_FILTER = "inventory=instock";

    private final String NEW_SORT = "sort=addedTimeDesc";
    private final String PRICE_LOW_TO_HIGH_SORT = "sort=priceAsc";
    private final String PRICE_HIGH_TO_LOW_SORT = "sort=priceDesc";
    private final String TITLE_A_TO_Z_SORT = "nameAsc";
    private final String TITLE_Z_TO_A_SORT = "sort=nameDesc";
    private final String PRICE_VALUE_RESULT = "span.ec-pill__text-inner";


    public void assertManApparelIsShowItems(){
        String itemsCheck = getPageAddress().replaceAll("[\\D]","");
        assertThat(itemsCheck).as("The man apparel filter does not match the selected").isEqualTo(MENS_APPAREL_FILTER);
    }
    public void assertWomanApparelIsShowItems(){
        String itemsCheck = getPageAddress().replaceAll("[\\D]","");
        assertThat(itemsCheck).as("The woman apparel filter does not match the selected").isEqualTo(WOMAN_APPAREL_FILTER);
    }
    public void assertSurfboardsIsShowItems(){
        String itemsCheck = getPageAddress().replaceAll("[\\D]","");
        assertThat(itemsCheck).as("The surfboards filter does not match the selected").isEqualTo(SURFBOARDS_FILTER);
    }
    public void assertSizeFiltersShowItems(SizeFilters filters){
        String itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_CATEGORY_AND_SIZE_FILTERS);
        switch (filters){
            case THIRTY -> assertThat(itemsCheck).as("Filter must show items with size "+SIZE_FILTER_THIRTY+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_THIRTY);
            case THIRTY_TWO -> assertThat(itemsCheck).as("Filter must show items with size "+SIZE_FILTER_THIRTY_TWO+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_THIRTY_TWO);
            case THIRTY_FOUR -> assertThat(itemsCheck).as("Filter must show items with size "+SIZE_FILTER_THIRTY_FOUR+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_THIRTY_FOUR);
            case THIRTY_SIX -> assertThat(itemsCheck).as("Filter must show items with size "+SIZE_FILTER_THIRTY_SIX+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_THIRTY_SIX);
            case THIRTY_EIGHT -> assertThat(itemsCheck).as("Filter must show items with size "+SIZE_FILTER_THIRTY_EIGHT+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_THIRTY_EIGHT);
            case SMALL -> assertThat(itemsCheck).as("Filter must show items with size "+ SIZE_FILTER_SMALL +" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_SMALL);
            case MEDIUM -> assertThat(itemsCheck).as("Filter must show items with size "+ SIZE_FILTER_MEDIUM +" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_MEDIUM);
            case LARGE -> assertThat(itemsCheck).as("Filter must show items with size "+ SIZE_FILTER_LARGE +" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_LARGE);
            case XLARGE -> assertThat(itemsCheck).as("Filter must show items with size "+ SIZE_FILTER_XLARGE+" but show size "+itemsCheck+"").isEqualTo(SIZE_FILTER_XLARGE);
        }

    }
    public void assertSortShowItems(Sort sort){
        String itemsCheck = null;
        switch (sort){

            case NEW -> {
                itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_NEW_SORT);
                assertThat(itemsCheck).as("Sort must be show address as "+ NEW_SORT +" but show as "+itemsCheck+"").isEqualTo(NEW_SORT);

            }
            case LOW_TO_HIGH -> {
                itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_PRICE_LOW_TO_HIGH_SORT);
                assertThat(itemsCheck).as("Sort must be show address as "+ PRICE_LOW_TO_HIGH_SORT +" but show as "+itemsCheck+"").isEqualTo(PRICE_LOW_TO_HIGH_SORT);

            }
            case HIGH_TO_LOW -> {
                itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_PRICE_HIGH_TO_LOW_SORT);
                assertThat(itemsCheck).as("Sort must be show address as "+ PRICE_HIGH_TO_LOW_SORT +" but show as "+itemsCheck+"").isEqualTo(PRICE_HIGH_TO_LOW_SORT);

            }
            case TITLE_A_TO_Z -> {
                itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_TITLE_A_TO_Z_SORT);
                assertThat(itemsCheck).as("Sort must be show address as "+ TITLE_A_TO_Z_SORT +" but show as "+itemsCheck+"").isEqualTo(TITLE_A_TO_Z_SORT);

            }
            case TITLE_Z_TO_A  -> {
                itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_TITLE_Z_TO_Z_SORT);
                assertThat(itemsCheck).as("Sort must be show address as "+ TITLE_Z_TO_A_SORT +" but show as "+itemsCheck+"").isEqualTo(TITLE_Z_TO_A_SORT);

            }
        }
    }

    public void assertInstockFiltersShowItems(){
        String itemsCheck = extractSubstringFromAddress(getPageAddress(),REGEX_FOR_EXTRACT_FROM_IN_STOCK_FILTER);
        assertThat(itemsCheck).as("Filter must show items with "+INVENTORY_INSTOCK_FILTER+" but show "+itemsCheck+"").isEqualTo(INVENTORY_INSTOCK_FILTER);

    }

    public void assertPriceFilterCorrectShowItems(){
        List<Double> list = getDoubleValueFromWebElementsArrays();
        double resFromList = list.get(0);
        double resFromPage = getValueFromPriceFilterResult();
        assertThat(resFromList>=resFromPage).isTrue();
        System.out.println(resFromList+" "+resFromPage);

    }

    public double getValueFromPriceFilterResult(){
        return getIntValueFromElement(By.cssSelector(PRICE_VALUE_RESULT));

    }





    public String extractSubstringFromAddress(String url, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find())
        {
            url = matcher.group();
        }
        return url;
    }

    public List<Double> getDoubleValueFromWebElementsArrays(){
        List<WebElement> list = getArrayWebElements(By.cssSelector("div.grid-product__price-value.ec-price-item"));
        List<Double> result = new ArrayList<>();
        for (WebElement element:list){
            Double resValue = Double.valueOf(element.getText().replaceAll("[а-я-А-Я-a-z-A-Z-$]",""));
            result.add(resValue);
        }
        Collections.sort(result);
        return result;
    }









}
