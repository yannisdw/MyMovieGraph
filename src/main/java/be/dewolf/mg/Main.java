package be.dewolf.mg;

import be.dewolf.mg.services.GraphService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


import static spark.Spark.*;

/**
 * Created by yannis on 17/06/14.
 */
@Component
public class Main {

    public static void main(String args[]) {

        ApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);

        get("/hello", (request, response) -> {
            GraphService bean = c.getBean(GraphService.class);
            bean.doStuff();
            return "hello world";
        });

    }


}
