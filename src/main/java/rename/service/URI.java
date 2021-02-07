package rename.service;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class URI {
    @Getter
    private String checkText;
    @Getter
    private String checkTexts;
    @Getter
    private String baseUrl;

    @SneakyThrows
    public URI() {
        Properties props = new Properties();
        FileInputStream filePath = new FileInputStream("src/test/resources/test-api.properties");
        props.load(filePath);
        baseUrl = props.getProperty("baseUrl");
        checkText = props.getProperty("checkText");
        checkTexts = props.getProperty("checkTexts");
    }
}