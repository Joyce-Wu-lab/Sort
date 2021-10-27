public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {   /*因第一个数字不需要排序，故从第二个数字开始遍历*/
            int key = array[i], j = i - 1;         /*仅考察key位置之前的数值与key的大小*/
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];           /*若比key的值要大，则后移为key的插入留出空位*/
                j--;
            }
            array[j + 1] = key;                    /*将key的值插入准确位置*/
        }
    }

    //以下代码用于测试准确性
    //数组打印
    private static void printArray(int[] array) {
        for (int x : array) System.out.print(x + ", ");
        System.out.println();
    }

    //随机生成数组
    private static void Random(int[] array, int bound) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * bound + 1);
        }
    }


    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        int[] test = new int[10];
        Random(test, 100);
        printArray(test);
        insertSort(test);
        printArray(test);
        //long endTime = System.currentTimeMillis();
        //long runTime = endTime - startTime;
        //System.out.println(runTime + "ms");
    }
}
