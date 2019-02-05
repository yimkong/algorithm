package sort;

/**
 * author yg
 * description 快速排序
 * date 2019/2/4
 */
public class QuitSort {

    public static void sort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int left, int right) {
        if (right < left) {
            return;
        }
        int i = left;
        int j = right;
        int base = arr[left];
        while (i != j) {
            while (arr[j] >= base && j > i) {
                j--;
            }
            while (arr[i] <= base && j > i) {
                i++;
            }
            if (i < j) {
                change(arr, j, i);
            }
        }
        //最终将基准数归位
        change(arr, left, i);
        //递归
        qsort(arr, left, i - 1);
        qsort(arr, i + 1, right);
    }

    private static void change(int[] arr, int i, int j) {
        //交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
