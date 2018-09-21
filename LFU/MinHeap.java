package com.epam.teja.lfu;

import java.util.HashSet;

public class MinHeap {
    private Node[] Heap;
    private int size;
    private int maxsize;
    private HashSet<Integer> presentElements;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.presentElements = new HashSet<Integer>();
        Heap = new Node[this.maxsize + 1];
        Heap[0] = new Node(Integer.MIN_VALUE);
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        Node tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos].freq > Heap[leftChild(pos)].freq || Heap[pos].freq > Heap[rightChild(pos)].freq) {
                if (Heap[leftChild(pos)].freq < Heap[rightChild(pos)].freq) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if(presentElements.contains(element)) {
            //Frequency Incrementing
            for(int i = 1; i <= size; i++) {
                if(Heap[i].data == element) {
                    Heap[i].freq++;
                    break;
                }
            }
            minHeapify(1);
        }
        else if (size < maxsize) {
            Heap[++size] = new Node(element);
            int current = size;

            while (Heap[current].freq < Heap[parent(current)].freq) {
                swap(current, parent(current));
                current = parent(current);
            }
            presentElements.add(element);
        }
        else {
            remove();
            insert(element);
        }
        printArray();
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = Heap[FRONT].data;
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        presentElements.remove(popped);
        return popped;
    }
    
    void printArray() {
        System.out.print("[");
        for(int i = 1;i<=size;i++) {
            System.out.print(Heap[i] + ", ");
        }
        System.out.print("]");
        System.out.println(presentElements);
        
    }

}