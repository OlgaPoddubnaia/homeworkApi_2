package rename.service;

import io.restassured.response.Response;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class SpellerService extends CommonService {

    private SpellerService spellerService;
    String checkTextPoint = new URI().getCheckText();
    String checkTextsPoint = new URI().getCheckTexts();


    public SpellerService getInstance() {
        if (spellerService == null)
            spellerService = new SpellerService();

        return spellerService;
    }

    public Response getDataByArray(SpellerIncomeForTexts spellerIncomeForTexts) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", spellerIncomeForTexts.getText());
        params.put("lang", spellerIncomeForTexts.getLang());
        params.put("options", spellerIncomeForTexts.getOptions());
        return getWithParams(checkTextsPoint, params);
    }

    public Response getDataByString(SpellerIncomeForText spellerIncomeForText) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", spellerIncomeForText.getText());
        params.put("lang", spellerIncomeForText.getLang());
        params.put("options", spellerIncomeForText.getOptions());
        return getWithParams(checkTextPoint, params);
    }

    public SpellerDto[] responseForText(Response response) {
        return response
                .then().extract().body().as((Type) SpellerDto[].class);
    }

    public SpellerDto[] responseForTexts(Response response) {
        return response
                .then().extract().body().as((Type) SpellerDto[][].class);
    }
}





