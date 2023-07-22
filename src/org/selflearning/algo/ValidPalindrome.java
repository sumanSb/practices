package org.selflearning.algo;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isValid(s);
        System.out.println("O/P -> "+res);

    }

    private static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c>='A' && c<='Z'){
                c+=32;
            }
            else if(!((c>='a' && c<='z')||(c>='0' && c<='9'))){
                continue;
            }
            sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
