package sort;

/**
 * author yg
 * description 归并排序 TODO bug
 * date 2019/2/4
 */
public class MergeSort {
    public static int[] sort(int[] ints) {
        int[] result = new int[ints.length];
        merge(ints, result, 0, ints.length - 1);
        return result;
    }

    private static void merge(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;
        int center = (start + end) / 2;
        int start1 = start, end1 = center;
        int start2 = center + 1, end2 = end;
        merge(arr, result, start1, end1);
        merge(arr, result, start2, end2);
        int k = start1;
        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] < arr[start2]) {
                result[k++] = arr[start1++];
            } else {
                result[k++] = arr[start2++];
            }
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }
}
