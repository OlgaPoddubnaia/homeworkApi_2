package rename.service;

import lombok.SneakyThrows;

import java.util.Properties;

public class URI {
    private String checkText;
    private String checkTexts;
    String baseUrl;

    @SneakyThrows
    public URI() {
        Properties props = new Properties();
        String propFileName = "test-api.properties.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
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
