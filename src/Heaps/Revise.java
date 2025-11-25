package Heaps;
import java.util.*;

public class Revise {
    ArrayList<Integer> list;
    int size;

    Revise(){
        list = new ArrayList<>();
        size = 0;
    }

    public void insertion(int val){
        list.add(val);
        size++;
        int i = size - 1;
        while(i > 0){
            int parent = (i - 1)/2;
            if(list.get(parent) > list.get(i)){
                int temp = list.get(parent);
                list.set(parent, list.get(i));
                list.set(i, temp);
                i = parent;
            } else break;
        }
    }

    public void deletion(){
        if(size == 0) return;
        list.set(0, list.get(size - 1));
        list.remove(size - 1);
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int i){
        while(true){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int smallest = i;
            if(left < size && list.get(left) < list.get(smallest)) smallest = left;
            if(right < size && list.get(right) < list.get(smallest)) smallest = right;
            if(smallest != i){
                int temp = list.get(i);
                list.set(i, list.get(smallest));
                list.set(smallest, temp);
                i = smallest;
            } else break;
        }
    }

    public void buildHeap(ArrayList<Integer> arr){
        list = new ArrayList<>(arr);
        size = list.size();
        for(int i = (size - 2)/2; i >= 0; i--) heapifyDown(i);
    }

    public ArrayList<Integer> heapSort(){
        ArrayList<Integer> sorted = new ArrayList<>();
        int originalSize = size;
        while(size > 0){
            sorted.add(list.get(0));
            deletion();
        }
        size = originalSize;
        buildHeap(list);
        return sorted;
    }

    public void printHeap(){
        System.out.println(list);
    }

    public static void main(String[] args){
        Revise heap = new Revise();
        heap.insertion(5);
        heap.insertion(3);
        heap.insertion(8);
        heap.insertion(1);
        heap.printHeap(); // Min-heap

        heap.deletion();
        heap.printHeap();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,7,1,9,2));
        heap.buildHeap(arr);
        heap.printHeap();

        System.out.println(heap.heapSort());
    }
}
