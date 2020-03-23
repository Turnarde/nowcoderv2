package com.drturner.nowcoderv2.problem2;

public class FindSpace {
    public String replaceSpace(StringBuffer str) {
        String s=new String();
        if (str==null||str.length()==0) return s;
        for (int i=0;i<str.length();i++)
            if (str.charAt(i)==' ') str.replace(i,i+1,"%20");
        return str.toString();
    }

    public static void main(String[] args) {

        String i_am_a_student = new FindSpace().replaceSpace(new StringBuffer(" "));
        System.out.println(i_am_a_student);
    }
}
