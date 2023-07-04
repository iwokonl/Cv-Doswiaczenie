package pl.stanislawski.iwo;

import java.util.List;
import java.util.Map;

public class Graph<T> extends Vertex{
    Map<Vertex, List<Edge>> adjacencies;

    public Graph(Map<Vertex, List<Edge>> adjacencies) {
        this.adjacencies = adjacencies;
    }
    public void createVertex(T Data){

    }
}
