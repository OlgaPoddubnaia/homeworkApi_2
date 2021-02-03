package rename.service;

import org.testng.Assert;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SpellerAssertions {

    private SpellerIncomeForText[] spellerData;

    public SpellerAssertions containsRightWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            Assert.assertEquals(response[i].getWord(), spellerIncomeForText.getWord());
        }
        return this;
    }

    public SpellerAssertions containsRightWords
            (SpellerDto[][] response, SpellerIncomeForTexts spellerIncomeForTexts) {
        /*for (int i = 0; i < response[i].length; i++) {
            for (int j = 0; j < response[i].length; i++) {
                Assert.assertEquals(response[i][j].getWord(), spellerIncomeForTexts.getWord());
            }
        }*/
        if (response[0].length > 0) {
            for (int i = 0; i < response[0].length; i++) {
                List<SpellerDto[]> listDtoArr = Arrays.asList(response);
                List<String> list = Arrays.asList(listDtoArr.get(0)[i].getS());
                String[] arrayS=listDtoArr.get(0)[i].getS();

                for (int j = 0; j < arrayS.length; j++) {
                   String expected =arrayS[i];
                   Assert.assertTrue(spellerIncomeForTexts.getS()[i].contains(expected));
                }

               // String expectedRightWord = dataForTexts.getS()[i];
                //assertTrue(list.contains(expectedRightWord), "There is not eny match in right word list");
            }
        }
        /*for (int i = 0; i < response[0].length; i++) {
            List<SpellerDto[]> listSpeller = Arrays.asList(response);
            List<String> list = Arrays.asList(listSpeller.get(0)[i].getS());
            String expectedRightWord = spellerIncomeForTexts.getS()[i];
            Assert.assertEquals(list.contains(expectedRightWord));
        }*/
        return this;
    }
}
