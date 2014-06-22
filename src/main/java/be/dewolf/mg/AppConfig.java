package be.dewolf.mg;

import be.dewolf.mg.services.GraphService;
import com.oracle.webservices.internal.api.message.PropertySet;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yannis on 17/06/14.
 */
@Configuration
@ComponentScan({"be.dewolf.mg.services", "be.dewolf.mg.moviedb"})
@PropertySource({"classpath:application.properties", "classpath:private.properties"})
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService(){

        GraphDatabaseService memoryDb = new GraphDatabaseFactory().newEmbeddedDatabase("memoryDb");
        return memoryDb;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
