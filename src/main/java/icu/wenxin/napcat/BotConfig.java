package icu.wenxin.napcat;

import lombok.Builder;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Data
@Builder
public class BotConfig {
    private String protocol;
    private String host;
    private String accessToken;
    private Integer port;

    public String getUrl() {
        return protocol + "://" + host + ":" + port + "?access_token=" + accessToken;
    }

}
