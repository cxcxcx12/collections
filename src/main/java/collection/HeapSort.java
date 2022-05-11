package collection;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

   /* static int[] arr={1,1,23,4,55,11231,4432,4324,2,5,7,12,3,54,7,99,13,34,46,3,4};*/

    static void sortheap(int[] arr,int tail){  //这个数组，你要调整数组的范围是怎么样的，以及从哪个节点开始调整，是向下调整，因为是子根堆呀
        int father= ((tail-1)>>1)-1;


        while (father>=0){
            int leftson=(father<<1)+1;
            int rightson=(father<<1)+2;
            if (arr[leftson]>arr[rightson]){
                if (arr[leftson]>arr[father]){
                    swap(arr,leftson,father);
                }
            } else {  if (arr[rightson]>arr[father]){
                swap(arr,rightson,father);
            }
            }
            father--;
        }

    }
    static void sort(int[] arr){
        for (int length = arr.length; length>4; length--) {
            sortheap(arr,length);
            swap(arr,0,length-1);

        }

    }

    private static void swap(int[] arr, int leftson, int father){
        int tep=arr[leftson];
        arr[leftson] =arr[father];
        arr[father]=tep;
    }

    public static void main(String[] args) {
        int length1 = 100000;
        int[] array = new int[length1];
        for (int i = 0; i < length1; i++) {
            array[i] = new Random().nextInt(100);

        }
        long former = System.currentTimeMillis();
        sort(array);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }


}
