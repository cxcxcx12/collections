package collection;

public class Heap {
    public static void main(String[] args) {
        int[] arrTime = new int[30000000];
        for (int i = 0; i < 30000000; i++) {
            arrTime[i] = (int) (Math.random() * 30000000);
        }
        long former = System.currentTimeMillis();
        sort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    private static void sort(int[] arr) {

        for (int i = arr.length/2-1; i >=0; i--) {
            adjustHeap(arr,i,arr.length-1);
        }
        for (int i = arr.length - 1; i > 0; i--) {

            swap(arr,0,i);
            adjustHeap(arr,0,i-1);
        }

    }

    private static void adjustHeap(int[] arr,int cur,int tail) {

        int maxindex;
        while (true){
            int cur_leftchild=cur*2+1;
            int cur_rightchild=cur*2+2;
            if (cur_rightchild<=tail){
                    if(arr[cur_rightchild]>arr[cur_leftchild]){maxindex=cur_rightchild;}else {maxindex=cur_leftchild;}
            }else if(cur_leftchild<=tail){maxindex=cur_leftchild;}
            else {break;}


            if (arr[maxindex]>arr[cur]){
                swap(arr,maxindex,cur);
                cur=maxindex;}
            else {break;}


    }
}

    private static void swap(int[] arr, int maxindex, int index) {
        int temp=arr[maxindex];
        arr[maxindex]=arr[index];
        arr[index]=temp;
    }
    }
