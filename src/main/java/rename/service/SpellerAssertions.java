package rename.service;

import org.testng.Assert;
import rename.dto.SpellerDto;
import rename.dto.SpellerIncomeForText;

public class SpellerAssertions {

    private SpellerIncomeForText[] spellerData;

    public SpellerAssertions containsRightWord
            (SpellerDto[] response, SpellerIncomeForText spellerIncomeForText) {
        Assert.assertEquals(response[0].getWord(), spellerIncomeForText.getWord());
        return this;
    }
}
