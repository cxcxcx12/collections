package collection;



public class heap2 { //手写第二个，话费20分钟。
    public static void main(String[] args) {
        int size=10000000;
        int[] arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]= (int) (Math.random()*size);
        }
         long start= System.currentTimeMillis();
        sort(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start+"毫秒");
    }

    private static void sort(int[] arr) {
        int index=arr.length/2-1;
        for (int i = index; i >= 0; i--) {
            adjust(arr,i,arr.length-1);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            adjust(arr,0,i-1);
        }

    }

    private static void adjust(int[] arr, int cur, int tail) {
        int maxindex;
        while (true){
            int cur_leftchild=cur*2+1;
            int cur_rightchild=cur*2+2;
            if(cur_rightchild<=tail){
                if (arr[cur_rightchild]>arr[cur_leftchild]){maxindex=cur_rightchild;}
                else {maxindex=cur_leftchild;}
            }
            else if(cur_leftchild<=tail){maxindex=cur_leftchild;}
            else {break;}
            if (arr[maxindex]>arr[cur]){
               swap(arr,maxindex,cur);
               cur=maxindex;
            }

        }

    }

    private static void swap(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }
}
