package collection;

import java.util.Random;

public class MergeSort {

    /**
     * @param sourceArray 要排序的源数据
     * @param temp        临时数据，因为归并时需要借用一个临时的数据
     * @param first       要排序的数组起始索引
     * @param end         要排序的数组结束索引
     */
    public void sort(int[] sourceArray, int[] temp, int first, int end) {
        //首先判断一下当前数组要排序是否只有一个元素，这个是返回条件
        if (first == end) {
            return;
        }

        int mid = (first + end) / 2;
        //前一段
        sort(sourceArray, temp, first, mid);
        //后一段
        sort(sourceArray, temp, mid + 1, end);
        //两段都返回时进行归并排序
        merge(sourceArray, temp, first, mid, end);
    }

    //mid 是包含在前段 升序
    public void merge(int[] sourceArray, int[] temp, int first, int mid, int end) {
        //首先记住起始位置
        int firstIndex = first;
        //长度
        int n = end - first + 1;
        int secondFirst = mid + 1;
        int j = 0; //临时索引
        while (first <= mid && secondFirst <= end) {
            if (sourceArray[first] <= sourceArray[secondFirst]) {
                temp[j++] = sourceArray[first++]; //后移一个
            } else {
                temp[j++] = sourceArray[secondFirst++];
            }
        }

        //考虑没有移动完的数据
        //前一段
        while (first <= mid) {
            temp[j++] = sourceArray[first++];
        }

        //后一段
        while (secondFirst <= end) {
            temp[j++] = sourceArray[secondFirst++];
        }

        //最后将临时数据拷贝到源数组，这区间数据代表排序完成
        for (int i = 0; i < n; i++) {
            sourceArray[firstIndex++] = temp[i];
        }
    }
  /*  public static void main(String[] args) {
        int[] arrTime = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arrTime[i] = (int) (Math.random() * 10000000);
        }
        long former = System.currentTimeMillis();
        heapSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }
    */



    public static void main(String[] arsg) {
        int length = 100000;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(100);
        }
        int[] arrTime = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arrTime[i] = (int) (Math.random() * 100000);
        }

        MergeSort mergeSort = new MergeSort();
        int[] tempArrary = new int[array.length];
        System.out.println("开始排序" + length + "元素.....");
        long start = System.currentTimeMillis();
        mergeSort.sort(array, tempArrary, 0, array.length - 1);
        long useMillis = System.currentTimeMillis() - start;
        System.out.println("排序完成，用时" + useMillis + "毫秒，约" + useMillis / 1000.0 + "秒！");
  /*      for(int item : array){
            System.out.print(item+" ");
        }*/
    }
}