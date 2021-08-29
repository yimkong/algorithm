package sort;

/**
 * author yg
 * description 快速排序
 * 必须从右边开始找,是因为必须先找到比基准小的数,基准交换才准确(左边的全部比中间基准小,右边的全部比中间基准大)
 * 如果先从左边开始找,找到比基准大的,有可能交换后左边的原基准位还是比中间基准大,不正确
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
        int i = left;//该指针指的数一直都是小于等于基准数
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
        change(arr, left, i);//将小于等于基准数的i指向的数跟基准数调换
        //递归
        qsort(arr, left, i - 1);
        qsort(arr, i + 1, right);
    }

    //将数组中的俩个位置的数交换位置
    private static void change(int[] arr, int i, int j) {
        //交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
