/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author SheaJing
 */

import java.util.*;

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {

    private T[] heap;
    private int heapSize;
    private int heapCapacity = 30;
    
    public PriorityQueue() {
        heap =(T[]) new Comparable[heapCapacity];
        heapSize = 0;
    }
    
    public PriorityQueue(int initialCapacity) {
        heap = (T[]) new Comparable[initialCapacity];
        heapSize = 0;
    }
    
    public PriorityQueue(T[] elements) {
        heapCapacity = elements.length;
        heap = (T[]) new Comparable[heapCapacity];
        
        for (int i = 0; i < heapCapacity; i++) {
            if(elements[i] != null){
                heap[i] = elements[i];
                heapSize++;
            }
        }
        
        for (int i = Math.max(0, (heapCapacity / 2) - 1); i >= 0; i--)
            sink(i);
    }

    public T peek() {
        if (isEmpty()) 
            return null;
        
        return heap[0];
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean add(T element) {
        if (element == null)
            return false;  
        else if (!contains(element)) {
            if (isFull()){
                doubleArray();
            }
            heap[heapSize] = element;
            swim(heapSize);
            heapSize++;
            return true; 
        }
        return false; 
    }

    public T remove(T element) {
        T removedData = null;
        
        if (element == null)
            return null;
        else if(contains(element)) {
            for (int i = 0; i < heapSize; i++) {
                if (element.equals(heap[i])) {
                    removedData = heap[i];
                    removeAt(i);
                    return removedData;
                }
            }
        }
        return removedData;
    }

    private T removeAt(int i) {
        int indexOfLastElem = heapSize - 1;
        T removed_data = heap[i];
        
        if (isEmpty()) 
            return null;
        
        else if(heapSize == 1) {
            heap[indexOfLastElem] = null;
            return removed_data;
        }
        
        else {
            swap(i, indexOfLastElem);
        
            heap[indexOfLastElem] = null;
            heapSize--;

            T element = heap[i];
            sink(i);

            if (heap[i].equals(element)) 
                swim(i);
        }
        return removed_data;
    }

    private boolean less(int i, int j) {
        T node1 = heap[i];
        T node2 = heap[j];
        
        return node1.compareTo(node2) < 0;
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1; 
            int right = 2 * k + 2; 
            int smallest = left; 

            if (right < heapSize && less(right, left)) 
                smallest = right;
            
            if (left >= heapSize || less(k, smallest)) 
                break;
            
            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int i, int j) {
        T i_elem = heap[i];
        T j_elem = heap[j];

        heap[i] = j_elem;
        heap[j] = i_elem;
    }
    
    private void doubleArray(){
        T[] oldHeap = heap;
        int oldHeapSize = heapSize;
        
        heap = (T[]) new Comparable[2 * oldHeapSize];
        
        for(int i = 0; i < oldHeapSize; i++)
            heap[i] = oldHeap[i];
        
        heapCapacity = oldHeapSize * 2;
    }
    
    public boolean contains(T element) {
        if (element == null) 
            return false;
        
        for(int i = 0; i < heapSize; i++)
            if (heap[i].equals(element))
                return true;
        
        return false;
    }

    public int getLength() {
        return heapSize;
    }
    
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    public boolean isFull() {
        return heapSize == heapCapacity;
    }

    public void clear() {
        for(int i = 0; i < heapSize; i++)
            heap[i] = null;
        
        heapSize = 0;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for(int i = 0; i < heapSize; i++)
            outputStr += heap[i] + "\n";
        
        return outputStr;
    }
}
