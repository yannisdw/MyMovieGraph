package be.dewolf.mg.moviedb;

import be.dewolf.mg.moviedb.transferobjects.Movie;
import be.dewolf.mg.services.ApplicationResources;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yannis on 21/06/14.
 */
@Component
public class MovieDBService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MovieDbURLService movieDbURLService;

    public Movie getMovie(String title) {

        String searchMovieString = movieDbURLService.createSearchMovieString(title);
        Map result = restTemplate.getForObject(searchMovieString, HashMap.class);
        List<Map<String, String>> results= (List<Map<String, String>>) result.get("results");
        for (Map<String, String> resultItem: results) {
            String id = resultItem.get("id");
            String original_title = resultItem.get("original_title");
            String release_date = resultItem.get("release_date");
            System.out.println("id: " + id + " - original_title: " + original_title + " - release_date: " + release_date);
        }


        return null;
    }

}
