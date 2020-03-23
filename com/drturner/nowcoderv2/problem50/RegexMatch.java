package com.drturner.nowcoderv2.problem50;

public class RegexMatch {
    public boolean match(char[] str, char[] pattern)
    {
        if (str==null||pattern==null) return false;
        if (str.length==0&&pattern.length==0) return true;
        return isMatch(str,0,pattern,0);
    }
    private boolean isMatch(char[] str,int start1,char[] pattern,int start2){
        if (start2==pattern.length) return start1==str.length;
        //(strStart != str.length() && pattern.charAt(patternStart) == str.charAt(strStart)) || (pattern.charAt(patternStart) == '.' && strStart != str.length())
        boolean priMatch=((start1<str.length)&&(str[start1]==pattern[start2]))||(pattern[start2]=='.'&&start1<str.length);
        if ((start2+1<pattern.length)&&pattern[start2+1]=='*'){
            return isMatch(str,start1,pattern,start2+2)||((priMatch)&&isMatch(str,start1+1,pattern,start2));
        }
        else {
            return (priMatch)&&isMatch(str,start1+1,pattern,start2+1);
        }
    }

    public static void main(String[] args) {
        String str1="aaaaa";
        String pattern1="aaaaaaaaa";
        char[] str=str1.toCharArray();
        char[] pattern=pattern1.toCharArray();
        boolean match = new RegexMatch().match(str, pattern);
        System.out.println(match);
    }
}
