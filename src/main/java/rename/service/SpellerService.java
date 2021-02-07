package rename.service;

import io.restassured.response.Response;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.util.HashMap;
import java.util.Map;

public class SpellerService extends CommonService {

    String checkTextPoint = new URI().getCheckText();
    String checkTextsPoint = new URI().getCheckTexts();

    public Response getDataByString(SpellerIncomeForText spellerIncomeForText) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", spellerIncomeForText.getText());
        params.put("lang", spellerIncomeForText.getLang());
        params.put("options", spellerIncomeForText.getOptions());
        return getWithParams(checkTextPoint, params);
    }

    public SpellerDto[] responseForText(Response response) {
        return response
                .then().extract().body().as(SpellerDto[].class);
    }

    public Response getDataByArray(SpellerIncomeForTexts spellerIncomeForTexts) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", spellerIncomeForTexts.getText());
        params.put("lang", spellerIncomeForTexts.getLang());
        params.put("options", spellerIncomeForTexts.getOptions());
        return getWithParams(checkTextsPoint, params);
    }

    public SpellerDto[][] responseForTexts(Response response) {
        return response
                .then().extract().body().as(SpellerDto[][].class);
    }
}