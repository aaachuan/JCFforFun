package com.aaachuan.collection;


public class SinglyLinkedListV2<E> {
    //链表长度
    private int size;
    //头节点
    private Node first;

    /**
     * 节点定义(内部类)——单链表包含节点值与下一节点地址
     * @param <E>
     */
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 指定索引返回对应元素
     * @param index
     * @return
     */
    public E get(int index) {
        indexCheck(index);
        return node(index).value;
    }

    /**
     * 索引越界检查
     * index应满足(index >= 0 && index < size)
     * @param index
     */
    private void indexCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引值越界: index:" + index + ",size:" + size);
    }

    /**
     * 通过索引定位元素(其他方法使用场景多而抽取)
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
}
