package collection;

import java.util.Queue;

public class ArrayDequeue {
    int head;   //这个是索引指针，就没必要写成对象指针的形式

    int tail;
    Object[] objects;

    public ArrayDequeue() {
        objects=new Object[16];
    }
    public ArrayDequeue(int numcapa) {
        if (numcapa <=8) {
            objects=new Object[8];
        }else {
            int i=0;
            while (true){
                numcapa/=2;
                i++;
                if (numcapa<2){
                    break;
                }
            }
            objects=new Object[1<<(i+1)];
        }
    }

    void add(Object obj){
        int oldtail=tail;
        objects[oldtail]=obj;
        tail++;
        tail=tail&(objects.length-1);
        if (tail==head){
            int n= objects.length;
            Object[] objectsnew=new Object[objects.length<<1];
            System.arraycopy(objects,head,objectsnew,0,objects.length-head);
            System.arraycopy(objects,0,objectsnew,objects.length-head,tail);
            objects=objectsnew;
            tail=n;
            head=0;

        }

    }
    void remove(){
        int oldhead=head;
        objects[oldhead]=null;
        head++;
    }

    void foreach(){
        int cur=head;
        for (int i = 0; i < size(); i++) {
            System.out.println(objects[cur]);
            cur++;
            cur=cur&(objects.length-1);

        }


    }



    int size(){
        return (tail-head)&(objects.length-1);
    }



}
class test004{
    public static void main(String[] args) {
       /* ArrayDequeue arrayDequeue = new ArrayDequeue(9);
        System.out.println(arrayDequeue.objects.length);*/

        ArrayDequeue queue = new ArrayDequeue();

        int size1=45;
        for (int i = 0; i < size1; i++) {
            queue.add(i);
        }
        System.out.println(queue.objects.length);

        /*queue.foreach();*/
      /*  int size1=14;
        for (int i = 0; i < size1; i++) {
            arrayDequeue.add(i);
        }
        int size2=8;
        for (int i = 0; i < size2; i++) {
            arrayDequeue.remove();
        }
        int size3=6;
        for (int i = 0; i < size3; i++) {
            arrayDequeue.add(i);
        }

        arrayDequeue.foreach();*/

    }


}
