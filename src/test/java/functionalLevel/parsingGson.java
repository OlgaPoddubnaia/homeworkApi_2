package functionalLevel;

import com.google.gson.Gson;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class parsingGson {

    protected String jsonPathText = "src/test/resources/forCheckTextData.json";
    protected String jsonPathTexts = "src/test/resources/forCheckTextsData.json";
    private Gson gson;
    private FileReader fileReader;
    protected Object[][] dataObject;
    private SpellerIncomeForText[] spellerIncomeForText;
    private SpellerIncomeForTexts[][] spellerIncomeForTexts;

    public Object[][] importDataIntoProvider(String path) {
        gson = new Gson();
        try {
            fileReader = new FileReader(path);
            if (path.equals(jsonPathText)) {
                spellerIncomeForText = gson.fromJson(fileReader, SpellerIncomeForText[].class);
                dataObject = new Object[spellerIncomeForText.length][1];
                for (int i = 0; i < spellerIncomeForText.length; i++) {
                    dataObject[i][0] = spellerIncomeForText[i];
                }

            } else if (path.equals(jsonPathTexts)) {
                spellerIncomeForTexts = gson.fromJson(fileReader, SpellerIncomeForTexts[][].class);
                dataObject = new Object[spellerIncomeForTexts.length][1];
                for (int i = 0; i < spellerIncomeForTexts.length; i++) {
                    dataObject[i][0] = spellerIncomeForTexts[i];
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataObject;
    }
}
