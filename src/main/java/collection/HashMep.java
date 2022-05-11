package collection;

public class HashMep<K,V> {
    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        int hash;

        public Node(int hash,K key, V value, Node<K, V> next) {
            this.hash=hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    int size=0;
    static int capacitiy=8;
    final static float loadfactory=0.75F;
    Node<K,V>[] table;

    public HashMep() {
        table=(Node<K,V>[])new Node[capacitiy];
    }
    public int hash(K key){
        int h=key.hashCode();
        return h^(h>>>16);
    }



    public void put(K key,V value){
        int index=hash(key)&(capacitiy-1);
        Node<K,V> cur=table[index];
        if (cur==null) {
            table[index]=new Node<>(hash(key),key,value,null);
        }


        while (cur != null) {

                if (cur.key==key){
                    cur.value=value;
                    break;}


            if (cur.next==null) {
                cur.next=new Node<>(hash(key),key,value,null);
            }
                cur=cur.next;

            }
        size++;
        if (size==capacitiy*loadfactory) {
            resize();
        }
        }


    private void resize() {
        int oldcapacity=capacitiy;
        int newcapacity=capacitiy<<1;
        Node<K,V>[] oldtable=table;
        Node<K,V>[] newtable=(Node<K,V>[])new Node[newcapacity];

        for (int i = 0; i < oldcapacity; i++) {
            Node<K,V>  cur=oldtable[i];
            oldtable[i]=null;
            if (cur==null) {
                continue;
            }
            if (cur.next==null) {
                newtable[cur.hash&(newcapacity-1)]=cur;
            }
            else {

                Node<K,V> lh=null; Node<K,V> lt=null;
                Node<K,V> hh=null; Node<K,V> ht=null;
                while (cur != null) {
                    if ((cur.hash&oldcapacity)==0) {
                        if (lt==null) {
                            lt=lh=cur;
                        }else {
                            lt.next=cur;
                            lt=cur;
                        }
                    }else {
                        if (ht==null) {
                            ht=hh=cur;
                        }else {
                            ht.next=cur;
                            ht=cur;
                        }

                    }
                    cur=cur.next;
                }
                if (lt!=null) {
                    lt.next=null;
                    newtable[i]=lh;
                }
                if (ht!=null) {
                    ht.next=null;
                    newtable[i+oldcapacity]=hh;
                }

            }
        }
        table=newtable;
        capacitiy=newcapacity;
    }

   public V get(K key){
       int index=hash(key)&(table.length-1);
       Node<K,V> cur=table[index];
       while (cur!=null) {
           if (cur.key.equals(key)) {
               return cur.value;
           }
           cur=cur.next;
       }
       return null;
    }

}
class test013{
    public static void main(String[] args) {
        HashMep<String,String> hashMep=new HashMep<String,String>();
        int size=3425;


        for (int i = 0; i < size; i++) {
            hashMep.put("name"+i,"chenxing"+i);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(hashMep.get("name"+i));

        }

    }
}
