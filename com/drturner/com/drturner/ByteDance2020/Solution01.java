package com.drturner.com.drturner.ByteDance2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution01 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str1 = sc.nextLine();
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        int N = Integer.parseInt(str1);
        for (int i=0;i<N;i++){
            String s = sc.nextLine();
            String[] sp = s.split(" ");
            ArrayList<String> list=new ArrayList<>();
            for (int j=1;j<sp.length;j++){
                if (map.containsKey(sp[j])){
                    ArrayList<String> strings = map.get(sp[j]);
                    if (!strings.contains(sp[0])){
                        map.get(sp[j]).add(sp[0]);
                    //    map.put(sp[j],sp[0])
                    }
                }
                else {
                    ArrayList<String> ls=new ArrayList<>();
                    ls.add(sp[0]);
                    map.put(sp[j],ls);
                }
            }

        }
        Set<String> strings = map.keySet();
        for (String s :
                strings) {
            map.get(s).sort((o1,o2)->{
                return o1.compareTo(o2);
            });
            System.out.print(s);
            for (int i=0;i<map.get(s).size();i++){
                System.out.print(" "+map.get(s).get(i));
            }
            System.out.println();
        }
    }
}
