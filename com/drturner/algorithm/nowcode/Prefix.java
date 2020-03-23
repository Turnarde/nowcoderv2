package com.drturner.algorithm.nowcode;


import java.util.Scanner;
class TrieNode{
    int path;
    int end;
    TrieNode[] next;
    public TrieNode() {
        this.path = 0;
        this.end = 0;
        this.next = new TrieNode[26];
    }
}
class Trie{
    TrieNode node;
    public Trie() {
        node=new TrieNode();
    }
    public void add(String word){
        if (word==null) return;
        TrieNode trieNode=node;
        for (int i=0;i<word.length();i++){
            if(trieNode.next[word.charAt(i)-'a']==null){
                trieNode.next[word.charAt(i)-'a']=new TrieNode();
            }
            trieNode.path++;
            trieNode=trieNode.next[word.charAt(i)-'a'];

        }
        trieNode.path++;
        trieNode.end++;
    }
    public String prefix(String word){
        TrieNode trieNode=node;
        for (int i=0;i<word.length();i++){
            if (trieNode.path==1) return word.substring(0,i);
            else {
                trieNode=trieNode.next[word.charAt(i)-'a'];
            }
        }
        return word;
    }

}
public class Prefix {
    /*
    5
meituanapp
meituanwaimai
dianpingliren
dianpingjiehun
mt
    * */


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Trie trie=new Trie();
        int count = Integer.parseInt(sc.nextLine());
      //  count++;
        String [] strings=new String[count];
        String [] result=new String[count];
        System.out.println("count: "+count+"string length: "+ result.length);
        for (int i=0;i<count;i++){
            strings[i]=sc.nextLine();
            trie.add(strings[i]);
        }
        for (int i=0;i<count;i++){
            result[i]=trie.prefix(strings[i]);
        }
        for (String s:result) {
            System.out.println(s);
        }
    }
}
