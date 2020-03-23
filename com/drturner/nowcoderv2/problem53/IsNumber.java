package com.drturner.nowcoderv2.problem53;

public class IsNumber {
    private boolean isFloat(char[] str,int start,int end){
        if (str[start]=='.'||str[end]=='.') return false;
        int dotCount=0;
        int i=(str[start]=='+'||str[start]=='-')?start+1:start;
        for (;i<=end;i++){
            if (str[i]!='.'&&!(str[i]>='0'&&str[i]<='9')){
                return false;
            }
            if(str[i]=='.'){
                dotCount++;
            }
        }
        return dotCount<=1;
    }
    private boolean isInteger(char[] str,int start,int end){
        int i=(str[start]=='+'||str[start]=='-')?start+1:start;
        for (;i<=end;i++){
            if (str[i]-'0'<0||str[i]-'9'>9){
                return false;
            }
        }
        return true;
    }
    public boolean isNumeric(char[] str) {
        if (str==null||str.length==0) return false;
        int EIndex=-1;
        if ((str[0]>='0'&&str[0]<='9')||str[0]=='+'||str[0]=='-'){
            for (int i=0;i<str.length;i++){
                if (str[i]=='E'||str[i]=='e'){
                    if (i==0||i==str.length-1) return false;
                    EIndex=i;
                }
            }
        }
        if (EIndex==-1){
            return isFloat(str,0,str.length-1);
        }
        else{
            return isFloat(str,0,EIndex-1)&&isInteger(str,EIndex+1,str.length-1);
        }
    }

    public static void main(String[] args) {
        String str1="+308";
        boolean aFloat = new IsNumber().isInteger(str1.toCharArray(), 0, str1.length() - 1);
        boolean numeric = new IsNumber().isNumeric("1.79769313486232E+308".toCharArray());
        System.out.println(aFloat);
    }
}
