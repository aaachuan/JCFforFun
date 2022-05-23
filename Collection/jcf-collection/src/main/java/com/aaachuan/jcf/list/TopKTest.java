package com.aaachuan.jcf.list;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 求Top K
 */
public class TopKTest {
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);


    public static void main(String[] args) {
        System.out.println(getTopK(3,Arrays.asList(11,88,15,19,205,200,189,55,44,33,22,77,129,198)));
    }

    public static Integer getTopK(Integer k, List<Integer> list) {
        for (Integer num: list) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() != null) {
                    int max = priorityQueue.peek();
                    if (max > num) {
                        priorityQueue.poll();
                        priorityQueue.add(num);
                    }
                }
            }
        }
        return priorityQueue.poll();
    }
}
