package rename.service;

import org.testng.Assert;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SpellerAssertions {

    public SpellerAssertions resultContainsRightWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            Assert.assertEquals(response[i].getWord(), spellerIncomeForText.getWord());
        }
        return this;
    }

    public SpellerAssertions resultWithOneWrongWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            assertEquals(response[i].getWord(),
                    response[i].getWord(),
                    "No one or incorrect word in result");
        }
        return this;
    }

    public SpellerAssertions resultNotContainsWrongWord
            (SpellerDto[] response, String wrongString) {
        for (int i = 0; i < response.length; i++) {
            Assert.assertNotEquals(response[i].getWord(), wrongString);
        }
        return this;
    }

    public SpellerAssertions resultContainsWordInSArray
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            List<String> sArray = Arrays.asList(response[i].getS());
            System.out.println(response[i].getS());
            List<String> spellerArray = Arrays.asList(spellerIncomeForText.getS());
            Assert.assertEquals(sArray, spellerArray);
        }
        return this;
    }

    public SpellerAssertions checkCodeInResult
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            assertEquals(response[i].getCode(),
                    spellerIncomeForText.getCode(),
                    "Code number is empty or isn't right");
        }
        return this;
    }
}