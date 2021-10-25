package steps;

import pages.SearchDemoShopPage;
import pages.SearchDemoShopResultsPage;
import util.SizeFilters;
import util.Sort;

public class SearchDemoShopPageSteps {

    SearchDemoShopPage searchDemoShopPage = new SearchDemoShopPage();

    public SearchDemoShopResultsSteps executeCheckForManApparelFilter(){
        searchDemoShopPage.clickMensApparel();
        return new SearchDemoShopResultsSteps();

    }
    public SearchDemoShopResultsSteps executeCheckForWomanApparelFilter() {
        searchDemoShopPage.clickWomenApparelFilter();
        return new SearchDemoShopResultsSteps();
    }
    public SearchDemoShopResultsSteps executeCheckForSurfboardsFilter() {
        searchDemoShopPage.clickSurfboardsFilter();
        return new SearchDemoShopResultsSteps();
    }
    public SearchDemoShopResultsSteps executeCheckForSizeFilter(SizeFilters filters) {
        searchDemoShopPage.clickSizeFilter(filters);
        return new SearchDemoShopResultsSteps();
    }

    public SearchDemoShopResultsSteps executeClickForInstockFilter(){
        searchDemoShopPage.clickInstockFilter();
        return new SearchDemoShopResultsSteps();
    }

    public SearchDemoShopResultsSteps executeMovePriceSlider(){
        searchDemoShopPage.MoveSlider(20,0);
        return new SearchDemoShopResultsSteps();
    }

    public SearchDemoShopResultsSteps executeClickForSortButton(Sort sort){
        searchDemoShopPage.clickOnSortButton(sort);
        return new SearchDemoShopResultsSteps();

    }



}
