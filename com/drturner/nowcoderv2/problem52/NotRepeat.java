package com.drturner.nowcoderv2.problem52;

import java.util.*;

public class NotRepeat {
    Map<Character,Integer> map=new HashMap<>();
    ArrayList<Character> list=new ArrayList<>();
    public void Insert(char ch)
    {
        list.add(ch);
        if (!map.containsKey(ch)){
            map.put(ch,1);
        }
        else {
            map.put(ch,map.get(ch)+1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i=0;i<list.size();i++){
            if (map.get(list.get(i))==1) return list.get(i);
        }
        return '#';
    }

    public static void main(String[] args) {
        NotRepeat notRepeat=new NotRepeat();
        notRepeat.Insert('g');
        System.out.println(notRepeat.FirstAppearingOnce());
        notRepeat.Insert('o');

        System.out.println(notRepeat.FirstAppearingOnce());
        notRepeat.Insert('o');
        System.out.println(notRepeat.FirstAppearingOnce());
        notRepeat.Insert('g');
        System.out.println(notRepeat.FirstAppearingOnce());
        notRepeat.Insert('l');
        System.out.println(notRepeat.FirstAppearingOnce());
        notRepeat.Insert('e');
        System.out.println(notRepeat.FirstAppearingOnce());
    }
}
