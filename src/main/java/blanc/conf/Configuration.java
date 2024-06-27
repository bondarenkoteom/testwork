package blanc.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    Properties appProps = new Properties();

    public String getUri() {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/uri.properties");
            appProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps.get("URL").toString();
    }

}
