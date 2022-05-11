package collection;

public class Pripotyqueue {
    private static void adjust(int[] arr, int cur, int tail1,int size) {
        for (int i = 0; i <size ; i++) {
            arr[i]=arr[i+cur&(arr.length - 1)];
        }
        int tail=size-1;
        cur=0;
        int minindex;
        while (true) {
            int cur_leftchild = (cur * 2 + 1);
            int cur_rightchild = (cur * 2 + 2);
            if (cur_rightchild <= tail) {
                if (arr[cur_rightchild] < arr[cur_leftchild]) {
                    minindex = cur_rightchild;
                } else {
                    minindex = cur_leftchild;
                }
            } else if (cur_leftchild <= tail) {
                minindex = cur_leftchild;
            } else {
                for (int i = 0; i <size ; i++) {
                    arr[i]=arr[i-cur&(arr.length - 1)];
                }
                break;
            }
            if (arr[minindex] < arr[cur]) {
                swap(arr, minindex, cur);
                cur = minindex;
            } else {
                for (int i = 0; i <size ; i++) {
                    arr[i]=arr[i-cur&(arr.length - 1)];
                }
                break;
            }


        }
    }

    private static void swap(int[] arr, int maxindex, int cur) {
        int temp = arr[maxindex];
        arr[maxindex] = arr[cur];
        arr[cur] = temp;
    }



    void addfirst(int obj) {

        head = head-1 & (ints.length-1);
        ints[head]=obj;
        if (tail == head) {
            int n=ints.length;
            int[] intsnew = new int[ints.length <<1];
            System.arraycopy(ints, head, intsnew, 0, ints.length - head);
            System.arraycopy(ints, 0, intsnew, ints.length - head, tail);
            ints = intsnew;
            head = 0;
            tail = n;
        }
        int size=size();
        adjust(ints, head, tail-1,size);
    }

        int head;   //这个是索引指针，就没必要写成对象指针的形式

        int tail;
        int[] ints;

        public Pripotyqueue() {
            ints = new int[16];
        }

        public Pripotyqueue(int numcapa) {
            if (numcapa <= 8) {
                ints = new int[8];
            } else {
                int i = 0;
                while (true) {
                    numcapa /= 2;
                    i++;
                    if (numcapa < 2) {
                        break;
                    }
                }
                ints = new int[1 << (i + 1)];
            }
        }

        void add(int obj) {
            int oldtail = tail;
            ints[oldtail] = obj;
            tail++;
            tail = tail & (ints.length - 1);
            if (tail == head) {
                int n=ints.length;
                int[] intsnew = new int[ints.length << 1];
                System.arraycopy(ints, head, intsnew, 0, ints.length - head);
                System.arraycopy(ints, 0, intsnew, ints.length - head, tail);
                ints = intsnew;
                head = 0;
                tail = n;

            }

        }

        void remove() {
            int oldhead = head;
            ints[oldhead] = 0;
            head++;
        }

        void foreach() {
            int cur = head;
            for (int i = 0; i < size(); i++) {
                System.out.println(ints[cur]);
                cur++;
                cur = cur & (ints.length - 1);

            }


        }


        int size() {
            return (tail - head) & (ints.length - 1);
        }


}
    class test005{
        public static void main(String[] args) {
            Pripotyqueue queue = new Pripotyqueue();

        int size1=126;
        for (int i = 0; i < size1; i++) {
            queue.addfirst(i);
        }
            System.out.println(queue.ints.length);

        queue.foreach();

        }


    }


