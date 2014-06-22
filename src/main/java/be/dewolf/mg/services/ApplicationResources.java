package be.dewolf.mg.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yannis on 22/06/14.
 */
@Component
public class ApplicationResources {

    @Value("${moviedb.url.base}")
    private String movieDbUrlBase;

    @Value("${moviedb.api.key}")
    private String movieDbApiKey;

    public String getMovieDbUrlBase() {
        return movieDbUrlBase;
    }

    public String getMovieDbApiKey() {
        return movieDbApiKey;
    }

    public String getEncoding() {
        return "UTF-8";
    }
}
