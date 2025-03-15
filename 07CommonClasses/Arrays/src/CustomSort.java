import java.util.Arrays;
import java.util.Comparator;

public class CustomSort {
    public static void main(String[] args) {
        int[] arr = {3,5,-1, 3, 10,50};
        System.out.println(Arrays.toString(BubbleSort(arr)));
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(BubbleCustom(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        })));
    }

    // 冒泡排序
    public static int[] BubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {//从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    // 冒泡排序 + 定制
    public static int[] BubbleCustom(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组排序由compare()返回的值决定
                // 从小到大
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}