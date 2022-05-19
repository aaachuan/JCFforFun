package com.aaachuan.jcf.list;

/**
 * 常规堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] intArrays = {11,88,8,19,129,33,44,22,77,55,505,15,198,189,200};
        //int[] intArrays = {35,8,25,2,61,41};
        sort(intArrays);
        for (int i = 0; i < intArrays.length; i++) {
            System.out.print(intArrays[i] + ",");
        }
    }

    public static void sort(int[] beforeSort) {
        for (int j = beforeSort.length - 1; j > 0; j--) {
            int n = j + 1;
            for (int i = (n >> 1) - 1; i >= 0; i--) {
                int leftNodeIndex = (i << 1) + 1;
                int rightNodeIndex = (i << 1) + 2;

                if (rightNodeIndex > j) {
                    if (beforeSort[i] < beforeSort[leftNodeIndex]) {
                        int temp = beforeSort[i];
                        beforeSort[i] = beforeSort[leftNodeIndex];
                        beforeSort[leftNodeIndex] = temp;
                    }
                } else {
                    if ((beforeSort[i] < beforeSort[leftNodeIndex]) && (beforeSort[leftNodeIndex] > beforeSort[rightNodeIndex])) {
                        int temp = beforeSort[i];
                        beforeSort[i] = beforeSort[leftNodeIndex];
                        beforeSort[leftNodeIndex] = temp;
                    }
                    if (beforeSort[i] < beforeSort[rightNodeIndex]) {
                        int temp = beforeSort[i];
                        beforeSort[i] = beforeSort[rightNodeIndex];
                        beforeSort[rightNodeIndex] = temp;
                    }
                }
            }
            int swapHeadTail = beforeSort[0];
            beforeSort[0] = beforeSort[n-1];
            beforeSort[n-1] = swapHeadTail;
        }
    }
}
