import java.net.StandardSocketOptions;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        m("abcde","defgc");

    }
    private static void m(String a, String b){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i< a.length();i++){
            if(b.indexOf(a.charAt(i))!=-1){
               sb.append(a.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

}