package pl.stanislawski.iwo;

public class Edge{
    Vertex source;
    Vertex destination;
    float weight;

    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(Vertex source, Vertex destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
