package com.drturner.nowcoderv2.problem47;

public class StringToInt {
    public int StrToInt(String str) {
        if (str==null||str.length()==0) return 0;
        int i=(str.charAt(0)=='+'||str.charAt(0)=='-')?1:0;
        int result=0;
        for (;i<str.length();i++){
            if (!(str.charAt(i)>'0'&&str.charAt(i)<'9')){
                return 0;
            }
            else {
                result=result*10+str.charAt(i)-'0';
            }
        }
        if (str.charAt(0)=='-') result=-result;
        if (((result>0)&&str.charAt(0)=='-')||(result<0&&(str.charAt(0)!='-'))) return 0;
        return result;
    }

    public static void main(String[] args) {
        int i = new StringToInt().StrToInt("2147483648");
        System.out.println(i);
    }
}
