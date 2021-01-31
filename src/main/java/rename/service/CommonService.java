package rename.service;

import lombok.SneakyThrows;

import java.util.Properties;

public class CommonService {
    //тут дб реализация спецификаций класса

    @SneakyThrows
    private Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "test-api.properties.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return props;
    }




}
