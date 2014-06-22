package be.dewolf.mg.moviedb;

import be.dewolf.mg.services.ApplicationResources;
import be.dewolf.mg.services.EncodingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URLEncoder;

/**
 * Created by yannis on 22/06/14.
 */
@Component
public class MovieDbURLService {

    @Resource
    private ApplicationResources applicationResources;

    @Resource
    private EncodingService encodingService;

    public String createSearchMovieString(String movieTitle) {
        String movieDbApiKey = applicationResources.getMovieDbApiKey();
        StringBuilder sb = new StringBuilder();

        sb.append("search/movie?");
        sb.append("api_key").append("=").append(movieDbApiKey);
        sb.append("&query=").append(encodingService.encode(movieTitle));
        return buildUrl(sb.toString());


    }

    public String createSearchActorsForMovie(String movieId) {
        String movieDbApiKey = applicationResources.getMovieDbApiKey();
        StringBuilder sb = new StringBuilder();

        sb.append("movie/").append(movieId).append("/credits");
        sb.append("?api_key").append("=").append(movieDbApiKey);
        return buildUrl(sb.toString());
    }

    private String buildUrl(String toAddtoUrl) {
        String movieDbApiKey = applicationResources.getMovieDbApiKey();
        String movieDbUrlBase = applicationResources.getMovieDbUrlBase();

        StringBuilder sb = new StringBuilder();
        sb.append(movieDbUrlBase);
        sb.append(toAddtoUrl);
        return sb.toString();
    }

}
