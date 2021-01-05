package com.aaachuan.collection;


import java.util.LinkedList;

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
     * 指定索引节点修改元素
     * @param index
     * @param value
     * @return
     */
    public E set(int index, E value) {
        indexCheck(index);
        Node<E> oldNode =  node(index);
        E oldValue = oldNode.value;
        oldNode.value = value;
        return oldValue;
    }

    /**
     * 这里仍参考LinkedList的clear()方法，O(n)复杂度去置null;
     * 而非采用直接头节点置null的方法（有种解释是可达性算法，剩余node到达不了头节点GC ROOTS，就会被GC回收——在此情况并非准确）
     * 全置null的原因是中间的node在不同的代码区域仍存在对node的引用，例如List使用过Iterator的情况，迭代到中间断了的话，栈内
     * 有引用指向Iterator对象，而Iterator对象又有引用指向node导致整条链路得不到释放，GC就不能回收。
     * （年轻代的对象被老年代的对象引用，young gc不会回收）
     */
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x = next;
        }
        first = null;
        size = 0;
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
