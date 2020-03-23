package com.drturner;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.ensureCapacity(8);
        int [] array=new int[65535];
        for (int i=0;i<array.length;i++){
            array[i]=new Random().nextInt(20);
        }
        for (int e:array
             ) {
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println("==============");
        System.arraycopy(array,1,array,2,array.length-2);
        for (int e:array
                ) {
            System.out.print(e+" ");
        }
    }
}
