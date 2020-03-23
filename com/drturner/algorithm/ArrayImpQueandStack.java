package com.drturner.algorithm;
class ArrayStack{
    private final int STACKSIZE=15;
    private int [] data=new int[STACKSIZE];
    private int size=-1;
    public void push(int e){
        if (size+1>=STACKSIZE) throw new ArrayIndexOutOfBoundsException("栈满，压入失败");
        data[++size]=e;
    }
    public int pop(){
        if (size<0) throw new ArrayIndexOutOfBoundsException("栈空，弹出元素失败");
        return data[size--];
    }
}

class ArrayQueue{
    private final int QUEUESIZE=3;
    private int[] data=new int[QUEUESIZE];
    private int size=0;
    private int start=-1;
    private int end=-1;
    public boolean isEmpty(){
        return size==0;
    }
    public void push(int e){
        if (size==QUEUESIZE) throw new ArrayIndexOutOfBoundsException("队列已满");
        end=(end==QUEUESIZE-1)?0:end+1;
        data[end]=e;
        size++;
    }
    public int pop(){
        if (size==0) throw new ArrayIndexOutOfBoundsException("队列空");
        size--;
        start=(start==QUEUESIZE-1)?0:start+1;
        return data[start];
    }
}
public class ArrayImpQueandStack {
    static ArrayQueue arrayQueue=new ArrayQueue();

    public static void main(String[] args) {
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.pop();
        arrayQueue.push(5);
        while (!arrayQueue.isEmpty()){
            System.out.println(arrayQueue.pop());
        }
    }
}
