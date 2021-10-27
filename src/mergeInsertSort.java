public class mergeInsertSort {
    private static void sort(int[] array, int left, int right){
        int length = right - left + 1, k = 210;
        //在长度大于k的情况下用归并，小于k用插入
        if(length > k){
            if(left >= right) return;
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }else
            insertSort(array);
    }

    private static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            if(array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while(i <= mid)
            temp[k++] = array[i++];
        while(j <= right)
            temp[k++] = array[j++];
        k = 0;
        while(left <= right)
            array[left++] = temp[k++];
    }

    private static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int key = array[i], j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
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

    public static void main(String[] args){
        /*long n = 500, sum = 0;
        while(n >= 0) {
            long startTime = System.currentTimeMillis();*/
            int[] test = new int[10];
            Random(test, 100);
            printArray(test);
            sort(test, 0, test.length - 1);
            printArray(test);
           /* long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            //System.out.print(runTime + "ms");
            sum += runTime;
            n--;
        }
        System.out.print(sum);*/
    }
}
