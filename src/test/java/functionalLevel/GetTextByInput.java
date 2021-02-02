package functionalLevel;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class GetTextByInput {

    private String jsonPathText = "src/test/resources/forCheckTextData.json";
    private String jsonPathTexts = "src/test/resources/forCheckTextsData.json";
    private Gson gson;
    private FileReader fileReader;
    private Object[][] dataObject;
    private SpellerIncomeForText[] spellerIncomeForText;
    private SpellerIncomeForTexts[] spellerIncomeForTexts;


    public Object[][] importDataIntoProvider(String path) {

        gson = new Gson();
        try {
            fileReader = new FileReader(path);
            if (path.equals(jsonPathText)) {
                spellerIncomeForText = gson.fromJson(fileReader, SpellerIncomeForText[].class);
                dataObject = new Object[spellerIncomeForText.length][1];
                for (int j = 0; j < spellerIncomeForText.length; j++) {
                    dataObject[j][0] = spellerIncomeForText[j];
                }
            }
            if (path.equals(jsonPathTexts)) {
                spellerIncomeForTexts = gson.fromJson(fileReader, SpellerIncomeForTexts[].class);
                dataObject = new Object[spellerIncomeForTexts.length][1];
                for (int j = 0; j < spellerIncomeForTexts.length; j++) {
                    dataObject[j][0] = spellerIncomeForTexts[j];
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataObject;
    }

    @DataProvider
    public Object[][] dataFromJsonForText() {

        dataObject = importDataIntoProvider(jsonPathText);
        return dataObject;
    }

    @DataProvider
    public Object[][] dataFromJsonForTexts() {

        dataObject = importDataIntoProvider(jsonPathTexts);
        return dataObject;
    }


}
