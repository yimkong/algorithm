package sort;

//希尔排序
public class ShellSort {

    public static void main(String[] args) {
        int a[] = {8, 2, 3, 1, 6, 2, 3};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(int[] a) {
        //通过折半的方式大幅度提高数组有序程度，以便大幅提高插入排序的效率
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            //i从折半开始向后走
            for (int i = gap; i < a.length; i++) {
                //j为需要比较的下标，间隔gap做比较，当gap为1时，则是插入排序
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }
            }
        }
    }
}
