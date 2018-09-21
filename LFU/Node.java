package com.epam.teja.lfu;

public class Node {
    int data;
    int freq;
    Node(int data) {
        this.data = data;
        this.freq = 1;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "("+data+","+freq+")";
    }
}
