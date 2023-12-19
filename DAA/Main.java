import java.util.ArrayList;
//ALLL IN ONE HEAP OPERATION 
//HEAP SORT,HEAPIFY....
class heap1<T extends Comparable<T>> {
    private ArrayList<T> list;

    public heap1() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int indx) {
        if (indx == 0) {
            return;
        }
        int p = parent(indx);
        if (list.get(indx).compareTo(list.get(p)) < 0) {
            swap(indx, p);
            upheap(p); // recursive call
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap");
        }
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int indx) {
        int min = indx;
        int l = left(indx);
        int r = right(indx);
        if (l < list.size() && list.get(min).compareTo(list.get(l)) > 0) {
            min = l;
        }
        if (r < list.size() && list.get(min).compareTo(list.get(r)) > 0) {
            min = r;
        }
        if (min != indx) {
            swap(min, indx);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        heap1<Integer> heap = new heap1<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(72);
        heap.insert(86);
        System.out.println(heap.remove());
        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}
