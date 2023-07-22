package org.selflearning.dp;

public class ConvertTime {
    public static void main(String[] args) {
        String s1 = "02:30";
        String s2 = "03:56";
        int res = convertTime(s1,s2);
        System.out.println("O/P -> "+res);
    }

    private static int convertTime(String current, String correct) {
        String[] cur = current.split(":");
        String[] cor = correct.split(":");
        int cu = Integer.parseInt(cur[0])*60+Integer.parseInt(cur[1]);
        int co = Integer.parseInt(cor[0])*60+Integer.parseInt(cor[1]);
        int count = 0;
        while((cu+60)<=co){
            count++;
            cu+=60;
        }
        while((cu+15)<=co){
            count++;
            cu+=15;
        }
        while((cu+5)<=co){
            count++;
            cu+=5;
        }
        while((cu+1)<=co){
            count++;
            cu+=1;
        }
        return count;
    }
}
