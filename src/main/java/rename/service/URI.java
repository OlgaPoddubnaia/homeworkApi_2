package rename.service;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class URI {
    private String checkText;
    private String checkTexts;
    String baseUrl;

    @SneakyThrows
    public URI() {
        Properties props = new Properties();
        FileInputStream filePath = new FileInputStream("src/test/resources/test-api.properties");
        props.load(filePath);
        baseUrl = props.getProperty("baseUrl");
        checkText = props.getProperty("checkText");
        checkTexts = props.getProperty("checkTexts");
    }

    public String getCheckText() {
        return checkText;
    }

    public String getCheckTexts() {
        return checkTexts;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}