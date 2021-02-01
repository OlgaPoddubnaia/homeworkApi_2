package rename.service;

import com.google.gson.Gson;
import rename.dto.SpellerDto;

import java.util.HashMap;
import java.util.Map;

public class SpellerService extends CommonService {

    private SpellerService spellerService;


    public SpellerService getInstance() {
        if (spellerService == null)
            spellerService = new SpellerService();

        return spellerService;
    }
//не уверена который спеллер нужен
    public SpellerDto[] getDataByWord(String word) {
        return
                new CommonService()
                        .getNoParams(String.format(URI.GET_BY_COUNTRY_NAME_URI, name))
                        .getBody().as(CountryDto[].class);
    }

    public CountryDto[] getCountryByCode(String code) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("codes", code);

        return
                new Gson().fromJson(
                        new CommonService()
                                .getWithParams(URI.GET_BY_COUNTRY_CODE_URI, params)
                                .getBody().asString(), CountryDto[].class);
    }
}
