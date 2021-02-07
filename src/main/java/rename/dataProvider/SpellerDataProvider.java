package rename.dataProvider;

import org.testng.annotations.DataProvider;
import rename.dataProvider.ParsingGson;

public class SpellerDataProvider extends ParsingGson {

    @DataProvider(name = "dataFromJsonForText")
    public Object[][] dataFromJsonForText() {
        dataObject = importDataIntoProvider(jsonPathText);
        return dataObject;
    }

    @DataProvider(name = "dataFromJsonForTexts")
    public Object[][] dataFromJsonForTexts() {
        dataObject = importDataIntoProvider(jsonPathTexts);
        return dataObject;
    }
}