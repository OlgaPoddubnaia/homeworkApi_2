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
        for (SpellerDto s : response
        ) {
            Assert.assertEquals(s.getWord(), spellerIncomeForText.getWord());

        }
        return this;
    }

    public SpellerAssertions resultWithOneWrongWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response
        ) {
            assertEquals(speller.getWord(),
                    speller.getWord(),
                    "No one or incorrect word in result");
        }
        return this;
    }

    public SpellerAssertions resultNotContainsWrongWord
            (SpellerDto[] response, String wrongString) {
        for (SpellerDto speller : response
        ) {
            Assert.assertNotEquals(speller.getWord(), wrongString);
        }
        return this;
    }

    public SpellerAssertions resultContainsWordInSArray
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response
        ) {
            List<String> sArray = Arrays.asList(speller.getS());
            System.out.println(speller.getS());
            List<String> spellerArray = Arrays.asList(spellerIncomeForText.getS());
            Assert.assertEquals(sArray, spellerArray);
        }
        return this;
    }

    public SpellerAssertions checkCodeInResult
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (SpellerDto speller : response
        ) {
            assertEquals(speller.getCode(),
                    spellerIncomeForText.getCode(),
                    "Code number is empty or isn't right");
        }
        return this;
    }
}