package be.dewolf.mg.services;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yannis on 22/06/14.
 */
@Component
public class EncodingService {

    @Resource
    private ApplicationResources applicationResources;

    public String encode(String movieTitle) {
        try {
            String s = URLEncoder.encode(movieTitle, applicationResources.getEncoding());
            return s;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
