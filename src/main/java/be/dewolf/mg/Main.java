package be.dewolf.mg;

import be.dewolf.mg.be.dewolf.mg.types.RelTypes;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.config.java.context.JavaConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


import static spark.Spark.*;

/**
 * Created by yannis on 17/06/14.
 */
public class Main {

    public Main() {
        final GraphDatabaseService memoryDb = new GraphDatabaseFactory().newEmbeddedDatabase("memoryDb");

        Node firstNode;
        Node secondNode;
        Relationship relationship;

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                memoryDb.shutdown();
            }
        });

        try(Transaction tx = memoryDb.beginTx()) {
            firstNode = memoryDb.createNode();
            firstNode.setProperty("name", "yannis");

            secondNode = memoryDb.createNode();
            secondNode.setProperty("name", "amke");

            relationship = firstNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
            relationship.setProperty("message", "brave Neo4j");

            System.out.println(firstNode.getProperty("name"));
            System.out.println(relationship.getType().name());
            System.out.println(relationship.getProperty("message"));
            System.out.println(secondNode.getProperty("name"));


            tx.success();
        }




        try (Transaction tx = memoryDb.beginTx()) {
            firstNode.getSingleRelationship(RelTypes.KNOWS, Direction.OUTGOING).delete();
            firstNode.delete();
            secondNode.delete();
            tx.success();
        }

        memoryDb.shutdown();

    }

    public static void main(String args[]) {

        JavaConfigApplicationContext c = new JavaConfigApplicationContext(AppConfig.class);

        get("/hello", (request, response) -> {
            return "hello world";
        });
        new Main();
    }


}
