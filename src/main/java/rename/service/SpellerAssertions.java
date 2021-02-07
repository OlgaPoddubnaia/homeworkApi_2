package rename.service;

import org.testng.Assert;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;
import rename.dto.SpellerIncomeForTexts;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SpellerAssertions {

    public SpellerAssertions resultContainsRightWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto s : response) {
            Assert.assertEquals(s.getWord(), spellerIncomeForText.getWord(),
                    "Result does not contains expected words");

        }
        return this;
    }

    public SpellerAssertions resultWithOneWrongWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response) {
            assertEquals(speller.getWord(),
                    speller.getWord(),
                    "No one or incorrect word in result");
        }
        return this;
    }

    public SpellerAssertions resultNotContainsWrongWord
            (SpellerDto[] response, String wrongString) {
        for (SpellerDto speller : response) {
            Assert.assertNotEquals(speller.getWord(), wrongString, "Result does contains wrong word");
        }
        return this;
    }

    public SpellerAssertions resultContainsWordInSArray
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response) {
            List<String> sArray = Arrays.asList(speller.getS());
            List<String> spellerArray = Arrays.asList(spellerIncomeForText.getS());
            Assert.assertEquals(sArray, spellerArray, "Results does not contain expected words");
        }
        return this;
    }

    public SpellerAssertions checkCodeInResult
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response) {
            assertEquals(speller.getCode(),
                    spellerIncomeForText.getCode(),
                    "Code number is empty or isn't right");
        }
        return this;
    }

    public SpellerAssertions containsRightWords(SpellerDto[][] response, SpellerIncomeForTexts spellerIncomeForTexts) {
        if (response[0].length > 0) {
            for (int i = 0; i < response[0].length; ++i) {
                List<SpellerDto[]> listDtoArr = Arrays.asList(response);
                List<String> list = Arrays.asList(((SpellerDto[]) listDtoArr.get(0))[i].getS());
                String[] arrayS = ((SpellerDto[]) listDtoArr.get(0))[i].getS();
                for (int j = 0; j < arrayS.length; ++j) {
                    String expected = arrayS[i];
                    Assert.assertTrue(spellerIncomeForTexts.getS()[i].contains(expected),
                            "Results does not contain expected words");
                }
            }
        }
        return this;
    }

    public SpellerAssertions doesNotContainsWrongWords(SpellerDto[][] response, SpellerIncomeForTexts incomeForTexts,
                                                String wrongS) {
        if (response[0].length > 0) {
            for (int i = 0; i < response[0].length; ++i) {
                List<SpellerDto[]> listDtoArr = Arrays.asList(response);
                List<String> list = Arrays.asList(((SpellerDto[]) listDtoArr.get(0))[i].getS());
                String[] arrayS = ((SpellerDto[]) listDtoArr.get(0))[i].getS();
                for (int j = 0; j < arrayS.length; ++j) {
                    String expected = arrayS[i];
                    Assert.assertNotEquals(incomeForTexts.getS()[i], wrongS,
                            "Result does contains wrong word");

                }
            }
        }
        return this;
    }
}