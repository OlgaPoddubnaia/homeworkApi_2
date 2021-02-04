package rename.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellerDto {
    private String code;
    private String word;
    private String[] s;
    private String pos;
    private String row;
    private String col;
    private String len;
}