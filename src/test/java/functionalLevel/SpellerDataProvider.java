package functionalLevel;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

public class SpellerDataProvider extends parsingGson {

    private String jsonPathText = "src/test/resources/forCheckTextData.json";
    private String jsonPathTexts = "src/test/resources/forCheckTextsData.json";
    private Gson gson;
    private Object[][] dataObject;

    @DataProvider
    public Object[] dataFromJsonForText() {

        dataObject = importDataIntoProvider(jsonPathText);
        return dataObject;
    }

    @DataProvider
    public Object[][] dataFromJsonForTexts() {

        dataObject = importDataIntoProvider(jsonPathTexts);
        return dataObject;
    }
}