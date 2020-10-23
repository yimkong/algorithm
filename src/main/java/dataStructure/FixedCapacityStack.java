package dataStructure;

/**
 * author yg
 * description 表示泛型定容栈的抽象数据结构
 * date 2020/10/23
 */
public class FixedCapacityStack<T> {
    private T[] a; //stack entries
    private int n;// size

    public FixedCapacityStack(int cap) {
        this.a = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T t) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = t;
    }

    public T pop() {
        T t = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return a[--n];
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

}
