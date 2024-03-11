package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    Properties properties;

    public ConfigLoader() throws IOException {
        DataLoading();
    }

    public void DataLoading() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        properties.load(inputStream);
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }
}
