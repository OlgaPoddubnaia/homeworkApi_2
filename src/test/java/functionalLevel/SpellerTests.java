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
    public void checkIfTextContainsWord(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult = spellerService.responseForText(response);
        spellerAssertions
                .resultContainsRightWord(actualResult, spellerIncomeForText)
                .resultContainsWordInSArray(actualResult, spellerIncomeForText);
    }

    @Test(dataProvider = "dataFromJsonForText", dataProviderClass = SpellerDataProvider.class)
    public void checkIfTextNotContainsWord(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult = spellerService.responseForText(response);
        spellerAssertions
                .resultNotContainsWrongWord(actualResult, "Hello")
                .resultWithOneWrongWord(actualResult, spellerIncomeForText);
    }

    @Test(dataProvider = "dataFromJsonForText", dataProviderClass = SpellerDataProvider.class)
    public void checkCodeInResults(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult = spellerService.responseForText(response);
        spellerAssertions.checkCodeInResult(actualResult, spellerIncomeForText);
    }

    @Test(dataProvider = "dataFromJsonForTexts", dataProviderClass = SpellerDataProvider.class)
    public void checkTextsContainRightWordsInArray(SpellerIncomeForTexts spellerIncomeForTexts) {
        Response response = spellerService.getDataByArray(spellerIncomeForTexts);
        SpellerDto[][] actualResult = spellerService.responseForTexts(response);
        spellerAssertions
                .containsRightWords(actualResult, spellerIncomeForTexts)
                .doesNotContainsWrongWords(actualResult, spellerIncomeForTexts, "WrongString");
    }

    @Test(dataProvider = "dataFromJsonForTexts", dataProviderClass = SpellerDataProvider.class)
    public void checkNumberOfResultsInArray(SpellerIncomeForTexts spellerIncomeForTexts) {
        Response response = spellerService.getDataByArray(spellerIncomeForTexts);
        SpellerDto[][] actualResult = spellerService.responseForTexts(response);
        spellerAssertions.checkNumberOfResults(actualResult, spellerIncomeForTexts);
    }
}