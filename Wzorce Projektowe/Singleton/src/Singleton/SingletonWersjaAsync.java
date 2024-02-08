package Singleton;

public class SingletonWersjaAsync {
    private static volatile SingletonWersjaAsync singleton; // Zapisuje to zapisanie zmiennej w pamięci głównej a nie w
    // pamięci podręcznej procesora.
    private String data;
    private SingletonWersjaAsync(String data){
        this.data = data;
    }
    public static SingletonWersjaAsync getSingleton(String data){
        SingletonWersjaAsync temp = singleton; // Robimy to ponieważ volatile powoduje zapisanie zmiennej w pamięci głównej
        // a nie z pamięci podręcznej procesora. Usprawnia to proces
        if (temp == null){
            synchronized (SingletonWersjaAsync.class){
                if(temp == null){
                    singleton = temp = new SingletonWersjaAsync(data);
                }
            }

        }
        return temp;
    }
}
