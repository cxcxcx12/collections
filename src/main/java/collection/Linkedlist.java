package collection;

public class Linkedlist {

    private static class Node{
        Node pre;
        Node next;
        int value;


        public Node(Node pre, int value,Node next ) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
    int size;
    Node first;
    Node last;



    public Linkedlist() {
        size=0;
        first=null;
        last=null;
    }

    void removefirst(){
        Node oldfirst=first;
        first=first.next;
        oldfirst.next=null;
                first.pre=null;
                size--;

    }

    Node getNodebyIndex(int index){
        cheakrange(index);

        if (index<(size>>1)) {
            Node cur=first;
            for (int i = 1; i < index; i++) {     //调用first的index数量的next！！！
                cur=cur.next;
            }
            return cur;
        }else {
            Node cur=last;
            for (int i = 0; i < (size-index); i++) {   //调用last的size-index数量的pre！！！
                last=last.pre;
            }
            return cur;
        }

    }

    private void cheakrange(int index) {
        if (index>size||index<1) {
            throw new RuntimeException("数组越界拉啊");
        }
    }

    void removelast(){
        Node oldlast=last;
        last=last.pre;
        oldlast.pre=null;
        last.next=null;
        size--;
    }

    void add(int value){
        Node oldlast=last;
        Node node=new Node(oldlast,value,null);

        if (last == null) {
            first=node;
        }else {
            oldlast.next=node;
        }
        last=node;
        size++;
    }

    void addfirst(int value){
        Node oldfirst=first;
        Node node=new Node(null,value,oldfirst);

        if (first == null) {
            last=node;
        }else {
            oldfirst.next=node;
        }
        first=node;
        size++;
    }

  void foreacher(){
      Node cur=first;
      for (int i = 0; i <size; i++) {
          System.out.println(cur.value);
          cur=cur.next;
      }

  }



}
class  test003{
    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        linkedlist.add(2);
        linkedlist.add(0);
        linkedlist.add(2);
        linkedlist.add(0);
        linkedlist.add(2);
        linkedlist.add(2);linkedlist.add(1);linkedlist.add(0);linkedlist.add(0);
        linkedlist.add(5);linkedlist.add(1);linkedlist.add(5);
        linkedlist.removefirst();
        linkedlist.removelast();
        linkedlist.foreacher();
    }
}
