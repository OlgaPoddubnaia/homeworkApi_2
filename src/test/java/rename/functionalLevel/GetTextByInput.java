package rename.functionalLevel;

import org.testng.annotations.Test;
import rename.dto.SpellerIncome;
import rename.service.SpellerAssertions;

public class GetTextByInput {

    @Test(description = "Get data by text,lang,option,format")
    void getDataByInput() {
        String textToInput = "helloo";
        String langToInput = "en";
        String optionsToInput = "t";
        String formatToInput = "";


        SpellerIncome[] spellerIncomes = new SpellerIncome[]{
                new SpellerIncome().setText(textToInput)};

        spellerIncomes[0].setFormat(formatToInput);
        spellerIncomes[0].setOptions(optionsToInput);
        spellerIncomes[0].setLang(langToInput);


    }
