package com.epam.teja.lfu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String...arg)
    {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(3);
        
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.insert(7);
        
    }
}
