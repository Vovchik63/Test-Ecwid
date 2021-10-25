package steps;

import pages.SearchDemoShopResultsPage;
import util.SizeFilters;
import util.Sort;

public class SearchDemoShopResultsSteps {
    SearchDemoShopResultsPage searchDemoShopResultsPage = new SearchDemoShopResultsPage();

    public SearchDemoShopResultsSteps verifyThatMensApparelFilterIsWork() {
        searchDemoShopResultsPage.assertManApparelIsShowItems();
        return this;
    }

    public SearchDemoShopResultsSteps verifyThatWomanApparelFilterIsWork() {
        searchDemoShopResultsPage.assertWomanApparelIsShowItems();
        return this;
    }

    public SearchDemoShopResultsSteps verifySurboardsFilterIsWork() {
        searchDemoShopResultsPage.assertSurfboardsIsShowItems();
        return this;
    }
    public SearchDemoShopResultsSteps verifySizeFilterIsWork(SizeFilters filters) {
        searchDemoShopResultsPage.assertSizeFiltersShowItems(filters);
        return this;
    }
    public SearchDemoShopResultsSteps verifyInstockFilterIsWork(){
        searchDemoShopResultsPage.assertInstockFiltersShowItems();
        return this;
    }

    public SearchDemoShopResultsSteps verifyFilterPriceIsWork(){
        searchDemoShopResultsPage.assertPriceFilterCorrectShowItems();
        return this;
    }

    public SearchDemoShopResultsSteps verifySortButtonIsWork(Sort sort){
        searchDemoShopResultsPage.assertSortShowItems(sort);
        return this;
    }


}