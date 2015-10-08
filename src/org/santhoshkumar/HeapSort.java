package org.santhoshkumar;

public class HeapSort {

    int[] heap;

    public static void main(String[] args) {
        int[] a = {9,8,5,6,7,4,3,2,1,0};
        HeapSort hs = new HeapSort();
        hs.heap = a;
        hs.sort();
        hs.print();
    }

    public void heapify(int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < heapSize && heap[left] > heap[index]) {
            largest = left;
        }
        if (right < heapSize && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            //swap(largest, index);
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            heapify(largest, heapSize);
        }
    }

    // the way we will build max heap is that we take the half the array and start heapify form there.
    // why half? Because in an array the half will be leaf nodes of the heap tree
    // 0 is parent, 2*i+1 left, 2*i+2 right
    private void buildMaxHeap(){
        for(int i= heap.length/2; i >= 0 ; i--){
            heapify(i, heap.length);
        }
    }

    private void print(){
        for(int i= 0; i < heap.length ; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public void sort(){
        buildMaxHeap();
        for(int i = heap.length-1; i > 0 ; i --) {
            int temp = heap[i];
            heap[i]=heap[0];
            heap[0]=temp;
            heapify(0,i);
        }
    }
}
