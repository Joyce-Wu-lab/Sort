public class mergeSort {
    private static void sort(int[] array, int left, int right) {
        if(left >= right) return;                /*结束递归条件*/
        int mid = (left + right) / 2;
        //二分法拆分数组
        sort(array, left, mid);
        sort(array, mid + 1, right);
        //合并数组
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; /*设一个长度为两个需合并的数组长度之和的数组用于暂存整理后的数*/
        int i = left, j = mid + 1, k = 0;       /*i、j分别为两个数组遍历下标，k为整理后数组下标*/
        //找出两个数组中较小的数字存入temp数组中
        while (i <= mid && j <= right) {
            if (array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        //若一边数组先遍历完，则将另一数组中剩余的数字存入temp中
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= right)
            temp[k++] = array[j++];
        k = 0;                                 /*将temp数组下边归零*/
        //将temp复制给原数组
        while(left <= right)
            array[left++] = temp[k++];
    }



    private static void printArray(int[] array) {
        for (int x : array)
            System.out.print(x + ", ");
        System.out.println();
    }

    private static void Random(int[] array, int bound){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * bound + 1);
        }
    }

    public static void main(String[] args) {
        //long n = 500, sum = 0;
        //while(n >= 0) {
            //long startTime = System.currentTimeMillis();
            int[] test = new int[100];
            Random(test, 100);
            printArray(test);
            sort(test, 0, test.length - 1);
            printArray(test);
            /*long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            //System.out.println(runTime + "ms");
            sum += runTime;
            n--;
        }
        System.out.print(sum);*/
    }


}
