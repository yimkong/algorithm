package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {8, 2, 3, 1, 6, 2, 3};
        sort(a);
        String s = Arrays.toString(a);
        System.err.println(s);
    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int f = a[i];
            while (j > 0 && f < a[j-1]){
                a[j] = a[j - 1];
                --j;
            }
            a[j] = f;
        }
    }
}
