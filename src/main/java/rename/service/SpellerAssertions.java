package rename.service;

import org.testng.Assert;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;

public class SpellerAssertions {

    private SpellerIncomeForText[] spellerData;

    public SpellerAssertions containsRightWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        for (int i = 0; i < response.length; i++) {
            Assert.assertEquals(response[i].getWord(), spellerIncomeForText.getWord());
        }
        return this;
    }
}
