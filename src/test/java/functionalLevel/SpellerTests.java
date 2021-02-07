package functionalLevel;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;
import rename.service.SpellerAssertions;
import rename.dataProvider.SpellerDataProvider;
import rename.service.SpellerService;

public class SpellerTests {

    private SpellerAssertions spellerAssertions;
    private SpellerService spellerService;

    @BeforeClass
    public void defineEntities() {
        spellerAssertions = new SpellerAssertions();
        spellerService = new SpellerService();
    }

    @Test(dataProvider = "dataFromJsonForText", dataProviderClass = SpellerDataProvider.class)
    public void checkIfTextContains(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult = spellerService.responseForText(response);
        spellerAssertions
                .resultContainsRightWord(actualResult, spellerIncomeForText)
                .resultNotContainsWrongWord(actualResult, "Hello")
                .resultContainsWordInSArray(actualResult, spellerIncomeForText)
                .resultWithOneWrongWord(actualResult, spellerIncomeForText);

    }

    @Test(dataProvider = "dataFromJsonForText", dataProviderClass = SpellerDataProvider.class)
    public void checkCodeInResults(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult = spellerService.responseForText(response);
        spellerAssertions.checkCodeInResult(actualResult, spellerIncomeForText);
    }

    @Test(dataProvider = "dataFromJsonForTexts", dataProviderClass = SpellerDataProvider.class)
    public void checkTextsContainRightWords(SpellerIncomeForTexts spellerIncomeForTexts) {
        Response response = spellerService.getDataByArray(spellerIncomeForTexts);
        SpellerDto[][] actualResult = spellerService.responseForTexts(response);
        spellerAssertions.containsRightWords(actualResult, spellerIncomeForTexts);
    }

    @Test(dataProvider = "dataFromJsonForTexts", dataProviderClass = SpellerDataProvider.class)
    public void checkTextsDoesNotContainWrongWords(SpellerIncomeForTexts spellerIncomeForTexts) {
        Response response = spellerService.getDataByArray(spellerIncomeForTexts);
        SpellerDto[][] actualResult = spellerService.responseForTexts(response);
        spellerAssertions.doesNotContainsWrongWords(actualResult, spellerIncomeForTexts, "WrongString");
    }


}