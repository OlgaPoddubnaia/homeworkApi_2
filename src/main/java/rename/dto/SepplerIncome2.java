package rename.dto;

import java.util.Objects;

public class SepplerIncome2 {
    private String text;
    private String lang;
    private String options;
    private String format;

    public SepplerIncome2(String text, String lang, String options, String format) {
        this.text = text;
        this.lang = lang;
        this.options = options;
        this.format = format;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "SepplerIncome2{" +
                "text='" + text + '\'' +
                ", lang='" + lang + '\'' +
                ", options='" + options + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SepplerIncome2 that = (SepplerIncome2) o;
        return Objects.equals(text, that.text) && Objects.equals(lang, that.lang) && Objects.equals(options, that.options) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, lang, options, format);
    }
}
