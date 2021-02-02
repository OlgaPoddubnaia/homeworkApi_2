package rename.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SpellerIncomeForTexts {
    private String[] text;
    private String lang;
    private String options;
    private String[] word;
    private String[] s;
    private String code;
}
