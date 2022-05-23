package com.aaachuan.jcf.list;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(11);
        priorityQueue.add(88);
        priorityQueue.add(8);
        priorityQueue.add(19);
        priorityQueue.add(129);
        priorityQueue.add(33);
        priorityQueue.add(44);
        priorityQueue.add(22);
        priorityQueue.add(77);
        priorityQueue.add(55);
        priorityQueue.add(505);
        priorityQueue.add(15);
        priorityQueue.add(198);
        priorityQueue.add(189);
        priorityQueue.add(200);


        System.out.println("priorityQueue item = ");
        //每poll一次，size--
        for (int i = 0; i < priorityQueue.size(); ) {
            System.out.print(priorityQueue.poll() + ",");
        }


    }
}
