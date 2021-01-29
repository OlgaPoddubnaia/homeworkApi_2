package rename.dto;

import java.util.List;
import java.util.Objects;

public class SpellerDto2 {
    private Integer code;
    private Integer pos;
    private Integer row;
    private Integer col;
    private Integer len;
    private String word;
    private List<String> s;

    public SpellerDto2(Integer code, Integer pos, Integer row, Integer col,
                       Integer len, String word, List<String> s) {
        this.code = code;
        this.pos = pos;
        this.row = row;
        this.col = col;
        this.len = len;
        this.word = word;
        this.s = s;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getS() {
        return s;
    }

    public void setS(List<String> s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpellerDto2 that = (SpellerDto2) o;
        return Objects.equals(code, that.code) && Objects.equals(pos, that.pos)
                && Objects.equals(row, that.row) && Objects.equals(col, that.col)
                && Objects.equals(len, that.len) && Objects.equals(word, that.word)
                && Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, pos, row, col, len, word, s);
    }

    @Override
    public String toString() {
        return "SpellerDto2{" +
                "code=" + code +
                ", pos=" + pos +
                ", row=" + row +
                ", col=" + col +
                ", len=" + len +
                ", word='" + word + '\'' +
                ", s=" + s +
                '}';
    }
}
