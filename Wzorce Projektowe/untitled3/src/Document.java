import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Document implements DocumentPrototype{
    String content;
    List<String> images;
    String formatting;
    List<String> annotations;


    public Document(String content, List<String> images, String formatting, List<String> annotations){
        this.content = content;
        this.images = new ArrayList<>(images);
        this.formatting = formatting;
        this.annotations = new ArrayList<>(annotations);
    }

    @Override
    public DocumentPrototype cloneDocument() {
        return new Document(this.content,this.images,this.formatting,this.annotations);
    }

    @Override
    public void display() {
        System.out.println("Content: " + content);
        System.out.println("Images: " + images);
        System.out.println("Formatting: " + formatting);
        System.out.println("Annotations: " + annotations);
    }

    public void addImage(String image){
        images.add(image);
    }

    public void addAnnotation(String annotation){
        annotations.add(annotation);
    }

}
