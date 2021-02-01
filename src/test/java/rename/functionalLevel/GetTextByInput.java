package rename.functionalLevel;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import rename.dto.SpellerIncome;
import rename.service.SpellerAssertions;

public class GetTextByInput {

   /* @Test(description = "Get data by text,lang,option,format")
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


    }*/

    @Test
    void yandexSpellerPositiveTest() {
        String body =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spel=\"http://speller.yandex.net/services/spellservice\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <spel:CheckTextRequest lang=\"?\" options=\"0\" format=\"\">\n" +
                        "         <spel:text>lilt</spel:text>\n" +
                        "      </spel:CheckTextRequest>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        RestAssured
                .given().body(body)
                .when().post("http://speller.yandex.net/services/spellservice")
                .then().header()
    }
}
