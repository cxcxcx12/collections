package collection;


import java.util.LinkedList;

public class List{

    private int capacity;
    private  int size;
    private Object[] objects;



    public List() {
        this(10);
    }  //初始化容量是10，也可以调用 init（）方法，具体逻辑在此方法中实现

    public List(int capacity) {
        super();
        this.capacity=capacity;
        this.objects=new Object[capacity];  //初始化实际的容器
        size=0;
    }

    public int size() {
        return size;
    }
    public int getCapacity(){
        return capacity;
    }


    public boolean isEmpty() {
        return size==0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if(o==null){
                if(objects[i]==null){return true;}
            }
            else { if(objects[i]==o){return true;}}
        }
        return false;
    }
    public boolean rangeover(int index){
        if (index<0||index>=capacity){
            throw new RuntimeException("sdada ");
        }
        return true;
    }
    public Object get(int index){
        rangeover(index);
        return objects[index];
    }



    public void add(Object o) {
        if(size<capacity){
           objects[size]=o;

       }else {
           capacity=capacity<<1;
           Object[] newlist=new Object[capacity];
           for (int i = 0; i < size; i++) {
               newlist[i]=objects[i];
               objects[i]=null;

           }
           this.objects=newlist;
           objects[size]=o;



       }

        size++;

    }


    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (objects[i]==o){
                objects[i]=null;
                return true;   }
        }
         return false;
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i]=null;
        }

    }
}

class Testlist {
    public static void main(String[] args) {
       List list = new List();
         int num=700;
        for (int i = 0; i < num; i++) {
            list.add(new String("第"+i+"个同学的学号是："+202022100+i+"\n"));

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        System.out.println(list.size()+"  "+list.getCapacity());

    }



}

class Stuer implements Cloneable{
    int age=10;

    public Stuer(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class user implements Cloneable{
    int a=10;
    String name;
    Stuer stuer;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof user;
        
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public user() {
        /*this(new Stuer());*/
    }

    public user(Stuer stuer) {
        this.stuer = stuer;
    }


    @Override
    public String toString() {
        return "user{" +
                "a=" + a +
                ", name='" + name + '\'' +
                ", stuer=" + stuer +
                '}';
    }

    public static void main(String[] args) {
        user user1 = new user(new Stuer(15));

        System.out.println(user1.stuer.toString());

        System.out.println(user1);
        try {
            user clone = (user) user1.clone();
            System.out.println(clone);
            System.out.println(clone.equals(user1));
            System.out.println(clone==user1);


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println();

    }
}
