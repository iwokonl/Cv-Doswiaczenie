package zadanie2;

import java.time.LocalDate;

public class Zadanie2 {
    public static <T> void print(T[] lista){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<lista.length;i++){
            stringBuilder.append(lista[i] + ", ");
        }
        if(lista.length != 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        System.out.print(stringBuilder.toString());

    }

    public static void main(String[] args) {
        LocalDate[] temp = {};
        print(temp);
    }
}
