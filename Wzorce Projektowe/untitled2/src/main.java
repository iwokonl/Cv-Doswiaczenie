import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<String> images = new ArrayList<>(List.of("Image1.png"));
        List<String> annotations = new ArrayList<>(List.of("Annotation1"));
        Document originalDoc = new Document("Hello World!",images,"Basic",annotations);
        DocumentPrototype copiedDoc = originalDoc.cloneDocument();
        System.out.println(originalDoc == copiedDoc);
        originalDoc.addImage("Image2.png");
        originalDoc.addAnnotation("Annotation2");
        System.out.println("Original Document: ");
        originalDoc.display();
        System.out.println();
        System.out.println("Copied Document: ");
        copiedDoc.display();
    }
}


