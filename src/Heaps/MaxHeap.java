package Heaps;

class MaxHeap {
    int[] arr;
    int size;
    int totalSize;

    MaxHeap(int totalSize) {
        this.totalSize = totalSize;
        arr = new int[totalSize];
        size = 0;
    }

    void delete(){
        if(size==0){
            System.out.println("Heap is empty");
            return;
        }
        System.out.println("Delete element:" + arr[0]);
        arr[0]=arr[size-1];
        size--;

        int i=0;
        while(true){
            int left=2*i+1;
            int right=2*i+2;
            int largest=i;

            if(left < size && arr[left]>arr[largest])
                largest=left;
            if(right < size && arr[right]>arr[largest])
                largest=right;
            if(largest!=i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i=largest;
            }
            else{
                break;
            }
        }
    }
    void insert(int val) {
        if (size == totalSize) {
            System.out.println("Heap is full");
            return;
        }

        int index = size;
        arr[index] = val;
        size++;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class TestHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(20);
        heap.insert(50);
        heap.insert(10);
        heap.insert(70);
        heap.insert(30);

        heap.printHeap();
        heap.delete();
        System.out.print("Heap after deletion: ");
        heap.printHeap();
    }
}
