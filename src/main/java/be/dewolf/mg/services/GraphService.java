package be.dewolf.mg.services;

import be.dewolf.mg.graph.types.RelTypes;
import org.neo4j.graphdb.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yannis on 21/06/14.
 */
@Component
public class GraphService {

    @Resource
    private GraphDatabaseService graphDatabaseService;

    public void doStuff() {

        Node firstNode;
        Node secondNode;
        Relationship relationship;

      /*  Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                graphDatabaseService.shutdown();
            }
        });*/

        try (Transaction tx = graphDatabaseService.beginTx()) {
            firstNode = graphDatabaseService.createNode();
            firstNode.setProperty("name", "yannis");

            secondNode = graphDatabaseService.createNode();
            secondNode.setProperty("name", "amke");

            relationship = firstNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
            relationship.setProperty("message", "brave Neo4j");

            System.out.println(firstNode.getProperty("name"));
            System.out.println(relationship.getType().name());
            System.out.println(relationship.getProperty("message"));
            System.out.println(secondNode.getProperty("name"));


            tx.success();
        }


        try (Transaction tx = graphDatabaseService.beginTx()) {
            firstNode.getSingleRelationship(RelTypes.KNOWS, Direction.OUTGOING).delete();
            firstNode.delete();
            secondNode.delete();
            tx.success();
        }

        //graphDatabaseService.shutdown();
    }
}
