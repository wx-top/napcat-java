package icu.wenxin.napcat.core;

import lombok.Data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Data
public class BotConfig {
    private String protocol;
    private String host;
    private String accessToken;
    private Integer port;

    public URI getUrl() throws URISyntaxException {
        return new URI(protocol + "://" + host + ":" + port + "?access_token=" + accessToken);
    }

}
