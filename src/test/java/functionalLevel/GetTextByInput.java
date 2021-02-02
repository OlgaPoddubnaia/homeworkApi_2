package functionalLevel;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapper;
import org.testng.annotations.DataProvider;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class GetTextByInput {

    private String jsonPathText = "src/test/resources/forCheckTextData.json";
    private String jsonPathTexts = "src/test/resources/forCheckTextsData.json";
    prvivate Gson gson;
    private static FileInputStream fileInputStream;
    private static ObjectMapper objectMapper;
    private static Object[][] dataObject;
    private SpellerIncomeForText[] spellerIncomeForText;
    private SpellerIncomeForTexts[] spellerIncomeForTexts;


    public Object[][] importDataIntoProvider(String path) {

        gson = new Gson();
        try {
            fr = new FileReader(path);
            if (path.equals(filePathToTextData)) {
                textDataArr = gson.fromJson(fr, DataForText[].class);
                dataProviderArray = new Object[textDataArr.length][1];
                for (int j = 0; j < textDataArr.length; j++) {
                    dataProviderArray[j][0] = textDataArr[j];
                }
            }
            if (path.equals(filePathToTextsData)) {
                dataForTexts = gson.fromJson(fr, DataForTexts[].class);
                dataProviderArray = new Object[dataForTexts.length][1];
                for (int j = 0; j < dataForTexts.length; j++) {
                    dataProviderArray[j][0] = dataForTexts[j];
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
