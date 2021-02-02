package rename.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellerDto {
    private Integer code;
    private Integer pos;
    private Integer row;
    private Integer col;
    private Integer len;
    private String word;
    private String[] s;

}
