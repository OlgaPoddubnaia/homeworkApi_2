package functionalLevel;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;
import rename.service.SpellerAssertions;
import rename.service.SpellerService;

public class SpellerTests {

    private SpellerAssertions spellerAssertions;
    private SpellerService spellerService;

    @BeforeClass
    public void defineEntities() {
        spellerAssertions = new SpellerAssertions();
        spellerService = new SpellerService();
    }


    @Test(dataProvider = "dataFromJsonForText", dataProviderClass = GetTextByInput.class)
    public void checkText(SpellerIncomeForText spellerIncomeForText) {
        Response response = spellerService.getDataByString(spellerIncomeForText);
        SpellerDto[] actualResult =spellerService.responseForText(response);
       spellerAssertions
                .containsRightWord(actualResult,spellerIncomeForText);
    }

    @Test(dataProvider = "dataFromJsonForTexts", dataProviderClass = GetTextByInput.class)
    public void checkTexts(SpellerIncomeForTexts spellerIncomeForTexts) {

        Response response = spellerService.getDataByArray(spellerIncomeForTexts);
        SpellerDto[][] actualResult =spellerService.responseForTexts(response);

       spellerAssertions
                .containsRightWords(actualResult,spellerIncomeForTexts);
    }


}
