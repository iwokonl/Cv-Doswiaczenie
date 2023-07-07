package zadanie1;

public interface Named {
    default String getName() {
        return "";
    }
}