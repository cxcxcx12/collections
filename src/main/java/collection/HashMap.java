package collection;

public class HashMap<K,V> {

    Node<K,V>[] table;
    int size=0;
    static int CAPACITY=8;
    final static float LOAD_FACTORY= 0.75F;

    public HashMap() {
        table= (Node<K,V>[])new Node[CAPACITY];
    }

    static class Node<K,V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private int hash(K key){
         int h=key.hashCode();
        return h^(h>>>16);
    }
    public void put(K key,V value){

         int index=hash(key)&(table.length-1);


        Node<K,V> cur=table[index];
        if (table[index]==null) {
            table[index]=new Node<>(hash(key),key,value,null);
        }else if(table[index].key==key){table[index].value=value;}

        else {
            while (cur!= null) {
                if (cur.key==key) {
                    cur.value=value;
                    break;}


                Node<K,V> oldcur=cur;
                cur=cur.next;



                if (cur==null) {
                    oldcur.next=new Node<>(hash(key),key,value,null);
                }
            }
        }
        //扩容
        size++;
        if (size==CAPACITY*LOAD_FACTORY) {
            resize();
        }


    }

    private void resize() {
         int oldcapacity=CAPACITY;
        int newcapacity=CAPACITY<<1;

        Node<K,V>[] oldtable=table;
        Node<K,V>[] newtable= (Node<K,V>[])new Node[newcapacity];    //先创建一个新数组，但是保留之前的数据
        table=newtable;
        CAPACITY=newcapacity;
        //进入正题：
        for (int i = 0; i < oldcapacity; i++) {
            Node<K,V> cur=oldtable[i];
            oldtable[i]=null;
            //释放引用，帮助gc，换数组都要进行的操作。
            if (cur==null) {
                continue;   //这个必须要做,把核心逻辑放在后面，把要考虑的因素放在前面。
            }
            if (cur.next==null) {
                table[(cur.hash)&(newcapacity-1)]=cur;
            }
            else {
                Node<K,V> lowhead=null;
                Node<K,V> highhead=null;
                Node<K,V> lowtail=null;
                Node<K,V> hightail=null;

                while (cur!=null){
                    if ((cur.hash&oldcapacity)==0) {
                        if (lowtail==null) {
                            lowtail= lowhead=cur;
                        }else {
                            lowtail.next=cur;
                            lowtail=cur;
                        }
                    }
                    else {
                        if (hightail==null) {
                            hightail=highhead=cur;
                        }else {
                            hightail.next=cur;
                            hightail=cur;
                        }

                    }
                    cur=cur.next;

                }

                if (lowtail!=null) {
                    lowtail.next=null;
                    table[i]=lowhead;   //考虑不周导致的。
                }
                if (hightail!=null) {
                    hightail.next=null;
                    table[i+oldcapacity]=highhead;
                }


            }

        }




    }
    public V get(K key){
        int index=hash(key)&(table.length-1);
        if (table[index].next==null) {
            return table[index].value;
        }else {
            Node<K,V> cur=table[index];
            while (cur!=null){
                if (cur.key.equals(key)) {  //key的hashcode的值是一样的，
                    return cur.value;
                }
                cur=cur.next;
            }
            return null;
        }
    }
}
class test012{
    public static void main(String[] args) {
        HashMap<String,String> hashMap=new HashMap<String,String>();
        int size=3425;


        for (int i = 0; i < size; i++) {
            hashMap.put("name"+i,"chenxing"+i);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(hashMap.get("name"+i));

        }

    }
}
