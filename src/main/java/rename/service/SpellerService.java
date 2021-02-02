package rename.service;

import com.google.gson.Gson;
import rename.dto.SpellerDto;

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

    public SpellerDto[] getDataByWord(String word) {
        return
                new CommonService()
                        .getNoParams(String.format(checkTextPoint, word))
                        .getBody().as(SpellerDto[].class);
    }

    public SpellerDto[] getDataByArray(String[] data) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("codes", data);

        return
                new Gson().fromJson(
                        new CommonService()
                                .getWithParams(checkTextsPoint, params)
                                .getBody().asString(), SpellerDto[].class);
    }
}
