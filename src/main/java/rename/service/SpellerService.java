package rename.service;

import io.restassured.response.Response;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;

import java.util.HashMap;
import java.util.Map;

public class SpellerService extends CommonService {

    private SpellerService spellerService;
    String checkTextPoint = new URI().getCheckText();

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
}