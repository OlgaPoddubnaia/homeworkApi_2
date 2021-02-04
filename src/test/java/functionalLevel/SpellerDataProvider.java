package functionalLevel;

import org.testng.annotations.DataProvider;

public class SpellerDataProvider extends parsingGson {

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