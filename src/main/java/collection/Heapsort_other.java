package collection;

public class Heapsort_other {
    /*public static void buildMaxHeap(int[] tree, int p, int size) {
        // 只有发生交换时才会继续循环，以被交换的子结点作为父节点继续向下重构
        // i 初始定位为待调整父结点的左孩子
        for (int i = 2 * p + 1; i < size; i = 2 * i + 1) {
            // 右孩子存在比较两个孩子的值
            if (i + 1 < size && tree[i] < tree[i + 1]) {
                i += 1;  // 右孩子大，将 i 指向右孩子
            }
            // 孩子结点大于父结点，进行交换
            if (tree[i] > tree[p]) {
                int temp = tree[i];
                tree[i] = tree[p];
                tree[p] = temp;
                // 交换后，以被交换的节点作为父节点继续构造
                p = i;
            } else {  // 如果父结点比孩子节点大，直接退出即可，因为是从底层调整到上层
                break;
            }
        }
    }
    public static void heapSort(int[] tree) {
        // 第一步：将无序序列当作完全二叉树，并构建成大顶堆
        // p 指向父节点，从最后一个 非叶子节点 调整到根节点
        for (int p = tree.length / 2 - 1; p >= 0; p--) {
            buildMaxHeap(tree, p, tree.length);
        }
        //System.out.println(Arrays.toString(tree));

        // 第二步：交换根节点和尾节点，缩小堆的尺寸，重构大顶堆
        // 重复这个过程，直到尺寸减少为 1
        int size = tree.length;
        int temp = 0;
        while (size > 1) {
            // 交换根节点与尾节点
            temp = tree[0];
            tree[0] = tree[size - 1];
            tree[size - 1] = temp;
            // 缩小尺寸
            size--;
            // 从根节点开始重构大顶堆
            buildMaxHeap(tree, 0, size);
        }
    }
    public static void main(String[] args) {
        int[] arrTime = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arrTime[i] = (int) (Math.random() * 10000000);
        }
        long former = System.currentTimeMillis();
        heapSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }*/
    public static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换。
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上, 也就是说只调用一次,并没有得到大顶堆）
     * 就是将arr[i] 的值放到本次 调整过程中适当的位置。
     * @param arr    : 数组
     * @param i      : 非叶子节点的索引
     * @param length : 对多少个元素进行调整，这个length是逐渐减少的..
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2*i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];//把较大的值，赋给当前节点
                i = k;//i 指向k,继续循环比较
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arrTime = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arrTime[i] = (int) (Math.random() * 10000000);
        }
        long former = System.currentTimeMillis();
        heapSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }
}
